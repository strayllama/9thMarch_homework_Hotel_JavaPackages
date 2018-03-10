import Hotel.Guest;
import Hotel.Rooms.Bedroom;
import Hotel.Rooms.ConferenceRoom;
import Hotel.Rooms.RoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRoom {
    private Bedroom aBedRoom;
    private ConferenceRoom aConferenceRoom;
    private Guest aGuest;

    @Before
    public void before() {
        aBedRoom = new Bedroom(RoomType.DOUBLE,27, 50);
        aConferenceRoom = new ConferenceRoom(20, "Woodland", 200);
        aGuest = new Guest("Stevie Wonder");
    }

    @Test
    public void bedroomHasName() {
        assertEquals("DOUBLE",aBedRoom.getName());
    }

    @Test
    public void bedroomHasCapactiy() {
        assertEquals(2, aBedRoom.getCapacity());
    }

    @Test
    public void bedroomCanAddGuestAndGuestHasName() {
        aBedRoom.addGuest(aGuest);
        assertEquals("Stevie Wonder", aGuest.getName());
    }

    @Test
    public void bedroomHasNumber() {
        assertEquals(27, aBedRoom.getRoomNumber());
    }

    @Test
    public void bedroomHasRate() {
        assertEquals(50,aBedRoom.getRate());
    }

    @Test
    public void bedroomDoesnAddGuestsWhenFull() {
        aBedRoom.addGuest(aGuest);
        aBedRoom.addGuest(aGuest);
        aBedRoom.addGuest(aGuest);
        assertEquals(2, aBedRoom.getCapacity());
    }

    @Test
    public void bedroomRateCanBeChanged() {
        aBedRoom.setRate(100);
        assertEquals(100, aBedRoom.getRate());
    }

    @Test
    public void conferenceRoomHasBookingFee() {
        assertEquals(200, aConferenceRoom.getBookingFee());
    }

} // end class TestRoom
