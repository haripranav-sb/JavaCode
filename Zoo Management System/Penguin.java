package ZooManagment;

public class Penguin extends Animal implements Feedable{
	
	Penguin(String name, int age, int energyLevel) {
		super(name, age, energyLevel);
	}
	
	@Override
	public void feed(String foodType) throws InvalidFoodException {
		
		if (foodType == "fish") {
			super.setEnergyLevel(getEnergyLevel() + 12);
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
			return "SQUAWK!";
		}
	}
	
	public void swim() {
		super.setEnergyLevel(getEnergyLevel()+10);
	}
}
