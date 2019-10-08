import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { HttpClient} from '@angular/common/http';

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

  ngOnInit() {
      this.roomsearch = new FormGroup({
          checkin: new FormControl(''),
          checkout: new FormControl('')
      });

  }

  onSubmit({value,valid}: {value:Roomsearch, valid:boolean}) {
    this.getAll()
      .subscribe(
                rooms => {this.rooms =  rooms},
                err => {console.log(err)}
                );

  }

  reserveRoom(value:string) {
    console.log("Room id for reservation: " + value)
  }

  getAll() : Observable<Room[]> {
    return this.http.get(this.baseUrl + '/room/reservation/v1?checkin=2019-10-19&checkout=2019-10-22')
      .pipe(map(res => res.content));
  }

}

export interface Roomsearch {
  checkin:string;
  checkout:string;
}

export interface Room {
  id:string;
  roomNumber:string;
  price:string;
  links:string;
}

