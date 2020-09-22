
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWorker {

	public static void main(String[] args) {

		Path pathStart = Paths.get("C:/workspace/FileWorker/start.log");
		Path pathEnd = Paths.get("C:/workspace/FileWorker/end.log");
		Path pathLabel = Paths.get("C:/workspace/FileWorker/abbreviations.txt");
		List<String> timeFromStart = new ArrayList<>();
		List<String> minutesFromStart = new ArrayList<>();
		List<String> minutesFromEnd = new ArrayList<>();
		List<String> secondsFromStart = new ArrayList<>();
		List<String> secondsFromEnd = new ArrayList<>();
		List<String> linesLabel = new ArrayList<>();
		List<String> linesLabelForResult = new ArrayList<>();
		List<String> nameFromLabel = new ArrayList<>();
		List<String> carFromLabel = new ArrayList<>();
		List<String> counterSpaceForName = new ArrayList<>();
		List<String> counterSpaceForCar = new ArrayList<>();
		List<Integer> nameFromLabelLength = new ArrayList<>();
		List<Integer> carFromLabelLength = new ArrayList<>();
		Map<String, Double> mapLabelFromStart = new LinkedHashMap<>();
		Map<String, Double> mapLabelFromEnd = new LinkedHashMap<>();
		Map<String, Double> mapResult = new LinkedHashMap<>();
		try (Stream<String> lineStream = Files.lines(pathStart)) {
			timeFromStart = lineStream.sorted().collect(Collectors.toList());
		} catch (IOException e) {
			e.getStackTrace();
		}
		System.out.println("start.log");
		System.out.println();
		for (String line : timeFromStart) {
			System.out.print(line.substring(0, 3) + " ");
			System.out.print(line.substring(17, 19) + " ");
			System.out.println(line.substring(20, line.length()));
			minutesFromStart.add(line.substring(17, 19));
			secondsFromStart.add(line.substring(20, line.length()));
			mapLabelFromStart.put(line.substring(0, 3),
					((new Integer(line.substring(17, 19)) * 60) + (new Double(line.substring(20, line.length()))))
							/ 60);
		}
		List<String> timeFromEnd = new ArrayList<>();
		try (Stream<String> lineStream = Files.lines(pathEnd)) {
			timeFromEnd = lineStream.sorted().collect(Collectors.toList());
		} catch (IOException e) {
			e.getStackTrace();
		}
		System.out.println();
		System.out.println("end.log");
		System.out.println();
		for (String line : timeFromEnd) {
			System.out.print(line.substring(0, 3) + " ");
			System.out.print(line.substring(17, 19) + " ");
			System.out.println(line.substring(20, line.length()));
			minutesFromEnd.add(line.substring(17, 19));
			secondsFromEnd.add(line.substring(20, line.length()));
			mapLabelFromEnd.put(line.substring(0, 3),
					((new Integer(line.substring(17, 19)) * 60) + (new Double(line.substring(20, line.length()))))
							/ 60);
		}
		try (Stream<String> lineStream = Files.lines(pathLabel)) {
			linesLabel = lineStream.sorted().collect(Collectors.toList());
		} catch (IOException e) {
			e.getStackTrace();
		}
		System.out.println();
		System.out.println("abrv.txt");
		System.out.println();
		Collections.sort(linesLabel);
		for (String s : linesLabel) {
			System.out.println(s);
			linesLabelForResult.add(s.substring(4, s.length()));
		}
		for (String line : linesLabelForResult) {
			String[] nameAndCar = line.split("_");
			nameFromLabel.add(nameAndCar[0]);
			nameFromLabelLength.add(nameAndCar[0].length());
			carFromLabel.add(nameAndCar[1]);
			carFromLabelLength.add(nameAndCar[1].length());
		}
		System.out.println();

		int nameFromLabelLengthMax = Collections.max(nameFromLabelLength);
		int carFromLabelLengthMax = Collections.max(carFromLabelLength);
		System.out.println();
		for (String line : nameFromLabel) {
			System.out.println(countSpaceWithPipeline(line, nameFromLabelLengthMax));
			counterSpaceForName.add(countSpaceWithPipeline(line, nameFromLabelLengthMax));
		}
		System.out.println();
		for (String line : carFromLabel) {
			System.out.println(countSpaceWithPipeline(line, carFromLabelLengthMax));
			counterSpaceForCar.add(countSpaceWithPipeline(line, carFromLabelLengthMax));
		}

		List<String> nameAndCarFromLabel = new ArrayList<>();
		for (int i = 0; i < nameFromLabel.size(); i++) {
			nameAndCarFromLabel.add(counterSpaceForName.get(i) + " " + counterSpaceForCar.get(i));
		}
		System.out.println();
		for (String line : nameAndCarFromLabel) {
			System.out.println(line);
		}
		System.out.println();

		System.out.println(mapLabelFromStart);
		System.out.println(mapLabelFromEnd);
		List<Double> valuesMapLabelFromStart = new ArrayList<>(mapLabelFromStart.values());
		List<Double> valuesMapLabelFromEnd = new ArrayList<>(mapLabelFromEnd.values());
		System.out.println(valuesMapLabelFromStart);
		System.out.println(valuesMapLabelFromEnd);
		List<Double> valuesTimeOfLap = new ArrayList<>();
		for (int i = 0; i < valuesMapLabelFromStart.size(); i++) {
			valuesTimeOfLap.add(valuesMapLabelFromEnd.get(i) - valuesMapLabelFromStart.get(i));
		}
		System.out.println(valuesTimeOfLap);

		for (int i = 0; i < valuesTimeOfLap.size(); i++) {
			System.out.println(valuesTimeOfLap.get(i));
			mapResult.put(nameAndCarFromLabel.get(i), valuesTimeOfLap.get(i));
		}
		System.out.println(mapResult);
		System.out.println();
		for (Map.Entry<String, Double> pair : mapResult.entrySet()) {
			System.out.println(pair.getKey() + " " + pair.getValue());
		}

		List<Map.Entry<String, Double>> listResult = new ArrayList<>(mapResult.entrySet());
		Collections.sort(listResult, new Comparator<Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> time1, Entry<String, Double> time2) {
				return time1.getValue().compareTo(time2.getValue());
			}

		});
		System.out.println();
		LinkedHashMap<String, Double> sortedMapResult = new LinkedHashMap<>();
		for (int i = 0; i < listResult.size(); i++) {
			System.out.println(listResult.get(i));
			Map.Entry<String, Double> mapFromListResult = listResult.get(i);
			sortedMapResult.put(mapFromListResult.getKey(), mapFromListResult.getValue());
		}
		int idDriver = 1;
		StringBuilder resultInString = new StringBuilder();
		for (Map.Entry<String, Double> pair : sortedMapResult.entrySet()) {
			if (idDriver == 16) {
				System.out.println("---------------------------------------------------------");
				resultInString.append("-------------------------------------------------------------------------"
						+ System.lineSeparator());
			}
			if (idDriver >= 10) {
				System.out.format("%d" + "%s" + "%s" + " " + "%.5f\n", idDriver, countSpace(".", 1), pair.getKey(),
						pair.getValue());
				String timeReplaceSign = String.valueOf(pair.getValue()).replace(".", ":");
				String timeMinutesAndSeconds = timeReplaceSign.substring(0, 4);
				String timeMilliseconds = timeReplaceSign.substring(3, 6);
				String timeResult = timeMinutesAndSeconds + "." + timeMilliseconds;
				System.out.println(timeResult);
				resultInString
						.append(idDriver + countSpace(".", 1) + pair.getKey() + " " + timeResult + System.lineSeparator());
			} else {
				System.out.format("%d" + "%s" + "%s" + " " + "%.5f\n", idDriver, countSpace(".", 2), pair.getKey(),
						pair.getValue());
				String timeReplaceSign = String.valueOf(pair.getValue()).replace(".", ":");
				String timeMinutesAndSeconds = timeReplaceSign.substring(0, 4);
				String timeMilliseconds = timeReplaceSign.substring(3, 6);
				String timeResult = timeMinutesAndSeconds + "." + timeMilliseconds;
				System.out.println(timeResult);
				resultInString
						.append(idDriver + countSpace(".", 2) + pair.getKey() + " " + timeResult + System.lineSeparator());
			}
			idDriver++;

		}
		System.out.println();
		System.out.println(resultInString);

		try (FileWriter writer = new FileWriter("C:/workspace/FileWorker/result.txt", false)) {
			try {
				writer.write(resultInString.toString());
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	static String countSpaceWithPipeline(String string, int maxLengthString) {
		while (string.length() < maxLengthString + 5) {
			string += " ";
		}
		string += "|";
		return string;
	}

	static String countSpace(String string, int maxLengthString) {
		while (string.length() < maxLengthString + 1) {
			string += " ";
		}
		return string;
	}

}
