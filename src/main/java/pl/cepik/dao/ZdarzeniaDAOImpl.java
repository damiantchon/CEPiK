package pl.cepik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.cepik.entity.Zdarzenia;

import java.util.List;


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

    @Override
    public List<Zdarzenia> getZdarzeniaFiltrowana(int idSzukanegoKierowcy) {
            Session currentSession = sessionFactory.getCurrentSession();
            Query<Zdarzenia> theQuery = currentSession.createQuery("from Zdarzenia where idKierowcy=:id order by dataZdarzenia desc, idZdarzenia desc ", Zdarzenia.class);
            theQuery.setParameter("id",idSzukanegoKierowcy);
            return theQuery.getResultList();
    }

    @Override
    public List<Zdarzenia> getZdarzenia(String nrSzukanegoPojazdu) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Zdarzenia> theQuery = currentSession.createQuery("from Zdarzenia where numerRejestracyjny=:numer order by dataZdarzenia desc, idZdarzenia desc ", Zdarzenia.class);
        theQuery.setParameter("numer", nrSzukanegoPojazdu);
        return theQuery.getResultList();
    }

    @Override
    public void dodajZdarzenie(Zdarzenia zdarzenie) {
        if(zdarzenie.getNumerRejestracyjny().equals(""))zdarzenie.setNumerRejestracyjny(null);
        if(zdarzenie.getIdKierowcy()==0)zdarzenie.setIdKierowcy(null);
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(zdarzenie);

    }
}
