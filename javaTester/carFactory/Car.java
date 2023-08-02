package carFactory;

public abstract class Car {
	
	// Hàm abstract
	public abstract void viewCar();
	
	public abstract void driveCar();
	
	// Hàm non-abstract
	public void bookCar(String carName) {
		System.out.println("Booking " + carName + " Car.");
	}
}
