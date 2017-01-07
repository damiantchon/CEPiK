package pl.cepik.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.cepik.entity.Oc;

import java.util.List;

/**
 * Created by Damian on 04.01.2017.
 */
@Repository
public class OcDAOImpl implements OcDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Oc> getOC() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Oc> theQuery = currentSession.createQuery("from Oc", Oc.class);
        List<Oc> oc = theQuery.getResultList();
        return oc;
    }
}
