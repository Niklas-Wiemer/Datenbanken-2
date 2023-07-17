package datenbanken.database.entries;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "streamer")
public class Streamer extends Nutzer {

    @OneToMany(mappedBy = "streamer", cascade = CascadeType.ALL)
    private Set<Stream> streamSet;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "streamerSet")
    private Set<Zuschauer> zuschauerSet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iban")
    private Bankverbindung bankverbindung;

    public void setStreamSet(Set<Stream> streamSet) {
        this.streamSet = streamSet;
    }

    public void setZuschauerSet(Set<Zuschauer> zuschauerSet) {
        this.zuschauerSet = zuschauerSet;
    }

    public void setBankverbindung(Bankverbindung bankverbindung) {
        this.bankverbindung = bankverbindung;
    }

    public Set<Stream> getStreamSet() {
        return streamSet;
    }

    public Set<Zuschauer> getZuschauerSet() {
        return zuschauerSet;
    }

    public Bankverbindung getBankverbindung() {
        return bankverbindung;
    }

    @Override
    public String toString() {
        return super.toString() + " - Streamer{" +
                "stream=" + streamSet +
                ", zuschauerSet=" + zuschauerSet +
                ", bankverbindung=" + bankverbindung +
                '}';
    }
}
