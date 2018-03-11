package Hotel;

import Hotel.Rooms.Bedroom;
import Hotel.Rooms.ConferenceRoom;
import Hotel.Rooms.DiningRoom;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;

    // CONSTRUCTOR
    public Hotel(String aName) {
        this.name = aName;
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRooms = new ArrayList<>();
    }

    // GETTOR METHODS
    public String getName() {
        return this.name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return bedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public ArrayList<DiningRoom> getDiningRooms() {
        return diningRooms;
    }


    // SETTOR METHODS
    public void setBedrooms(ArrayList<Bedroom> bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setConferenceRooms(ArrayList<ConferenceRoom> conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }

    public void setDiningRooms(ArrayList<DiningRoom> diningRooms) {
        this.diningRooms = diningRooms;
    }

    // ADD ROOM METHODS
    public void addBedRoom(Bedroom aBedroom) {
        this.bedrooms.add(aBedroom);
    }

    public void addConferenceRoom(ConferenceRoom aConferenceRoom) {
        this.conferenceRooms.add(aConferenceRoom);
    }

    public void addDinningRoom(DiningRoom aDiningRoom) {
        this.diningRooms.add(aDiningRoom);
    }

    // CHECKIN GUESTS METHODS
    public void checkGuestIntoBedroom(ArrayList<Guest> aGuestList) {
        for (int i = 0; i < this.bedrooms.size(); i++) {
            if ((this.bedrooms.get(i).numberOfOccupants() == 0) && (this.bedrooms.get(i).getCapacity() >= aGuestList.size())) {
                for (int j = 0; j < aGuestList.size(); j++) {
                    this.bedrooms.get(i).addGuest(aGuestList.get(j));
                }
                return;
            }
        }
    }

    public int howManyGuestsInBedrooms() {
        int numberOfGuests = 0;
        for (int i = 0; i < this.bedrooms.size(); i++) {
            if (this.bedrooms.get(i).numberOfOccupants() != 0) {
                numberOfGuests += this.bedrooms.get(i).numberOfOccupants();
            }
        }
        return numberOfGuests;
    }

    public int howManyGuestsInABedroom(int aRoomNumber) {
        int numberOfGuests = 0;
        for (int i = 0; i < this.bedrooms.size(); i++) {
            if (this.bedrooms.get(i).getRoomNumber() == aRoomNumber) {
                numberOfGuests = this.bedrooms.get(i).numberOfOccupants();
            }
        }
        return numberOfGuests;
    }

    public int howManyEmptyBedrooms() {
        int emptyCount = 0;
        for (int i = 0; i < this.bedrooms.size(); i++ ) {
            if (this.bedrooms.get(i).numberOfOccupants() == 0) {
                emptyCount += 1;
            }
        }
        return emptyCount;
    }


    public String listEmptyBedrooms() {
        String roomNumbers = "";
        for (int i = 0; i < this.bedrooms.size(); i++ ) {
            if (this.bedrooms.get(i).numberOfOccupants() == 0) {
                roomNumbers += this.bedrooms.get(i).getRoomNumber() + ",";
            }
        }
        return roomNumbers;
    }

    public ArrayList<Guest> getGuestsInBedroomNumber(int aRoomNumber) {
        for (int i = 0; i < this.bedrooms.size(); i++) {
            if (this.bedrooms.get(i).getRoomNumber() == aRoomNumber) {
                return this.bedrooms.get(i).getGuests();
            }
        }
        return null;
    }


    public void checkGuestsOutOfBedroom(int aRoomNumber) {
        for (int i = 0; i < this.bedrooms.size(); i++) {
            if (this.bedrooms.get(i).getRoomNumber() == aRoomNumber) {
                this.bedrooms.get(i).removeGuests();
            }
        }
    }
} // end class Hotel
