public class Praks1 {

	public static void yl5a(int n) {
		System.out.println("#".repeat(n));
		for (int i = 0; i < n - 2; i++) {
			System.out.println("#" + " ".repeat(n - 2) + "#");
		}
		System.out.println("#".repeat(n));
	}

	public static void yl5b(int n) {
		System.out.println("#".repeat(n));
		for (int i = 0; i < n - 2; i++) {
			System.out.println(" ".repeat(i + 1) + "#" + " ".repeat(n - 2) + "#");
		}
		System.out.println(" ".repeat(n - 1) + "#".repeat(n));
	}

	public static void yl5c(int n) {
		int tühikuid = 0;
		for (int i = 1; i <= n; i++) {
			System.out.println(" ".repeat(tühikuid) + "#".repeat(i));
			tühikuid += i;
		}
	}

	public static void yl5g(int n) {
		System.out.println(" ".repeat(n - 1) + "#");

		for (int i = 0; i < n - 2; i++) {
			System.out.println(" ".repeat(n - 2 - i) + "#" + " ".repeat(i) + "#");
		}

		for (int i = n - 2; i >= 0; i--) {
			System.out.println("#" + " ".repeat(i) + "#");
		}

		System.out.println("#");
	}

	public static int yl2(int arv) {
		int viimane = arv % 10;
		arv = arv / 10;

		int kohaline = (int) Math.log10(arv) + 1;

		return viimane * (int) Math.pow(10, kohaline) + arv;
	}

	public static void yl3a() {
		for (int abcd = 1000; abcd < 10000; abcd++) {
			int ab = abcd / 100;
			int cd = abcd % 100;
			if (cd < 10) continue;

			if (abcd == Math.pow(ab + cd, 2)) {
				System.out.println(abcd);
			}
		}
	}

	public static void yl3b() {
		for (int ab = 10; ab < 100; ab++) {
			for (int cd = 10; cd < 100; cd++) {
				int abcd = ab * 100 + cd;

				if (abcd == Math.pow(ab + cd, 2)) {
					System.out.println(abcd);
				}
			}
		}
	}

	public static void yl4() {
		for (int a = 1; a < 10; a++) {
			for (int b = 1; b < 10; b++) {
				if (a == b) continue;

				for (int c = 1; c < 10; c++) {
					if (a == c || b == c) continue;

					int ab = a * 10 + b;
					int bc = b * 10 + c;

					if (ab * c == bc * a) {
						System.out.println(ab + "/" + bc);
					}
				}
			}
		}
	}

	public static int yl7(int n) {
		int summa = 0;
		for (int i = 1; i <= n - 1; i += 2) {
			summa += i * (i + 1);
		}
		return summa;
	}
	
	public static int yl7Test() {
		for (int i = 2022; i <= 2500; i += 2) {
			int tulemus = yl7(i);

			if (tulemus < 0) {
				return i - 2;
			}
		}
		throw new RuntimeException();
	}

	public static double yl9(int arv) {
		int sees = 0;

		for (int i = 0; i < arv; i++) {
			double a = Math.random();
			double b = Math.random();

			if (Math.sqrt(a * a + b * b) < 1) {
				sees++;
			}
		}

		return 4.0 * sees / arv;
	}

	public static void main(String[] args) {
		System.out.println(yl9(10));
		System.out.println(yl9(1000));
		System.out.println(yl9(100000));
		System.out.println(yl9(100000000));
	}

}
