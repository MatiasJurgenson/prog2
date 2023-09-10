public class Praks11 {

	public static String yl1(String s) {
		if (s.length() == 0) return "";
		StringBuilder uus = new StringBuilder(String.valueOf(s.charAt(0)));

		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.toLowerCase(uus.charAt(uus.length() - 1)) !=
					Character.toLowerCase(c)) {
				uus.append(c);
			}
		}

		return uus.toString();
	}

	public static boolean yl2(String s, String osa) {
		if (s.length() < osa.length()) return false;
		if (osa.length() == 0) return true;

		int osaIndeks = 0;

		for (int sIndeks = 0; sIndeks < s.length(); sIndeks++) {
			if (s.charAt(sIndeks) == osa.charAt(osaIndeks)) {
				osaIndeks++;
				if (osaIndeks == osa.length()) return true;
			}
		}
		return false;
	}

	public static String yl3(String s) {
		String[] sõnad = s.split(" ");

		for (int i = 0; i < sõnad.length; i++) {
			String sõna = sõnad[i];
			if (!sõna.toUpperCase().equals(sõna)) {
				sõnad[i] = sõna.toLowerCase();
			}
		}

		return String.join(" ", sõnad); // " ".join(sõnad)
	}

	public static String yl4(String s) {
		String[] sõnad = s.split(" ");

		for (int i = 0; i < sõnad.length; i++) {
			String sõna = sõnad[i];
			if (sõna.matches(".*\\p{L}.*")) {
				sõnad[i] = sõna.replaceAll("\\d", "");
			}
		}

		return String.join(" ", sõnad); // " ".join(sõnad)
	}

	public static String yl5(String s) {
		for (int pikkus = s.length(); pikkus > 0; pikkus--) {
			for (int i = 0; i < s.length() - pikkus + 1; i++) {
				String alam = s.substring(i, i + pikkus);
				if (alam.contentEquals(new StringBuilder(alam).reverse())) return alam;
			}
		}
		return "";
	}

	public static String yl6(String s) {
		String pikim = "";
		String jooksev = "";

		for (char c : s.toCharArray()) {
			if (!jooksev.contains(String.valueOf(c))) {
				jooksev += c;
			} else {
				jooksev = jooksev.substring(jooksev.indexOf(c) + 1) + c;
			}
			if (jooksev.length() > pikim.length()) pikim = jooksev;
		}

		return pikim;
	}

	public static String yl7(String s) {
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

	public static int yl8(String[] read) {
		int pikim = 0;

		for (String rida : read) {
			String[] sõnad = rida.split(" ");
			String viimane = sõnad[sõnad.length - 1];
			if (viimane.length() > pikim) pikim = viimane.length();
		}

		return pikim;
	}

	public static String yl9(String s) {
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
}
