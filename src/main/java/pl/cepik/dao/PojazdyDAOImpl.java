package pl.cepik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;

import java.util.LinkedList;
import java.util.List;

@Repository
public class PojazdyDAOImpl implements PojazdyDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PojazdyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Pojazdy> getPojazdy() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Pojazdy> theQuery = currentSession.createQuery("from Pojazdy where czyAktywny='TAK'", Pojazdy.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Pojazdy> getPojazdyFiltrowana(Pojazdy pojazd) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Pojazdy> theQuery = currentSession.createQuery("from Pojazdy where czyAktywny='TAK' and numerRejestracyjny like :numer order by numerRejestracyjny", Pojazdy.class);
        theQuery.setParameter("numer","%"+pojazd.getNumerRejestracyjny()+"%");
        return theQuery.getResultList();
    }

    @Override
    public List<Pojazdy> getPojazdyFiltrowana(int idSzukanegoKierowcy) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Pojazdy> theQuery = currentSession.createQuery("from Pojazdy where czyAktywny='TAK' and idKierowcy=:id order by numerRejestracyjny", Pojazdy.class);
        theQuery.setParameter("id",idSzukanegoKierowcy);
        return theQuery.getResultList();
    }

    @Override
    public List<Pojazdy> getPojazdyUbezpieczyciel(String ubezpieczyciel) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Oc> theQuery = currentSession.createQuery("from Oc where ubezpieczyciel=:param",Oc.class);
        theQuery.setParameter("param",ubezpieczyciel);
        List<Oc> ocList = theQuery.getResultList();
        LinkedList<Integer> ocIdList = new LinkedList<Integer>();
        for(Oc oc :ocList){
            ocIdList.add(oc.getIdOc());
        }
        if(!ocIdList.isEmpty()) {
            Query<Pojazdy> theQuery2 = currentSession.createQuery("from Pojazdy where idOc in (:ids)", Pojazdy.class);
            theQuery2.setParameter("ids", ocIdList);
            return theQuery2.getResultList();
        }else{
            return null;
        }
    }

    @Override
    public void zapiszNowyPojazd(Pojazdy pojazd) {
        if(pojazd.getIdKierowcy()==0)pojazd.setIdKierowcy(null);
        if(pojazd.getIdOc()==0)pojazd.setIdOc(null);
        Session currentSession = sessionFactory.getCurrentSession();
        Pojazdy tempPojazd = currentSession.get(Pojazdy.class, pojazd.getNumerRejestracyjny());
        if(tempPojazd==null){
            currentSession.save(pojazd);
        }
    }

    @Override
    public void usunPojazd(String nrRejestracyjny) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("update Pojazdy set czyAktywny ='NIE'" +
                " where numerRejestracyjny=:idToDelete");
        theQuery.setParameter("idToDelete", nrRejestracyjny);
        theQuery.executeUpdate();
        theQuery = currentSession.createQuery("update Pojazdy set dataUsuniecia = CURRENT_DATE " +
                "where numerRejestracyjny=:idToDelete");
        theQuery.setParameter("idToDelete",nrRejestracyjny);
        theQuery.executeUpdate();

    }

    @Override
    public Pojazdy getPojazdy(String nrRejestracyjny) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Pojazdy.class, nrRejestracyjny);
    }

    @Override
    public void zapiszEdytowanyPojazd(Pojazdy pojazd) {
        if(pojazd.getIdKierowcy()==0)pojazd.setIdKierowcy(null);
        if(pojazd.getIdOc()==0)pojazd.setIdOc(null);
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("from Kierowcy where idKierowcy=:param");
        theQuery.setParameter("param",pojazd.getIdKierowcy());
        if(!theQuery.getResultList().isEmpty()) currentSession.saveOrUpdate(pojazd);
        else if(pojazd.getIdKierowcy()==null) currentSession.saveOrUpdate(pojazd);
    }

}
