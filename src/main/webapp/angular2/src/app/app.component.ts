import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  constructor(private http : HttpClient) {}

  private baseUrl:string = 'http://localhost:8080';
  public submitted : boolean;
  roomsearch : FormGroup;
  rooms : Room[];
  currentCheckInVal : string;
  currentCheckOutVal : string;
  request : ReserveRoomRequest;

  ngOnInit() {
      this.roomsearch = new FormGroup({
          checkin : new FormControl(''),
          checkout : new FormControl('')
      });
      const roomsearchValueChanges$ = this.roomsearch.valueChanges;
      roomsearchValueChanges$.subscribe( valChange => {
        this.currentCheckInVal = valChange.checkin;
        this.currentCheckOutVal = valChange.checkout;}
      )
  }

  onSubmit({value,valid}: {value:Roomsearch, valid:boolean}) {
    this.getAll()
      .subscribe(
                rooms => {this.rooms =  rooms},
                err => {console.log(err)}
      );

  }

  reserveRoom(value:string) {
    this.request = new ReserveRoomRequest(value, this.currentCheckInVal, this.currentCheckOutVal);
    this.createReservation(this.request);
  }

  getAll() : Observable<Room[]> {
    return this.http
      .get(this.baseUrl + '/room/reservation/v1?checkin=' + this.currentCheckInVal + '&checkout=' + this.currentCheckOutVal)
      .pipe(map(res => res.content));
  }

  createReservation(body : Object) {
    let bodyString = JSON.stringify(body);
    let headers = new HttpHeaders({'Content-Type':'application/json'});
    let options = {headers:headers};

    this.http.post(this.baseUrl + '/room/reservation/v1', body, options)
      .subscribe(res => console.log(res));
  }

}

export interface Roomsearch {
  checkin : string;
  checkout : string;
}

export interface Room {
  id : string;
  roomNumber : string;
  price : string;
  links : string;
}

export class ReserveRoomRequest {
  roomId : string;
  checkin : string;
  checkout : string;

  constructor(roomId : string, checkin : string, checkout : string) {
    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }
}
