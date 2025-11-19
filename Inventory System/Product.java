package InventoryManagement;

public class Product {
	
	private String SKU;
	private String description;
	private double price;
	private int quantity;
	
	Product(String SKU, int quantity, double price, String description) {
		this.setSKU(SKU);
		this.setDescription(description);
		this.setPrice(price);
		this.setQuantity(quantity);
	}
	
	Product(String SKU, String quantity, String price, String description) {
		this.setSKU(SKU);
		this.setDescription(description);
		this.setPrice(Double.parseDouble(price));
		this.setQuantity(Integer.parseInt(quantity));
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
	
	@Override
    public String toString() {
        return SKU + " | " + description + " | $" + price + " | Stock: " + quantity;
    }


}
