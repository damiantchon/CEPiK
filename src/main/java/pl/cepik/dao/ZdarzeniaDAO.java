package pl.cepik.dao;

import pl.cepik.entity.Zdarzenia;

import java.util.List;

/**
 * Created by Damian on 04.01.2017.
 */
public interface ZdarzeniaDAO {
    public List<Zdarzenia> getZdarzenia();

    List<Zdarzenia> getZdarzeniaFiltrowana(int idSzukanegoKierowcy);

    List<Zdarzenia> getZdarzenia(String nrSzukanegoPojazdu);

    void dodajZdarzenie(Zdarzenia zdarzenie);
}
