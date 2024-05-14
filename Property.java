public class Property extends User {
    private String city;
    private String street;
    private int roomsNumbers;
    private int price;
    private String type;
    private String ifRenting;
    private int homeNumber;
    private int floorNumber;
    private User publisher;

    public Property(String city, String street, int roomsNumbers, int price, String type, String ifRenting, int homeNumber, int floorNumber, User publisher) {
        super();
        this.city = city;
        this.street = street;
        this.roomsNumbers = roomsNumbers;
        this.price = price;
        this.type = type;
        this.ifRenting = ifRenting;
        this.homeNumber = homeNumber;
        this.floorNumber = floorNumber;
        this.publisher = publisher;
    }

    public String getCity() {
        return city;
    }


    public String getStreet() {
        return street;
    }

    public int getRoomsNumbers() {
        return roomsNumbers;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String isIfRenting() {
        return ifRenting;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public User getPublisher() {
        return publisher;
    }
}
