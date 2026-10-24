
import java.util.HashMap;

abstract class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours);
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 10;
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30;
    }
}

class ParkingTicket {
    int ticketNo;
    Vehicle vehicle;
    int entryHour;

    ParkingTicket(int ticketNo, Vehicle vehicle, int entryHour) {
        this.ticketNo = ticketNo;
        this.vehicle = vehicle;
        this.entryHour = entryHour;
    }
}

class ParkingFacility {
    private final HashMap<String, ParkingTicket> activeTickets =
            new HashMap<>();
    private int ticketCounter = 1000;

    public void vehicleEntry(Vehicle vehicle, int entryHour) {
        if (activeTickets.containsKey(vehicle.regNo)) {
            System.out.println("Error: Vehicle already parked.");
            return;
        }

        ParkingTicket ticket = new ParkingTicket(
                ++ticketCounter, vehicle, entryHour);
        activeTickets.put(vehicle.regNo, ticket);

        System.out.println("Entry successful: " + vehicle.regNo
                + ", Ticket: " + ticket.ticketNo);
    }

    public void vehicleExit(String regNo, int exitHour) {
        ParkingTicket ticket = activeTickets.remove(regNo);

        if (ticket == null) {
            System.out.println("Error: Vehicle not found.");
            return;
        }

        int hours = Math.max(0, exitHour - ticket.entryHour);
        double fee = ticket.vehicle.calculateFee(hours);

        System.out.println("Exit successful: " + regNo);
        System.out.println("Parking Fee: Rs. " + fee);
    }
}

public class Task11 {
    public static void main(String[] args) {
        ParkingFacility parking = new ParkingFacility();

        parking.vehicleEntry(
                new TwoWheeler("TN01AB1111"), 9);
        parking.vehicleEntry(
                new Car("TN02CD2222"), 10);

        parking.vehicleEntry(
                new Car("TN02CD2222"), 11);

        parking.vehicleExit("TN01AB1111", 12);
        parking.vehicleExit("TN02CD2222", 13);

        parking.vehicleExit("TN03EF3333", 14);
    }
}
