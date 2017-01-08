package pl.cepik.service;

import pl.cepik.entity.Kierowcy;

import java.util.List;

/**
 * Created by Damian on 05.01.2017.
 */
public interface KierowcyService {
    public List<Kierowcy> getKierowcy();

    void zapiszKierowce(Kierowcy kierowca);
}
