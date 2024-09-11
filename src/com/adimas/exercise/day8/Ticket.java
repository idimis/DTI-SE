import java.util.Scanner;

class Ticket {
    private int id;
    private String name;
    private boolean isBooked;
    private boolean isValidated;
    private boolean isConfirmed;

    public Ticket(int id, String name) {
        this.id = id;
        this.name = name;
        this.isBooked = false;
        this.isValidated = false;
        this.isConfirmed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void book() {
        this.isBooked = true;
    }

    public void validate() {
        this.isValidated = true;
    }

    public void confirm() {
        this.isConfirmed = true;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Name: " + name +
                ", Booked: " + isBooked + ", Validated: " + isValidated +
                ", Confirmed: " + isConfirmed;
    }
}
