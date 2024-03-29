package random.learning.springbootangular.model.response;

import random.learning.springbootangular.model.Links;

public class ReservableRoomResponse {

    private Long id;
    private Integer roomNumber;
    private Integer price;
    private Links links;

    public ReservableRoomResponse(Integer roomNumber, Integer price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public ReservableRoomResponse() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
