package ZooManagment;

public class Driver {
	
	public static void main(String[] args) {
		
		// Create Animals
		Lion Leo = new Lion("Leo", 5, 60);         // energetic lion
        Elephant Ella = new Elephant("Ella", 10, 70); // will become 85 after feeding (70 + 15)
        Penguin Penny = new Penguin("Penny", 3, 10);  // tired penguin (energy < 20)
		
		//Create zoo with animals
		Zoo zoo = new Zoo();
		zoo.addAnimal(Leo);
		zoo.addAnimal(Ella);
		zoo.addAnimal(Penny);
		
		//Feeding animals
		System.out.println("=== Feeding Aniamls ===");
		zoo.feedAllAnimals("meat");
		System.out.println();
		
		//Animals make sound
		System.out.println("=== Animals Making Sound ===");
		zoo.makeAllSoundsIfEnergetic();
		
	}
}
