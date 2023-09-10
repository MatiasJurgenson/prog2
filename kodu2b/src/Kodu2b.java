import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 2.b
 * Teema: massiivid ja ilm
 *
 * Autor: Matias Jürgenson
 *
 **********************************/

public class Kodu2b {

	// Kolm massiivi, mis täidetakse failist loetud andmetega
	static String[] kuupäev;
	static String[] kellaaeg;
	static double[] temperatuur;

	 public static void loeAndmed(String failitee) {
	 	//loeb andmed failist nimega "failitee"
		try {
			// Loeme failist kõik read, eeldame et faili kodeering on UTF-8
			List<String> read = Files.readAllLines(Path.of(failitee), StandardCharsets.UTF_8);

			// Määrame massiivide pikkuse
			kuupäev = new String[read.size()];
			kellaaeg = new String[read.size()];
			temperatuur = new double[read.size()];
			for (int i = 0; i < read.size(); i++) {
				// Hakime read tühikute põhjal
				String[] jupid = read.get(i).split(" ");
				// Määrame hakitud jupid vastavatesse massiividesse
				kuupäev[i] = jupid[0];
				kellaaeg[i] = jupid[1];
				temperatuur[i] = Double.parseDouble(jupid[2]);
			}
		} catch (IOException e) {
			// Faili ei leitud või lugemisel esines viga - viskame erindi ja lõpetame töö
			throw new RuntimeException("Faili " + failitee + " lugemisel tekkis viga", e);
		}
	}//loeAndmed

	/**
	 * Näidismeetod (mitte kasutamiseks): leiab antud ajal mõõdetud temperatuuri.
	 *
	 * @param päev Kuupäev kujul aaaa-kk-pp.
	 * @param kell Kellaaeg kujul tt:mm:ss.
	 * @return Temperatuur kuupäeval <b>päev</b> ajal <b>kell</b>, NaN kui andmetest puudu.
	 */
	static double temperatuurValitudPäevalJaKellal(String päev, String kell) {
		for (int i = 0; i < temperatuur.length; i++) {
			if (kuupäev[i].equals(päev) && kellaaeg[i].equals(kell))
				return temperatuur[i];
		}
		return Double.NaN;
	}

	public static void main(String[] args) {
		// Näidis
		// Failitee jooksvas kaustas. IntelliJ puhul otsitakse faili eelkõige PROJEKTI kaustast, mitte SRC kaustast
	    // Kui fail asetsetb src kaustas siis peaks failitee olema "src/ilmAegTemp_2022.txt"
		loeAndmed("ilmAegTemp_2022.txt");//loeb andmed etteantud failist
		System.out.println("Kodutöö nr 2b");
		System.out.println();

		System.out.println("Kontrolliks, massiivide algused:");
		System.out.printf("%s\t%s\t %s%n", "kuupäev[]", "kellaaeg[]", "temperatuur[]");
		for (int i = 0; i < 10; i++)
			System.out.printf("%s\t%s\t%.11f%n", kuupäev[i], kellaaeg[i], temperatuur[i]);

		System.out.println("   ...   \t".repeat(3) + "\n");

		String sünnipäev = "2022-08-29";
		String kell = "12:00:00";
		double temp = temperatuurValitudPäevalJaKellal(sünnipäev, kell);

		System.out.printf("Minu sünnipäeval aastal 2022 (%s) oli keskpäevane temperatuur: ", sünnipäev);
		if (Double.isNaN(temp))
			System.out.printf("- %nAntud aega: %s %s ei ole andmestikus!%n%n", sünnipäev, kell);
		else
			System.out.printf("%.1f kraadi.%n%n", temp);

		System.out.println(vaheMinMaxVähimPäevas());
		System.out.println(vaheMinMaxSuurimPäevas());
		System.out.println(vaheMinMaxVähimKuus());
		System.out.println(vaheMinMaxSuurimKuus());
		System.out.println(suurimMiinimum());
	}

	// Õpilase poolt teostatavad meetodid:

	/**
	 * Tagastab selle päeva kuupäev, kus vähima ja suurima temperatuuri vahe oli väikseim.
	 * @return vähima ja suurima temperatuuri väikseima vahe kuupäev
	 */
	public static String vaheMinMaxVähimPäevas() {
		// Tagastada selle päeva kuupäev, kus vähima ja suurima temperatuuri vahe oli väikseim.
		// Tagastuse näide: "2022-08-02"

		/*massiivid kus hoitakse kuupäevi ja teises massiivis selle vasatava kuupäeva vahet
		ning kolmas, kus hoitakse ühe päeva temperatuure
		 */
		ArrayList<String> päevad = new ArrayList<>();
		ArrayList<Double> vähimTempPäevas = new ArrayList<>();
		ArrayList<Double> päevaTemp = new ArrayList<>();

		String praegunePäev = kuupäev[0];
		//suvaline arv iga päeva jaoks, kuna kui anda teisugusemas failis võib olla eri arv temperatuure päevas
		int suvaline = 0;

		//käib läbi iga kuupäeva
		for (int i = 0; i < kuupäev.length; i++) {
			String päev = kuupäev[i];

			//kui praegune kuupäev ei klapi või on viimane päev
			if (!päev.equals(praegunePäev) || i == kuupäev.length-1){
				if (i == kuupäev.length-1) {
					päevaTemp.add(suvaline, temperatuur[i]);
					suvaline++;
				}
				//sorteerib temperatuurid
				Collections.sort(päevaTemp);

				// lisab päeva listi
				päevad.add(praegunePäev);
				//lisab min ja max temperatuuri vahe listi
				vähimTempPäevas.add(päevaTemp.get(suvaline-1) - päevaTemp.get(0));
				suvaline = 0;

				praegunePäev = päev;

				// teeb listi tühjaks
				päevaTemp.removeAll(päevaTemp);
			}
			// lisab temperatuuri päeva listi
			päevaTemp.add(suvaline, temperatuur[i]);
			suvaline++;

		}
		// koopia min max temperatuuride vahest
		ArrayList<Double> koopia = new ArrayList<>(vähimTempPäevas);

		//sorteerib ja leiab väikseima vahega päeva
		Collections.sort(koopia);
		double vähimVahe = koopia.get(0);
		String minPäev = päevad.get(vähimTempPäevas.indexOf(vähimVahe));

		return minPäev;
	}

	/**
	 * Tagastab selle päeva kuupäev, kus vähima ja suurima temperatuuri vahe oli suurim.
	 * @return vähima ja suurima temperatuuri suurima vahe kuupäev
	 */
	public static String vaheMinMaxSuurimPäevas() {
		// Tagastada selle päeva kuupäev, kus vähima ja suurima temperatuuri vahe oli suurim.
		// Tagastuse näide: "2022-08-08"

		/*massiivid kus hoitakse kuupäevi ja teises massiivis selle vasatava kuupäeva vahet
		ning kolmas, kus hoitakse ühe päeva temperatuure
		 */
		ArrayList<String> päevad = new ArrayList<>();
		ArrayList<Double> suurimTempPäevas = new ArrayList<>();
		ArrayList<Double> päevaTemp = new ArrayList<>();

		String praegunePäev = kuupäev[0];
		//suvaline arv iga päeva jaoks, kuna kui anda teisugusemas failis võib olla eri arv temperatuure päevas
		int suvaline = 0;

		//käib läbi iga kuupäeva
		for (int i = 0; i < kuupäev.length; i++) {
			String päev = kuupäev[i];

			//kui praegune kuupäev ei klapi või on viimane päev
			if (!päev.equals(praegunePäev) || i == kuupäev.length-1){
				if (i == kuupäev.length-1) {
					päevaTemp.add(suvaline, temperatuur[i]);
					suvaline++;
				}
				//sorteerib temperatuurid
				Collections.sort(päevaTemp);

				// lisab päeva listi
				päevad.add(praegunePäev);
				//lisab min ja max temperatuuri vahe listi
				suurimTempPäevas.add(päevaTemp.get(suvaline-1) - päevaTemp.get(0));
				suvaline = 0;

				praegunePäev = päev;

				// teeb listi tühjaks
				päevaTemp.removeAll(päevaTemp);
			}
			// lisab temperatuuri päeva listi
			päevaTemp.add(suvaline, temperatuur[i]);
			suvaline++;

		}
		// koopia min max temperatuuride vahest
		ArrayList<Double> koopia = new ArrayList<>(suurimTempPäevas);

		//sorteerib ja leiab väikseima vahega päeva
		Collections.sort(koopia);
		Collections.reverse(koopia);
		double maxVahe = koopia.get(0);
		String maxPäev = päevad.get(suurimTempPäevas.indexOf(maxVahe));

		return maxPäev;
	}

	/**
	 * Tagastab selle kuu numbri (jaanuar: 1, veebruar: 2, ...), kus vähima ja suurima temperatuuri vahe oli väikseim.
	 * @return vähima ja suurima temperatuuri väikseima vahe kuu
	 */
	public static int vaheMinMaxVähimKuus() {
		// Tagastada selle kuu number (jaanuar: 1, veebruar: 2, ...),
		// kus vähima ja suurima temperatuuri vahe oli väikseim.
		// Tagastuse näide: 12

		/*massiivid kus hoitakse kuid ja teises massiivis selle vasatava kuu vahet
		ning kolmas, kus hoitakse ühe kuu temperatuure
		 */
		ArrayList<String> kuud = new ArrayList<>();
		ArrayList<Double> vähimTempKuus = new ArrayList<>();
		ArrayList<Double> kuuTemp = new ArrayList<>();

		String praeguneKuu = kuupäev[0].substring(5, 7);
		//suvaline arv iga kuu jaoks, kuna kui anda teisugusemas failis võib olla eri arv temperatuure kuus
		int suvaline = 0;

		//käib läbi iga kuu
		for (int i = 0; i < kuupäev.length; i++) {
			String kuu = kuupäev[i].substring(5, 7);

			//kui praegune kuu ei klapi või on viimane päev
			if (!kuu.equals(praeguneKuu) || i == kuupäev.length-1){
				if (i == kuupäev.length-1) {
					kuuTemp.add(suvaline, temperatuur[i]);
					suvaline++;
				}
				//sorteerib temperatuurid
				Collections.sort(kuuTemp);

				// lisab kuu listi
				kuud.add(praeguneKuu);
				//lisab min ja max temperatuuri vahe listi
				vähimTempKuus.add(kuuTemp.get(suvaline-1) - kuuTemp.get(0));
				suvaline = 0;

				praeguneKuu = kuu;

				// teeb listi tühjaks
				kuuTemp.removeAll(kuuTemp);
			}
			// lisab temperatuuri kuu listi
			kuuTemp.add(suvaline, temperatuur[i]);
			suvaline++;

		}
		// koopia min max temperatuuride vahest
		ArrayList<Double> koopia = new ArrayList<>(vähimTempKuus);

		//sorteerib ja leiab väikseima vahega kuu
		Collections.sort(koopia);
		double vähimVahe = koopia.get(0);
		String minKuu = kuud.get(vähimTempKuus.indexOf(vähimVahe));

		return Integer.parseInt(minKuu);
	}

	/**
	 * Tagastab selle kuu numbri (jaanuar: 1, veebruar: 2, ...), kus vähima ja suurima temperatuuri vahe oli suurim.
	 * @return vähima ja suurima temperatuuri suurima vahe kuu
	 */
	public static int vaheMinMaxSuurimKuus() {
		// Tagastada selle kuu number (jaanuar: 1, veebruar: 2, ...),
		// kus vähima ja suurima temperatuuri vahe oli suurim.
		// Tagastuse näide: 1

		/*massiivid kus hoitakse kuid ja teises massiivis selle vasatava kuu vahet
		ning kolmas, kus hoitakse ühe kuu temperatuure
		 */
		ArrayList<String> kuud = new ArrayList<>();
		ArrayList<Double> suurimTempKuus = new ArrayList<>();
		ArrayList<Double> kuuTemp = new ArrayList<>();

		String praeguneKuu = kuupäev[0].substring(5, 7);
		//suvaline arv iga kuu jaoks, kuna kui anda teisugusemas failis võib olla eri arv temperatuure kuus
		int suvaline = 0;

		//käib läbi iga kuu
		for (int i = 0; i < kuupäev.length; i++) {
			String kuu = kuupäev[i].substring(5, 7);

			//kui praegune kuu ei klapi või on viimane päev
			if (!kuu.equals(praeguneKuu) || i == kuupäev.length-1){
				if (i == kuupäev.length-1) {
					kuuTemp.add(suvaline, temperatuur[i]);
					suvaline++;
				}
				//sorteerib temperatuurid
				Collections.sort(kuuTemp);

				// lisab kuu listi
				kuud.add(praeguneKuu);
				//lisab min ja max temperatuuri vahe listi
				suurimTempKuus.add(kuuTemp.get(suvaline-1) - kuuTemp.get(0));
				suvaline = 0;

				praeguneKuu = kuu;

				// teeb listi tühjaks
				kuuTemp.removeAll(kuuTemp);
			}
			// lisab temperatuuri kuu listi
			kuuTemp.add(suvaline, temperatuur[i]);
			suvaline++;

		}
		// koopia min max temperatuuride vahest
		ArrayList<Double> koopia = new ArrayList<>(suurimTempKuus);

		//sorteerib ja leiab väikseima vahega kuu
		Collections.sort(koopia);
		Collections.reverse(koopia);
		double vähimVahe = koopia.get(0);
		String maxKuu = kuud.get(suurimTempKuus.indexOf(vähimVahe));

		return Integer.parseInt(maxKuu);
	}

	/**
	 * Tagastab selle päeva kuupäeva, millel oli kõrgeim miinimumtemperatuur, võrreldes teiste päevade miinimumtemperatuuridega.
	 * @return kõrgeim miinimumtemperatuur, võrreldes teiste päevade miinimumtemperatuuridega kuupäev
	 */
	public static String suurimMiinimum() {
		// Tagastada selle päeva kuupäev, millel oli kõrgeim miinimumtemperatuur
		// võrreldes teiste päevade miinimumtemperatuuridega.
		// Tagastuse näide: "2022-07-07"

		/*massiivid kus hoitakse kuupäevi ja teises massiivis selle vasatava kuupäeva vahet
		ning kolmas, kus hoitakse ühe päeva temperatuure
		 */
		ArrayList<String> päevad = new ArrayList<>();
		ArrayList<Double> suurimMinTempPäevas = new ArrayList<>();
		ArrayList<Double> päevaTemp = new ArrayList<>();

		String praegunePäev = kuupäev[0];
		//suvaline arv iga päeva jaoks, kuna kui anda teisugusemas failis võib olla eri arv temperatuure päevas
		int suvaline = 0;

		//käib läbi iga kuupäeva
		for (int i = 0; i < kuupäev.length; i++) {
			String päev = kuupäev[i];

			//kui praegune kuupäev ei klapi või on viimane päev
			if (!päev.equals(praegunePäev) || i == kuupäev.length-1){
				if (i == kuupäev.length-1) {
					päevaTemp.add(suvaline, temperatuur[i]);
					suvaline++;
				}
				//sorteerib temperatuurid
				Collections.sort(päevaTemp);

				// lisab päeva listi
				päevad.add(praegunePäev);
				//lisab min temperatuuri listi

				suurimMinTempPäevas.add(päevaTemp.get(0));
				suvaline = 0;

				praegunePäev = päev;

				// teeb listi tühjaks
				päevaTemp.removeAll(päevaTemp);
			}
			// lisab temperatuuri päeva listi
			päevaTemp.add(suvaline, temperatuur[i]);
			suvaline++;

		}
		// koopia min temperatuuride vahest
		ArrayList<Double> koopia = new ArrayList<>(suurimMinTempPäevas);

		//sorteerib ja leiab suurima min temperatuuriga päeva
		Collections.sort(koopia);
		Collections.reverse(koopia);
		double maxMin = koopia.get(0);
		String maxPäev = päevad.get(suurimMinTempPäevas.indexOf(maxMin));

		return maxPäev;
	}
}


