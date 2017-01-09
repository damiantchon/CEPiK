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

    private final SessionFactory sessionFactory;

    @Autowired
    public KierowcyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Kierowcy> getKierowcy() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Kierowcy> theQuery = currentSession.createQuery("from Kierowcy order by nazwisko", Kierowcy.class);
        List<Kierowcy> kierowcy = theQuery.getResultList();
        return kierowcy;
    }

    @Override
    public void zapiszKierowce(Kierowcy kierowca) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(kierowca);
    }

    @Override
    public Kierowcy getKierowcy(int idKierowcy) {
        Session currentSession = sessionFactory.getCurrentSession();
        Kierowcy kierowca = currentSession.get(Kierowcy.class, idKierowcy);
        return kierowca;
    }

    @Override
    public void usunKierowce(int idKierowcy) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Kierowcy where idKierowcy=:idToDelete");
        theQuery.setParameter("idToDelete", idKierowcy);
        theQuery.executeUpdate();

    }
}
