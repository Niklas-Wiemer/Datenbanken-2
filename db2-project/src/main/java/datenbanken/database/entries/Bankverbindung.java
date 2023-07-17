package datenbanken.database.entries;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Bankverbindung implements Serializable {

    @Id
    private String iban;
    private String bic;
    private String name;

    public Bankverbindung(String iban, String bic, String name) {
        this.iban = iban;
        this.bic = bic;
        this.name = name;
    }

    public Bankverbindung() {
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public String getBic() {
        return bic;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bankverbindung{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
