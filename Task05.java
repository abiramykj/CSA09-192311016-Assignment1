
class ParkingTicket {
    private static int ticketCounter = 1000;
    private static int totalTickets = 0;

    private final int ticketNo;
    private String vehicleNo;
    private boolean active;

    ParkingTicket(String vehicleNo) {
        ticketCounter++;
        totalTickets++;
        this.ticketNo = ticketCounter;
        this.vehicleNo = vehicleNo;
        this.active = true;
    }

    public void vehicleExit() {
        if (active) {
            active = false;
            System.out.println(vehicleNo + " has exited.");
        }
    }

    public static int getTotalTickets() {
        return totalTickets;
    }

    public void display() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Active: " + active);
    }
}

public class Task05 {
    public static void main(String[] args) {
        ParkingTicket t1 = new ParkingTicket("TN01AB1111");
        ParkingTicket t2 = new ParkingTicket("TN02CD2222");

        t1.display();
        t1.vehicleExit();

        System.out.println("\nSecond Ticket:");
        t2.display();

        System.out.println("\nTotal Tickets: "
                + ParkingTicket.getTotalTickets());

        t1 = null;
        System.out.println("First ticket reference released.");
    }
}
