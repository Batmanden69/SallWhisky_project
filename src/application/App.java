package application;


import application.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Lager lager1 = new Lager("Lager1", 10);


        lager1.createPlads(1, 1, lager1);
        lager1.createPlads(1, 2, lager1);
        lager1.createPlads(1, 3, lager1);
        lager1.createPlads(1, 4, lager1);


        Fad fad1 = new Fad(1, 100, "Fad1", "Leverandør1");
        Fad fad2 = new Fad(2, 10, "Fad2", "Leverandør2");
        Fad fad3 = new Fad(3, 10, "Fad3", "Leverandør3");
        Fad fad4 = new Fad(4, 70, "Fad4", "Leverandør4");

        fad1.lægPåPlads(lager1);
        fad2.lægPåPlads(lager1);
        fad3.lægPåPlads(lager1);
        fad4.lægPåPlads(lager1);

        Destillering destillering1 = new Destillering(100, 1, "Kornsort1", 40, null, null);
        Destillering destillering2 = new Destillering(100, 2, "Kornsort2", 40, null, null);

        destillering1.hældPåFad(fad1);
        destillering2.hældPåFad(fad2);





        fad1.getLagringList().get(0).setStartDato(LocalDate.of(2023, 1, 1));
//        fad1.getLagringList().get(1).setStartDato(LocalDate.of(2022, 1, 1));

        System.out.println(fad1.getNuværendeIndhold());
        Whisky whisky1 = new Whisky(1, 100);
        System.out.println(fad2.getNuværendeIndhold());
        fad1.omhældFad(fad2);
        System.out.println(fad1.getNuværendeIndhold());
        System.out.println(fad2.getNuværendeIndhold());

        System.out.println(whisky1);






//        System.out.println(fad1.getAntalLiterPåfyldt());
//        System.out.println(fad4.getAntalLiterPåfyldt());
//        System.out.println(fad4.getNuværendeIndhold().getDestillatHistorik());


//        Whisky whisky1 = new Whisky(1, 100);
//
//        whisky1.addFad(fad1);
//        whisky1.addFad(fad2);
//
//        System.out.println(whisky1.destillatHistorik());
//
//        System.out.println(whisky1.destilleringHistorik());
//
//        System.out.println(whisky1.lagringHistorik());

//        Lagring lagring1 = new Lagring(fad1, destillering1.createDestillat(10), LocalDate.now());
//        lagring1.setSlutDato(LocalDate.now().plus(7, ChronoUnit.DAYS));
//
//        System.out.println(lagring1.getLagringsperiode());


//        System.out.println(destillering1.getAntalLiter());
//        destillering1.hældPåFad(fad2);
//        System.out.println(destillering1.getAntalLiter());
//        destillering2.hældPåFad(fad1);
//        System.out.println(destillering2.getAntalLiter());
//        System.out.println(fad1.getNuværendeLagring());
//        System.out.println(fad3.getNuværendeLagring());


    }
}
