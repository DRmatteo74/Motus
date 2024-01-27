package fr.esgi.service;

import fr.esgi.business.Joueur;
import fr.esgi.business.Partie;

/**
 * Service qui concerne toutes fonctions de la class Joueur
 */
public interface JoueurService {

	void creerJoueur(String pseudo);

	Joueur recupererJoueur();

	void ajouterPartie(Joueur joueur, Partie partie);
}
