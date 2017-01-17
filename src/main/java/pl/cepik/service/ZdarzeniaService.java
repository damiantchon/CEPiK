package pl.cepik.service;

import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;

import java.util.List;


public interface ZdarzeniaService {
    public List<Zdarzenia> getZdarzenia();

    Kierowcy getKierowca(int idKierowcy);

    Pojazdy getPojazd(String numerRejestracyjny);

    void dodajZdarzenie(Zdarzenia zdarzenie);

    void edytujKierowce(Kierowcy kierowca);

    void edytujPojazd(Pojazdy pojazd);
}
