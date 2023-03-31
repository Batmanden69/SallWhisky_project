package storage;

import model.Fad;
import model.Whisky;

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


    //----------------------------------------------#
    //Get-metoder


    public ArrayList<Whisky> getWhiskyList() {
        return WhiskyList;
    }

    public ArrayList<Fad> getFadList() {
        return fadList;
    }

    //----------------------------------------------#
    //Add-metoder

    public void addWhisky(Whisky whisky) {
        WhiskyList.add(whisky);
    }

    public void addFad(Fad fad) {
        fadList.add(fad);
    }

}
