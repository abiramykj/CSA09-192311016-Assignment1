
class ParkingSlot {
    private int floorNo;
    private int slotNo;
    private boolean occupied;

    public ParkingSlot(int floorNo, int slotNo) {
        setFloorNo(floorNo);
        setSlotNo(slotNo);
        this.occupied = false;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        if (floorNo <= 0)
            throw new IllegalArgumentException("Invalid floor number");
        this.floorNo = floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        if (slotNo <= 0)
            throw new IllegalArgumentException("Invalid slot number");
        this.slotNo = slotNo;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void parkVehicle() {
        if (occupied)
            throw new IllegalStateException("Slot already occupied");
        occupied = true;
    }

    public void releaseSlot() {
        if (!occupied)
            throw new IllegalStateException("Slot already free");
        occupied = false;
    }
}

public class Task10 {
    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot(1, 10);

        System.out.println("Floor: " + slot.getFloorNo());
        System.out.println("Slot: " + slot.getSlotNo());
        System.out.println("Occupied: " + slot.isOccupied());

        slot.parkVehicle();
        System.out.println("After parking: " + slot.isOccupied());

        slot.releaseSlot();
        System.out.println("After release: " + slot.isOccupied());

        Integer a = 1000;
        Integer b = 1000;

        System.out.println("Using equals(): " + a.equals(b));
        System.out.println("Using ==: " + (a == b));
    }
}
