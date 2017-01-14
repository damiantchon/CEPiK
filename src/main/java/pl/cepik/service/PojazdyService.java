package pl.cepik.service;

import pl.cepik.entity.Pojazdy;

import java.util.List;

public interface PojazdyService {
    List<Pojazdy> getPojazdy();

    void zapiszNowyPojazd(Pojazdy pojazd);

    void usunPojazd(String nrRejestracyjny);

    Pojazdy getPojazdy(String nrRejestracyjny);

    void zapiszEdytowanyPojazd(Pojazdy pojazd);

    List<Pojazdy> getPojazdyFiltrowana(Pojazdy pojazd);
}
