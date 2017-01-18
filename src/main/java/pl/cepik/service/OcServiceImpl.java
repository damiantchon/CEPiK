package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.KierowcyDAO;
import pl.cepik.dao.OcDAO;
import pl.cepik.dao.PojazdyDAO;
import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;

import java.util.List;

/**
 * Created by Damian on 05.01.2017.
 */
@Service
public class OcServiceImpl implements OcService {

    private final OcDAO ocDAO;
    private final PojazdyDAO pojazdyDAO;
    private final KierowcyDAO kierowcyDAO;

    @Autowired
    public OcServiceImpl(OcDAO ocDAO, PojazdyDAO pojazdyDAO, KierowcyDAO kierowcyDAO) {
        this.ocDAO = ocDAO;
        this.pojazdyDAO = pojazdyDAO;
        this.kierowcyDAO = kierowcyDAO;
    }


    @Override
    @Transactional
    public List<Oc> getOc() {
        return ocDAO.getOC();
    }

    @Override
    @Transactional
    public List<Oc> getOc(int idOc) {
        return ocDAO.getOC(idOc);
    }

    @Override
    @Transactional
    public List<Oc> getOc(String ubezpieczyciel) {
        return ocDAO.getOC(ubezpieczyciel);
    }

    @Override
    @Transactional
    public List<Pojazdy> getPojazdy(String ubezpieczyciel) {
        return pojazdyDAO.getPojazdyUbezpieczyciel(ubezpieczyciel);
    }

    @Override
    @Transactional
    public Kierowcy getKierowca(int idKierowcy) {
        return kierowcyDAO.getKierowcy(idKierowcy);
    }

    @Override
    @Transactional
    public Pojazdy znajdzPojazd(Pojazdy pojazd) {
        return pojazdyDAO.getPojazdy(pojazd.getNumerRejestracyjny());
    }

    @Override
    @Transactional
    public void zapiszOC(Oc oc) {
        ocDAO.zapiszOC(oc);
    }
}
