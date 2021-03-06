package pl.cepik.entity;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="OC")
public class Oc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdOc")
    private int idOc;

    @Column(name="Rozpoczecie")
    @Type(type = "date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date rozpoczecie;

    @Column(name="Zakonczenie")
    @Type(type = "date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date zakonczenie;

    @Column(name="Ubezpieczyciel")
    private String ubezpieczyciel;

    public int getIdOc() {
        return idOc;
    }
    public void setIdOc(int idOc) {
        this.idOc = idOc;
    }
    public Date getRozpoczecie() {
        return rozpoczecie;
    }
    public void setRozpoczecie(Date rozpoczecie) {
        this.rozpoczecie = rozpoczecie;
    }
    public Date getZakonczenie() {
        return zakonczenie;
    }
    public void setZakonczenie(Date zakonczenie) {
        this.zakonczenie = zakonczenie;
    }
    public String getUbezpieczyciel() {
        return ubezpieczyciel;
    }
    public void setUbezpieczyciel(String ubezpieczyciel) {
        this.ubezpieczyciel = ubezpieczyciel;
    }

    @Override
    public String toString() {
        return "Oc{" +
                "idOc=" + idOc +
                ", rozpoczecie=" + rozpoczecie +
                ", zakonczenie=" + zakonczenie +
                ", ubezpieczyciel='" + ubezpieczyciel + '\'' +
                '}';
    }

    public Oc(){

    }

}
