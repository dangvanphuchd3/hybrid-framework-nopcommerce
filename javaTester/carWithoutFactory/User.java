package carWithoutFactory;

public class User {

	public static void main(String[] args) {
		// Sáng T7
		Honda hon = new Honda();
		hon.viewCar();
		hon.driveCar();
		
		// Chiều T7
		Toyota to = new Toyota();
		to.viewCar();
		to.driveCar();
		
		// Sáng CN
		Huyndai hy = new Huyndai();
		hy.viewCar();
		hy.driveCar();
		
		// Chiều CN
		Ford ford = new Ford();
		ford.viewCar();
		ford.driveCar();
	}

}