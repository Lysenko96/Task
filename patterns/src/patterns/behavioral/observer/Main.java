package patterns.behavioral.observer;

public class Main {

	public static void main(String[] args) {
		UserOne userOne = new UserOne();
		UserTwo userTwo = new UserTwo();

		Software software = new Software();
		software.getListeners().add(userOne);
		software.getListeners().add(userTwo);
		software.createPackageForSender("package java");
	}

}
