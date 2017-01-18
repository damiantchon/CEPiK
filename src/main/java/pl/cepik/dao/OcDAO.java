package pl.cepik.dao;

import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;

import java.util.List;

/**
 * Created by Damian on 04.01.2017.
 */
public interface OcDAO {
    public List<Oc> getOC();

    List<Oc> getOC(List<Pojazdy> pojazdy);

    List<Oc> getOC(int idOc);

    Oc getOcEntity(Integer idOc);

    List<Oc> getOC(String ubezpieczyciel);

    void zapiszOC(Oc oc);
}
