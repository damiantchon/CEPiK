package pl.cepik.service;

import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;

import java.util.List;

public interface OcService {
    public List<Oc> getOc();

    List<Oc> getOc(int idOc);

    List<Oc> getOc(String ubezpieczyciel);

    List<Pojazdy> getPojazdy(String ubezpieczyciel);

    Kierowcy getKierowca(int idKierowcy);

    Pojazdy znajdzPojazd(Pojazdy pojazd);

    void zapiszOC(Oc oc);
}
