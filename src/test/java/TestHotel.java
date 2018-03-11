import Hotel.*;  // Adds Guest and Hotel
import Hotel.Rooms.*; // Adds Bedroom, ConferenceRoom and DiningRoom;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestHotel {
    private Hotel aHotel;

    private Bedroom aSingleRoomToAdd;
    private Bedroom aDoubleRoomToAdd;
    private Bedroom aFamilyRoomToAdd;

    private ArrayList<Guest> guestToAdd1;
    private ArrayList<Guest> guestsToAdd2;
    private ArrayList<Guest> guestsToAdd3;
    private ArrayList<Guest> guestsToAdd4;

    private Guest daddy;
    private Guest mummy;
    private Guest son;
    private Guest daughter;

    private ConferenceRoom aConferenceRoomToAdd;
    private DiningRoom aDinningRoomToAdd;

    private ArrayList<Bedroom> someBedrooms;
    private ArrayList<ConferenceRoom> someConferenceRooms;
    private ArrayList<DiningRoom> someDiningRooms;


    public TestHotel() {
    }

    @Before
    public void before() {

        daddy = new Guest("Freddie Mercury");
        mummy = new Guest("Lady GaGa");
        son = new Guest("Prince");
        daughter = new Guest("Shakira");

        guestToAdd1 = new ArrayList();
        guestsToAdd2 = new ArrayList();
        guestsToAdd3 = new ArrayList();
        guestsToAdd4 = new ArrayList();
        guestToAdd1.add(daddy);
        guestsToAdd2.add(daddy);
        guestsToAdd2.add(mummy);
        guestsToAdd3.add(daddy);
        guestsToAdd3.add(mummy);
        guestsToAdd3.add(son);
        guestsToAdd4.add(daddy);
        guestsToAdd4.add(mummy);
        guestsToAdd4.add(son);
        guestsToAdd4.add(daughter);

        someBedrooms = new ArrayList<>();

        // Create Array of 10 Single Bedrooms
        int rate = 30;
        for (int i = 1; i <11 ; i++) {
            aSingleRoomToAdd = new Bedroom(RoomType.SINGLE, i, rate);
            someBedrooms.add(aSingleRoomToAdd);
        }

        // Create Array of 10 Doube Bedrooms
        rate = 55;
        for (int i = 11; i <21 ; i++) {
            aDoubleRoomToAdd = new Bedroom(RoomType.DOUBLE, i, rate);
            someBedrooms.add(aDoubleRoomToAdd);
        }

        // Create Array of 10 Family Bedrooms
        rate = 80;
        for (int i = 21; i <31 ; i++) {
            aFamilyRoomToAdd = new Bedroom(RoomType.FAMILY, i, rate);
            someBedrooms.add(aFamilyRoomToAdd);
        }

        aHotel = new Hotel("CodeClan Tower");
    }

    @Test
    public void hotelHasName() {
        assertEquals("CodeClan Tower", aHotel.getName());
    }

    @Test
    public void hasBedrooms() {
        aHotel.setBedrooms(someBedrooms);
        System.out.println(aHotel.getBedrooms().getClass());
        assertEquals(30, aHotel.getBedrooms().size());
    }

    @Test
    public void bedRoomsHaveNumbers() {
//        assertEquals()
    }

    @Test
    public void canCheckIn1GuestToBedroom() {
        aHotel.setBedrooms(someBedrooms);
        aHotel.checkGuestIntoBedroom(guestToAdd1);
        assertEquals(1,aHotel.howManyGuestsInBedrooms());
    }

    @Test
    public void canCheckIn2GuestToBedroom() {
        aHotel.setBedrooms(someBedrooms);
        aHotel.checkGuestIntoBedroom(guestsToAdd2);
        assertEquals(2,aHotel.howManyGuestsInBedrooms());
    }

    @Test
    public void canCheckIn3GuestToBedroom() {
        aHotel.setBedrooms(someBedrooms);
        aHotel.checkGuestIntoBedroom(guestsToAdd3);
        assertEquals(3,aHotel.howManyGuestsInBedrooms());
    }

    @Test
    public void canGetNumberOfEmptyBedrooms() {
        aHotel.setBedrooms(someBedrooms);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        assertEquals(28,aHotel.howManyEmptyBedrooms());
    }

    @Test
    public void canGetListOfEmptyBedroomNumbers() {
        aHotel.setBedrooms(someBedrooms);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,", aHotel.listEmptyBedrooms());
    }

    @Test
    public void canSeeGuestsInRooms() {
        aHotel.setBedrooms(someBedrooms);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        assertEquals(guestsToAdd4, aHotel.getGuestsInBedroomNumber(21));
        assertEquals(4, aHotel.howManyGuestsInABedroom(21));

    }

    @Test
    public void canEmptyBedroom() {
        aHotel.setBedrooms(someBedrooms);
        aHotel.checkGuestIntoBedroom(guestsToAdd4);
        aHotel.checkGuestsOutOfBedroom(21);
        assertEquals(0, aHotel.howManyGuestsInABedroom(21));
    }

} // end class TestHotel
