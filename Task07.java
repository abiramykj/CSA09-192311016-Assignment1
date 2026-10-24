
class Vehicle {
    protected String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    double calculateFee(int hours) {
        return 0;
    }

    @Override
    public String toString() {
        return "Vehicle Registration: " + regNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Vehicle))
            return false;

        Vehicle v = (Vehicle) obj;
        return regNo.equals(v.regNo);
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
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

public class Task07 {
    public static void main(String[] args) {
        Vehicle v1 = new TwoWheeler("TN01AB1111");
        Vehicle v2 = new Car("TN02CD2222");
        Vehicle v3 = new Car("TN02CD2222");

        System.out.println(v1);
        System.out.println("Two Wheeler Fee: Rs. "
                + v1.calculateFee(2));

        System.out.println(v2);
        System.out.println("Car Fee: Rs. "
                + v2.calculateFee(2));

        System.out.println("Same Registration: "
                + v2.equals(v3));
    }
}
