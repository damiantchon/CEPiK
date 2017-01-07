package pl.cepik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.cepik.entity.Pojazdy;

import java.util.List;

@Repository
public class PojazdyDAOImpl implements PojazdyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Pojazdy> getPojazdy() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Pojazdy> theQuery = currentSession.createQuery("from Pojazdy", Pojazdy.class);
        List<Pojazdy> pojazdy = theQuery.getResultList();
        return pojazdy;
    }
}
