package fr.esgi.service.impl;

import fr.esgi.business.Joueur;
import fr.esgi.business.Partie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JoueurServiceImplTest {

    private JoueurServiceImpl joueurService;

    @BeforeEach
    void setUp() {
        joueurService = new JoueurServiceImpl();
    }

    @Test
    void creerJoueur() {
        joueurService.creerJoueur("TestJoueur");
        Joueur joueur = joueurService.recupererJoueur();
        assertNotNull(joueur);
        assertEquals("TestJoueur", joueur.getPseudo());
    }

    @Test
    void ajouterPartie() {
        joueurService.creerJoueur("TestJoueur");
        Partie partie = new Partie();
                Joueur joueur = joueurService.recupererJoueur();
        joueurService.ajouterPartie(joueur, partie);
        List<Partie> parties = joueur.getParties();
        assertNotNull(parties);
        assertEquals(1, parties.size());
        assertEquals(partie, parties.get(0));
    }
}
