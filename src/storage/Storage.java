package storage;

import application.Destillat;
import application.Destillering;
import application.Fad;
import application.Whisky;

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

}
