package datenbanken.database.entries;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "clip")
public class Clip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clipNr")
    private int clipNr;

    @Column(name = "clipStart")
    private String start;

    @Column(name = "laenge")
    private int laenge;

    @ManyToOne
    @JoinColumn(name = "nutzername")
    private Nutzer nutzer;
    @ManyToOne
    @JoinColumn(name = "streamNr")
    private Stream stream;

    public void setClipNr(int clipNr) {
        this.clipNr = clipNr;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public int getClipNr() {
        return clipNr;
    }

    public String getStart() {
        return start;
    }

    public int getLaenge() {
        return laenge;
    }

    public Nutzer getNutzer() {
        return nutzer;
    }

    public Stream getStream() {
        return stream;
    }

    @Override
    public String toString() {
        return "Clip{" +
                "clipNr=" + clipNr +
                ", start=" + start +
                ", laenge=" + laenge +
                ", nutzer=" + nutzer.getNutzername() +
                ", stream=" + stream.getStreamNr() +
                '}';
    }
}
