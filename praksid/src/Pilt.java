/* Pilditöötluse abiklass

Pakub meetodeid piltide maatriksina sisse laadimiseks ja maatriksite piltideks salvestamiseks.
Maatriksi väärtused on int tüüpi vahemikust 0-255 ja tähistavad iga pildil oleva piksli esimese värvikanali väärtust.
Mustvalgete piltide puhul ongi vaid üks varvikanal, ning väärtus määrab piksli heleduse.
Värviliste piltide puhul on kanaleid rohkem ja saadud väärtused sõltuvad suuresti formaadist.

 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Pilt { // Tõnis Hendrik Hlebnikov 2023

    /**
     * Väljastab etteantud maatriksi konsooli.
     * Vahel on loetav.
     *
     * @param m - maatriks
     */
    public static void väljasta(int[][] m) {
        int laius = 0;
        for (int[] r : m) {
            for (int e : r) {
                laius = Math.max(laius, String.valueOf(e).length()); // negatiivsed arvud
            }
        }
        String formaat = "%" + laius + "d";
        System.out.println("_".repeat((laius + 2) * m[m.length - 1].length));
        for (int[] r : m) {
            System.out.println("[" + Arrays.stream(r).mapToObj(e -> String.format(formaat, e))
                    .collect(Collectors.joining(", ")) + "]");
        }
        System.out.println("‾".repeat((laius + 2) * m[m.length - 1].length));
    }

    /**
     * Laeb pildifaili maatriksiks
     * NB! värvilise pildi puhul laeb ainul esimese värvikanali andmed!
     *
     * @param tee failitee pildini
     * @return pildi kõrgus x laius int tüüpi maatriks
     */
    public static int[][] lae(String tee) {
        BufferedImage pilt;
        try {
            pilt = ImageIO.read(new File(tee));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Faili ei leitud absoluutselt teelt: %s",
                    Path.of(tee).toAbsolutePath()));
        }
        int kõrgus = pilt.getHeight();
        int laius = pilt.getWidth();
        int[][] piltMaatriksina = new int[kõrgus][laius];
        DataBuffer pildiAndmed = pilt.getRaster().getDataBuffer();
        SampleModel sampler = pilt.getSampleModel();
        for (int i = 0; i < kõrgus; i++) {
            for (int j = 0; j < laius; j++) {
                piltMaatriksina[i][j] = sampler.getSample(j, i, 0, pildiAndmed);
            }
        }
        return piltMaatriksina;
    }

    /**
     * Salvestab etteantud maatriksi mustvalgeks jpg tüüpi pildiks
     *
     * @param andmed int[][] maatriks pildi andmetega
     * @param tee    kaustatee ja failinimi kuhu salvestada
     */
    public static void salvesta(int[][] andmed, String tee) {
        int kõrgus = andmed.length;
        int laius = andmed[0].length;
        BufferedImage pildiAndmed = new BufferedImage(laius, kõrgus, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster pildiRaster = pildiAndmed.getRaster();
        for (int i = 0; i < kõrgus; i++) {
            for (int j = 0; j < laius; j++) {
                pildiRaster.setSample(j, i, 0, andmed[i][j]);
            }
        }
        try {
            ImageIO.write(pildiAndmed, "png", new File(tee));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
