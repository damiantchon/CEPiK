package pl.cepik.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.cepik.Main;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedList;
import java.util.List;


@Repository
public class OcDAOImpl implements OcDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Oc> getOC() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Oc> theQuery = currentSession.createQuery("from Oc", Oc.class);
        return theQuery.getResultList();
    }

    @Override //nie używane
    public List<Oc> getOC(List<Pojazdy> pojazdy) {
        List<Integer> lista = new LinkedList<Integer>();
        for(Pojazdy pojazd: pojazdy){
            if(pojazd.getIdOc()!=null) {
                lista.add(pojazd.getIdOc());
            }
        }
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Oc> theQuery = currentSession.createQuery("from Oc where idOc in (:parLista)",Oc.class);
        theQuery.setParameter("parLista",lista);
        return theQuery.getResultList();
    }

    @Override
    public List<Oc> getOC(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Oc> theQuery = currentSession.createQuery("from Oc where idOc=:id",Oc.class);
        theQuery.setParameter("id",id);
        return theQuery.getResultList();
    }

    @Override
    public Oc getOcEntity(Integer idOc) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Oc> theQuery = currentSession.createQuery("from Oc where idOc=:id",Oc.class);
        theQuery.setParameter("id",idOc);
        List<Oc> oc = theQuery.getResultList();
        if(!oc.isEmpty()) return oc.get(0);
        else return null;
    }

    @Override
    public List<Oc> getOC(String ubezpieczyciel) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Oc> theQuery = currentSession.createQuery("from Oc where ubezpieczyciel =:ubezParam",Oc.class);
        theQuery.setParameter("ubezParam",ubezpieczyciel);
        return theQuery.getResultList();
    }

    @Override
    public void zapiszOC(Oc oc) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(oc);



        Query theQuery = currentSession.createQuery("update Pojazdy set idOc=:param where numerRejestracyjny=:param2");
        theQuery.setParameter("param",oc.getIdOc());
        theQuery.setParameter("param2", Main.getNrRejestracyjnySaved());
        theQuery.executeUpdate();

        Main.setNrRejestracyjnySaved("");

    }
}
