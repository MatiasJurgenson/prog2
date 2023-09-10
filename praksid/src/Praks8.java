import java.util.Arrays;

public class Praks8 {

	public static int yl1aTsükkel(int[] massiiv) {
		int summa = 0;
		for (int arv : massiiv) summa += arv;
		return summa;
	}

	public static int yl1aUnaarne(int[] massiiv) {
		return yl1aUnaarne(massiiv, 0);
	}

	public static int yl1aUnaarne(int[] massiiv, int indeks) {
		if (indeks == massiiv.length) return 0;
		return massiiv[indeks] + yl1aUnaarne(massiiv, indeks + 1);
	}

	public static int yl1aBinaarne(int[] massiiv) {
		return yl1aBinaarne(massiiv, 0, massiiv.length);
	}

	public static int yl1aBinaarne(int[] massiiv, int indeks, int pikkus) {
		if (pikkus == 1) return massiiv[indeks];

		int pool = pikkus / 2;
		return yl1aBinaarne(massiiv, indeks, pool) +
				yl1aBinaarne(massiiv, indeks + pool, pikkus - pool);
	}

	public static int yl1bTsükkel(int[] massiiv) {
		int min = Integer.MAX_VALUE;
		for (int arv : massiiv) min = Math.min(min, arv);
		return min;
	}

	public static int yl1bUnaarne(int[] massiiv) {
		return yl1bUnaarne(massiiv, 0);
	}

	public static int yl1bUnaarne(int[] massiiv, int indeks) {
		if (indeks == massiiv.length) return Integer.MAX_VALUE;
		return Math.min(massiiv[indeks], yl1bUnaarne(massiiv, indeks + 1));
	}

	public static int yl1bBinaarne(int[] massiiv) {
		return yl1bBinaarne(massiiv, 0, massiiv.length);
	}

	public static int yl1bBinaarne(int[] massiiv, int indeks, int pikkus) {
		if (pikkus == 1) return massiiv[indeks];

		int pool = pikkus / 2;
		return Math.min(
				yl1bBinaarne(massiiv, indeks, pool),
				yl1bBinaarne(massiiv, indeks + pool, pikkus - pool)
		);
	}

	public static boolean yl2(double[] massiiv) {
		return yl2(massiiv, 0);
	}

	public static boolean yl2(double[] massiiv, int indeks) {
		if (indeks == massiiv.length) return false;
		if (0 < massiiv[indeks] && massiiv[indeks] < 1) return true;
		return yl2(massiiv, indeks + 1);
	}

	public static int yl3(int[] massiiv) {
		return yl3(massiiv, 0);
	}

	public static int yl3(int[] massiiv, int indeks) {
		if (indeks == massiiv.length) return 0;
		int mituKorda = massiiv[indeks] % 2 == 0 ? 1 : 2;
		return mituKorda * massiiv[indeks] + yl3(massiiv, indeks + 1);
	}

	public static int yl4(int[] massiiv) {
		return yl4(massiiv, 0);
	}

	public static int yl4(int[] massiiv, int indeks) {
		if (indeks == massiiv.length / 2) {
			if (massiiv.length % 2 == 0) return 0;
			return massiiv[indeks];
		}

		return massiiv[indeks] * massiiv[massiiv.length - 1 - indeks]
				+ yl4(massiiv, indeks + 1);
	}

	public static int yl5(int[] massiiv) {
		return yl5(massiiv, 0);
	}

	public static int yl5(int[] massiiv, int indeks) {
		if (indeks == massiiv.length) return 0;
		return (indeks + 1) * massiiv[indeks] + yl5(massiiv, indeks + 1);
	}

	public static double yl6(double[] massiiv) {
		return yl6(massiiv, 0);
	}

	public static double yl6(double[] massiiv, int indeks) {
		if (indeks == massiiv.length) return 1;
		double arv = massiiv[indeks] == 0 ? 1 : massiiv[indeks];
		return arv * yl6(massiiv, indeks + 1);
	}

	public static void yl7a(int[] massiiv) {
		yl7a(massiiv, 0);
	}

	public static void yl7a(int[] massiiv, int indeks) {
		if (indeks == massiiv.length - (massiiv.length % 2)) return;
		Praks2.vaheta(massiiv, indeks, indeks + 1);
		yl7a(massiiv, indeks + 2);
	}

	public static int yl7b(int[] massiiv) {
		return yl7b(massiiv, 0);
	}

	public static int yl7b(int[] massiiv, int indeks) {
		if (indeks == massiiv.length - (massiiv.length % 2)) return 0;

		boolean onSamaMärk = massiiv[indeks] < 0 == massiiv[indeks + 1] < 0;
		return (onSamaMärk ? 0 : 1) + yl7b(massiiv, indeks + 2);
	}

	public static int yl7c(int[] massiiv) {
		return yl7c(massiiv, 0);
	}

	public static int yl7c(int[] massiiv, int indeks) {
		if (indeks == massiiv.length - (massiiv.length % 2)) return 0;
		Praks2.vaheta(massiiv, indeks, indeks + 1);

		boolean onSamaMärk = massiiv[indeks] < 0 == massiiv[indeks + 1] < 0;
		return (onSamaMärk ? 0 : 1) + yl7c(massiiv, indeks + 2);
	}

	public static int yl9a(int[] massiiv) {
		return yl9a(massiiv, 0);
	}

	public static int yl9a(int[] massiiv, int indeks) {
		if (indeks == massiiv.length) return 0;
		if (massiiv[indeks] != 0) return 0;
		return 1 + yl9a(massiiv, indeks + 1);
	}

	public static boolean yl10(int[] massiiv) {
		return yl10(massiiv, 0, 0, false, false);
	}

	public static boolean yl10(int[] massiiv, int indeks, int vahe, boolean lisatud1, boolean lisatud2) {
		if (vahe == 0 && lisatud1 && lisatud2) return true;
		if (indeks == massiiv.length) return false;

		return yl10(massiiv, indeks + 1, vahe + massiiv[indeks], true, lisatud2) ||
				yl10(massiiv, indeks + 1, vahe - massiiv[indeks], lisatud1, true) ||
				yl10(massiiv, indeks + 1, vahe, lisatud1, lisatud2);
	}

	public static void main(String[] args) {
		int[] test = new int[]{0, 0};
		System.out.println(yl10(test));
	}
}
