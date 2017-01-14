package pl.cepik.dao;

import pl.cepik.entity.Pojazdy;

import java.util.List;

public interface PojazdyDAO {
    List<Pojazdy> getPojazdy();

    void zapiszNowyPojazd(Pojazdy pojazd);

    void usunPojazd(String nrRejestracyjny);

    Pojazdy getPojazdy(String nrRejestracyjny);

    void zapiszEdytowanyPojazd(Pojazdy pojazd);

    List<Pojazdy> getPojazdyFiltrowana(Pojazdy pojazd);
}
