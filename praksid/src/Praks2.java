import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Praks2 {

	public static void yl1(int n) {
		for (int i = 0; i < n / 2; i++) {
			System.out.println(" ".repeat(i) + "#" + " ".repeat(n - 2 - 2 * i) + "#");
		}
		if (n % 2 != 0) System.out.println(" ".repeat(n / 2) + "#");
		for (int i = n / 2 - 1; i >= 0; i--) {
			System.out.println(" ".repeat(i) + "#" + " ".repeat(n - 2 - 2 * i) + "#");
		}
	}

	public static int yl2(int a, int b) {
//		if (b > a) {
//			int temp = b;
//			b = a;
//			a = temp;
//		}

		System.out.println(a + " " + b);
		while (b > 0) {
			int ajutine = a % b;
			a = b;
			b = ajutine;
			System.out.println(a + " " + b);
		}
		return a;
	}

	public static int erak() {
		int u1 = 3, u2 = 3, loendur = 0;
		while (true) {
			loendur++;

			// uksest väljumine
			if (Math.random() < 0.5) {
				if (u1 == 0) return loendur;
				u1--;
			} else {
				if (u2 == 0) return loendur;
				u2--;
			}

			// sisenemine
			if (Math.random() < 0.5) {
				u1++;
			} else {
				u2++;
			}
		}
	}

	public static int yl3(int n) {
		int kokku = 0;
		for (int i = 0; i < n; i++) {
			kokku += erak();
		}
		return (int) Math.ceil((double) kokku / n);
	}

	public static void yl4(int[] m) {
		for (int i = 0; i < m.length / 2; i++) {
			System.out.println(m[i]);
			System.out.println(m[m.length - 1 - i]);
		}
		if (m.length % 2 != 0) System.out.println(m[m.length / 2]);
	}

	public static int juhuslikArv(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	public static int[] juhuslikMassiiv2(int pikkus, int min, int max) {
		int[] m = new int[pikkus];
		for (int i = 0; i < pikkus; i++) {
			m[i] = juhuslikArv(min, max);
		}
		return m;
	}

	public static int[] juhuslikMassiiv(int pikkus, int min, int max) {
		return ThreadLocalRandom.current().ints(pikkus, min, max + 1).toArray();
	}

	public static void yl5(int[] m) {
		if (m.length == 0) return;
		if (m.length == 1) {
			System.out.println(m[0]);
			return;
		}
		Arrays.sort(m);

		if (m[0] != m[1]) System.out.println(m[0]);
		for (int i = 1; i < m.length - 1; i++) {
			if (m[i - 1] != m[i] && m[i] != m[i + 1]) {
				System.out.println(m[i]);
			}
		}
		if (m[m.length - 2] != m[m.length - 1]) System.out.println(m[m.length - 1]);
	}

	public static void yl8a(int[] m) {
		int koht = 0;
		for (int i = 0; i < m.length; i++) {
			if (m[i] % 2 == 0) {
				int ajutine = m[i];
				System.arraycopy(m, koht, m, koht + 1, i - koht);
				m[koht] = ajutine;
				koht++;
			}
		}
	}

	public static void yl8b(int[] m) {
		int koht = 0;
		for (int i = 0; i < m.length; i++) {
			if (m[i] < 0) {
				int ajutine = m[i];
				System.arraycopy(m, koht, m, koht + 1, i - koht);
				m[koht] = ajutine;
				koht++;
			}
		}
	}

	/**
	 * Vahetab massiivi m elemendid kohal i ja j
	 * @param m massiiv, mida muudame
	 * @param i esimese elemendi indeks
	 * @param j teise elemendi indeks
	 */
	public static void vaheta(int[] m, int i, int j) {
		int ajutine = m[i];
		m[i] = m[j];
		m[j] = ajutine;
	}

	// mitte päris korrektne
	public static void yl11(int[] m) {
		Arrays.sort(m);

		int kesk = (m.length - 1) / 2;
		for (int i = 1; i <= kesk; i += 2) {
			vaheta(m, i, kesk + i + 1);
		}
	}

	public static void yl13(int[] m, int k) {
		k %= m.length;
		if (k < 0) k += m.length;

		int[] abi = m.clone();

		for (int i = 0; i < m.length; i++) {
			int kuhu = (i + k) % m.length;
			m[kuhu] = abi[i];
		}
	}

	public static void main(String[] args) {
		int[] test = {3, 7, 6, 0, 3};

		System.out.println(Arrays.toString(test));
		yl13(test, -7);
		System.out.println(Arrays.toString(test));
	}
}
