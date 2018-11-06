public class Car {
    private double fuelAmount;
    private double fuelCapacity;
    private double fuelConsumption;
    private Point location;
    private String model;

    public Car(double fuelCapacity, double fuelConsumption, Point location, String model) {
        this.fuelAmount = fuelCapacity;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.location = location;
        this.model = model;
    }


    public double getFuelAmount() {
        return this.fuelAmount;
    }
    public double getFuelCapacity() {
        return this.fuelCapacity;
    }
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }
    public Point getLocation() {
        return this.location;
    }
    public String getModel() {
        return this.model;
    }

    public void drive(Point destination) throws OutOfFuel {
        double distance      = location.distance(destination);
        double fuelNeeded    = distance * fuelConsumption;
        double newFuel       = fuelAmount - fuelNeeded;

        if ( newFuel < 0 ) {
            throw new OutOfFuel();
        }
        fuelAmount = newFuel;
        location = destination;
    }
    public void drive(double x, double y) throws ToMuchFuel {
        Point destination = new Point(x, y);

        double dist = location.distance(destination);
        double fuelCons = dist*fuelConsumption;

        if(fuelCons < fuelAmount){
            location = destination;
            fuelAmount -= fuelCons;
        } else {
            this.refill(fuelCapacity);
            this.drive(x, y);
        }
    }

    public void refill(double fuel) throws ToMuchFuel {
        this.fuelAmount = fuel;
        if ( fuelAmount > fuelCapacity ) {
            throw new ToMuchFuel();
        }
    }

    public String toString() {
        String car = "Car { amount: " + Double.toString(this.getFuelAmount()) + ", capacity: " + Double.toString(this.getFuelCapacity()) + ", model: " + this.getModel() + ", location: " + this.getLocation().toString() + ", consumption: " + Double.toString(this.getFuelConsumption()) + " }";
        return car;
    }
}
