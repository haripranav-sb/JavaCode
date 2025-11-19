package ZooManagment;

public class Zoo {
	
	private Animal animals[] = new Animal[10];
	private int index = 0;
	
	public void addAnimal (Animal animal) {
		this.animals[index] = animal;
		index++;
	}
	
	public void feedAllAnimals(String foodType) {
		for(int i=0; i<index; i++) {
			try {
				animals[i].feed(foodType);
				System.out.println("Feeding " + animals[i].getName() + 
						" with " + foodType + "...Success! Energy: " + animals[i].getEnergyLevel());
			} catch (InvalidFoodException e) {
				System.out.println("Error--" + e);
			}
		}
	}
	
	public void makeAllSoundsIfEnergetic() {
		for(int i=0; i<index; i++) {
			try {
				System.out.println( animals[i].getName() + 
						" says: " + animals[i].makeSound());
			} catch (LowEnergyException e) {
				System.out.println("Warning--" + e);
			}
		}
	}
}
