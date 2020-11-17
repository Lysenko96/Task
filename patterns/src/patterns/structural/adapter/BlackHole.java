package patterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class BlackHole {

	public static void main(String[] args) {

		List<Matter> list = new ArrayList<>();
		Matter planetEarth = new Matter("Earth");
		Matter starSun = new Matter("Sun");
		Matter planetMars = new Matter("Mars");
		planetEarth.setCountMatter(3);
		planetEarth.setDataOfMatter(planetEarth.getName());
		starSun.setCountMatter(0);
		starSun.setDataOfMatter(starSun.getName());
		planetMars.setCountMatter(4);
		planetMars.setDataOfMatter(planetMars.getName());
		list.add(starSun);
		list.add(planetEarth);
		list.add(planetMars);

		EventHorizon eventHorizon = new EventHorizon();
		eventHorizon.annihilation(list);

	}
}
