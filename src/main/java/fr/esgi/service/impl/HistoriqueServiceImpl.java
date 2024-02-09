package fr.esgi.service.impl;

import fr.esgi.business.Joueur;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;
import fr.esgi.service.HistoriqueService;
import fr.esgi.service.JoueurService;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;

public class HistoriqueServiceImpl implements HistoriqueService {

    JoueurService joueurService = new JoueurServiceImpl();

    @Override
    public List<Partie> recupererPartie(Joueur joueur) {
        return joueur.getParties();
    }

    @Override
    public List<Question> recupererQuestion(Partie partie) {
        return partie.getQuestions();
    }

    @Override
    public void afficherBoutonChoix(FlowPane plane, GridPane grille){
        List<Partie> parties = recupererPartie(joueurService.recupererJoueur());
        System.out.println(joueurService.recupererJoueur().toString());
        if(parties != null){
            for (Partie partie: parties) {
                Button button = new Button();
                button.setText("Partie " + partie.getId().toString());
                button.setStyle("-fx-background-color: #FFFFFF00; -fx-border-color: #FFF; -fx-border-radius: 40px; -fx-border-width: 2px;");
                button.setOnAction(event -> {
                    afficherGrille(grille, partie);
                });
            }
        }

    }

    @Override
    public void afficherGrille(GridPane grille, Partie partie) {
        List<Question> questions = recupererQuestion(partie);

        grille.getChildren().clear();

        int taille = questions.size();
        // Supprimer toutes les colonnes existantes
        grille.getColumnConstraints().clear();

        // defini la taille de chaque carreau
        for (int col = 0; col < 3; col++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / taille);
            grille.getColumnConstraints().add(colConst);
        }

        // Supprimer toutes les lignes existantes
        grille.getRowConstraints().clear();

        grille.setVgap(10.0);

        int nbLigne = (int) Math.ceil((double)(taille / 3));
        int questionAfficher = 0;

        // defini la taille de chaque carreau
        for (int row = 0; row < nbLigne; row++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / nbLigne);
            grille.getRowConstraints().add(rowConst);

            // créer un tableau dans chaque carreau
            for (int col = 0; col < 3; col++) {
                GridPane grid = new GridPane();
                grid.getColumnConstraints().clear();
                grid.getRowConstraints().clear();
                grid.setStyle("-fx-border-color: #FFFFFF; -fx-border-width: 3px; -fx-border-radius: 10px;");

                afficherMots(grid, questions.get(questionAfficher));
                questionAfficher = questionAfficher +1;

                grille.add(grid, col, row);
            }
        }
    }

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

            String reponse = reponses.get(row);

            // créer un label dans chaque carreau
            for (int col = 0; col < taille; col++) {
                Label label = new Label();
                label.setText(String.valueOf(reponse.charAt(col)));

                // defini le style de mes labels
                label.setStyle(
                        "-fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-background-color: #FFFFFF00; -fx-font-size: 16px; -fx-font-weight: bold; -fx-min-width: 30px; -fx-alignment: center; -fx-text-fill: white;");
                grid.add(label, col, row);
            }
        }
    }

}
