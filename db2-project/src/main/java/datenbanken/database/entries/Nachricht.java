package datenbanken.database.entries;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "nachricht")
public class Nachricht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nachrichtenNr")
    private int nachrichtNr;

    @Column(name = "zeitstempel")
    private Date zeitstempel;
    @Column(name = "inhalt")
    private String inhalt;

    @ManyToOne
    @JoinColumn(name = "nutzername", referencedColumnName = "nutzername")
    private Nutzer nutzer;

    @ManyToOne
    @JoinColumn(name = "streamNr")
    private Stream stream;

    public void setNachrichtNr(int nachrichtNr) {
        this.nachrichtNr = nachrichtNr;
    }

    public void setZeitstempel(Date zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public int getNachrichtNr() {
        return nachrichtNr;
    }

    public Date getZeitstempel() {
        return zeitstempel;
    }

    public String getInhalt() {
        return inhalt;
    }

    public Nutzer getNutzer() {
        return nutzer;
    }

    public Stream getStream() {
        return stream;
    }

    @Override
    public String toString() {
        return "Nachricht{" +
                "nachrichtNr=" + nachrichtNr +
                ", zeitstempel=" + zeitstempel +
                ", inhalt='" + inhalt + '\'' +
                ", nutzer=" + nutzer.getNutzername() +
                ", stream=" + stream.getStreamNr() +
                '}';
    }
}
