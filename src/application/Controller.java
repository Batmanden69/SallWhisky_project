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

    public Fad createFad(int id, int størrelse, String fadType, String leverandør) {
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

    public Destillat createDestillat(int mængde, Destillering destillering) {
        Destillat destillat = new Destillat(mængde, destillering);
        Storage.getInstance().addDestillat(destillat);
        return destillat;
    }

    public ArrayList<Destillat> getDestillatList() {
        return Storage.getInstance().getDestillatList();
    }

    public Destillering createDestillering(int antalLiter, int maltBatch, String kornsort, double alkoholProcent, String rygemateriale, String kommentar) {
        Destillering destillering = new Destillering(antalLiter, maltBatch, kornsort, alkoholProcent, rygemateriale, kommentar);
        Storage.getInstance().addDestillering(destillering);
        return destillering;
    }

    public ArrayList<Destillering> getDestilleringList() {
        return Storage.getInstance().getDestilleringList();
    }

    public void createLager(String navn, int ledigePladser) {
        Lager lager = new Lager(navn, ledigePladser);
        Storage.getInstance().addLager(lager);
    }

    public void createPlads(int reol, int hylde, Lager lager) {
        Plads plads = new Plads(reol, hylde, lager);
        Storage.getInstance().addPlads(plads);
    }





    public void initStorage() {
        this.createLager("Lager1", 10);

        this.createPlads(1, 1, Storage.getInstance().getLagerList().get(0));
        this.createPlads(1, 2, Storage.getInstance().getLagerList().get(0));
        this.createPlads(1, 3, Storage.getInstance().getLagerList().get(0));
        this.createPlads(1, 4, Storage.getInstance().getLagerList().get(0));

        Fad fad1 = this.createFad(1, 100, "Fad1", "Leverandør1");
        Fad fad2 = this.createFad(2, 10, "Fad2", "Leverandør2");
        Fad fad3 = this.createFad(3, 50, "Fad3", "Leverandør3");
        Fad fad4 = this.createFad(4, 70, "Fad4", "Leverandør4");

        Storage.getInstance().getFadList().get(0).lægPåPlads(Storage.getInstance().getLagerList().get(0));
        Storage.getInstance().getFadList().get(1).lægPåPlads(Storage.getInstance().getLagerList().get(0));
        Storage.getInstance().getFadList().get(2).lægPåPlads(Storage.getInstance().getLagerList().get(0));
        Storage.getInstance().getFadList().get(3).lægPåPlads(Storage.getInstance().getLagerList().get(0));

        Destillering destillering1 = this.createDestillering(100, 1, "Kornsort1", 40, null, null);
        Destillering destillering2 = this.createDestillering(100, 2, "Kornsort2", 40, null, null);

        Destillat destillat1 = this.createDestillat(20, destillering1);
        Destillat destillat2 = this.createDestillat(20, destillering2);
//        Storage.getInstance().getDestilleringList().get(0).hældPåFad(Storage.getInstance().getFadList().get(0));
//        Storage.getInstance().getDestilleringList().get(1).hældPåFad(Storage.getInstance().getFadList().get(1));
        destillat1.hældPåFad(fad1,20);
        destillat2.hældPåFad(fad2,20);


        destillat1.getDestillatHistorik().get(0).setStartDato(LocalDate.of(2020, 01, 01));
        destillat2.getDestillatHistorik().get(0).setStartDato(LocalDate.of(2021, 01, 01));

        System.out.println(destillat1.destillatLagringOversigt());
        System.out.println(destillat2.destillatLagringOversigt());

//        destillering1.getDestillatList().get(0).getDestillatHistorik().get(0).setStartDato(LocalDate.of(2020, 01, 01));
//        destillering2.getDestillatList().get(0).getDestillatHistorik().get(0).setStartDato(LocalDate.of(2021, 01, 01));

        fad1.omhældFad2(fad3);
        fad2.omhældFad2(fad3);




//        Lager lager1 = new Lager("Lager1", 10);
//
//
//        lager1.createPlads(1, 1, lager1);
//        lager1.createPlads(1, 2, lager1);
//        lager1.createPlads(1, 3, lager1);
//        lager1.createPlads(1, 4, lager1);
//
//
//        Fad fad1 = new Fad(1, 100, "Fad1", "Leverandør1");
//        Fad fad2 = new Fad(2, 10, "Fad2", "Leverandør2");
//        Fad fad3 = new Fad(3, 10, "Fad3", "Leverandør3");
//        Fad fad4 = new Fad(4, 70, "Fad4", "Leverandør4");
//
//        fad1.lægPåPlads(lager1);
//        fad2.lægPåPlads(lager1);
//        fad3.lægPåPlads(lager1);
//        fad4.lægPåPlads(lager1);
//
//        Destillering destillering1 = new Destillering(100, 1, "Kornsort1", 40, null, null);
//        Destillering destillering2 = new Destillering(100, 2, "Kornsort2", 40, null, null);
//
//        destillering1.hældPåFad(fad1);
//        destillering2.hældPåFad(fad2);


    }

    public void init() {
        initStorage();
    }


}
