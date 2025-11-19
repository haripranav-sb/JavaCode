package ZooManagment;

public class LowEnergyException extends Exception{
	
	LowEnergyException(String animalName) {
		super(animalName + " is too tired to perform this action!");
	}

}
