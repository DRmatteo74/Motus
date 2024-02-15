package fr.esgi.service;

import fr.esgi.business.Joueur;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.List;

/**
 * Service permettant l'affichage et le fonctionnement de l'historique du partie
 */
public interface HistoriqueService {

    void changerTrie(int trie, GridPane grille);

    List<Partie> recupererPartie(Joueur joueur);

    List<Question> recupererQuestion(Partie partie);

    void afficherBoutonChoix(FlowPane plane, GridPane grille);

    void afficherGrille(GridPane grille, Partie partie);

    void afficherMots(GridPane grid, Question question);
}
