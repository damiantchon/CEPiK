package pl.cepik;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static String ubezpieczycielSaved ="";
    private static String nrRejestracyjnySaved = "";

    public static String getUbezpieczycielSaved() {
        return ubezpieczycielSaved;
    }
    public static void setUbezpieczycielSaved(String ubezpieczyciel) {
        ubezpieczycielSaved = ubezpieczyciel;
    }
    public static String getNrRejestracyjnySaved() {
        return nrRejestracyjnySaved;
    }
    public static void setNrRejestracyjnySaved(String nrRejestracyjny) {
        nrRejestracyjnySaved = nrRejestracyjny;
    }

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("start app");
    }
}
