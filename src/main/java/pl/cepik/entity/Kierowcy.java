package pl.cepik.entity;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Kierowcy")
public class Kierowcy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdKierowcy")
    private int idKierowcy;

    @Column(name = "Imie")
    private String imie;

    @Column(name = "Nazwisko")
    private String nazwisko;

    @Column(name = "EMail")
    private String eMail;

    @Column(name = "CzyPosiadaUprawnienia")
    private String czyPosiadaUprawnienia;

    @Column(name = "CzyAktywny")
    private String czyAktywny = "TAK";

    @Column(name = "DataUsuniecia")
    @Type(type="date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dataUsuniecia;

    @Override
    public String toString() {
        return "Kierowcy{" +
                "idKierowcy=" + idKierowcy +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", eMail='" + eMail + '\'' +
                ", czyPosiadaUprawnienia='" + czyPosiadaUprawnienia + '\'' +
                ", czyAktywny='" + czyAktywny + '\'' +
                ", dataUsuniecia=" + dataUsuniecia +
                '}';
    }

    public Date getDataUsuniecia() {
        return dataUsuniecia;
    }
    public void setDataUsuniecia(Date dataUsuniecia) {
        this.dataUsuniecia = dataUsuniecia;
    }
    public String getCzyAktywny() {
        return czyAktywny;
    }
    public void setCzyAktywny(String czyAktywny) {
        this.czyAktywny = czyAktywny;
    }
    public int getIdKierowcy() {
        return idKierowcy;
    }
    public void setIdKierowcy(int idKierowcy) {
        this.idKierowcy = idKierowcy;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getCzyPosiadaUprawnienia() {
        return czyPosiadaUprawnienia;
    }
    public void setCzyPosiadaUprawnienia(String czyPosiadaUprawnienia) {
        this.czyPosiadaUprawnienia = czyPosiadaUprawnienia;
    }

    public Kierowcy() {
    }
}
