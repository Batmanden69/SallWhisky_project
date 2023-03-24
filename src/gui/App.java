package gui;


import model.*;

public class App {
    public static void main(String[] args) {
        Lager lager1 = new Lager("Lager1", 10);


        lager1.createPlads(1, 1, lager1);
        lager1.createPlads(1, 2, lager1);
        lager1.createPlads(1, 3, lager1);
        lager1.createPlads(1, 4, lager1);


        Fad fad1 = new Fad(1, 10, "Fad1", "Leverandør1");
        Fad fad2 = new Fad(2, 10, "Fad2", "Leverandør2");
        Fad fad3 = new Fad(3, 10, "Fad3", "Leverandør3");
        Fad fad4 = new Fad(4, 10, "Fad4", "Leverandør4");

        fad1.lægPåPlads(lager1);
        fad2.lægPåPlads(lager1);
        fad3.lægPåPlads(lager1);
        fad4.lægPåPlads(lager1);

        Destillering destillering1 = new Destillering(100, 1, "Kornsort1", 1, 40, null, null);
        Destillering destillering2 = new Destillering(100, 2, "Kornsort2", 2, 40, null, null);

        destillering1.hældPåFad(fad1);
        System.out.println(destillering1.getAntalLiter());
        destillering1.hældPåFad(fad2);
        System.out.println(destillering1.getAntalLiter());
        destillering2.hældPåFad(fad1);
        System.out.println(destillering2.getAntalLiter());
        System.out.println(fad1.getNuværendeLagring());
        System.out.println(fad3.getNuværendeLagring());

    }
}
