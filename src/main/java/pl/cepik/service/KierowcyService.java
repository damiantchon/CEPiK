package pl.cepik.service;

import pl.cepik.entity.Kierowcy;

import java.util.List;

public interface KierowcyService {
    List<Kierowcy> getKierowcy();

    void zapiszKierowce(Kierowcy kierowca);

    Kierowcy getKierowcy(int idKierowcy);

    void usunKierowce(int idKierowcy);

    void zapiszEdytowanegoKierowce(Kierowcy kierowca);

    List<Kierowcy> getKierowcyFiltrowana(Kierowcy kierowca);
}
