package pl.cepik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.cepik.entity.Kierowcy;

import java.util.List;


@Repository
public class KierowcyDAOImpl implements KierowcyDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Kierowcy> getKierowcy() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Kierowcy> theQuery = currentSession.createQuery("from Kierowcy", Kierowcy.class);
        List<Kierowcy> kierowcy = theQuery.getResultList();
        return kierowcy;
    }
}
