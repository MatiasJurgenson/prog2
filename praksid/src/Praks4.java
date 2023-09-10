import java.util.Arrays;

public class Praks4 {

	public static char[][] yl1a(int n) {
		char[][] m = Abi.tühi(n, n);

		Arrays.fill(m[0], '#');
		for (int i = 1; i < n - 1; i++) {
			m[i][0] = '#';
			m[i][n - 1] = '#';
		}
		Arrays.fill(m[n - 1], '#');

		return m;
	}

	public static char[][] yl1b(int n) {
		int laius = 2 * n - 1;
		char[][] m = Abi.tühi(n, laius);

		for (int i = 0; i < n; i++) {
			m[0][i] = '#';
		}
		for (int i = 1; i < n - 1; i++) {
			m[i][i] = '#';
			m[i][n - 1 + i] = '#';
		}
		for (int i = n - 1; i < laius; i++) {
			m[n - 1][i] = '#';
		}

		return m;
	}

	public static int[][] yl1c(int n) {
		int laius = n * (n + 1) / 2;
		int[][] m = new int[n][laius];

		int tühikuid = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				m[i][tühikuid + j] = 7;
			}
			tühikuid += i + 1;
		}

//		for (int i = 0; i < n; i++) {
//			int tühikuid = i * (i + 1) / 2;
//			for (int j = 0; j < i + 1; j++) {
//				m[i][tühikuid + j] = '#';
//			}
//		}


		return m;
	}

	public static char[][] yl1e(int n) {
		char[][] m = Abi.tühi(n, n);

		m[0][0] = '#';

		int rida = 0, veerg = 0;
		while (true) {
			int liikus = 0;

			// paremale
			while (veerg + 1 < n && (veerg + 2 >= n || m[rida][veerg + 2] != '#')) {
				m[rida][++veerg] = '#';
				liikus++;
			}
			if (liikus < 2) break;
			liikus = 0;

			// alla
			while (rida + 1 < n && (rida + 2 >= n || m[rida + 2][veerg] != '#')) {
				m[++rida][veerg] = '#';
				liikus++;
			}
			if (liikus < 2) break;
			liikus = 0;

			// vasakule
			while (veerg - 1 >= 0 && (veerg - 2 < 0 || m[rida][veerg - 2] != '#')) {
				m[rida][--veerg] = '#';
				liikus++;
			}
			if (liikus < 2) break;
			liikus = 0;

			// üles
			while (rida - 1 >= 0 && (rida - 2 < 0 || m[rida - 2][veerg] != '#')) {
				m[--rida][veerg] = '#';
				liikus++;
			}
			if (liikus < 2) break;
		}

		return m;
	}

	public static char[][] yl2a(char[][] m, int rida1, int rida2) {
		char[][] uus = Abi.koopia(m);

		uus[rida1] = m[rida2].clone();
		uus[rida2] = m[rida1].clone();

		return uus;
	}

	public static char[][] yl2b(char[][] m, int veerg1, int veerg2) {
		char[][] uus = Abi.koopia(m);

		for (int i = 0; i < m.length; i++) {
			uus[i][veerg1] = m[i][veerg2];
			uus[i][veerg2] = m[i][veerg1];
		}

		return uus;
	}

	public static int[][] yl3a(int[][] m) {
		int laius = m[0].length;
		int[][] uus = new int[m.length][laius];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < laius; j++) {
				uus[i][j] = m[i][laius - 1 - j];
			}
		}

		return uus;
	}

	public static int[][] yl3b(int[][] m) {
		int laius = m[0].length;
		int[][] uus = new int[m.length][laius];
		for (int i = 0; i < m.length; i++) {
			uus[i] = m[m.length - 1 - i].clone();
		}

		return uus;
	}

	public static int[][] yl3c(int[][] m) {
		int algneLaius = m[0].length;
		int[][] uus = new int[algneLaius][m.length];

		for (int ridaM = 0; ridaM < m.length; ridaM++) {
			for (int veergM = 0; veergM < algneLaius; veergM++) {
				uus[veergM][m.length - 1 - ridaM] = m[ridaM][veergM];
			}
		}

		return uus;
	}

	public static int[][] yl3d(int[][] m) {
		int algneLaius = m[0].length;
		int[][] uus = new int[algneLaius][m.length];

		for (int ridaM = 0; ridaM < m.length; ridaM++) {
			for (int veergM = 0; veergM < algneLaius; veergM++) {
				uus[algneLaius - 1 - veergM][ridaM] = m[ridaM][veergM];
			}
		}

		return uus;
	}

	public static int yl4a(int[][] m) {
		int summa = 0;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < i && j < m[0].length; j++) {
				summa += m[i][j];
			}
		}

		return summa;
	}

	public static void yl4b(int[][] m) {
		int suurimSumma = Integer.MIN_VALUE;
		int mituSuurimat = 0;

		for (int rida = 0; rida < m.length - 1; rida++) {
			for (int veerg = 0; veerg < m[0].length - 1; veerg++) {
				int summa = summa2x2(m, rida, veerg);

				if (summa == suurimSumma) mituSuurimat++;

				if (summa > suurimSumma) {
					suurimSumma = summa;
					mituSuurimat = 1;
				}
			}
		}

		System.out.println("Suurim summa: " + suurimSumma);
		System.out.println("Suurimate arv: " + mituSuurimat);
	}

	private static int summa2x2(int[][] maatriks, int rida, int veerg) {
		int summa = 0;

		for (int i = rida; i < rida + 2; i++) {
			for (int j = veerg; j < veerg + 2; j++) {
				summa += maatriks[i][j];
			}
		}

		return summa;
	}

	public static void main(String[] args) {
		//int[][] juhuslik = Abi.juhuslik(3, 3, 1, 9);
		char[][] m = yl1e(9);
		Abi.väljasta(m);

//		int[][] uus = yl3a(juhuslik);
//		Abi.väljasta(uus);
//		Abi.väljasta(juhuslik);
/*
		int[][] meri = Pilt.lae("lennart.png");
		int[][] uus = yl3d(meri);
		Pilt.salvesta(uus, "vastupaeva.png");
*/
		/*
		int[][] trepp = yl1c(5);
		Abi.väljasta(trepp);
		int[][] uus = yl3c(trepp);
		Abi.väljasta(uus);
*/
	}
}
