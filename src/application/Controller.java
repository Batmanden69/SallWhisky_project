package application;

import storage.Storage;

import javax.naming.ldap.Control;
import java.util.ArrayList;

public class Controller {

    private static Controller instance;

    public Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }


    public ArrayList<Whisky> getWhiskyList() {
        return Storage.getInstance().getWhiskyList();
    }


    public static void initStorage() {

        Whisky whisky1 = new Whisky(1, 500);

    }


}
