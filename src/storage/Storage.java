package storage;

public class Storage {
    private static Storage instance;

    private Storage() {

    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }
}
