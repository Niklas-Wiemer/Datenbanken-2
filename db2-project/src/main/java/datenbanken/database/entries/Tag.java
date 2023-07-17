package datenbanken.database.entries;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Column(name = "inhalt")
    private String inhalt;

    @ManyToOne
    @JoinColumn(name = "streamNr")
    private Stream stream;

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public String getInhalt() {
        return inhalt;
    }

    public Stream getStream() {
        return stream;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "inhalt='" + inhalt + '\'' +
                ", stream=" + stream.getStreamNr() +
                '}';
    }
}
