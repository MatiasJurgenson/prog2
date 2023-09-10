import java.util.ArrayList;
import java.util.Arrays;

/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 3b
 * Teema: massiivid
 *
 * Autor: Matias Jürgenson
 *
 **********************************/

public class Kodu3b{

	/**
	 * arvude leidmine, mis korduvad igas reas
	 * @param a kahe astmeline maasiv
	 * @return arvude massiv, mis korduvad igas reas
	 */
   public static int[] korduvadRead(int[][] a){
	   //teeb koopia esimesest reast

	   //teeb rea koopia listi

	   //for tsükkel iga rea jaoks

		   	//teeb reast koopia
	   		//for tsükkel iga arvu jaoks

				//kui arv ei ole kordarvudes eemaldab koopiast
	   			//muidu eemaldab arvu kordarvudest reast

	       //tühjendab kordarvud
		   //koopia on uus esimene rida
		   //tühjendab koopia

	   //=======================================================//

	   //teeb koopia esimesest reast
	   ArrayList<Integer> kordarvud = new ArrayList<>();
	   for (int arv : a[0]) {
		   kordarvud.add(arv);
	   }

	   //teeb koopia listi
	   ArrayList<Integer> koopia = new ArrayList<>();

	   //for tsükkel iga rea jaoks
	   for (int[] rida : a){
		   //teeb reast koopia
		   for (int arv : rida) {
			   koopia.add(arv);
		   }
		   //for tsükkel iga arvu jaoks
		   for (int i = 0; i < rida.length; i++) {
			   //kui arv ei ole kordarvudes eemaldab koopiast
			   if (!kordarvud.contains(rida[i])) {
				   koopia.remove(koopia.indexOf(rida[i]));
				//muidu eemaldab arvu kordarvudest reast
			   } else {
				   kordarvud.remove(kordarvud.indexOf(rida[i]));
			   }

		   }
		   //tühjendab kordarvud
		   //koopia on uus kordarvud
		   kordarvud.removeAll(kordarvud);
		   for (int arv : koopia){
			   kordarvud.add(arv);
		   }
		   //tühjendab koopia
		   koopia.removeAll(koopia);

	   }

	   int[] lõpparvud = new int[kordarvud.size()];
	   for (int i = 0; i < lõpparvud.length; i++) {
		   lõpparvud[i] = kordarvud.get(i);
	   }
	   Arrays.sort(lõpparvud);
	   return lõpparvud;
   }


	public static void main(String[] args) {
        int[][] a=
        	{{2,2,1,4},
        	{4,1,2,2},
        	{7,1,2,2},
        	{2,10,2,1}};

		int[][] b=
				{{1,1,2,1},
						{1,2,1,1},
						{2,1,1,1},
						{1,5,4,1}};

		int[] c = korduvadRead(b);
		System.out.println(Arrays.toString(c));



	}//main

}//klass