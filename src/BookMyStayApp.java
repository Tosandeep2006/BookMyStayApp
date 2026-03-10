import java.util.LinkedList;
import java.util.Queue;

class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + " | Requested Room: " + roomType;
    }
}

class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }
    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Booking request added: " + reservation);
    }
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }
    public void displayRequests() {
        System.out.println("\nCurrent Booking Requests in Queue:");

        if (requestQueue.isEmpty()) {
            System.out.println("No pending booking requests.");
            return;
        }

        for (Reservation r : requestQueue) {
            System.out.println(r);
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Alice", "Deluxe");
        Reservation r2 = new Reservation("Bob", "Suite");
        Reservation r3 = new Reservation("Charlie", "Standard");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        bookingQueue.displayRequests();

        System.out.println("\nNext request to process:");
        System.out.println(bookingQueue.peekNextRequest());
    }
}