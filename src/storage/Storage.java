package storage;

import application.Fad;
import application.Whisky;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Whisky> WhiskyList = new ArrayList<>();

    private static ArrayList<Fad> fadList = new ArrayList<>();


    //----------------------------------------------#
    //Get-metoder


    public static ArrayList<Whisky> getWhiskyList() {
        return WhiskyList;
    }

    public static ArrayList<Fad> getFadList() {
        return fadList;
    }

    //----------------------------------------------#
    //Add-metoder

    public static void addWhisky(Whisky whisky) {
        WhiskyList.add(whisky);
    }

    public static void addFad(Fad fad) {
        fadList.add(fad);
    }

}
