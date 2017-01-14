package pl.cepik.entity;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="Pojazdy")
public class Pojazdy {

    @Id
    @Column(name="numerRejestracyjny")
    private String numerRejestracyjny;

    @Column(name="marka")
    private String marka;

    @Column(name="model")
    private String model;

    @Column(name="terminBadania")
    @Type(type="date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date terminBadania;

    @Column(name="idOc")
    private Integer idOc;

    @Column(name="idKierowcy")
    private Integer idKierowcy;

    @Column(name="CzyAktywny")
    private String czyAktywny = "TAK";

    @Column(name="DataUsuniecia")
    @Type(type="date")
    private Date dataUsuniecia;

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }
    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }
    public String getMarka() {
        return marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Date getTerminBadania() {
        return terminBadania;
    }
    public void setTerminBadania(Date terminBadania) {
        this.terminBadania = terminBadania;
    }
    public Integer getIdOc() {
        return idOc;
    }
    public void setIdOc(Integer idOc) {
        this.idOc = idOc;
    }
    public Integer getIdKierowcy() {
        return idKierowcy;
    }
    public void setIdKierowcy(Integer idKierowcy) {
        this.idKierowcy = idKierowcy;
    }

    public void setDataUsuniecia(Date dataUsuniecia) {
        this.dataUsuniecia = dataUsuniecia;
    }

    @Override
    public String toString() {
        return "Pojazdy{" +
                "numerRejestracyjny='" + numerRejestracyjny + '\'' +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", terminBadania=" + terminBadania +
                ", idOc=" + idOc +
                ", idKierowcy=" + idKierowcy +
                ", czyAktywny='" + czyAktywny + '\'' +
                ", dataUsuniecia=" + dataUsuniecia +
                '}';
    }

    public Pojazdy(){

    }
}
