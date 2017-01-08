package pl.cepik.dao;

import pl.cepik.entity.Kierowcy;

import java.util.List;

/**
 * Created by Damian on 04.01.2017.
 */
public interface KierowcyDAO {
    public List<Kierowcy> getKierowcy();

    void zapiszKierowce(Kierowcy kierowca);
}
