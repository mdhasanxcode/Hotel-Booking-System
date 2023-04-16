import java.util.Scanner;

public class Hotel {
    private Room room1;
    private Room room2;
    private Booking booking1;
    private Booking booking2;

    
    public Hotel() {
        
        //////////////////////// INITIAL CODE ////////////////////////
        // Scanner object as a local variable in the main class
        Scanner scanner = new Scanner(System.in);
        // Initialise all objects by default Hotel constructor       
        room1 = new Room(101, 180.0);
        room2 = new Room(102, 200.0);
        booking1 = new Booking(room1, "Hasan", 3);
        booking2 = new Booking(room2, "", 0);
        
        
        
        
        
        //////////////////////// DISPLAYING CODE////////////////////////
        //Display Info
        displayHotelInfo(room1, room2);
        
        // Display state of the objects for once
        displayInitialState(room1, room2, booking1, booking2);
        
        // Display Menu
        displayMenu();
        
        
        
        
        
        //////////////////////// USER CHOICE CODE ////////////////////////
        // Modify objects based on user input
        while (true) 
        {
            // User's Decision
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            //// Choice Switch
            
            // Choice 1: Book a Room
            if (choice == 1 && numOfRoomsAvailable(room1, room2)>0) 
            {
                //// Booking in progress
                
                /// Part 1: Room Number matching
                System.out.print("Please provide information for booking\n Enter room number (101/102): ");
                
                // take room number for booking
                int roomNumber = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                // Room object to indicate room1 and room2 created earlier
                Room room;
                
                // Assigning room as user selected room and later check whther room is booked or available
                if (roomNumber == 101) {
                    room = room1;
                } else if (roomNumber == 102) {
                    room = room2;
                } else {
                    System.out.println("Invalid room number!");
                    displayMenu();
                    continue;
                }
                /// Part 1 ENDS
                
                
                //// Part 2: Room Number and Availability Checking
                // Check if room is booked or available
                if (room.isBooked()) 
                {
                    System.out.println("Sorry, the room is already booked. Would you like to book the other one? (yes/no)");
                    String answer = scanner.nextLine();
                    
                    if (answer.equalsIgnoreCase("yes")) 
                    {
                        // assign room as the other one
                        if (room == room1) {
                            room = room2;
                        } else {
                            room = room1;
                        }
                    } 
                    else 
                    {
                        displayMenu();
                        continue;
                    }
                }
                //// Part 2 ENDS
                
                // Continue the booking
                
                
                //// Part 3: Taking information for booking
                // Enter Guest Name
                System.out.print("Enter guest name: ");
                String guestName = scanner.nextLine();
                
                // Number of days for booking
                System.out.print("Enter number of days to book: ");
                int numOfDays = scanner.nextInt();
                
                // Check if Min and Max number of days for bookiong
                if (numOfDays < room.getMIN_DAYS() || numOfDays > room.getMAX_DAYS()) {
                    System.out.println("Invalid number of days!");
                    displayMenu();
                    continue;
                }
                Booking booking = new Booking(room, guestName, numOfDays);
                if (room == room1) {
                    booking1 = booking;
                } else {
                    booking2 = booking;
                }
                
                // Calculate total cost            
                double totalCost = room.getPricePerNight() * numOfDays;

                // Display total cost
                System.out.println("Booking successful! Your total cost for " + numOfDays + " nights in Room " + room.getRoomNumber() + " is $" + totalCost);
                displayMenu();
            } 
            
            
            else if (choice == 1 && numOfRoomsAvailable(room1, room2)<1){
                System.out.println("We are extremely sorry. No room are available right now!");
                displayMenu();
            }
            
            
            // Choice 2: Cancel Booking
            else if (choice == 2) {
                System.out.print("Enter room number to cancel booking (101/102): ");
                int roomNumber = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                Booking booking;
                if (roomNumber == 101) {
                    booking = booking1;
                } else if (roomNumber == 102) {
                    booking = booking2;
                } else {
                    System.out.println("Invalid room number!");
                    displayMenu();
                    continue;
                }
                
                System.out.print("Enter guest name: ");
                String verifyName = scanner.nextLine();
                
                if (booking.getGuestName().equals(verifyName)){
                    if (booking.getRoom().isBooked()) {
                    booking.getRoom().setBooked(false);
                    if (booking == booking1) {
                        booking1 = new Booking(room1, "", 0);
                    } else {
                        booking2 = new Booking(room2, "", 0);
                    }
                    System.out.println("Booking cancelled successfully!");
                    } else {
                        System.out.println("The room is not booked!");
                    }
                }
                else {
                    System.out.println("Verification Unsuccessful for cancelling booking! Guest Name did't match.");
                }
                
                
                displayMenu();
            }
            
            else if (choice == 3){
                displayInitialState(room1, room2, booking1, booking2);
                displayMenu();
            } 
            
            else if (choice == 4){
                System.out.println("We hope you had a great time in our Hotel! Byeeeee! ;-)");
                return;
            }
            
            else{
                System.out.println("Invalid choice!");
                displayMenu();
            }
        }
    }
    
    
    //////////////////////// METHODS ////////////////////////
    // Methods for displaying hotel information
    public static void displayHotelInfo(Room room1, Room room2) {
        System.out.println("Hello There! Welcome to our Hotel!");
        System.out.println("We have 2 rooms in our Hotel.");
        System.out.println("You can book room for up to 7 days.");
        System.out.println("Currently, we have " + numOfRoomsAvailable(room1, room2)+ " room(s) available.");
    }
    
    //Methods to display Menu
    public static void displayMenu() {
        System.out.println("\nFeel free to tell us what you would like to do.");
        System.out.println("1. Book a room");
        System.out.println("2. Cancel a booking");
        System.out.println("3. Use toString");
        System.out.println("4. Exit");
        System.out.println("Choose an option. Enter 1/2/3/4: ");
    }
    
    public static void displayInitialState(Room room1, Room room2, Booking booking1, Booking booking2){
        System.out.println("\n/*********** Displaying Current State of all the objects using toString. ***********/");
        System.out.println("State of Room Object 1:");
        System.out.println(room1.toString()+"\n");
        System.out.println("State of Room Object 2:");
        System.out.println(room2.toString());
        
        System.out.println("\n\nState of Booking Object 1:");
        System.out.println(booking1.toString()+"\n");
        System.out.println("State of Booking Object 2:");
        System.out.println(booking2.toString());
        System.out.println("/**************************        Exiting toString        **************************/\n\n");
    }
    
    public static int numOfRoomsAvailable(Room room1, Room room2){
        int count = 2;
        if(room1.isBooked()){
            count--;
        }
        if(room2.isBooked()){
            count--;
        }
        
        return count;
    }
}
