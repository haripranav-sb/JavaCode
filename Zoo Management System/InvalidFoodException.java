package ZooManagment;

public class InvalidFoodException extends Exception {
	

	InvalidFoodException(String animalName, String food) {
		super(animalName + " cannot eat " + food + "!");
	}

}
