package datenbanken;

import datenbanken.database.Database;
import datenbanken.utils.InputMenu;
import datenbanken.database.entries.*;

import java.util.*;

public class Main {

    private static final String[] tables = {"Zuschauer", "Streamer", "Stream", "Anzeige"};
    private static Database database;

    // ToDo 1:N checken

    public static void main(String[] args) {
        // Disable Hibernate logging
        // java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        // Init Database
        database = new Database();

        // Start menu
        menu();
    }

    private static void menu() {
        InputMenu menu = new InputMenu("Auslesen", "Einfügen", "Löschen", "Beenden");
        int value;

        do {
            value = menu.start();
            switch (value) {
                case 0 -> auslesen();
                case 1 -> einfuegen();
                case 2 -> loeschen();
            }
        } while (value != 3);
    }

    private static void auslesen() {
        InputMenu menu = new InputMenu(tables);
        int value = menu.start();

        Class<?> clazz = getTableFromName(tables[value]);
        List<?> objects = database.getAllFromTable(clazz);

        if (objects.isEmpty()) {
            System.out.println("Die Tabelle besitzt keinen Eintrag.");
            return;
        }

        for (Object o : objects) {
            System.out.println(o);
        }
    }

    private static void einfuegen() {
        InputMenu menu = new InputMenu(tables);
        int value = menu.start();

        switch (value) {
            case 0 -> einfuegenZuschauer();
            case 1 -> einfuegenStreamer();
            case 2 -> einfuegenStream();
            case 3 -> einfuegenAnzeige();
        }
    }

    private static void einfuegenZuschauer() {
        Scanner scanner = new Scanner(System.in);
        Zuschauer zuschauer = new Zuschauer();

        System.out.print("Nutzername: ");
        zuschauer.setNutzername(scanner.next());

        System.out.print("Passwort: ");
        zuschauer.setPasswort(scanner.next());

        System.out.print("Email: ");
        zuschauer.setEmail(scanner.next());

        System.out.print("Anzeigename: ");
        zuschauer.setAnzeigename(scanner.next());

        try {
            database.insert(zuschauer);
            System.out.print("Der Datensatz wurde hinzugefügt.");
        } catch (Exception e) {
            System.out.println("Der Datensatz konnte nicht hinzugefügt werden.");
        }
    }

    private static void einfuegenStreamer() {
        Scanner scanner = new Scanner(System.in);
        Streamer streamer = new Streamer();

        System.out.print("Nutzername: ");
        streamer.setNutzername(scanner.next());

        System.out.print("Passwort: ");
        streamer.setPasswort(scanner.next());

        System.out.print("Email: ");
        streamer.setEmail(scanner.next());

        System.out.print("Anzeigename: ");
        streamer.setAnzeigename(scanner.next());

        Bankverbindung bankverbindung = new Bankverbindung();
        System.out.println("Bankverbindung einrichten:");
        System.out.print("IBAN: ");
        bankverbindung.setIban(scanner.next());

        System.out.print("BIC: ");
        bankverbindung.setBic(scanner.next());

        System.out.print("Name: ");
        bankverbindung.setName(scanner.next());

        streamer.setBankverbindung(bankverbindung);

        try {
            database.insert(streamer);
            System.out.print("Der Datensatz wurde hinzugefügt.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Der Datensatz konnte nicht hinzugefügt werden.");
        }
    }

    private static void einfuegenStream() {
        Scanner scanner = new Scanner(System.in);
        Stream stream = new Stream();

        System.out.print("Start: ");
        stream.setStart(scanner.next());

        System.out.print("Ende: ");
        stream.setEnde(scanner.next());

        System.out.print("Titel: ");
        stream.setTitel(scanner.next());

        System.out.print("Kategorie: ");
        stream.setKategorie(scanner.next());

        System.out.print("Streamer Nutzername:");
        try {
            stream.setStreamer(database.getFromTable(Streamer.class, "nutzername", scanner.next()));
        } catch (Exception e) {
            System.out.println("Der Streamer konnte nicht gefunden werden.");
            return;
        }

        try {
            database.insert(stream);
            System.out.print("Der Datensatz wurde hinzugefügt.");
        } catch (Exception e) {
            System.out.println("Der Datensatz konnte nicht hinzugefügt werden.");
        }
    }


    private static void einfuegenAnzeige() {
        Scanner scanner = new Scanner(System.in);
        Anzeige anzeige = new Anzeige();

        System.out.print("Link: ");
        anzeige.setLink(scanner.next());

        System.out.print("Werbepartner:");
        try {
            anzeige.setWerbepartner(database.getFromTable(Werbepartner.class, "partnerNr", scanner.next()));
        } catch (Exception e) {
            System.out.println("Der Werbepartner konnte nicht gefunden werden.");
            return;
        }

        try {
            database.insert(anzeige);
            System.out.print("Der Datensatz wurde hinzugefügt.");
        } catch (Exception e) {
            System.out.println("Der Datensatz konnte nicht hinzugefügt werden.");
        }
    }

    private static void loeschen() {
        // list and select table
        InputMenu menu = new InputMenu(tables);
        int value = menu.start();

        Class<?> clazz = getTableFromName(tables[value]);

        // list and select entity
        List<?> entities = database.getAllFromTable(clazz);

        if (entities.isEmpty()) {
            System.out.println("Die Tabelle besitzt keinen Eintrag.");
            return;
        }

        String[] menuItems = new String[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            menuItems[i] = entities.get(i).toString();
        }
        menu = new InputMenu(menuItems);
        value = menu.start();

        database.delete(entities.get(value));
    }

    private static Class<?> getTableFromName(String name) {
        switch (name.toLowerCase()) {
            case "streamer" -> {
                return Streamer.class;
            }
            case "zuschauer" -> {
                return Zuschauer.class;
            }
            case "anzeige" -> {
                return Anzeige.class;
            }
            case "stream" -> {
                return Stream.class;
            }
        }
        return null;
    }

}
