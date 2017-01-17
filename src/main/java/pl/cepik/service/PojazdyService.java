package pl.cepik.service;

import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;

import java.util.List;

public interface PojazdyService {
    List<Pojazdy> getPojazdy();

    void zapiszNowyPojazd(Pojazdy pojazd);

    void usunPojazd(String nrRejestracyjny);

    Pojazdy getPojazdy(String nrRejestracyjny);

    void zapiszEdytowanyPojazd(Pojazdy pojazd);

    List<Pojazdy> getPojazdyFiltrowana(Pojazdy pojazd);

    Kierowcy getKierowca(Integer idKierowcy);

    List<Zdarzenia> getZdarzenia(String nrSzukanegoPojazdu);

    Oc getOc(Integer idOc);
}
