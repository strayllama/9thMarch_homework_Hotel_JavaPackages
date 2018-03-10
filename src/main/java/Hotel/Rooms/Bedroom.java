package Hotel.Rooms;

public class Bedroom extends Room {
    private int roomNumber;
    private int nightlyRate;

    public Bedroom (RoomType roomType, int aRoomNumber, int aNightlyRate) {
        super(roomType.toString(), roomType.getCapacity());
        this.roomNumber = aRoomNumber;
        this.nightlyRate = aNightlyRate;
    }

    // GETTER METHODS
    public int getRoomNumber() {
        return this.roomNumber;
    }

    public int getRate() {
        return nightlyRate;
    }

    // SETTER
    public void setRate(int newRate) {
        this.nightlyRate = newRate;
    }
} // end class Bedroom