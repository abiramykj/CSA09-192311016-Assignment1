
class Vehicle {
    protected String regNo;
    protected double rate;

    Vehicle(String regNo, double rate) {
        this.regNo = regNo;
        this.rate = rate;
        System.out.println("Vehicle constructor");
    }

    double calculateFee(int hours) {
        return rate * hours;
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo, 30);
        System.out.println("Car constructor");
    }
}

class ElectricCar extends Car {
    ElectricCar(String regNo) {
        super(regNo);
        System.out.println("ElectricCar constructor");
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo, 10);
        System.out.println("TwoWheeler constructor");
    }
}

public class Task06 {
    public static void main(String[] args) {
        System.out.println("Creating Electric Car:");
        ElectricCar e = new ElectricCar("TN01AB1111");

        System.out.println("\nCreating Two Wheeler:");
        TwoWheeler t = new TwoWheeler("TN02CD2222");

        System.out.println("\nElectric Car Fee: Rs. "
                + e.calculateFee(2));
        System.out.println("Two Wheeler Fee: Rs. "
                + t.calculateFee(2));
    }
}
