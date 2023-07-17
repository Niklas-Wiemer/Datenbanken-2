package datenbanken.database.entries;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "zuschauer")
public class Zuschauer extends Nutzer {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Streamer> streamerSet;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Stream> streamSet;

    public void setStreamerSet(Set<Streamer> streamerSet) {
        this.streamerSet = streamerSet;
    }

    public void setStreamSet(Set<Stream> streamSet) {
        this.streamSet = streamSet;
    }

    public Set<Streamer> getStreamerSet() {
        return streamerSet;
    }

    public Set<Stream> getStreamSet() {
        return streamSet;
    }

    @Override
    public String toString() {
        return super.toString() + " - Zuschauer{" +
                "streamerSet=" + streamerSet +
                ", streamSet=" + streamSet +
                '}';
    }
}
