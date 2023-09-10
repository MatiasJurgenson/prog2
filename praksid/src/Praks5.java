import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Praks5 {

	public static int[][] yl1(int[][] m, int i, int j) {
		int[][] uus = new int[m.length - 1][m[0].length - 1];

		for (int ridaM = 0, ridaUus = 0; ridaM < m.length; ridaM++, ridaUus++) {
			if (ridaM == i) {
				ridaUus--;
				continue;
			}

			for (int veergM = 0, veergUus = 0; veergM < m[0].length; veergM++, veergUus++) {
				if (veergM == j) {
					veergUus--;
					continue;
				}

				uus[ridaUus][veergUus] = m[ridaM][veergM];
			}

		}

		return uus;
	}

	public static int[] yl2(int[][] m) {
		int[] uss = new int[m.length * m[0].length];

		int koht = 0;
		for (int i = 0; i < m.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m[0].length; j++) {
					uss[koht++] = m[i][j];
				}
			} else {
				for (int j = m[0].length - 1; j >= 0; j--) {
					uss[koht++] = m[i][j];
				}
			}
		}

		return uss;
	}

	public static boolean yl3(int[][] m) {
		välimine:
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 0 && m[i + 1][j] == 0) continue;
				if (m[i][j] == 0 || m[i + 1][j] % m[i][j] != 0) continue välimine;
			}
			return true;
		}
		return false;
	}

	public static void yl4(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < i; j++) {
				if (m[i][j] == m[j][i]) m[i][j] = 0;
			}
		}
	}

	public static int[][] yl5(int[][] m) {
		int[][] uus = new int[m.length][];

		for (int i = 0; i < m.length; i++) {
			int kuhu = (i - 1 + m.length) % m.length;
			uus[kuhu] = m[i].clone();
		}

		return uus;
	}

	public static void yl6(int[][] m) {
		int[][] koopia = Abi.koopia(m);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = naabriteSumma(koopia, i, j);
			}
		}
	}

	private static int naabriteSumma(int[][] m, int i, int j) {
		int summa = 0;

		if (i != 0) summa += m[i - 1][j];
		if (j != 0) summa += m[i][j - 1];
		if (i != m.length - 1) summa += m[i + 1][j];
		if (j != m[0].length - 1) summa += m[i][j + 1];

		return summa;
	}

	public static int yl7(int[][] m) {
		int[] read = new int[m.length];
		int[] veerud = new int[m[0].length];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 1) {
					read[i]++;
					veerud[j]++;
				}
			}
		}

		int mitu = 0;

		for (int i = 0; i < m.length; i++) {
			if (read[i] != 1) continue;

			for (int j = 0; j < m[0].length; j++) {
				if (veerud[j] != 1) continue;

				if (m[i][j] == 1) mitu++;
			}
		}

		return mitu;
	}

	/**
	 * Antud bitimaatriksis leida (kui võimalik) suurim alammaatriks,
	 * mille igas nurgas asub 1.
	 * @param m bitimaatriks
	 * @return [rida, veerg, kõrgus, laius]
	 */
	public static int[] yl8(int[][] m){
		List<int[]> kõrgusLaius = new ArrayList<>();
		for (int i = 1; i <= m.length; i++) {
			for (int j = 1; j <= m[0].length; j++) {
				kõrgusLaius.add(new int[] {i, j});
			}
		}
		kõrgusLaius.sort(Comparator.comparingInt(kl -> kl[0] * kl[1]));

		for (int k = kõrgusLaius.size() - 1; k >= 0; k--) {
			int kõrgus = kõrgusLaius.get(k)[0];
			int laius = kõrgusLaius.get(k)[1];

			for (int i = 0; i < m.length - kõrgus + 1; i++) {
				for (int j = 0; j < m[0].length - laius + 1; j++) {
					if (m[i][j] == 1 &&
						m[i + kõrgus - 1][j] == 1 &&
						m[i][j + laius - 1] == 1 &&
						m[i + kõrgus - 1][j + laius - 1] == 1) {
						return new int[] {i, j, kõrgus, laius};
					}

				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[][] m = Abi.juhuslik(4, 4, 0, 1);
		Abi.väljasta(m);
		System.out.println(Arrays.toString(yl8(m)));
	}
}
