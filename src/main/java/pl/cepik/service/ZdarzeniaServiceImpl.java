package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.KierowcyDAO;
import pl.cepik.dao.PojazdyDAO;
import pl.cepik.dao.ZdarzeniaDAO;
import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;

import java.util.List;

/**
 * Created by Damian on 05.01.2017.
 */
@Service
public class ZdarzeniaServiceImpl implements ZdarzeniaService {


    private final ZdarzeniaDAO zdarzeniaDAO;
    private final KierowcyDAO kierowcyDAO;
    private final PojazdyDAO pojazdyDAO;

    @Autowired
    public ZdarzeniaServiceImpl(ZdarzeniaDAO zdarzeniaDAO, KierowcyDAO kierowcyDAO, PojazdyDAO pojazdyDAO) {
        this.zdarzeniaDAO = zdarzeniaDAO;
        this.kierowcyDAO = kierowcyDAO;
        this.pojazdyDAO = pojazdyDAO;
    }

    @Override
    @Transactional
    public List<Zdarzenia> getZdarzenia() {
        return zdarzeniaDAO.getZdarzenia();
    }

    @Override
    @Transactional
    public Kierowcy getKierowca(int idKierowcy) {
        return kierowcyDAO.getKierowcy(idKierowcy);
    }

    @Override
    @Transactional
    public Pojazdy getPojazd(String numerRejestracyjny) {
        return pojazdyDAO.getPojazdy(numerRejestracyjny);
    }

    @Override
    @Transactional
    public void dodajZdarzenie(Zdarzenia zdarzenie) {
        zdarzeniaDAO.dodajZdarzenie(zdarzenie);
    }

    @Override
    @Transactional
    public void edytujKierowce(Kierowcy kierowca) {
        kierowcyDAO.zapiszEdytowanegoKierowce(kierowca);
    }

    @Override
    public void edytujPojazd(Pojazdy pojazd) {
        pojazdyDAO.zapiszEdytowanyPojazd(pojazd);
    }
}
