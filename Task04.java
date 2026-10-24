class Vehicle {
    String regNo;
    String type;

    Vehicle() {
        this("UNKNOWN", "Unknown");
    }

    Vehicle(String regNo, String type) {
        this.regNo = regNo;
        this.type = type;
    }

    Vehicle(Vehicle v) {
        this(v.regNo, v.type);
    }

    void display() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Vehicle Type: " + type);
    }
}

class ParkingTicket {
    static int counter = 1000;
    int ticketNo;
    Vehicle vehicle;

    ParkingTicket() {
        this(new Vehicle());
    }

    ParkingTicket(Vehicle vehicle) {
        this.ticketNo = ++counter;
        this.vehicle = vehicle;
    }

    ParkingTicket(ParkingTicket t) {
        this(new Vehicle(t.vehicle));
    }

    void display() {
        System.out.println("Ticket Number: " + ticketNo);
        vehicle.display();
    }
}

public class Task04 {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("TN01AB1111", "Car");
        Vehicle v2 = new Vehicle(v1);

        ParkingTicket t1 = new ParkingTicket(v1);
        ParkingTicket t2 = new ParkingTicket(t1);

        System.out.println("Original Ticket:");
        t1.display();

        System.out.println("\nCopied Ticket:");
        t2.display();
    }
}