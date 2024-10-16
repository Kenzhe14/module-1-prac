import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void startEngine() {
        System.out.println(brand + model + " запустил двигатель");
    }

    public void stopEngine() {
        System.out.println(brand + model + " остановил двигатель");
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + year;
    }
}

class Car extends Vehicle {
    private int doors;
    private String transmissionType;

    public Car(String brand, String model, int year, int doors, String transmissionType) {
        super(brand, model, year);
        this.doors = doors;
        this.transmissionType = transmissionType;
    }

    @Override
    public String toString() {
        return super.toString() + "  двери " + doors + " Трансмиссия " + transmissionType;
    }
}

class Motorcycle extends Vehicle {
    private String bodyType;
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, String bodyType, boolean hasSidecar) {
        super(brand, model, year);
        this.bodyType = bodyType;
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return super.toString() + " кузов " + bodyType + " бокс " + (hasSidecar ? "Да" : "Нет");
    }
}

class Garage {
    private List<Vehicle> vehicles;

    public Garage() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void displayVehicles() {
        System.out.println("В гараже =");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}

class Fleet {
    private List<Garage> garages;

    public Fleet() {
        this.garages = new ArrayList<>();
    }

    public void addGarage(Garage garage) {
        garages.add(garage);
    }

    public void removeGarage(Garage garage) {
        garages.remove(garage);
    }

    public void searchVehicles(String model) {
        System.out.println("пойск с моделью  " + model);
        for (Garage garage : garages) {
            for (Vehicle vehicle : garage.getVehicles()) {
                if (vehicle.toString().contains(model)) {
                    System.out.println(vehicle);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Garage garage1 = new Garage();
        Garage garage2 = new Garage();
        Fleet fleet = new Fleet();

        Car car1 = new Car("BMW", "M%", 2020, 4, "Автомат");
        Car car2 = new Car("LEXUS", "LX470", 2019, 4, "Автомат");
        Motorcycle motorcycle1 = new Motorcycle("KAWASAKI", "MOTO", 2021, "Спорт", false);
        Motorcycle motorcycle2 = new Motorcycle("Davidson", "750", 2018, "Cruiser", true);

        garage1.addVehicle(car1);
        garage1.addVehicle(motorcycle1);
        garage2.addVehicle(car2);
        garage2.addVehicle(motorcycle2);

        fleet.addGarage(garage1);
        fleet.addGarage(garage2);

        garage1.displayVehicles();
        garage2.displayVehicles();

        fleet.searchVehicles("LX470");

        garage1.removeVehicle(car1);
        garage1.displayVehicles();
    }
}
