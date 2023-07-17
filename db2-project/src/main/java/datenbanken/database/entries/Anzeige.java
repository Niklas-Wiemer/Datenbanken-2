package datenbanken.database.entries;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "anzeige")
public class Anzeige {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anzeigenNr")
    private int anzeigenNr;

    @Column(name = "link")
    private String link;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Stream> streamSet;

    @ManyToOne
    @JoinColumn(name = "partnerNr")
    private Werbepartner werbepartner;

    public void setAnzeigenNr(int anzeigenNr) {
        this.anzeigenNr = anzeigenNr;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setStreamSet(Set<Stream> streamSet) {
        this.streamSet = streamSet;
    }

    public void setWerbepartner(Werbepartner werbepartner) {
        this.werbepartner = werbepartner;
    }

    public int getAnzeigenNr() {
        return anzeigenNr;
    }

    public String getLink() {
        return link;
    }

    public Set<Stream> getStreamSet() {
        return streamSet;
    }

    public Werbepartner getWerbepartner() {
        return werbepartner;
    }

    @Override
    public String toString() {
        return "Anzeige{" +
                "anzeigenNr=" + anzeigenNr +
                ", link='" + link + '\'' +
                ", streamSet=" + streamSet +
                ", werbepartner=" + werbepartner.getPartnerNr() +
                '}';
    }
}
