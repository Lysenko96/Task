package patterns.creational.singleton;

public class Main {

	public static void main(String[] args) {

		System.out.println(Singleton.instance);
		Singleton.getInstance();
		System.out.println(Singleton.instance);
		Singleton.getInstance();
		System.out.println(Singleton.instance);

	}
}
