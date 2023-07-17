package datenbanken.database.entries;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "nutzer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Nutzer {

    @Id
    @Column(name = "nutzername")
    private String nutzername;
    @Column(name = "passwort")
    private String passwort;
    @Column(name = "email")
    private String email;
    @Column(name = "anzeigename")
    private String anzeigename;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nutzer")
    private Set<Nachricht> nachrichtSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nutzer")
    private Set<Clip> clipSet;

    public void setNutzername(String nutzername) {
        this.nutzername = nutzername;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAnzeigename(String anzeigename) {
        this.anzeigename = anzeigename;
    }

    public void setNachrichtSet(Set<Nachricht> nachrichtSet) {
        this.nachrichtSet = nachrichtSet;
    }

    public void setClipSet(Set<Clip> clipSet) {
        this.clipSet = clipSet;
    }

    public String getNutzername() {
        return nutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public String getEmail() {
        return email;
    }

    public String getAnzeigename() {
        return anzeigename;
    }

    public Set<Nachricht> getNachrichtSet() {
        return nachrichtSet;
    }

    public Set<Clip> getClipSet() {
        return clipSet;
    }

    @Override
    public String toString() {
        return "Nutzer{" +
                "nutzername='" + nutzername + '\'' +
                ", passwort='" + passwort + '\'' +
                ", email='" + email + '\'' +
                ", anzeigename='" + anzeigename + '\'' +
                ", nachrichtSet=" + nachrichtSet +
                ", clipSet=" + clipSet +
                '}';
    }
}
