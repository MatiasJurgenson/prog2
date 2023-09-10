import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 10b
 * Teema: sõned
 *
 * Autor: Matias Jürgenson
 *
 **********************************/

public class Kodu10b {

	/**
	 * leiab lühima sõnede järjendi lähtesõnast sihtsõnani
	 * @param sõnad massiiv, mille järgi järjendit luuakse
	 * @param ls lähtesõna
	 * @param ss sishtsõna
	 * @return lühim sõnede järjend
	 */
	public static String[] lühimTuletus(String[] sõnad, String ls, String ss) {
		//throw new UnsupportedOperationException("Kirjuta oma lahendus selle rea asemele. Juhul kui ülesanne jääb lahendamata jäta see rida alles.");

		//järjend, lähtesõnast sihtsõnani
		String[] järjend = new String[]{ls};

		//kui lähtesõna juba on võrdne sihtsõnaga
		if (ls.equals(ss)) {
			return järjend;
		}

		int tähtedeErinevus = 0;

		//järjend kuhu lähevad kõik senileitud ühe tähega erinevad sõnad
		String[] uued = new String[1];
		uued[0] = ls;

		//vana uued järjendi pikkus
		int vanaPikkus = 0;

		//sõna ja selle ühe tähe võrra erinevad sõnad
		Map<String, List<String>> üksTähtErinev = new HashMap<>();

		//seni kuni leidub uusi sõnu
		while (vanaPikkus != uued.length) {
			vanaPikkus = uued.length;

			//kui sihtsõna on leitud sõnade hulgas
			if (sisaldab(uued, ss)) {

				String otsitav = ss;
				String teekond = "";

				//käiakse tagurpidi läbi et leida järjend
				leiaTee:
				while (!otsitav.equals(ls)) {
					for (String võti : üksTähtErinev.keySet()) {
						if (üksTähtErinev.get(võti).contains(otsitav)){
							teekond += " " + võti;
							otsitav = võti;
							continue leiaTee;
						}
					}//for võti
				}// while

				String[] teekonnaSõnad = teekond.substring(1).split(" ");

				//lisatakse järjendisse sõnad, et jõuda sihtsõnani
				for (int i = teekonnaSõnad.length - 2; i > -1 ; i--) {
					järjend = lisa(järjend, teekonnaSõnad[i]);
				}
				return lisa(järjend, ss);
			}


			for (String uus : uued) {
				for (String sõna : sõnad) {

					//vaadatakse mitu tähte on erinevat
					for (int j = 0; j < 4; j++) {
						if (!(sõna.charAt(j) == uus.charAt(j))) {
							tähtedeErinevus++;
						}
					}

					//kui erinev vaid üks täht ja sõna pole leitud sõnade hulgas
					if (tähtedeErinevus == 1 && !sisaldab(uued, sõna)) {

						//lisatakse sõna leitud sõnade hulka
						uued = lisa(uued, sõna);
						if (!üksTähtErinev.containsKey(uus)) {
							üksTähtErinev.put(uus, new ArrayList<>());
						}

						//lisatakse sõna sellega ühe tähe võrra erineva hulka
						üksTähtErinev.get(uus).add(sõna);
					}
					tähtedeErinevus = 0;

				}//for sõna
			}//for uus
		}//while

		//kui ei leidu
		return null;
	}

	/**
	 * lisab massiivi kõik failis olevad read/sõnad
	 * @param failinimi fail, millest ridu loetakse
	 * @return massiivi failis olevates sõnadest
	 */
	public static String[] sõnad(String failinimi){
		//throw new UnsupportedOperationException("Kirjuta oma lahendus selle rea asemele. Juhul kui ülesanne jääb lahendamata jäta see rida alles.");

		//kuhu sõnad pannakse
		String[] massiiv = new String[0];

		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi), "UTF-8"))) {
			String rida = br.readLine();

			//loetakse iga rida failist sisse
			while (rida != null) {
				//laisatakse sõna massiivi
				massiiv = lisa(massiiv, rida);

				rida = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return massiiv;
	}

	/**
	 * abimeetod, mis vaatab kas massiiv sisaldab mingit väärtust
	 * @param a etteantud massiv
	 * @param väärtus väärtus, mida kontrollitakse, kas see on massiivi sees
	 * @return kas massiiv sisaldab arvu või mitte (true/flase)
	 */
	public static boolean sisaldab(String[] a, String väärtus) {
		for (String sõna : a) {
			if (sõna.equals(väärtus)){
				return true;
			}
		}
		return false;
	}

	/**
	 * abimeetod uue sõne lisamiseks massiivi
	 * @param massiiv etteantud massiiv
	 * @param sõne väärtus, mida sisestadakse
	 * @return uus massiiv kuhu on väärtus juurde lisatud
	 */
	public static String[] lisa(String[] massiiv, String sõne) {
		//luuakse uus massiiv, mis on ühe võrra suurem
		String[] uus = new String[massiiv.length + 1];
		//uute massiivi pannakse vana massiiv
		System.arraycopy(massiiv, 0, uus, 0, massiiv.length);
		//lisatakse uus väärtus uue massiivi lõppu
		uus[massiiv.length] = sõne;
		return uus;
	}

	//BOONUSÜLESANNE
	public static String[] pikimLühimTuletus(String[] sõnad){
		throw new UnsupportedOperationException("Kirjuta oma lahendus selle rea asemele. Juhul kui ülesanne jääb lahendamata jäta see rida alles.");
	}

	public static void main(String[] args) {
		// Siin võib vabas vormis oma lahendust testida.
		// Automaattestid töid hinnates main meetodit ei käivita. (Samas peab siiski kompileeruma!)

		String[] sõnad = sõnad("Nimis�nad4.txt");

		//lühimTuletus(sõnad, "kass", "kakk");
		System.out.println(Arrays.toString(lühimTuletus(sõnad, "kass", "kakk")));
		System.out.println(Arrays.toString(lühimTuletus(new String[]{"buss", "suss", "toss", "boss", "loss", "kana"}, "boss", "suss")));

	}
}