public class Praks6 {

	public static void yl1(int n) {
		yl1(n, "");
	}

	public static void yl1(int n, String lahutus) {
		if (n < 0) return;
		if (n == 0) {
			System.out.println(lahutus.substring(1));
			return;
		}

		yl1(n - 3, lahutus + "+3");
		yl1(n - 2, lahutus + "+2");
	}

	public static int yl2(int n) {
		return yl2(n, "");
	}

	public static int yl2(int n, String lahutus) {
		if (n < 0) return 0;
		if (n == 0) {
			System.out.println(lahutus.substring(1));
			return 1;
		}

		return yl2(n - 5, lahutus + "+5") +
				yl2(n - 4, lahutus + "+4") +
				yl2(n - 3, lahutus + "+3");
	}

	public static boolean yl3(int[] hinnad) {
		return yl3(hinnad, 0, 0);
	}

	public static boolean yl3(int[] hinnad, int indeks, int summa) {
		if (50 <= summa && summa <= 55) return true;
		if (summa > 55) return false;
		if (indeks == hinnad.length) return false;

		return yl3(hinnad, indeks + 1, summa) ||
				yl3(hinnad, indeks + 1, summa + hinnad[indeks]);
	}

	public static int yl4a(int[] hinnad) {
		return yl4a(hinnad, 0, 0);
	}

	public static int yl4a(int[] hinnad, int indeks, int summa) {
		if (summa > 100) return Integer.MIN_VALUE;
		if (indeks == hinnad.length) return summa;

		return Math.max(
				yl4a(hinnad, indeks + 1, summa),
				yl4a(hinnad, indeks + 1, summa + hinnad[indeks])
		);
	}

	public static int yl4b(int[] hinnad) {
		return yl4b(hinnad, 0, 0);
	}

	public static int yl4b(int[] hinnad, int indeks, int summa) {
		if (summa > 100) return Integer.MIN_VALUE;
		if (indeks == hinnad.length) return summa;

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= 2; i++) {
			max = Math.max(max, yl4b(hinnad, indeks + 1, summa + hinnad[indeks] * i));
		}
		return max;
	}

	public static int tõsta(int n, String kust, String kuhu, String ajutine) {
		if (n == 1) {
			System.out.printf("Tõsta ketas tornist %s torni %s.%n", kust, kuhu);
			return 1;
		}
		return 1 +
				tõsta(n - 1, kust, ajutine, kuhu) +
				tõsta(1, kust, kuhu, ajutine) +
				tõsta(n - 1, ajutine, kuhu, kust);

	}

	public static int yl6(int[] hinnad) {
		return yl6(hinnad, 0, 0);
	}

	public static int yl6(int[] hinnad, int indeks, int summa) {
		if (summa > 100) return summa;
		if (indeks == hinnad.length) return Integer.MAX_VALUE;

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= 2; i++) {
			min = Math.min(min, yl6(hinnad, indeks + 1, summa + hinnad[indeks] * i));
		}
		return min;
	}

	public static int yl7(int[] hinnadSentides) {
		return yl7(hinnadSentides, 0, 0);
	}

	public static int yl7(int[] hinnadSentides, int indeks, int summa) {
		System.out.println(indeks);
		if (summa > 10050) return 0;
		if (indeks == hinnadSentides.length) {
			if (9950 <= summa) return 1;
			return 0;
		}

		return yl7(hinnadSentides, indeks+1, summa) +
				yl7(hinnadSentides, indeks+1, summa + hinnadSentides[indeks]);
	}

	public static int yl8(int[] a) {
		return yl8(a, 0, 0);
	}

	public static int yl8(int[] a, int indeks, int summa) {
		if (indeks == a.length) {
			if (summa > 25) return 1;
			return 0;
		}

		return yl8(a, indeks + 1, summa + a[indeks]) +
				yl8(a, indeks + 1, summa + a[indeks] * 2);
	}

	public static void main(String[] args) {
		int[] hinnad = new int[]{103, 99, 3};
		System.out.println(yl7(hinnad));
		System.out.println(0.1 + 0.2);
	}
}
