package co.cofe;

import co.coffee.common.DAO;

public class Coffee extends DAO {
	private String coffeeMenu;
	private int coffeePrice;
	private String coffeeExplain;
	private int coffeeSales;

	public String getCoffeeMenu() {
		return coffeeMenu;
	}

	public void setCoffeeMenu(String coffeeMenu) {
		this.coffeeMenu = coffeeMenu;
	}

	public int getCoffeePrice() {
		return coffeePrice;
	}

	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	public String getCoffeeExplain() {
		return coffeeExplain;
	}

	public void setCoffeeExplain(String coffeeExplain) {
		this.coffeeExplain = coffeeExplain;
	}

	public int getCoffeeSales() {
		return coffeeSales;
	}

	public void setCoffeeSales(int coffeeSales) {
		this.coffeeSales = coffeeSales;
	}
}
