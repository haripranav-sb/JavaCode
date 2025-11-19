package ZooManagment;

public class Elephant extends Animal implements Feedable{
	
	Elephant(String name, int age, int energyLevel) {
		super(name, age, energyLevel);
	}
	
	@Override
	public void feed(String foodType) throws InvalidFoodException {
		
		if (foodType == "plants" || foodType == "vegetables") {
			super.setEnergyLevel(getEnergyLevel() + 15);
		} else {
			throw new InvalidFoodException(getName(), foodType);
		}
	}

	@Override
	public boolean isHungry() {
		if (super.getEnergyLevel() <100) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String makeSound() throws LowEnergyException{
		if(super.getEnergyLevel() < 20) {
			throw new LowEnergyException(getName());
		} else {
			return "TRUMPET!";
		}
	}

}
