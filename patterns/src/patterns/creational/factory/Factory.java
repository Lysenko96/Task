package patterns.creational.factory;

import static java.lang.System.lineSeparator;

public class Factory {

	public static void main(String[] args) {

		IShop shop = ShopSelector.getInstance().getShop(ShopType.BAR).get();
		System.out.println(
				shop.getClass().getSimpleName() + lineSeparator() + shop.eat() + lineSeparator() + shop.drink());
		shop = ShopSelector.getInstance().getShop(ShopType.RESTAURANT).get();
		System.out.println(
				shop.getClass().getSimpleName() + lineSeparator() + shop.eat() + lineSeparator() + shop.drink());
		shop = (Child) ShopSelector.getInstance().getShop(ShopType.CYBERSPORTCLUB).get();
		System.out.println(shop.getClass().getSimpleName() + lineSeparator() + ((Child) shop).play());
	}
}
