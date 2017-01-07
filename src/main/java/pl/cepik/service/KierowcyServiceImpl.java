package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.KierowcyDAO;
import pl.cepik.entity.Kierowcy;

import java.util.List;

/**
 * Created by Damian on 05.01.2017.
 */
@Service
public class KierowcyServiceImpl implements KierowcyService {

    @Autowired
    private KierowcyDAO kierowcyDAO;

    @Override
    @Transactional
    public List<Kierowcy> getKierowcy() {
        return kierowcyDAO.getKierowcy();
    }
}
