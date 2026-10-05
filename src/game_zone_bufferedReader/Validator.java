package game_zone_bufferedReader;

public class Validator {

    public static boolean platneJmeno(String jmeno) {
        return jmeno.matches(
                "[A-ZÁ-Ž][a-z-ž]+ " +
                "[A-ZÁ-Ž][a-zá-ž]+"
        );
    }

    public static boolean platnyEmail(String email) {
        return email.matches(
                "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
        );
    }

    public static boolean platnyProdukt(String produkt) {
        return produkt.equals("Herní myš")
                || produkt.equals("Klávesnice")
                || produkt.equals("Monitor")
                || produkt.equals("Grafická karta");
    }

    public static boolean platnaCena(String cena) {
        return cena.matches("[0-9]+,[0-9]{2}")
                && Double.parseDouble(cena.replace(",", ".")) > 0;
    }

    public static boolean platnyPocet(String pocet) {

        if (!pocet.matches("[0-9]+")) {
            return false;
        }

        int cislo = Integer.parseInt(pocet);

        return cislo > 0 && cislo <= 10;
    }
}
