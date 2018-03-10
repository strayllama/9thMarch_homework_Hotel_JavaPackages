package Hotel.Rooms;

public class ConferenceRoom extends Room {
    private int bookingFee;

    public ConferenceRoom(int aCapacity, String aName, int aBookingFee) {
        super(aName, aCapacity);
        this.bookingFee = aBookingFee;
    }

    // GETTER METHOD
    public int getBookingFee() {
        return this.bookingFee;
    }


} // end class ConferenceRoom
