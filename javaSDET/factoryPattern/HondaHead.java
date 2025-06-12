package factoryPattern;

public class HondaHead extends CarFactory{


    @Override
    public void viewCar() {
        System.out.println("View Honda car");
    }

    @Override
    public void bookCar() {
        System.out.println("Book Honda car");
    }

    @Override
    public void driveCar() {
        System.out.println("Drive Honda car");
    }
}
