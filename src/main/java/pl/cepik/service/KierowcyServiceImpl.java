package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.OcDAO;
import pl.cepik.dao.PojazdyDAO;
import pl.cepik.dao.KierowcyDAO;
import pl.cepik.dao.ZdarzeniaDAO;
import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;

import java.util.List;

@Service
public class KierowcyServiceImpl implements KierowcyService {

    private final KierowcyDAO kierowcyDAO;
    private final PojazdyDAO pojazdyDAO;
    private final ZdarzeniaDAO zdarzeniaDAO;
    private final OcDAO ocDAO;

    @Autowired
    public KierowcyServiceImpl(KierowcyDAO kierowcyDAO, PojazdyDAO pojazdyDAO, ZdarzeniaDAO zdarzeniaDAO, OcDAO ocDAO) {
        this.kierowcyDAO = kierowcyDAO;
        this.pojazdyDAO = pojazdyDAO;
        this.zdarzeniaDAO = zdarzeniaDAO;
        this.ocDAO = ocDAO;
    }

    @Override
    @Transactional
    public List<Kierowcy> getKierowcy() {
        return kierowcyDAO.getKierowcy();
    }

    @Override
    @Transactional
    public List<Kierowcy> getKierowcyFiltrowana(Kierowcy kierowca) {
        return kierowcyDAO.getKierowcyFiltrowana(kierowca);
    }

    @Override
    @Transactional
    public List<Pojazdy> getPojazdy(int idSzukanegoKierowcy) {
        return pojazdyDAO.getPojazdyFiltrowana(idSzukanegoKierowcy);
    }

    @Override
    @Transactional
    public List<Zdarzenia> getZdarzenia(int idSzukanegoKierowcy) {
        return zdarzeniaDAO.getZdarzeniaFiltrowana(idSzukanegoKierowcy);
    }

    @Override
    @Transactional
    public List<Oc> getOc(List<Pojazdy> pojazdy) {
        return ocDAO.getOC(pojazdy);
    }

    @Override
    @Transactional
    public void zapiszKierowce(Kierowcy kierowca) {
        kierowcyDAO.zapiszKierowce(kierowca);
    }

    @Override
    @Transactional
    public Kierowcy getKierowcy(int idKierowcy) {
        return kierowcyDAO.getKierowcy(idKierowcy);
    }

    @Override
    @Transactional
    public void usunKierowce(int idKierowcy) {
        kierowcyDAO.usunKierowce(idKierowcy);
    }

    @Override
    @Transactional
    public void zapiszEdytowanegoKierowce(Kierowcy kierowca) {
        kierowcyDAO.zapiszEdytowanegoKierowce(kierowca);
    }
}
