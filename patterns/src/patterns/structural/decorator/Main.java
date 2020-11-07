package patterns.structural.decorator;

public class Main {

	public static void main(String[] args) {

		Interactive angular = new Angular();
		Interactive vue = new Vue();
		Interactive react = new React();
		
		double number = Math.random();

		if (number >= 0.333 && number <= 0.666) {
		Interactive angularAndDatabase = new MySQLControlFramework(angular);
		System.out.println(angularAndDatabase.makeDialogMenu(angular.getClass().getSimpleName()));
		System.out.println();
		} else if (number >= 0.666 && number <= 0.999) {
		// several decorators
		Interactive vueAndDatabase = new FirebirdControlFramework(new PostgreSQLControlFramework(vue));
		System.out.println(vueAndDatabase.makeDialogMenu(vue.getClass().getSimpleName()));
		System.out.println();
		} else if (number >= 0 && number <= 0.333) {
		Interactive reactAndDatabase = new FirebirdControlFramework(react);
		System.out.println(reactAndDatabase.makeDialogMenu(react.getClass().getSimpleName()));
	}

	}
}
