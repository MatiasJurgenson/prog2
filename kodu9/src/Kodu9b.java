import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 9b
 * Teema: sõned
 *
 * Autor: Matias Jürgenson
 *
 **********************************/

public class Kodu9b {

	/**
	 * leiab etteantud tekstifailist 10 kõige sagedasemat väiketähega algavat sõna,
	 * milles on vähemalt 5 tähte
	 * @param failinimi fail mida vaadatakse läbi
	 */
	public static void sagedasedSõnad(String failinimi){
		//throw new UnsupportedOperationException("Kirjuta oma lahendus selle rea asemele. Juhul kui ülesanne jääb lahendamata jäta see rida alles.");

		//"[.?!]" lauseteks jagamiseks vajalik
		//"[\";,«»()]", "" lusetes märkide asendamine

		//sõne kuhu terve faili tekst pannakse
		String koguSisu = "";

		//loetakse fail ridahaaval sisse
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi), "UTF-8"))) {
			String rida = br.readLine();
			while (rida != null) {
				//lisatakse lause ilma kindlate lausemärkidega
				koguSisu += rida.replaceAll("[\";,«»()]", "") + " ";
				rida = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		//sisu tehakse lauseteks
		String[] laused = koguSisu.split("[.?!]");

		Map<String, Integer> sagedus = new HashMap<>();

		//vaadatakse kõik laused läbi
		for (String lause : laused) {
			//laused tehakse sõnadeks
			String[] sõnad = lause.split(" ");
			//vaadatakse lause kõik sõnad läbi, välja arvatud lause esimene osa
			for (int i = 1; i < sõnad.length; i++) {
				String sõna = sõnad[i];

				//kui sõna on pikkem kui 4 ja sisaldab ainult väiketähti
				if (sõna.length() > 4 && sõna.toLowerCase().equals(sõna))  {
					System.out.println(sõna);
					//kui sõnas on koolon vaadatakse kas tegu on tsitaadiga
					if (sõna.contains(":") && sõna.length() > 5) {
						sõna = sõna.replace(":", "");
						// kui tegu on tsitaadiga siis minnakse järgmisest sõnast üle
						if (!sõnad[i + 1].toLowerCase().equals(sõnad[i + 1])) i++;
					}
					//lisatakse sõna või suurendatakse sõna sagedust 1 võrra
					sagedus.put(sõna, sagedus.getOrDefault(sõna, 0) + 1);
				}
			}
		}

		TreeMap<Integer, List<String>> sorteeritud = new TreeMap<>();

		//vaadatakse sõnade sagedused üle ja lisatakse sorteeritud vormis uude mappi, korduste arvu järgi
		for (String sõna : sagedus.keySet()) {
			int arv = sagedus.get(sõna);
			//kui arvu pole mappis, lisatakse see
			if (!sorteeritud.containsKey(arv)) {
				sorteeritud.put(arv, new ArrayList<>());
			}

			//lisatakse sõna
			sorteeritud.get(arv).add(sõna);
		}

		int sõnu = 0;
		int suurus = sorteeritud.lastKey();

		//väljastadakse 10 kõige sagedasemat sõna
		while (sõnu < 10) {
			//võetakse sõnad
			List<String> list = sorteeritud.get(suurus);
			list.sort(null);
			System.out.println(suurus + " korda: " + list);

			//lisatakse mitu sõna on väljastatud
			sõnu += sorteeritud.get(suurus).size();

			//proovitakse saada järgmised sagedasemad sõnad
			try {
				suurus = sorteeritud.lowerKey(suurus);
			} catch (NullPointerException e) {
				//kui rohkem sõnu ei leidu lõpetadakse töö
				break;
			}

		}
	}


	public static void main(String[] args) {
		// Siin võib vabas vormis oma lahendust testida.
		// Automaattestid töid hinnates main meetodit ei käivita. (Samas peab siiski kompileeruma!)

		sagedasedSõnad("K�rboja_sisu_puhastekst.txt");
		//sagedasedSõnad("KuldninagaMees_est.txt");
	}
}