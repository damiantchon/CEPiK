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
        Query<Kierowcy> theQuery = currentSession.createQuery("from Kierowcy where czyAktywny='TAK' order by nazwisko, imie", Kierowcy.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Kierowcy> getKierowcyFiltrowana(Kierowcy kierowca) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Kierowcy> theQuery = currentSession.createQuery("from Kierowcy where czyAktywny='TAK' and nazwisko like :nazw order by nazwisko, imie");
        theQuery.setParameter("nazw", "%"+kierowca.getNazwisko()+"%");
        return theQuery.getResultList();
    }

    @Override
    public void zapiszEdytowanegoKierowce(Kierowcy kierowca) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(kierowca);
    }

    @Override
    public Kierowcy getKierowcy(int idKierowcy) {

        Session currentSession = sessionFactory.getCurrentSession();
        Kierowcy kierowca = currentSession.get(Kierowcy.class, idKierowcy);
        if(kierowca!=null) {
            if (kierowca.getCzyAktywny().equals("NIE")) {
                return null;
            } else {
                return kierowca;
            }
        }
        return null;
    }

    @Override
    public void usunKierowce(int idKierowcy) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("update Kierowcy set czyAktywny = 'NIE'" +
                " where idKierowcy=:idToDelete");
        theQuery.setParameter("idToDelete", idKierowcy);
        theQuery.executeUpdate();
        theQuery = currentSession.createQuery("update Kierowcy set dataUsuniecia = CURRENT_DATE where idKierowcy=:idToDelete");
        theQuery.setParameter("idToDelete", idKierowcy);
        theQuery.executeUpdate();

    }

    @Override
    public void zapiszKierowce(Kierowcy kierowca) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("select count(*) from Kierowcy where eMail=:temp and czyAktywny='TAK'");
        theQuery.setParameter("temp", kierowca.geteMail());
        Long tempInt = (Long) theQuery.uniqueResult();
        if(tempInt == 0){
            currentSession.save(kierowca);
        }
    }
}
