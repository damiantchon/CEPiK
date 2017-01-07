package pl.cepik.entity;

import javax.persistence.*;

/**
 * Created by Damian on 04.01.2017.
 */
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

    @Override
    public String toString() {
        return "Kierowcy{" +
                "idKierowcy=" + idKierowcy +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", eMail='" + eMail + '\'' +
                ", czyPosiadaUprawnienia='" + czyPosiadaUprawnienia + '\'' +
                '}';
    }

    public Kierowcy() {
    }
}
