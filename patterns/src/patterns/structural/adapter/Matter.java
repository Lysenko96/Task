package patterns.structural.adapter;

public class Matter {

	private String name;
	private int countMatter;
	private String dataOfMatter;

	public Matter(String nameMatter) {
		this.name = nameMatter;
	}

	public int getCountMatter() {
		return countMatter;
	}

	public void setCountMatter(int countMatter) {
		this.countMatter = countMatter;
	}

	public String getDataOfMatter() {
		return dataOfMatter;
	}

	public void setDataOfMatter(String dataOfMatter) {
		this.dataOfMatter = dataOfMatter;
	}

	public String getName() {
		return name;
	}

}
