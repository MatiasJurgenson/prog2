import java.util.Arrays;

public class Praks3 {
	public static void vaheta(int[] m, int i, int j) {
		int ajutine = m[i];
		m[i] = m[j];
		m[j] = ajutine;
	}

	public static void yl1a(int[] m) {
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

	public static void yl1b(int[] m) {
		int koht = 0;
		for (int i = 0; i < m.length; i++) {
			if (i > koht && m[i] % 2 == 0) {
				vaheta(m, i, koht);
				while (m[koht] % 2 == 0) {
					koht++;
					if (koht >= m.length) return;
				}
			}
		}
	}

	public static void yl2(int[] m) {
		int[] koopia = m.clone();
		Arrays.sort(koopia);

		int kust = 0;
		for (int i = 0; i < m.length; i += 2) {
			m[i] = koopia[kust];
			kust++;
		}
		kust = koopia.length - 1;
		for (int i = 1; i < m.length; i += 2) {
			m[i] = koopia[kust];
			kust--;
		}
	}

	public static void yl3(int[] m, int k) {
		k %= m.length;
		if (k < 0) k += m.length;

		int[] abi = m.clone();

		for (int i = 0; i < m.length; i++) {
			int kuhu = (i + k) % m.length;
			m[kuhu] = abi[i];
		}
	}

	public static void yl4(int[] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = i + 1; j < m.length; j++) {
				int a1 = m[i], a2 = m[j];
				int a3 = a2 + (a2 - a1);

				for (int k = j + 1; k < m.length; k++) {
					if (m[k] == a3) System.out.printf("(%d, %d, %d)%n", a1, a2, a3);
				}
			}
		}
	}

	public static void yl5(int[] m) {
		int arv = m[m.length - 1];
		for (int i = m.length - 2; i >= 0; i--) {
			int ajutine = arv;
			if (m[i] > arv) {
				arv = m[i];
			}
			m[i] = ajutine;
		}
	}

	public static boolean yl6(int[] m) {
		for (int i = 0; i < m.length - 1; i++) {
			int summa = m[i] + m[i + 1];
			for (int el : m) {
				if (el == summa) {
					System.out.printf("(%d, %d, %d)%n", m[i], m[i + 1], summa);
					return true;
				}
			}
		}
		return false;
	}

	public static boolean kahendOtsing(int[] m, int otsitav) {
		int algus = 0, lõpp = m.length - 1;
		while (algus <= lõpp) {
			int kesk = algus + (lõpp - algus) / 2;
			if (m[kesk] == otsitav) return true;

			if (m[kesk] > otsitav) {
				lõpp = kesk - 1;
			} else {
				algus = kesk + 1;
			}
		}
		return false;
	}

	public static boolean yl6Edasiarendus(int[] m) {
		int[] koopia = m.clone();
		Arrays.sort(koopia);

		for (int i = 0; i < m.length - 1; i++) {
			int summa = m[i] + m[i + 1];
			if (kahendOtsing(koopia, summa)) {
				System.out.printf("(%d, %d, %d)%n", m[i], m[i + 1], summa);
				return true;
			}
		}
		return false;
	}

	public static void yl7(int[] m) {
		Arrays.sort(m);
		System.out.println(Arrays.toString(m));

		int vähim = Integer.MAX_VALUE;
		for (int i = 0; i < m.length - 2; i++) {
			int vahe = m[i + 2] - m[i];
			if (vähim > vahe) vähim = vahe;
		}

		for (int i = 0; i < m.length - 2; i++) {
			int vahe = m[i + 2] - m[i];
			if (vahe == vähim) System.out.printf("(%d, %d, %d)%n", m[i], m[i + 1], m[i + 2]);
		}
	}

	public static void yl8(int[] a, int[] p) {
		int[] koopia = a.clone();

		for (int i = 0; i < p.length; i++) {
			int kuhu = p[i];
			a[kuhu] = koopia[i];
		}
	}

	public static void yl8Test() {
		int[] a = {25, 13, 56, 44, 75, 33};
		int[] algne = a.clone();
		int[] p = {3, 0, 4, 1, 2, 5};
		System.out.println(Arrays.toString(a));

		int i = 0;
		do {
			yl8(a, p);
			i++;
			System.out.println(Arrays.toString(a));
		} while (!Arrays.equals(a, algne));

		System.out.println("Iteratsioone: " + i);
	}

	public static void main(String[] args) {
		yl8Test();
	}
}
