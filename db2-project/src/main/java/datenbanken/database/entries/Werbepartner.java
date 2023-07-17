package datenbanken.database.entries;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "werbepartner")
public class Werbepartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partnerNr")
    private int partnerNr;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "werbepartner")
    private Set<Anzeige> anzeigeSet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iban")
    private Bankverbindung bankverbindung;


    public void setPartnerNr(int partnerNr) {
        this.partnerNr = partnerNr;
    }

    public void setAnzeigeSet(Set<Anzeige> anzeigeSet) {
        this.anzeigeSet = anzeigeSet;
    }

    public void setBankverbindung(Bankverbindung bankverbindung) {
        this.bankverbindung = bankverbindung;
    }

    public int getPartnerNr() {
        return partnerNr;
    }

    public Set<Anzeige> getAnzeigeSet() {
        return anzeigeSet;
    }

    public Bankverbindung getBankverbindung() {
        return bankverbindung;
    }

    @Override
    public String toString() {
        return "Werbepartner{" +
                "partnerNr=" + partnerNr +
                ", anzeigeSet=" + anzeigeSet +
                ", bankverbindung=" + bankverbindung +
                '}';
    }
}
