package patterns.creational.factory;

import java.util.Optional;

public class ShopSelector {

	private static ShopSelector instance;

	private ShopSelector() {
	}

	public Optional<IShop> getShop(ShopType shopType) {
		IShop shop = null;
		switch (shopType) {
		case BAR:
			shop = new Man();
			break;
		case RESTAURANT:
			shop = new Wooman();
			break;
		case CYBERSPORTCLUB:
			shop = new Child();
			break;

		}
		return Optional.ofNullable(shop);
	}

	public static ShopSelector getInstance() {
		if (instance == null) {
			instance = new ShopSelector();
		}
		return instance;
	}

}
