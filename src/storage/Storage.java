package storage;

import application.*;

import java.util.ArrayList;

public class Storage {

    private static Storage instans;

    public Storage() {
    }

    public static Storage getInstance() {
        if (instans == null) {
            instans = new Storage();
        }
        return instans;
    }

    private ArrayList<Whisky> WhiskyList = new ArrayList<>();

    private ArrayList<Fad> fadList = new ArrayList<>();
    private ArrayList<Destillat> destillatList = new ArrayList<>();
    private ArrayList<Destillering> destilleringList = new ArrayList<>();
    private ArrayList<Lager> lagerList = new ArrayList<>();
    private ArrayList<Plads> pladsList = new ArrayList<>();


    //----------------------------------------------#
    //Get-metoder


    public ArrayList<Whisky> getWhiskyList() {
        return WhiskyList;
    }

    public ArrayList<Fad> getFadList() {
        return fadList;
    }

    public ArrayList<Destillat> getDestillatList() {
        return destillatList;
    }

    public ArrayList<Destillering> getDestilleringList() {
        return destilleringList;
    }

    public ArrayList<Lager> getLagerList() {
        return lagerList;
    }

    public ArrayList<Plads> getPladsList() {
        return pladsList;
    }

    //----------------------------------------------#
    //Add-metoder

    public void addWhisky(Whisky whisky) {
        WhiskyList.add(whisky);
    }

    public void addFad(Fad fad) {
        fadList.add(fad);
    }

    public void addDestillat(Destillat destillat) {
        destillatList.add(destillat);
    }

    public void addDestillering(Destillering destillering) {
        destilleringList.add(destillering);
    }

    public void addLager(Lager lager) {
        lagerList.add(lager);
    }

    public void addPlads(Plads plads) {
        pladsList.add(plads);
    }
}
