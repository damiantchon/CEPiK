package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.KierowcyDAO;
import pl.cepik.entity.Kierowcy;

import java.util.List;

@Service
public class KierowcyServiceImpl implements KierowcyService {

    private final KierowcyDAO kierowcyDAO;

    @Autowired
    public KierowcyServiceImpl(KierowcyDAO kierowcyDAO) {
        this.kierowcyDAO = kierowcyDAO;
    }

    @Override
    @Transactional
    public List<Kierowcy> getKierowcy() {
        return kierowcyDAO.getKierowcy();
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
}
