import java.util.ArrayList;
import java.util.Arrays;

/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 8
 * Teema: sõned
 *
 * Autor: Matias Jürgenson
 *
 **********************************/

public class Kodu8 {

	/**
	 * eemaldab etteantud sõnest kõik kordusgruppid
	 * @param a etteantud sõne
	 * @return kordusgruppiteta sõne
	 */
	public static String eemaldaKordusgrupid(String a) {
		//throw new UnsupportedOperationException("Kirjuta oma lahendus selle rea asemele. Juhul kui ülesanne jääb lahendamata jäta see rida alles.");

		//koopia tegemine algsõnest ja kordustest eemaldatud sõne "tulemus" loomine
		String koopia = a;
		String tulemus;

		//seni kuni sõnes on kordusgruppe tehakse tsüklit
		tsükkel:
		while (true) {
			tulemus = "";
			int indeks = 0;

			//sõne tähthaaval läbikäimine
			for (int i = 0; i < koopia.length(); ) {
				char sümbol = koopia.charAt(i);

				int algus = i;

				//kui sümbol on sama suurendatakse i-d
				while (i < koopia.length() && sümbol == koopia.charAt(i)) {
					i++;
				}

				//kui sümbol on korduv
				if (i - algus >= 2) {
					//lisatakse tulemusele mittekorduv osa enne korduvat osa
					tulemus += koopia.substring(indeks, algus);
					indeks = i;
				}
			}

			//lisatakse ülejäänud mittekorduv osa
			tulemus += koopia.substring(indeks);

			//vaadatakse kas on korduvaid osi
			for (int i = 0; i < tulemus.length() - 1; i++) {
				//kui on tehakse tsükkel uuesti läbi saadud tulemusega
				if (tulemus.charAt(i) == tulemus.charAt(i + 1)) {
					koopia = tulemus;
					continue tsükkel;
				}
			}
			//kui pole korduvaid osi lõpetadakse tsükkel
			break tsükkel;
		}
		return tulemus;
	}

	/**
	 * Leiab kaashäälikute ühendite arvu tekstist
	 * @param a antud tekst
	 * @return mitu kaashäälikuühendit tekstis on
	 */
	public static int kaashäälikuÜhendeid(String a) {
		//throw new UnsupportedOperationException("Kirjuta oma lahendus selle rea asemele. Juhul kui ülesanne jääb lahendamata jäta see rida alles.");

		//mitu kaashääliku ühendit on
		int mitu = 0;
		ArrayList<String> kaashääliikud = new ArrayList<>(Arrays.asList("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "š", "z", "ž", "t", "v", "w", "x", "y"));

		//käiakse tekst läbi
		for (int i = 0; i < a.length(); ) {

			int algus = i;

			//kui täht on kaashäälik
			while (i < a.length() && kaashääliikud.contains(Character.toString(a.charAt(i)).toLowerCase())) {
				//kui on korduv kaashäälik viiakse kaashääliku ühendi algus edasi
				if (i > 0) {
					if (Character.toString(a.charAt(i)).equalsIgnoreCase(Character.toString(a.charAt(i-1)))) {
						algus += 1;
					}
				}
				i++;
			}

			if (i - algus >= 2) {
				//kui leidus kaashääliku ühend
				mitu++;
			} else {
				i++;
			}
		}
		return mitu;
	}

	//BOONUSÜLESANNE
	public static String[] kõikTulemused(String s){
		throw new UnsupportedOperationException("Kirjuta oma lahendus selle rea asemele. Juhul kui ülesanne jääb lahendamata jäta see rida alles.");
	}

	public static void main(String[] args) {
		// Siin võib vabas vormis oma lahendust testida.
		// Automaattestid töid hinnates main meetodit ei käivita. (Samas peab siiski kompileeruma!)
		System.out.println(eemaldaKordusgrupid("abbbaaacabbbbac"));
		System.out.println(eemaldaKordusgrupid("abbbaaacabbbbaac"));
		System.out.println(kaashäälikuÜhendeid("Mait Malmsten kehastus korstnapühkijaks."));
		System.out.println(kaashäälikuÜhendeid("loppoooaaaddroppb"));
	}
}