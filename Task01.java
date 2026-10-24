class Vehicle {
    String regNo;
    String type;
    long entryTime;

    Vehicle(String regNo, String type, long entryTime) {
        this.regNo = regNo;
        this.type = type;
        this.entryTime = entryTime;
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo, long entryTime) {
        super(regNo, "TwoWheeler", entryTime);
    }
}

class Car extends Vehicle {
    Car(String regNo, long entryTime) {
        super(regNo, "Car", entryTime);
    }
}

class ElectricCar extends Car {
    ElectricCar(String regNo, long entryTime) {
        super(regNo, entryTime);
    }
}

class ParkingSlot {
    int slotNo;
    int floorNo;
    boolean occupied;

    ParkingSlot(int slotNo, int floorNo) {
        this.slotNo = slotNo;
        this.floorNo = floorNo;
        this.occupied = false;
    }
}

class ParkingTicket {
    static int counter = 1000;
    int ticketNo;
    Vehicle vehicle;
    long entryTime;
    long exitTime;

    ParkingTicket(Vehicle vehicle) {
        this.ticketNo = ++counter;
        this.vehicle = vehicle;
        this.entryTime = System.currentTimeMillis();
    }
}

class MonthlyPass {
    String userType;
    boolean valid;

    MonthlyPass(String userType, boolean valid) {
        this.userType = userType;
        this.valid = valid;
    }
}

class PricingRule {
    double calculateFee(Vehicle vehicle, int hours) {
        if (vehicle.type.equals("TwoWheeler"))
            return hours * 10;
        else if (vehicle.type.equals("Car"))
            return hours * 30;
        else
            return hours * 30;
    }
}

class ParkingFacility {
    ParkingSlot[][] slots;

    ParkingFacility(int floors, int slotsPerFloor) {
        slots = new ParkingSlot[floors][slotsPerFloor];

        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < slotsPerFloor; j++) {
                slots[i][j] = new ParkingSlot(j + 1, i + 1);
            }
        }
    }

    ParkingSlot allocateSlot() {
        for (int i = 0; i < slots.length; i++) {
            for (int j = 0; j < slots[i].length; j++) {
                if (!slots[i][j].occupied) {
                    slots[i][j].occupied = true;
                    return slots[i][j];
                }
            }
        }
        return null;
    }

    void releaseSlot(int floor, int slot) {
        if (floor >= 1 && floor <= slots.length &&
            slot >= 1 && slot <= slots[floor - 1].length) {
            slots[floor - 1][slot - 1].occupied = false;
        }
    }
}

public class Task01 {
    public static void main(String[] args) {
        ParkingFacility parking = new ParkingFacility(3, 50);

        Vehicle v1 = new TwoWheeler("TN01AB1111",
                System.currentTimeMillis());
        Vehicle v2 = new Car("TN02CD2222",
                System.currentTimeMillis());
        Vehicle v3 = new ElectricCar("TN03EF3333",
                System.currentTimeMillis());

        ParkingSlot s1 = parking.allocateSlot();
        ParkingSlot s2 = parking.allocateSlot();
        ParkingSlot s3 = parking.allocateSlot();

        System.out.println(v1.regNo + " -> Floor " + s1.floorNo
                + ", Slot " + s1.slotNo);
        System.out.println(v2.regNo + " -> Floor " + s2.floorNo
                + ", Slot " + s2.slotNo);
        System.out.println(v3.regNo + " -> Floor " + s3.floorNo
                + ", Slot " + s3.slotNo);
    }
}