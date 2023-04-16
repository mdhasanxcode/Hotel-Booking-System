class Booking {
    private Room room;
    private String guestName;
    private int numOfDays;
    
    // Default Constructor
    public Booking() {
    this.room = new Room(0, 0);
    this.guestName = "None";
    this.numOfDays = 0;
    }
    
    // Alternate Constructor
    public Booking(Room room, String guestName, int numOfDays) {
        this.room = room;
        this.guestName = guestName;
        if(numOfDays >0){
            room.setBooked(true);
        }
        else{
            room.setBooked(false);
        }
        
        this.numOfDays = numOfDays;
    }
    
    // Accessors and mutators
    public Room getRoom() {
        return room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }
    
    public String getGuestName() {
        return guestName;
    }
    
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    
    public int getnumOfDays(){
        return numOfDays;
    }
    
    public void setnumOfDays(int numOfDays){
        this.numOfDays = numOfDays;
    }
    

    // toString method
    @Override
    public String toString() {
        return "Guest Name: " + guestName + "\tNumber of days Guest is staying: " + numOfDays;
    }
}