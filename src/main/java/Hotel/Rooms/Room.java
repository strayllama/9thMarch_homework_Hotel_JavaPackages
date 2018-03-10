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
        return guests;
    }

    // SETTER METHODS
    public void addGuest(Guest aGuest) {
        if (guests.size() < this.capacity) {
            guests.add(aGuest);
        }
    }

    // STRING INFO METHODS


    @Override
    public String toString() {
        return super.toString();
    }

} // end abstract class Room
