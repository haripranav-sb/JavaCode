package ZooManagment;

public interface Feedable {
	void feed(String foodType) throws InvalidFoodException;
	boolean isHungry();
}
