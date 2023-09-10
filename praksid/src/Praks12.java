import java.util.*;

public class Praks12 {

	public static String yl1(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public static String yl2(String[] sõned) {
		if (sõned.length == 0) return null;

		String lühim = lühim(sõned);

		for (int i = 0; i < lühim.length(); i++) {
			char c = sõned[0].charAt(i);

			for(String s : sõned) {
				if (s.charAt(i) != c) return s.substring(0, i);
			}
		}

		return lühim;
	}

	public static String lühim(String[] sõned) {
		return Arrays.stream(sõned).min(Comparator.comparingInt(String::length)).orElse(null);
	}

	public static String yl3(String s) {
		if (s.length() < 4) return s;
		String täishäälikud = "aeiouõäöü";

		StringBuilder uus = new StringBuilder(s.substring(0, 1));
		for (int i = 1; i < s.length() - 2; i++) {
			uus.append(s.charAt(i));
			if (
					!täishäälikud.contains(String.valueOf(s.charAt(i + 1))) &&
							täishäälikud.contains(String.valueOf(s.charAt(i + 2)))
			) {
				uus.append("-");
			}
		}

		uus.append(s.substring(s.length() - 2));

		return uus.toString();
	}

	public static String yl4(String s) {
		StringBuilder uus = new StringBuilder();

		for (int i = 0; i < s.length(); ) {
			char c = s.charAt(i);
			if (c != 'z' && c != 's') {
				uus.append(c);
				i++;
				continue;
			}

			int algus = i;
			while (i < s.length() && (
					s.charAt(i) == 'z' ||
							s.charAt(i) == 's'
			)) i++;

			uus.append(String.valueOf(c).repeat(i - algus));
		}

		return uus.toString();
	}

	public static String yl5(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		StringBuilder uus = new StringBuilder();

		int pikkus = Math.min(s1.length(), s2.length());
		for (int i = 0; i < pikkus; i++) {
			char c = s1.charAt(i);
			if (c == s2.charAt(i)){
				uus.append(c);
			}
		}

		return uus.toString();
	}

	public static boolean yl6a(String avaldis) {
		int sügavus = 0;

		for (char c : avaldis.toCharArray()) {
			switch (c) {
				case '(' -> sügavus++;
				case ')' -> sügavus--;
			}

			if (sügavus < 0) return false;
		}

		return sügavus == 0;
	}

	public static boolean yl6aRek(String avaldis) {
		return yl6aRek(avaldis, null, 0, 0) > -1;
	}

	public static int yl6aRek(String avaldis, Character tüüp, int i, int sügavus) {
		if (i == avaldis.length()) {
			if (sügavus != 0) return -1;
			return i;
		}

		for (; i < avaldis.length(); i++) {
			char c = avaldis.charAt(i);

			switch (c) {
				case '(' -> i = yl6aRek(avaldis, ')', i + 1, sügavus + 1);
				case '[' -> i = yl6aRek(avaldis, ']', i + 1, sügavus + 1);
				case '{' -> i = yl6aRek(avaldis, '}', i + 1, sügavus + 1);
				case ')', ']', '}' -> {
					if (tüüp != null && c == tüüp) return i;
					return -1;
				}
			}

			if (i < 0) return -1;
		}

		return i;
	}

	public static boolean yl7(String põiming, String s1, String s2) {
		if (põiming.length() != s1.length() + s2.length()) return false;

		return yl7(põiming, s1, s2, 0, 0, 0);
	}

	public static boolean yl7(String põiming, String s1, String s2, int i, int i1, int i2) {
		if (i == põiming.length()) return true;

		char c = põiming.charAt(i);

		return i1 < s1.length() && c == s1.charAt(i1) &&
				yl7(põiming, s1, s2, i + 1, i1 + 1, i2) ||
				i2 < s2.length() && c == s2.charAt(i2) &&
				yl7(põiming, s1, s2, i + 1, i1, i2 + 1);
	}

	public static void yl8(String[][] sõnejärjendid) {
		yl8(sõnejärjendid, 0, "")
				.stream()
				.sorted(
						Comparator.comparingInt(String::length)
								.reversed()
				)
				.forEach(System.out::println);
	}

	public static List<String> yl8(String[][] sõnejärjendid, int i, String jooksev) {
		if (i == sõnejärjendid.length) return List.of(jooksev.substring(1));

		List<String> laused = new LinkedList<>();
		for (String s : sõnejärjendid[i]) {
			laused.addAll(yl8(sõnejärjendid, i + 1, jooksev + " " + s));
		}
		return laused;
	}

	public static void main(String[] args) {
		System.out.println(yl6aRek("([{()]}{})()"));
	}
}
