import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Praks9 {
	// Nii ei tohi
	public static void yl1Globaalne(int[] a) {
		ArrayList<Integer> b = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>();
		yl1Globaalne(a, 0, b, c);
		System.out.println(b);
		System.out.println(c);
	}

	// Nii ei tohi
	public static void yl1Globaalne(int[] a, int indeks, ArrayList<Integer> b, ArrayList<Integer> c) {
		if (indeks == a.length) return;
		if (indeks % 2 == 0) b.add(a[indeks]);
		else c.add(a[indeks]);
		yl1Globaalne(a, indeks + 1, b, c);
	}

	public static int[] lisa(int[] massiiv, int väärtus) {
		int[] uus = new int[massiiv.length + 1];
		System.arraycopy(massiiv, 0, uus, 0, massiiv.length);
		uus[massiiv.length] = väärtus;
		return uus;
	}

	public static void yl1(int[] a) {
		int[] b = new int[0];
		int[] c = new int[0];
		int[][] tulemus = yl1(a, 0, b, c);
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));

//		System.out.println(Arrays.toString(tulemus[0]));
//		System.out.println(Arrays.toString(tulemus[1]));
	}

	public static int[][] yl1(int[] a, int indeks, int[] b, int[] c) {
		if (indeks == a.length) return new int[][]{b, c};

		if (indeks % 2 == 0) {
			return yl1(a, indeks + 1, lisa(b, a[indeks]), c);
		}
		return yl1(a, indeks + 1, b, lisa(c, a[indeks]));

	}


	public static int yl2a(int[] massiiv) {
		return yl2a(massiiv, 0);
	}

	public static int yl2a(int[] massiiv, int indeks) {
		if (indeks == massiiv.length) return 0;
		if (massiiv[indeks] != 0) return 0;
		return 1 + yl2a(massiiv, indeks + 1);
	}

	public static boolean yl3(int[] massiiv) {
		return yl3(massiiv, 0, 0, false, false);
	}

	public static boolean yl3(int[] massiiv, int indeks, int vahe, boolean lisatud1, boolean lisatud2) {
		if (vahe == 0 && lisatud1 && lisatud2) return true;
		if (indeks == massiiv.length) return false;

		return yl3(massiiv, indeks + 1, vahe + massiiv[indeks], true, lisatud2) ||
				yl3(massiiv, indeks + 1, vahe - massiiv[indeks], lisatud1, true) ||
				yl3(massiiv, indeks + 1, vahe, lisatud1, lisatud2);
	}

	public static int[][] ühenda(int[][] a, int[][] b) {
		return Stream.of(a, b).flatMap(Stream::of).toArray(int[][]::new);
	}

	public static int[][] yl4Kordused(int[] massiiv) {
		return yl4Kordused(massiiv, new boolean[massiiv.length], new int[0]);
	}

	public static int[][] yl4Kordused(int[] massiiv, boolean[] kasutatud, int[] jooksev) {
		if (jooksev.length == massiiv.length) return new int[][]{jooksev};

		int[][] tulemus = new int[0][];
		for (int i = 0; i < massiiv.length; i++) {
			if (kasutatud[i]) continue;

			kasutatud[i] = true;
			tulemus = ühenda(tulemus, yl4Kordused(massiiv, kasutatud, lisa(jooksev, massiiv[i])));
			kasutatud[i] = false;
		}

		return tulemus;
	}

	public static int[][] yl4(int[] massiiv) {
		List<Integer> arvud = new ArrayList<>();
		List<Integer> mitu = new ArrayList<>();

		for (int väärtus : massiiv) {
			int indeks = arvud.indexOf(väärtus);
			if (indeks == -1) {
				arvud.add(väärtus);
				mitu.add(1);
			} else mitu.set(indeks, mitu.get(indeks) + 1);
		}

		return yl4(
				arvud.stream().mapToInt(i -> i).toArray(),
				mitu.stream().mapToInt(i -> i).toArray(),
				new int[0],
				massiiv.length
		);
	}

	public static int[][] yl4(int[] arvud, int[] mitu, int[] jooksev, int pikkus) {
		if (jooksev.length == pikkus) return new int[][]{jooksev};

		int[][] tulemus = new int[0][];
		for (int i = 0; i < arvud.length; i++) {
			if (mitu[i] == 0) continue;

			mitu[i] -= 1;
			tulemus = ühenda(tulemus, yl4(arvud, mitu, lisa(jooksev, arvud[i]), pikkus));
			mitu[i] += 1;
		}

		return tulemus;
	}

	public static void yl5a(int n, int k) {
		yl5a(n, k, "", 0);
	}

	public static void yl5a(int n, int k, String jooksev, int arv) {
		if (k == 0) {
			System.out.println(jooksev.substring(1));
			return;
		}
		if (arv >= n) return;

		yl5a(n, k - 1, jooksev + " " + arv, arv + 1);
		if (n - arv > k) yl5a(n, k, jooksev, arv + 1);
	}

	public static void yl5b(int n, int k) {
		yl5b(n, k, "", 0);
	}

	public static void yl5b(int n, int k, String jooksev, int arv) {
		if (k < 0) return;
		if (k == 0) {
			System.out.println(jooksev.substring(1));
			return;
		}
		if (arv >= n) return;

		for (int i = k; i >= 0; i--) {
			yl5b(n, k - i, jooksev + (" " + arv).repeat(i), arv + 1);
		}
	}

	public static int[][] lisaUus(int[][] massiiv, int väärtus) {
		int[][] uus = new int[massiiv.length + 1][];
		System.arraycopy(massiiv, 0, uus, 0, massiiv.length);
		uus[massiiv.length] = new int[]{väärtus};
		return uus;
	}

	public static int[][] yl6(int[] massiiv) {
		return yl6(massiiv, 0, new int[0][]);
	}

	public static int[][] yl6(int[] massiiv, int indeks, int[][] jooksev) {
		if (indeks == massiiv.length) return jooksev;

		if (indeks > 0 && massiiv[indeks - 1] <= massiiv[indeks]) {
			jooksev[jooksev.length - 1] = lisa(jooksev[jooksev.length - 1], massiiv[indeks]);
		} else jooksev = lisaUus(jooksev, massiiv[indeks]);

		return yl6(massiiv, indeks + 1, jooksev);
	}

	public static void yl7(int n, int s) {
		yl7(n, s, 0, 1);
	}

	public static int yl7(int n, int s, int jooksev, int jrk) {
		if (n == 0) {
			if (s == 0) {
				System.out.println(jrk + ") " + jooksev);
				return jrk + 1;
			}
			return jrk;
		}
		if (s < 0) return jrk;

		int algus = s - (n - 1) * 9;
		algus = Math.max(algus, jooksev > 0 ? 0 : 1);
		for (int i = algus; i <= 9; i++) {
			jrk = yl7(n - 1, s - i, jooksev * 10 + i, jrk);
		}

		return jrk;
	}

	public static void main(String[] args) {
		yl7(5, 2);
	}
}
