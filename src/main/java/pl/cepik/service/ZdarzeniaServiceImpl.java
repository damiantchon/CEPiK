package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.ZdarzeniaDAO;
import pl.cepik.entity.Zdarzenia;

import java.util.List;

/**
 * Created by Damian on 05.01.2017.
 */
@Service
public class ZdarzeniaServiceImpl implements ZdarzeniaService {

    @Autowired
    private ZdarzeniaDAO zdarzeniaDAO;

    @Override
    @Transactional
    public List<Zdarzenia> getZdarzenia() {
        return zdarzeniaDAO.getZdarzenia();
    }
}
