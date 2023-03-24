package gui;

import model.Fad;
import model.Lager;

public class App {
    public static void main(String[] args) {
        Lager lager1 = new Lager("Lager1", 10);


        lager1.createPlads(1, 1, lager1);
        lager1.createPlads(1, 2, lager1);
        lager1.createPlads(1, 3, lager1);
        lager1.createPlads(1, 4, lager1);


        Fad fad1 = new Fad(1, 10, 10, "Fad1", "Leverandør1");
        Fad fad2 = new Fad(2, 10, 10, "Fad2", "Leverandør2");
        Fad fad3 = new Fad(3, 10, 10, "Fad3", "Leverandør3");

        fad1.lægPåPlads(lager1);
        fad2.lægPåPlads(lager1);
        fad3.lægPåPlads(lager1);

        System.out.println(lager1.getPladsListe());
    }
}
