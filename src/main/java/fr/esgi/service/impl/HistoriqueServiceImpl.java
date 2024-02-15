package fr.esgi.service.impl;

import fr.esgi.business.Joueur;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;
import fr.esgi.service.HistoriqueService;
import fr.esgi.service.JeuService;
import fr.esgi.service.JoueurService;
import fr.esgi.util.ComparateurQuestionParMot;
import fr.esgi.util.ComparateurQuestionParTemps;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueServiceImpl implements HistoriqueService {

    JoueurService joueurService = new JoueurServiceImpl();
    JeuService jeuService = new JeuServiceImpl();
    int trieActuel = 0;
    Partie partieActuel = null;


    /**
     * Permet de trier les questions et regénérer l'historique
     * @param trie
     * @param grille
     */
    @Override
    public void changerTrie(int trie, GridPane grille){
        trieActuel = trie;
        afficherGrille(grille, partieActuel);
    }

    /**
     * Permet de récupérer les parties du joueur
     * @param joueur
     * @return
     */
    @Override
    public List<Partie> recupererPartie(Joueur joueur) {
        return joueur.getParties();
    }

    /**
     * Permet de récupérer les questions à partir de la partie
     * @param partie
     * @return
     */
    @Override
    public List<Question> recupererQuestion(Partie partie) {
        return partie.getQuestions();
    }

    /**
     * Affiche les boutons de sélection de partie
     * @param plane
     * @param grille
     */
    @Override
    public void afficherBoutonChoix(FlowPane plane, GridPane grille){
        List<Partie> parties = recupererPartie(joueurService.recupererJoueur());
        if(parties != null){
            for (Partie partie: parties) {
                Button button = new Button();
                button.setText("Partie " + partie.getId().toString());
                button.setStyle("-fx-background-color: #FFFFFF00; -fx-border-color: #FFF; -fx-border-radius: 40px; -fx-border-width: 2px; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: white;");
                button.setOnAction(event -> {
                    afficherGrille(grille, partie);
                    partieActuel = partie;
                });
                plane.getChildren().add(button);
            }
        }
    }

    /**
     * Génère les grilles pour chaques questions d'une partie
     * @param grille
     * @param partie
     */
    @Override
    public void afficherGrille(GridPane grille, Partie partie) {
        if(partie == null) return;

        // Tri de la liste question
        List<Question> questions = recupererQuestion(partie);
        if(trieActuel == 1){
            questions = questions.stream().sorted(new ComparateurQuestionParMot()).toList();
        } else if (trieActuel == 2) {
            questions = questions.stream().sorted(new ComparateurQuestionParTemps()).toList();
        }

        grille.getChildren().clear();
        int taille = questions.size();
        // Supprimer toutes les colonnes existantes
        grille.getColumnConstraints().clear();

        // defini la taille de chaque carreau
        for (int col = 0; col < 2; col++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / 2);
            grille.getColumnConstraints().add(colConst);
        }

        // Supprimer toutes les lignes existantes
        grille.getRowConstraints().clear();

        grille.setVgap(10.0);
        double nbLigneF = taille / 2.0;
        int nbLigne = (int) Math.ceil(nbLigneF);
        int questionAfficher = 0;

        // defini la taille de chaque carreau
        for (int row = 0; row < nbLigne; row++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / nbLigne);
            grille.getRowConstraints().add(rowConst);

            // créer un tableau dans chaque carreau
            for (int col = 0; col < 2; col++) {
                if (questionAfficher < taille) {
                    // Ajout d'une box verticale
                    VBox vBox = new VBox();
                    vBox.setSpacing(2);
                    vBox.setAlignment(Pos.TOP_CENTER);
                    grille.add(vBox, col,row);
                    // Affichage de la grille de jeu avec les réponses données
                    GridPane grid = new GridPane();
                    grid.getColumnConstraints().clear();
                    grid.getRowConstraints().clear();
                    grid.setMinSize(100, 100);
                    grid.setStyle("-fx-border-color: #FFFFFF; -fx-border-width: 3px; -fx-border-radius: 10px;");
                    vBox.getChildren().add(grid);
                    afficherMots(grid, questions.get(questionAfficher));

                    // Affichage du temps
                    Label temps = new Label();
                    temps.setText("Temps : " + questions.get(questionAfficher).getTempsReponse() + "s");
                    temps.setStyle("fx-border-color: white; -fx-font-size: 16px; -fx-font-weight: bold; -fx-alignment: center; -fx-text-fill: white;");
                    vBox.getChildren().add(temps);

                    questionAfficher = questionAfficher + 1;
                }
            }
        }
    }

    /**
     * Permet d'afficher les mots dans une grille
     * @param grid
     * @param question
     */
    @Override
    public void afficherMots(GridPane grid, Question question){
        int taille = question.getMot().getLongueurMot();
        List<String> reponses = question.getReponses();

        for (int col = 0; col < taille; col++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / taille);
            grid.getColumnConstraints().add(colConst);
        }

        for (int row = 0; row < 6; row++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / 6);
            grid.getRowConstraints().add(rowConst);

            String reponse = null;

            // Vérifie s'il y a une réponse pour une ligne
            if(reponses.size() > row){
                reponse = reponses.get(row);
            }

            // créer un label dans chaque carreau
            for (int col = 0; col < taille; col++) {
                Label label = new Label();
                if(reponse == null){
                    label.setText("_");
                }else{
                    label.setText(String.valueOf(reponse.charAt(col)).toUpperCase());
                }

                // defini le style de mes labels
                label.setStyle(
                        "-fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-background-color: #FFFFFF00; -fx-font-size: 16px; -fx-font-weight: bold; -fx-min-width: 30px; -fx-alignment: center; -fx-text-fill: white;");
                grid.add(label, col, row);
            }
            // Affiche les couleurs pour chaque case
            if(reponses.size() > row) {
                jeuService.verifierMot(reponse, question.getMot().getMot(), grid, row);
            }
        }
    }

}
