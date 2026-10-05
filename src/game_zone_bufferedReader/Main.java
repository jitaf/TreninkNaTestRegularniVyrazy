package game_zone_bufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Objednavka> objednavky = new ArrayList<>();

        BufferedReader br = new BufferedReader(
                new FileReader("objednavky.txt")
        );

        String radek;

        while ((radek = br.readLine()) != null) {

            String[] udaje = radek.split(";");

            if (udaje.length != 5) {
                System.out.println("Neplatny radek - musi obsahovat presne 5 udaju.");
                continue;
            }

            String jmeno = udaje[0].trim();
            String email = udaje[1].trim();
            String produkt = udaje[2].trim();
            String cenaText = udaje[3].trim();
            String pocetText = udaje[4].trim();

            List<String> chyby = new ArrayList<>();

            if (!Validator.platneJmeno(jmeno)) {
                chyby.add("jmeno");
            }

            if (!Validator.platnyEmail(email)) {
                chyby.add("email");
            }

            if (!Validator.platnyProdukt(produkt)) {
                chyby.add("produkt");
            }

            double cena = 0;

            if (!Validator.platnaCena(cenaText)) {
                chyby.add("cena");
            } else {
                cena = Double.parseDouble(cenaText.replace(",", "."));
            }

            int pocetKusu = 0;

            if (!Validator.platnyPocet(pocetText)) {
                chyby.add("pocet kusu");
            } else {
                pocetKusu = Integer.parseInt(pocetText);
            }

            if (chyby.isEmpty()) {

                Objednavka objednavka = new Objednavka(
                        jmeno, email, produkt, cena, pocetKusu
                );

                objednavky.add(objednavka);

                System.out.println("Radek je platny.");

            } else {

                System.out.println("Radek neni platny.");
                System.out.println("Chybna pole: " + chyby);
            }
        }

        br.close();

        double celkovaCena = 0;

        for (Objednavka objednavka : objednavky) {
            celkovaCena += objednavka.celkovaCena();
        }

        System.out.println();
        System.out.println("===== VYSLEDKY =====");
        System.out.println("Pocet platnych objednavek: " + objednavky.size());
        System.out.printf("Celkova cena: %.2f Kc%n", celkovaCena);

        int mys = 0;
        int klavesnice = 0;
        int monitor = 0;
        int grafickeKarty = 0;

        for (Objednavka objednavka : objednavky) {

            if (objednavka.getProdukt().equals("Herní myš")) {
                mys += objednavka.getPocetKusu();
            }

            if (objednavka.getProdukt().equals("Klávesnice")) {
                klavesnice += objednavka.getPocetKusu();
            }

            if (objednavka.getProdukt().equals("Monitor")) {
                monitor += objednavka.getPocetKusu();
            }

            if (objednavka.getProdukt().equals("Graficka karta")) {
                grafickeKarty += objednavka.getPocetKusu();
            }
        }

        System.out.println();
        System.out.println("Pocet objednanych kusu:");
        System.out.println("Herni mys: " + mys);
        System.out.println("Klavesnice: " + klavesnice);
        System.out.println("Monitor: " + monitor);
        System.out.println("Graficka karta: " + grafickeKarty);
    }
}
