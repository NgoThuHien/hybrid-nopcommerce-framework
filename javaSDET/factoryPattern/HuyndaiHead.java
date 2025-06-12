package factoryPattern;

public class HuyndaiHead extends CarFactory{

    @Override
    public void viewCar() {
        System.out.println("View Huyndai car");
    }

    @Override
    public void bookCar() {
        System.out.println("Book Huyndai car");
    }

    @Override
    public void driveCar() {
        System.out.println("Drive Huyndai car");
    }
}
