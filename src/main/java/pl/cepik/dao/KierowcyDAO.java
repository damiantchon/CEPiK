package pl.cepik.dao;

import pl.cepik.entity.Kierowcy;

import java.util.List;

public interface KierowcyDAO {
    List<Kierowcy> getKierowcy();

    void zapiszKierowce(Kierowcy kierowca);

    Kierowcy getKierowcy(int idKierowcy);

    void usunKierowce(int idKierowcy);
}
