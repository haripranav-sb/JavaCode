package ZooManagment;

public abstract class Animal implements Feedable{
	private String name;
	private int age;
	private int energyLevel;
	
	Animal(String name, int age, int energyLevel) {
		this.setName(name);
		this.age = age;
		if (energyLevel <0) {
			this.energyLevel = 0;
		} else if (energyLevel >100) {
			this.energyLevel = 100;
		} else {
			this.energyLevel = energyLevel;
		}
	}
	
	public String makeSound() throws LowEnergyException {
		return "The animal makes sound";
	}
	
	public String toString() {
		return "Name: " + this.getName() +
				"\n Age: " + this.age +
				"\n Energy Level: " + this.energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		if (energyLevel <0) {
			this.energyLevel = 0;
		} else if (energyLevel >100) {
			this.energyLevel = 100;
		} else {
			this.energyLevel = energyLevel;
		}
	}
	
	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
