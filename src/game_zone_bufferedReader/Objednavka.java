package game_zone_bufferedReader;

public class Objednavka {

    private String jmeno;
    private String email;
    private String produkt;
    private double cena;
    private int pocetKusu;

    public Objednavka(String jmeno, String email, String produkt,
                      double cena, int pocetKusu) {

        this.jmeno = jmeno;
        this.email = email;
        this.produkt = produkt;
        this.cena = cena;
        this.pocetKusu = pocetKusu;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getEmail() {
        return email;
    }

    public String getProdukt() {
        return produkt;
    }

    public double getCena() {
        return cena;
    }

    public int getPocetKusu() {
        return pocetKusu;
    }

    public double celkovaCena() {
        return cena * pocetKusu;
    }
}
