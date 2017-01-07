package pl.cepik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cepik.dao.OcDAO;
import pl.cepik.entity.Oc;

import java.util.List;

/**
 * Created by Damian on 05.01.2017.
 */
@Service
public class OcServiceImpl implements OcService {

    @Autowired
    private OcDAO ocDAO;


    @Override
    @Transactional
    public List<Oc> getOc() {
        return ocDAO.getOC();
    }
}
