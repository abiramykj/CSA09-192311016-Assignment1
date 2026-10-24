public class Task02 {
    public static void main(String[] args) {
        int slotNo = 10;
        String vehicleNo = "TN01AB1111";
        long entryTime = System.currentTimeMillis();
        double duration = 2.5;
        double fee = 75.50;

        int floors = 3;
        int[] slotsPerFloor = {20, 50, 100};

        String[][] parkingSlots = new String[floors][];
        for (int i = 0; i < floors; i++) {
            parkingSlots[i] = new String[slotsPerFloor[i]];
        }

        parkingSlots[0][slotNo - 1] = vehicleNo;

        System.out.println("Slot Number: " + slotNo);
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Entry Time: " + entryTime);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Parking Fee: Rs. " + fee);

        double minutes = 90;
        double hours = Math.ceil(minutes / 60.0);
        double hourlyRate = 30;
        double calculatedFee = hours * hourlyRate;

        System.out.println("Calculated Hours: " + (int) hours);
        System.out.println("Calculated Fee: Rs. " + calculatedFee);
    }
}