public class Praks13 {

	public static String yl1(String s) {
		String eelmine;
		do {
			eelmine = s;
			s = s.replaceAll("\\([^()]*\\)", "");
		} while (s.length() < eelmine.length());

		return s;
	}

	public static String yl2(String s) {
		int sügavus = 0;

		StringBuilder uus = new StringBuilder();

		for (char c : s.toCharArray()) {
			switch (c) {
				case '(' -> sügavus++;
				case ')' -> sügavus--;
				default -> {
					if (sügavus % 2 == 0) uus.append(c);
				}
			}
		}
		return uus.toString();
	}

	public static boolean yl3(String s) {
		int a = 0, b = 0;

		for (char c : s.toCharArray()) {
			c = Character.toLowerCase(c);

			if (c == 'a') a++;
			if (c == 'b') b++;

			if (b > a) return false;
		}
		return a <= b;
	}

	public static int yl4a(String s) {
		return yl4a(s, 0)[0];
	}

	public static int[] yl4a(String s, int i) {
		int summa = 0;

		for (; i < s.length(); i++) {
			char c = s.charAt(i);

			switch (c) {
				case '(' -> {
					int[] summaJaIndeks = yl4a(s, i + 1);
					summa += Math.pow(summaJaIndeks[0], 2);
					i = summaJaIndeks[1];
				}
				case ')' -> {
					return new int[]{summa, i};
				}
				default -> summa += Character.getNumericValue(c);
			}
		}

		return new int[]{summa, i};
	}

	public static int yl4b(String s) {
		return yl4b(s, 0)[0];
	}

	public static int[] yl4b(String s, int i) {
		int summa = 0;

		for (; i < s.length(); i++) {
			char c = s.charAt(i);

			switch (c) {
				case '(' -> {
					int[] summaJaIndeks = yl4b(s, i + 1);
					summa -= summaJaIndeks[0];
					i = summaJaIndeks[1];
				}
				case ')' -> {
					return new int[]{summa, i};
				}
				default -> summa += Character.getNumericValue(c);
			}
		}

		return new int[]{summa, i};
	}

	public static void yl5(int n) {
		yl5(n, 0, 0, "");
	}

	public static void yl5(int n, int avavaid, int sulgevaid, String avaldis) {
		if (avavaid == n && sulgevaid == n) {
			System.out.println(avaldis);
			return;
		}

		if (avavaid < n) yl5(n, avavaid + 1, sulgevaid, avaldis + "(");
		if (avavaid > sulgevaid) yl5(n, avavaid, sulgevaid + 1, avaldis + ")");
	}

	public static int fiboX(int n) {
		if (n < 0) return 0;

		return fiboX(0, 1, n);
	}

	public static int fiboX(int miinus1, int arv, int n) {
		if (arv > n) return arv;

		return fiboX(arv, miinus1 + arv, n);
	}

	public static int g(int n) {
		if (n < 1) return 0;
		if (n < 6) return 1 + g(n - 1);
		return 5 + g(n - 1) + 2 * g(n - 2) + g(n - 3);
	}

	public static boolean mitteKahanevadOsajärjendid(int[] a) {
		return mitteKahanevadOsajärjendid(a, Integer.MIN_VALUE, Integer.MIN_VALUE, 0);
	}

	public static boolean mitteKahanevadOsajärjendid(int[] a, int eelmine1, int eelmine2, int i) {
		if (i == a.length) return true;

		return eelmine1 < a[i] && mitteKahanevadOsajärjendid(a, a[i], eelmine2, i + 1) ||
				eelmine2 < a[i] && mitteKahanevadOsajärjendid(a, eelmine1, a[i], i + 1);
	}
}
