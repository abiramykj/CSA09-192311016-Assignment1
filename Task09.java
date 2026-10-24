
interface Chargeable {
    double chargingFee(int kWh);

    default void showChargingInfo() {
        System.out.println("Vehicle supports charging.");
    }

    static void displayRate() {
        System.out.println("Charging Rate: Rs. 12 per kWh");
    }
}

abstract class Vehicle {
    protected String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours);

    void display() {
        System.out.println("Registration Number: " + regNo);
    }
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

class ElectricCar extends Car implements Chargeable {
    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double chargingFee(int kWh) {
        return kWh * 12;
    }
}

public class Task09 {
    public static void main(String[] args) {
        Vehicle v1 = new TwoWheeler("TN01AB1111");
        Vehicle v2 = new Car("TN02CD2222");
        ElectricCar v3 = new ElectricCar("TN03EF3333");

        v1.display();
        System.out.println("Parking Fee: Rs. "
                + v1.calculateFee(2));

        v2.display();
        System.out.println("Parking Fee: Rs. "
                + v2.calculateFee(2));

        v3.display();
        System.out.println("Parking Fee: Rs. "
                + v3.calculateFee(2));
        System.out.println("Charging Fee: Rs. "
                + v3.chargingFee(10));

        v3.showChargingInfo();
        Chargeable.displayRate();
    }
}
