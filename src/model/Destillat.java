package model;

import java.util.ArrayList;

public class Destillat {
    private String historie;
    private Destillering destillering;
    private final ArrayList<Fad> fadList = new ArrayList<>();

    public Destillat(String historie, Destillering destillering) {
        this.historie = historie;
        this.destillering = destillering;
    }

    public String getHistorie() {
        return historie;
    }

    public void setHistorie(String historie) {
        this.historie = historie;
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public void setDestillering(Destillering destillering) {
        this.destillering = destillering;
    }

    public ArrayList<Fad> getFadList() {
        return fadList;
    }

    public void addFad (Fad fad){
        if (!fadList.contains(fad)){
            fadList.add(fad);
            fad.setDestillat(this);
        }
    }
    public void removeFad(Fad fad){
        if (fadList.contains(fad)){
            fadList.remove(fad);
            fad.setDestillat(null);
        }
    }
}
