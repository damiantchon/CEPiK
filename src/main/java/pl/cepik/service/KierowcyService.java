package pl.cepik.service;

import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;

import java.util.List;

public interface KierowcyService {
    List<Kierowcy> getKierowcy();

    void zapiszKierowce(Kierowcy kierowca);

    Kierowcy getKierowcy(int idKierowcy);

    void usunKierowce(int idKierowcy);

    void zapiszEdytowanegoKierowce(Kierowcy kierowca);

    List<Kierowcy> getKierowcyFiltrowana(Kierowcy kierowca);

    List<Pojazdy> getPojazdy(int idSzukanegoKierowcy);

    List<Zdarzenia> getZdarzenia(int idSzukanegoKierowcy);

    List<Oc> getOc(List<Pojazdy> pojazdy);
}
