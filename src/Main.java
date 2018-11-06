public class Main {
    public static void main(String[] args) throws OutOfFuel, ToMuchFuel {
        Car car = new Car(60, 0.6, new Point(2, 6), "Mersedes");

        System.out.println(car);

        car.drive(new Point(5, 11));

        System.out.println(car);
    }
}
