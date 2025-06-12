package factoryPattern;

public class EndUser {

    public static CarFactory carFactory;


    public static void main(String[] args) {
        carFactory = null;
        carFactory = getCar("Huyndai");
        carFactory.viewCar();
        carFactory.bookCar();
        carFactory.driveCar();
    }

    public static CarFactory getCar(String carName) {
        CarFactory carFactory = null;
        switch (carName) {
            case "Ford":
                return carFactory = new FordHead();
            case "Huyndai":
                return carFactory = new HuyndaiHead();
            case "Honda":
                return carFactory = new HondaHead();
            default:
                new RuntimeException("carName is invalid");
//        if(carName.equals("Ford")){
//            carFactory = new FordHead();
//        } else if (carName.equals("Huyndai")){
//            carFactory = new HuyndaiHead();
//        } else if(carName.equals("Honda")){
//            carFactory = new HondaHead();
//        }

        }
        return carFactory;
    }

}
