import java.util.ArrayList;
import java.util.Arrays;

public class test3b10 {
    public static int[] korduvadRead(int[][] a) {
        ArrayList<Integer> vahepealne = new ArrayList<>();

        //Sorteerib maatriksi a
        for (int i = 0; i < a.length; i++) {
            Arrays.sort(a[i]);
        }

        int[] korduvateIndeks = new int[a.length];
        //System.out.println(Arrays.toString(korduvateIndeks));
        int sobivadKokku=0;

        for (int i = 0; i < a.length; i++) {
            sobivadKokku = 0;
            for (int j = 1; j < a.length; j++) {
                int hetkeIndeks = 0;
                //System.out.println(hetkeIndeks);
                while (hetkeIndeks < a.length && a[j][hetkeIndeks] < a[0][i]) {
                    System.out.println(a[j][hetkeIndeks]);
                    System.out.println(a[0][i]);
                    hetkeIndeks += 1;
                }
                if (hetkeIndeks < a.length) {
                    if (a[j][hetkeIndeks] == a[0][i]) {
                        sobivadKokku += 1;
                    }
                }
                //korduvateIndeks[j-1] = hetkeIndeks;
            }
            if (sobivadKokku == a.length-1) {
                vahepealne.add(a[0][i]);
            }
        }

        int[] output = new int[vahepealne.size()];
        Arrays.setAll(output,vahepealne::get);
        return output;
    }

    public static void main(String[] args) {
        int[][] a=
                {{-23, 1, -2, -1},
                        {1, -23, 1, 1},
                        {2, 1, -23, 1},
                        {-78, -23, 4, 1}};

        int[][] b =
                {{ 5,8,1 },
                        { 1,5,8 },
                        { 8,1,5 }};
        int[][] c =
                {{1, 2, 3, 4},
                        {5, 5, 5, 5},
                        {4, 3, 2, 1}, {3, 2, 3, 2}};
        int[][] d = {{1,1,2,1},{1,2,1,1},{2,1,1,1},{1,5,4,1}};

        System.out.println(Arrays.toString(korduvadRead(a)));
        System.out.println(Arrays.toString(korduvadRead(b)));
        System.out.println(Arrays.toString(korduvadRead(c)));
        System.out.println(Arrays.toString(korduvadRead(d)));

    }
}
