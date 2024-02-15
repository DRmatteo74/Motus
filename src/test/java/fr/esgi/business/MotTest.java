package fr.esgi.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotTest {

    @Test
    void testGettersSetters(){
        Mot mot = new Mot();
        String message = "Toto";
        int longueurMot = message.length();

        mot.setMot(message);
        mot.setLongueurMot(longueurMot);

        assertNotNull(mot.getId());
        assertNotNull(mot.getMot());
        assertEquals(4, mot.getLongueurMot());
    }

    @Test
    void testDefaultConstructor(){
        Mot mot = new Mot();
        assertNotNull(mot.getId());
    }

    @Test
    void testSecondConstructor(){
        String message = "Toto";
        int longueurMot = message.length();
        Mot mot = new Mot(message, longueurMot);

        assertNotNull(mot.getId());
        assertEquals(message, mot.getMot());
        assertEquals(longueurMot, mot.getLongueurMot());
    }

    @Test
    void testHashCode(){
        Mot mot1 = new Mot("Toto", 5);
        Mot mot2 = new Mot("Toto", 5);

        assertNotEquals(mot1.hashCode(), mot2.hashCode());
    }

    @Test
    void testEquals(){
        Mot mot1 = new Mot("Toto", 5);
        Mot mot2 = new Mot("Toto", 5);
        assertNotEquals(mot1, mot2);
    }

    @Test
    void testToString(){
        Mot mot = new Mot("Toto", 5);
        String expectedString = "Mot [id=1, mot=Toto, longueurMot=5]";
        assertEquals(expectedString, mot.toString());
    }
}
