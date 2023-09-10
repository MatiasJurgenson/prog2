public class NäitedPilt { // Jaan Janno 2023 - jaan.janno@ut.ee

    public static void main(String[] args) {
        // lisa pildifail enne jooksutamist oma projekti juurkausta! (mitte src sisse!)
        int[][] pilt = Pilt.lae("lennart.png"); // loeme pildifailist arvumaatriksi.
        // iga element kirjeldab ühe pildi punkti ehk piksli heleduse.
        // anname pildi töötle meetodile argumendiks.
        töötle(pilt, 158); // heledused on vahemikus 0 kuni 255, seega 158 on umbes keskmine heledus.
        Pilt.salvesta(pilt, "uus.png"); // kahevärvilise tulemuse salvestame uude faili.
    }

    /***
     * Muudab maatriksina etteantud pildi kahevärviliseks must-valgeks, arvestades argumendis olevat üleminekuväärtust.
     * @param pilt Töödeldav pilt.
     * @param heledus Heledus, alla mille muudetakse piksel mustaks ja üle mille valgeks.
     */
    private static void töötle(int[][] pilt, int heledus) {
        for (int rida = 0; rida < pilt.length; rida++)
            for (int veerg = 0; veerg < pilt[0].length; veerg++) {
                int piksliHeledus = pilt[rida][veerg];
                if (piksliHeledus < heledus)
                    pilt[rida][veerg] = 0;
                else
                    pilt[rida][veerg] = 255;
            }
    }
}
