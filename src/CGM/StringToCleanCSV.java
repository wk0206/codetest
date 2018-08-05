package CGM;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToCleanCSV {
	public static final IllegalArgumentException exception = new IllegalArgumentException();
	static String longString = "Java is an island of Indonesia. With a population of 143 million, Java is the home of 57 percent of the Indonesian population, and is the most populous island on Earth. The Indonesian capital city, Jakarta, is located on western Java. Much of Indonesian history took place on Java. It was the center of powerful Hindu-Buddhist empires, the Islamic sultanates, and the core of the colonial Dutch East Indies. Java was also the center of the Indonesian struggle for independence during the 1930s and 1940s. Java dominates Indonesia politically, economically and culturally.\n"
			+ "\n"
			+ "Formed mostly as the result of volcanic eruptions, Java is the 13th largest island in the world and the fifth largest in Indonesia. A chain of volcanic mountains forms an east–west spine along the island. Three main languages are spoken on the island, with Javanese being the dominant; it is the native language of about 60 million people in Indonesia, most of whom live on Java. Most residents are bilingual, with Indonesian as their first or second language. While the majority of the people of Java are Muslim, Java has a diverse mixture of religious beliefs, ethnicities, and cultures.\n"
			+ "\n"
			+ "Java is divided into four provinces, West Java, Central Java, East Java, and Banten, and also two special regions, Jakarta and Yogyakarta.";

	public static void main(String[] args) {
		String[] sArray = longString.split(" ");
		try {
			// split
			Stream<String> sp = Stream.of(sArray);

			String make = sp.map(s -> checkWithOptional(s)).skip(1).collect(Collectors.joining(", "));

			// output
			OutputStream out = new BufferedOutputStream(new FileOutputStream("myFile.txt"));
			out.write(make.getBytes());
			out.close();
		} catch (Exception e) {
			System.err.println("Could not do stuff");
			System.exit(0);
		}

		// bounus
		try {
			// split
			Stream<String> sp1 = Stream.of(sArray);
			Stream<String> sp2 = Stream.of(sArray);

			// Have some clue to build TreeMap directly,
			// but failed.
			// Use TreeSet+map instead
			TreeSet<String> tSet = sp1.map(s -> checkWithOptional(s)).skip(1)
					.collect(Collectors.toCollection((TreeSet::new)));
			Map<String, Long> map = sp2.map(s -> checkWithOptional(s)).skip(1)
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			StringBuilder sb = new StringBuilder();
			for (String s : tSet) {
				sb.append(s);
				sb.append("=");
				sb.append(map.get(s));
				sb.append(",");
			}
			// output
			OutputStream out = new BufferedOutputStream(new FileOutputStream("bounusFile.txt"));
			out.write(sb.toString().getBytes());
			out.close();
		} catch (Exception e) {
			System.err.println("Could not do stuff");
			System.exit(0);
		}
	}

	/**
	*/
	public static String checkWithOptional(String word) {
		try {
			return Optional.ofNullable(word).filter(w -> (!".".equals(w))).filter(w -> (!",".equals(w)))
					.filter(w -> (!"\n".equals(w))).orElseThrow(() -> exception);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return word;
	}

	/**
	*/
	public static boolean check(String word) {
		boolean hasException = false;
		boolean hasError = false;
		if (word == null) {
			hasException = true;
		}
		if (word != null && word == ".") {
			hasError = true;
		}
		if (word != null && word == ",") {
			hasError = true;
		}
		if (word != null && word == "\n") {
			hasError = true;
		}
		if (hasException) {
			throw exception;
		}
		return !hasError;
	}

	/**
	*/
	public static String make(String[] strings) {
		String s = "";
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] != "") {
				s += ", " + strings[i];
			}
		}
		return s.substring(2);
	}

}
