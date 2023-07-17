package datenbanken.database.entries;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "stream")
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "streamNr")
    private int streamNr;

    @ManyToOne
    private Streamer streamer;

    @Column(name = "streamStart")
    private String start;

    @Column(name = "ende")
    private String ende;

    @Column(name = "titel")
    private String titel;

    @Column(name = "kategorie")
    private String kategorie;

    @OneToMany(mappedBy = "stream", cascade = CascadeType.ALL)
    private Set<Tag> tags;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "streamSet")
    private Set<Zuschauer> zuschauerSet;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "streamSet")
    private Set<Anzeige> anzeigeSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Set<Nachricht> nachrichtSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Set<Clip> clipSet;

    public void setStreamNr(int streamNr) {
        this.streamNr = streamNr;
    }

    public void setStreamer(Streamer streamer) {
        this.streamer = streamer;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnde(String ende) {
        this.ende = ende;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void setZuschauerSet(Set<Zuschauer> zuschauerSet) {
        this.zuschauerSet = zuschauerSet;
    }

    public void setAnzeigeSet(Set<Anzeige> anzeigeSet) {
        this.anzeigeSet = anzeigeSet;
    }

    public void setNachrichtSet(Set<Nachricht> nachrichtSet) {
        this.nachrichtSet = nachrichtSet;
    }

    public void setClipSet(Set<Clip> clipSet) {
        this.clipSet = clipSet;
    }

    public int getStreamNr() {
        return streamNr;
    }

    public Streamer getStreamer() {
        return streamer;
    }

    public String getStart() {
        return start;
    }

    public String getEnde() {
        return ende;
    }

    public String getTitel() {
        return titel;
    }

    public String getKategorie() {
        return kategorie;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Set<Zuschauer> getZuschauerSet() {
        return zuschauerSet;
    }

    public Set<Anzeige> getAnzeigeSet() {
        return anzeigeSet;
    }

    public Set<Nachricht> getNachrichtSet() {
        return nachrichtSet;
    }

    public Set<Clip> getClipSet() {
        return clipSet;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "streamNr=" + streamNr +
                ", streamer=" + streamer.getNutzername() +
                ", start=" + start +
                ", ende=" + ende +
                ", titel='" + titel + '\'' +
                ", kategorie='" + kategorie + '\'' +
                ", tags=" + tags +
                ", zuschauerSet=" + zuschauerSet +
                ", anzeigeSet=" + anzeigeSet +
                ", nachrichtSet=" + nachrichtSet +
                ", clipSet=" + clipSet +
                '}';
    }
}
