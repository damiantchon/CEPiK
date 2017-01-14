package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.PojazdyDAO;
import pl.cepik.entity.Pojazdy;

import java.util.List;

@Service
public class PojazdyServiceImpl implements PojazdyService {

    //need to inject pojazdy dao
    private final PojazdyDAO pojazdyDAO;

    @Autowired
    public PojazdyServiceImpl(PojazdyDAO pojazdyDAO) {
        this.pojazdyDAO = pojazdyDAO;
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
}
