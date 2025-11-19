package ZooManagment;

public class Lion extends Animal implements Feedable{
	
	Lion(String name, int age, int energyLevel) {
		super(name, age, energyLevel);
	}
	
	@Override
	public void feed(String foodType) throws InvalidFoodException {
		
		if (foodType == "meat") {
			super.setEnergyLevel(getEnergyLevel() + 20);
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
			return "ROAR!";
		}
	}
}
