package patterns.structural.adapter;

import java.util.List;

import static java.lang.System.lineSeparator;

public class EventHorizon implements ISingularity {

	private Calculator calculator = new Calculator();

	@Override
	public void annihilation(List<Matter> list) {
		for (Matter matter : list) {
			calculator.calculateAntimatter(matter);
			System.out.println(matter.getName() + lineSeparator() + matter.getCountMatter() + lineSeparator()
					+ matter.getDataOfMatter() + lineSeparator());

		}

	}

}
