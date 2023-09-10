import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 5a
 * Teema: rekursioon
 *
 * Autor: Matias Jürgenson
 *
 **********************************/

class Kodu5a {

	/**
	 * leib kas massiivis leidub arve nii et need võrduks s-iga
	 * @param x Juku taskus olevad rahamündid
	 * @param s ostusumma
	 * @return tagastab tõeväärtuse kas massiivis leidub arve nii et need
	 * võrduks s-iga kasutades samanimelist abifnktsiooni
	 */
	static boolean kasSobib(int[] x, int s){
		return kasSobib(x, s,0);
	}

	/**
	 * abifunktsioon funktsioonil kasSobib, et leida kas massiivis leidub arve nii et need võrduks s-iga
	 * @param x Juku taskus olevad rahamündid
	 * @param s ostusumma
	 * @param index massiivi läbikäimiseks vajaminev arv
	 * @return tagastab tõeväärtuse kas massiivis leidub arve nii, et need võrduks s-iga
	 */
	static boolean kasSobib(int[] x, int s, int index){

		//kui massiivis leidub vajalikud mündid
		if (s == 0) return true;

		//kui summa on väiksem kui 0 või index on lubadust suurem
		if (s < 0) return false;
		if (index == x.length) return false;

		//esimesel korral ei lahuta summast münti praegusel indexil
		//teisel korral lahutab
		return (kasSobib(x, s, index + 1) || kasSobib(x, s - x[index], index + 1));
	}

	/**
	 * saab argumendiks kaks sõnade järjendit ja tagastab massiivina kõik sellised laused, mis
	 * sisaldavad mõlema sõnajärjendi kõik elemendid nii, et kummagi järjendi sõnade omavaheline
	 * järjestus pole muutunud
	 * @param a esimene sõnade järjend
	 * @param b teine sõnade järjend
	 * @return tagastab massiivina kõik sellised laused, mis sisaldavad mõlema sõnajärjendi
	 * kõik elemendid nii, et kummagi järjendi sõnade omavaheline järjestus pole muutunud
	 */
	static String[] sonePoime(String[] a, String[] b){

		//muudab massiivid ümeber listideks
		ArrayList<String> sA = new ArrayList<>();
		ArrayList<String> sB = new ArrayList<>();
		Collections.addAll(sA, a);
		Collections.addAll(sB, b);

		ArrayList<String> väljund = new ArrayList<>();

		//abifunktsiooni kasutamine
		sonePoime(sA, sB, väljund, "");

		//listi massiiviks ümber tegemine
		String[] uus = new String[väljund.size()];
		for (int i = 0; i < väljund.size(); i++) {
			uus[i] = väljund.get(i);
		}

		return uus;
	}

	/**
	 * abifunktsiion funktsioonile sonePoime, mis tagastab massiivina kõik sellised laused, mis
	 * sisaldavad mõlema sõnajärjendi kõik elemendid nii, et kummagi järjendi sõnade omavaheline
	 * järjestus pole muutunud
	 * @param a esimene sõnade järjend
	 * @param b teine sõnade järjend
	 * @param väljund järjend lusetest, mis sisaldavad mõlema sõnajärjendi kõik elemendid nii,
	 * et kummagi järjendi sõnade omavaheline järjestus pole muutunud
	 * @param lause siia lisatakse, mõlema sõnajärjendi kõik elemendid nii,
	 * et kummagi järjendi sõnade omavaheline järjestus pole muutunud
	 * @return tagastab massiivina kõik sellised laused, mis sisaldavad mõlema sõnajärjendi
	 * kõik elemendid nii, et kummagi järjendi sõnade omavaheline järjestus pole muutunud
	 */
	static ArrayList<String> sonePoime(ArrayList<String> a, ArrayList<String> b, ArrayList<String> väljund, String lause) {

		//kui mõlemad listid on tühjad lisab lause väljundi listi ja tagastab selle
		if (a.isEmpty() && b.isEmpty()) {
			väljund.add(lause.substring(1));
			return väljund;
		}

		//mõlamast listist esimese elemendi eemaldamine
		ArrayList<String> ajutineA = new ArrayList<>();
		ArrayList<String> ajutineB = new ArrayList<>();

		if (!a.isEmpty()) {
			for (int i = 1; i < a.size(); i++) {
				ajutineA.add(a.get(i));
			}
		}

		if (!b.isEmpty()) {
			for (int i = 1; i < b.size(); i++) {
				ajutineB.add(b.get(i));
			}
		}

		//kui a on tühi jätkab ühe võrra väiksema b listiga ja
		//lisab tavalise b listi esimese liikme lausele juurde
		if (a.isEmpty()) sonePoime(a, ajutineB, väljund, lause += " " + b.get(0));

		//kui b on tühi jätkab ühe võrra väiksema a listiga ja
		//lisab tavalise a listi esimese liikme lausele juurde
		if (b.isEmpty()) sonePoime(ajutineA, b, väljund, lause += " " + a.get(0));

		//kui mõlemad pole tühjad käib läbi esmalt ühe võrra väiksema a listiga,
		//lisades  tavalise a listi esimese liikme lausele juurde ja siis
		//käib läbi ühe võrra väiksema b listiga,
		//lisades tavalise b listi esimese liikme lausele juurde
		if (!a.isEmpty() && !b.isEmpty()) {
			sonePoime(ajutineA, b, väljund, lause + " " + a.get(0));
			sonePoime(a, ajutineB, väljund, lause + " " + b.get(0));
		}

		return väljund;
	}

    public static void main(String[] args) {
		int[] x = {2,5,10,20,50,100};
		System.out.println(kasSobib(x, 137));

		String [] a = {"kas", "mina"};
		String [] b = {"olen", "siin"};

		String[] väljund = sonePoime(a, b);
		System.out.println(Arrays.toString(väljund));

    }//peameetod


}//Kodu5a
