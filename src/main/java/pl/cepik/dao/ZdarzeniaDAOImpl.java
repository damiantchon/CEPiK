package pl.cepik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.cepik.entity.Zdarzenia;

import java.util.List;

/**
 * Created by Damian on 04.01.2017.
 */

@Repository
public class ZdarzeniaDAOImpl implements ZdarzeniaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Zdarzenia> getZdarzenia() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Zdarzenia> theQuery = currentSession.createQuery("from Zdarzenia", Zdarzenia.class);
        List<Zdarzenia> zdarzenia = theQuery.getResultList();
        return zdarzenia;
    }
}
