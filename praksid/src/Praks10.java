import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Praks10 {
	public static int yl1(String s, char sümbol) {
		int mitu = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == sümbol) mitu++;
		}
		return mitu;
	}

	public static int yl1Teine(String s, char sümbol) {
		int mitu = 0;
		for (char c : s.toCharArray()) {
			if (c == sümbol) mitu++;
		}
		return mitu;
	}

	public static void yl2(String s) {
		for (int i = 0; i < s.length() - 2; i++) {
			System.out.println(s.substring(i, i + 3));
		}
	}

	public static void yl3(String s) {
		for (char c : s.toCharArray()) {
			if (s.indexOf(c) == s.lastIndexOf(c)) System.out.println(c);
		}
	}

	public static void yl3Map(String s) {
		Map<Character, Integer> kogused = new HashMap<>();

		for (char c : s.toCharArray()) {
			kogused.put(c, kogused.getOrDefault(c, 0) + 1);
		}

		for (Map.Entry<Character, Integer> kirje : kogused.entrySet()) {
			if (kirje.getValue() == 1) System.out.println(kirje.getKey());
		}
	}

	public static void yl4(String s) {
		for (int i = 0; i < s.length(); ) {
			char sümbol = s.charAt(i);

			int algus = i;
			while (i < s.length() && sümbol == s.charAt(i)) i++;

			if (i - algus >= 2) System.out.println(String.valueOf(sümbol).repeat(i - algus));
		}
	}

	public static void yl5(String s1, String s2) {
		Map<Character, Integer> kogused1 = new HashMap<>();
		Map<Character, Integer> kogused2 = new HashMap<>();

		for (char c : s1.toCharArray()) {
			kogused1.put(c, kogused1.getOrDefault(c, 0) + 1);
		}

		for (char c : s2.toCharArray()) {
			kogused2.put(c, kogused2.getOrDefault(c, 0) + 1);
		}

		for (char c : kogused1.keySet()) {
			if (kogused1.get(c) == 1) {
				if (kogused2.getOrDefault(c, 0) == 1) System.out.println(c);
			}
		}
	}

	public static void yl6(String s) {
		for (int pikkus = 2; pikkus < s.length(); pikkus++) {
			for (int i = 0; i < s.length() - pikkus + 1; i++) {
				String alam = s.substring(i, i + pikkus);

				if (s.indexOf(alam) == i && s.lastIndexOf(alam) > i) {
					System.out.println(alam);
				}
			}
		}
	}

	public static String yl7(String s) {
		for (int i = 1; i < s.length() - 1; i++) {
			char sümbol = s.charAt(i);

			if (s.indexOf(sümbol) < i && s.lastIndexOf(sümbol) > i) {
				s = s.substring(0, i) + s.substring(i + 1);
			}
		}
		return s;
	}

	public static String yl8(String s) {
		char[] massiiv = s.toCharArray();
		Arrays.sort(massiiv);
		return new String(massiiv);
	}

	public static boolean yl9(String s1, String s2) {
		if (s1.length() != s2.length()) return false;

		char[] massiiv1 = s1.toCharArray();
		char[] massiiv2 = s2.toCharArray();
		Arrays.sort(massiiv1);
		Arrays.sort(massiiv2);

		return Arrays.equals(massiiv1, massiiv2);
	}

	public static void main(String[] args) {
		yl4("abbbaaacabbbbac");
	}
}
