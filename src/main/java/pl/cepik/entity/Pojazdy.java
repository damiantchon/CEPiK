package pl.cepik.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Damian on 04.01.2017.
 */
@Entity
@Table(name="Pojazdy")
public class Pojazdy {

    @Id
    @Column(name="NumerRejestracyjny")
    private String NumerRejestracyjny;

    @Column(name="Marka")
    private String Marka;

    @Column(name="Model")
    private String Model;

    @Column(name="TerminBadania")
    @Type(type="date")
    private Date TerminBadania;

    @Column(name="IdOc")
    private int IdOc;

    @Column(name="IdKierowcy")
    private int IdKierowcy;

    public String getNumerRejestracyjny() {
        return NumerRejestracyjny;
    }
    public void setNumerRejestracyjny(String numerRejestracyjny) {
        NumerRejestracyjny = numerRejestracyjny;
    }
    public String getMarka() {
        return Marka;
    }
    public void setMarka(String marka) {
        Marka = marka;
    }
    public String getModel() {
        return Model;
    }
    public void setModel(String model) {
        Model = model;
    }
    public Date getTerminBadania() {
        return TerminBadania;
    }
    public void setTerminBadania(Date terminBadania) {
        this.TerminBadania = terminBadania;
    }
    public int getIdOc() {
        return IdOc;
    }
    public void setIdOc(int idOc) {
        IdOc = idOc;
    }
    public int getIdKierowcy() {
        return IdKierowcy;
    }
    public void setIdKierowcy(int idKierowcy) {
        IdKierowcy = idKierowcy;
    }

    @Override
    public String toString() {
        return "Pojazdy{" +
                "NumerRejestracyjny='" + NumerRejestracyjny + '\'' +
                ", Marka='" + Marka + '\'' +
                ", Model='" + Model + '\'' +
                ", TerminBadania=" + TerminBadania +
                ", IdOc=" + IdOc +
                ", IdKierowcy=" + IdKierowcy +
                '}';
    }

    public Pojazdy(){

    }
}
