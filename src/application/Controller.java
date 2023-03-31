package application;

import storage.Storage;

import java.util.ArrayList;
import java.util.Collection;

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

    public static Fad createFad(int id, int størrelse, String fadType, String leverandør) {
        Fad fad = new Fad(id, størrelse, fadType, leverandør);
        Storage.getInstance().addFad(fad);
        return fad;
    }

    public ArrayList<Fad> getFadList() {
        return Storage.getInstance().getFadList();
    }

    public Whisky createWhisky(int batchId, double mængde) {
        Whisky whisky = new Whisky(batchId, mængde);
        Storage.getInstance().addWhisky(whisky);
        return whisky;
    }

    public ArrayList<Whisky> getWhiskyList() {
        return Storage.getInstance().getWhiskyList();
    }

    public Destillat createDestillat (int mængde, Destillering destillering){
        Destillat destillat = new Destillat(mængde, destillering);
        Storage.getInstance().addDestillat(destillat);
        return destillat;
    }

    public ArrayList<Destillat> getDestillatList() {
        return Storage.getInstance().getDestillatList();
    }

    public Destillering createDestillering(int antalLiter, int maltBatch, String kornsort, double alkoholProcent, String rygemateriale, String kommentar){
        Destillering destillering = new Destillering(antalLiter, maltBatch, kornsort, alkoholProcent, rygemateriale, kommentar);
        Storage.getInstance().addDestillering(destillering);
        return destillering;
    }

    public ArrayList<Destillering> getDestilleringList() {
        return Storage.getInstance().getDestilleringList();
    }



    public void initStorage() {
        Lager lager1 = new Lager("Lager1", 10);


        lager1.createPlads(1, 1, lager1);
        lager1.createPlads(1, 2, lager1);
        lager1.createPlads(1, 3, lager1);
        lager1.createPlads(1, 4, lager1);


        Fad fad1 = new Fad(1, 100, "Fad1", "Leverandør1");
        Fad fad2 = new Fad(2, 10, "Fad2", "Leverandør2");
        Fad fad3 = new Fad(3, 10, "Fad3", "Leverandør3");
        Fad fad4 = new Fad(4, 70, "Fad4", "Leverandør4");

        fad1.lægPåPlads(lager1);
        fad2.lægPåPlads(lager1);
        fad3.lægPåPlads(lager1);
        fad4.lægPåPlads(lager1);

        Destillering destillering1 = new Destillering(100, 1, "Kornsort1", 40, null, null);
        Destillering destillering2 = new Destillering(100, 2, "Kornsort2", 40, null, null);

        destillering1.hældPåFad(fad1);
        destillering2.hældPåFad(fad2);


    }

    public void init() {
        initStorage();
    }


}
