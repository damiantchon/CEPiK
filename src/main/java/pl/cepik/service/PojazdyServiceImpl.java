package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.KierowcyDAO;
import pl.cepik.dao.OcDAO;
import pl.cepik.dao.PojazdyDAO;
import pl.cepik.dao.ZdarzeniaDAO;
import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;

import java.util.List;

@Service
public class PojazdyServiceImpl implements PojazdyService {

    //need to inject pojazdy dao
    private final PojazdyDAO pojazdyDAO;
    private final KierowcyDAO kierowcyDAO;
    private final ZdarzeniaDAO zdarzeniaDAO;
    private final OcDAO ocDAO;

    @Autowired
    public PojazdyServiceImpl(PojazdyDAO pojazdyDAO, KierowcyDAO kierowcyDAO, ZdarzeniaDAO zdarzeniaDAO, OcDAO ocDAO) {
        this.pojazdyDAO = pojazdyDAO;
        this.kierowcyDAO = kierowcyDAO;
        this.zdarzeniaDAO = zdarzeniaDAO;
        this.ocDAO = ocDAO;
    }

    @Override
    @Transactional
    public List<Pojazdy> getPojazdy() {
        return pojazdyDAO.getPojazdy();
    }

    @Override
    @Transactional
    public void zapiszNowyPojazd(Pojazdy pojazd) {
        pojazdyDAO.zapiszNowyPojazd(pojazd);
    }

    @Override
    @Transactional
    public void usunPojazd(String nrRejestracyjny) {
        pojazdyDAO.usunPojazd(nrRejestracyjny);
    }

    @Override
    @Transactional
    public Pojazdy getPojazdy(String nrRejestracyjny) {
        return pojazdyDAO.getPojazdy(nrRejestracyjny);
    }

    @Override
    @Transactional
    public void zapiszEdytowanyPojazd(Pojazdy pojazd) {
        pojazdyDAO.zapiszEdytowanyPojazd(pojazd);
    }

    @Override
    @Transactional
    public List<Pojazdy> getPojazdyFiltrowana(Pojazdy pojazd) {
        return pojazdyDAO.getPojazdyFiltrowana(pojazd);
    }

    @Override
    @Transactional
    public Kierowcy getKierowca(Integer idKierowcy) {
        return kierowcyDAO.getKierowcy(idKierowcy);
    }

    @Override
    @Transactional
    public List<Zdarzenia> getZdarzenia(String nrSzukanegoPojazdu) {
        return zdarzeniaDAO.getZdarzenia(nrSzukanegoPojazdu);
    }

    @Override
    @Transactional
    public Oc getOc(Integer idOc) {
        return ocDAO.getOcEntity(idOc);
    }
}
