package pl.cepik.entity;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Zdarzenia")
public class Zdarzenia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdZdarzenia")
    private int idZdarzenia;

    @Column(name = "TypZdarzenia")//
    private String typZdarzenia;

    @Column(name = "OpisZdarzenia")
    private String opisZdarzenia;

    @Column(name = "DataZdarzenia")//
    @Type(type = "date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dataZdarzenia;

    @Column(name = "NumerRejestracyjny")
    private String numerRejestracyjny;

    @Column(name = "IdKierowcy")
    private Integer idKierowcy;

    public void setIdKierowcy(Integer idKierowcy) {
        this.idKierowcy = idKierowcy;
    }
    public int getIdZdarzenia() {
        return idZdarzenia;
    }
    public void setIdZdarzenia(int idZdarzenia) {
        this.idZdarzenia = idZdarzenia;
    }
    public String getTypZdarzenia() {
        return typZdarzenia;
    }
    public void setTypZdarzenia(String typZdarzenia) {
        this.typZdarzenia = typZdarzenia;
    }
    public String getOpisZdarzenia() {
        return opisZdarzenia;
    }
    public void setOpisZdarzenia(String opisZdarzenia) {
        this.opisZdarzenia = opisZdarzenia;
    }
    public Date getDataZdarzenia() {
        return dataZdarzenia;
    }
    public void setDataZdarzenia(Date dataZdarzenia) {
        this.dataZdarzenia = dataZdarzenia;
    }
    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }
    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }
    public Integer getIdKierowcy() {
        return idKierowcy;
    }
    public void setIdKierowcy(int idKierowcy) {
        this.idKierowcy = idKierowcy;
    }

    @Override
    public String toString() {
        return "ZdarzeniaService{" +
                "idZdarzenia=" + idZdarzenia +
                ", typZdarzenia='" + typZdarzenia + '\'' +
                ", opisZdarzenia='" + opisZdarzenia + '\'' +
                ", dataZdarzenia=" + dataZdarzenia +
                ", numerRejestracyjny='" + numerRejestracyjny + '\'' +
                ", idKierowcy=" + idKierowcy +
                '}';
    }

    public Zdarzenia() {
    }
}
