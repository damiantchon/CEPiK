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
    @Autowired
    private PojazdyDAO pojazdyDAO;

    @Override
    @Transactional
    public List<Pojazdy> getPojazdy() {
        return pojazdyDAO.getPojazdy();
    }
}
