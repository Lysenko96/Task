package patterns.creational.factory;

public class Man implements IShop {

	@Override
	public String eat() {
		return drink();
	}

	@Override
	public String drink() {
		return "beer";
	}

}
