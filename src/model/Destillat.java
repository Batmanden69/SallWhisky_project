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

}
