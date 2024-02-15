package fr.esgi.business;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void testGettersSetters(){
        Joueur joueur = new Joueur();
        String pseudo = "Toto";
        List<Partie> parties = new ArrayList<>();

        joueur.setPseudo(pseudo);
        joueur.setParties(parties);

        assertNotNull(joueur.getId());
        assertNotNull(joueur.getPseudo());
        assertNotNull(joueur.getParties());
    }

    @Test
    void testDefaultConstructor(){
        Joueur joueur = new Joueur();
        assertNotNull(joueur.getId());
    }

    @Test
    void testSecondConstructor(){
        String pseudo = "Toto";
        List<Partie> parties = new ArrayList<>();
        Joueur joueur = new Joueur(pseudo,parties);

        assertNotNull(joueur.getPseudo());
        assertNotNull(joueur.getParties());
    }

    @Test
    void testHashCode(){
        String pseudo = "Toto";
        List<Partie> parties = new ArrayList<>();

        Joueur joueur1 = new Joueur(pseudo,parties);
        Joueur joueur2 = new Joueur(pseudo,parties);

        assertNotEquals(joueur1.hashCode(), joueur2.hashCode());
        assertNotEquals(joueur1.hashCode(), joueur2.hashCode());
    }

    @Test
    void testEquals(){
        String pseudo = "Toto";
        List<Partie> parties = new ArrayList<>();

        Joueur joueur1 = new Joueur(pseudo,parties);
        Joueur joueur2 = new Joueur(pseudo,parties);

        assertNotEquals(joueur1, joueur2);
    }

    @Test
    void testToString(){
        String pseudo = "Toto";
        List<Partie> parties = new ArrayList<>();
        Joueur joueur = new Joueur(pseudo,parties);

        String expectedString = "Joueur [id=2, pseudo=Toto, parties=[]]";
        assertEquals(expectedString, joueur.toString());
    }
}
