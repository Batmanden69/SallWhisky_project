package test.application;

import application.Fad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    @Test
    void fyldPåTC1() {
        //Arrange
        Fad fad1 = new Fad(100, "Eg", "Frankrig");
        //Act
        fad1.fyldPå(50);
        //Assert
        assertEquals(50, fad1.getAntalLiterPåfyldt());
    }

    @Test
    void fyldPåTC2(){
        //Arrange
        Fad fad1 = new Fad(100, "Eg", "Frankrig");
        //Act
        fad1.fyldPå(100);
        //Assert
        assertEquals(100, fad1.getAntalLiterPåfyldt());
    }

    @Test
    void fyldPåTC3(){
        Fad fad1 = new Fad(100, "Eg", "Frankrig");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            fad1.fyldPå(150);
        });
        assertEquals("Der er ikke plads til den valgte mængde. Fadet har kun 100.0 liter plads ledig", exception.getMessage());
    }

    @Test
    void fyldPåTC4(){
        Fad fad1 = new Fad(100, "Eg", "Frankrig");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            fad1.fyldPå(-50);
        });
        assertEquals("Mængden skal være større end 0", exception.getMessage());
    }
}