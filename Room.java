class Room {
    private int roomNumber;
    private double pricePerNight;
    private boolean isBooked;
    private final int MAX_DAYS = 7;
    private final int MIN_DAYS = 1;

    // Constructor
    public Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    // Accessors and mutators
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    
    public int getMIN_DAYS() {
        return MIN_DAYS;
    } 
    public int getMAX_DAYS() {
        return MAX_DAYS;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

   
 // toString method
    @Override
    public String toString() {
        String status = isBooked ? "Booked" : "Available";
        return "Room No: " + roomNumber + "\nPrice Per Night: $" + pricePerNight + "\nStatus: "+ status  + "\nMinimum number of days guest can book: "+ MIN_DAYS +"\nMaximum number of days guest can book: " + MAX_DAYS;
    }
}
