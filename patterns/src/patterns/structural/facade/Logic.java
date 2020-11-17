package patterns.structural.facade;

import java.util.Random;

public class Logic {

	int method() {
		return new Random().nextInt(11);
	}

}
