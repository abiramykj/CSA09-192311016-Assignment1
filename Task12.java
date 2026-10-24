
interface Pass {
    boolean isValid();
}

class OneDayPass implements Pass {
    private final String visitorName;
    private final int days;

    OneDayPass(String visitorName, int days) {
        this.visitorName = visitorName;
        this.days = days;
    }

    @Override
    public boolean isValid() {
        return days == 1;
    }
}

abstract class Vehicle {
    protected String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours);
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

class EBike extends Vehicle {
    EBike(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return 25;
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 60;
    }

    double calculateFee(int hours, int entryHour) {
        if (entryHour >= 9 && entryHour < 17) {
            return hours * 60;
        }
        return hours * 30;
    }
}

class PricingRule {
    double calculateParkingFee(Vehicle vehicle, int hours) {
        return vehicle.calculateFee(hours);
    }
}

public class Task12 {
    public static void main(String[] args) {
        Vehicle car = new Car("TN01AB1111");
        Vehicle bike = new EBike("TN02CD2222");
        DeliveryVan van = new DeliveryVan("TN03EF3333");

        PricingRule pricing = new PricingRule();

        System.out.println("Car Fee: Rs. "
                + pricing.calculateParkingFee(car, 2));

        System.out.println("E-Bike Flat Fee: Rs. "
                + pricing.calculateParkingFee(bike, 2));

        System.out.println("Delivery Van Fee (10 AM): Rs. "
                + van.calculateFee(2, 10));

        System.out.println("Delivery Van Fee (7 PM): Rs. "
                + van.calculateFee(2, 19));

        OneDayPass pass = new OneDayPass("Visitor", 1);
        System.out.println("Visitor One-Day Pass Valid: "
                + pass.isValid());
    }
}
