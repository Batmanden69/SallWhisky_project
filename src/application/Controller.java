package application;

import storage.Storage;

import java.time.LocalDate;
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

    public Fad createFad(double størrelse, String fadType, String leverandør) {
        Fad fad = new Fad(størrelse, fadType, leverandør);
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

    public Destillat createDestillat(int mængde, Destillering destillering) {
        Destillat destillat = new Destillat(mængde, destillering);
        Storage.getInstance().addDestillat(destillat);
        return destillat;
    }

    public ArrayList<Destillat> getDestillatList() {
        return Storage.getInstance().getDestillatList();
    }

    public ArrayList<Lager> getLagerList() {
        return Storage.getInstance().getLagerList();
    }

    public Destillering createDestillering(int antalLiter, int maltBatch, String kornsort, double alkoholProcent, String rygemateriale, String kommentar) {
        Destillering destillering = new Destillering(antalLiter, maltBatch, kornsort, alkoholProcent, rygemateriale, kommentar);
        Storage.getInstance().addDestillering(destillering);
        return destillering;
    }

    public ArrayList<Destillering> getDestilleringList() {
        return Storage.getInstance().getDestilleringList();
    }

    public Lager createLager(String navn, int ledigePladser) {
        Lager lager = new Lager(navn, ledigePladser);
        Storage.getInstance().addLager(lager);
        return lager;
    }

    public void createPlads(int reol, int hylde, Lager lager) {
        Plads plads = new Plads(reol, hylde, lager);
        Storage.getInstance().addPlads(plads);
    }


    public void initStorage() {
//        this.createLager("Lager1", 10);
//
//        this.createPlads(1, 1, Storage.getInstance().getLagerList().get(0));
//        this.createPlads(1, 2, Storage.getInstance().getLagerList().get(0));
//        this.createPlads(1, 3, Storage.getInstance().getLagerList().get(0));
//        this.createPlads(1, 4, Storage.getInstance().getLagerList().get(0));

        Fad fad1 = this.createFad(100, "Fad1", "Leverandør1");
        Fad fad2 = this.createFad(50, "Fad2", "Leverandør2");
        Fad fad3 = this.createFad(25, "Fad3", "Leverandør3");
        Fad fad4 = this.createFad(75, "Fad4", "Leverandør4");

        Storage.getInstance().getFadList().get(0).lægPåPlads(Storage.getInstance().getLagerList().get(0));
        Storage.getInstance().getFadList().get(1).lægPåPlads(Storage.getInstance().getLagerList().get(0));
        Storage.getInstance().getFadList().get(2).lægPåPlads(Storage.getInstance().getLagerList().get(0));
        Storage.getInstance().getFadList().get(3).lægPåPlads(Storage.getInstance().getLagerList().get(0));

//        Destillering destillering1 = this.createDestillering(1000, 1, "Kornsort1", 40, null, null);
//        Destillering destillering2 = this.createDestillering(1000, 2, "Kornsort2", 40, null, null);

        Destillat destillat1 = this.createDestillat(20, destillering1);
        Destillat destillat2 = this.createDestillat(5, destillering2);

        destillering2.hældPåFad2(fad1, 10);
        destillering1.hældPåFad2(fad2,20);

        Whisky whisky1 = createWhisky(2,300);
        whisky1.addDestillat(destillat1);

    }
    public void init() {
        initStorage();
    }


}
