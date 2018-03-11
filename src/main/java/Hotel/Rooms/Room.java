package Hotel.Rooms;

import Hotel.Guest;

import java.util.ArrayList;

public abstract class Room {
    private String name;
    private int capacity;
    private ArrayList<Guest> guests;

    // CONSTRUCTOR
    Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    // GETTER METHODS

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }

    public int numberOfOccupants() {
        return this.guests.size();
    }

    // SETTER METHODS
    public void addGuest(Guest aGuest) {
        if (this.guests.size() < this.capacity) {
            this.guests.add(aGuest);
        }
    }


    public void removeGuests() {
        this.guests.clear();
    }

} // end abstract class Room
