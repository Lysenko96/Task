package patterns.structural.adapter;

public class Calculator {

	public Matter calculateAntimatter(Matter weightMatter) {
		weightMatter.setCountMatter(-weightMatter.getCountMatter());
		weightMatter.setDataOfMatter(new StringBuilder(weightMatter.getDataOfMatter()).reverse().toString());
		return weightMatter;
	}
}
