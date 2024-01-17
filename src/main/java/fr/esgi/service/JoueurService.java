package fr.esgi.service;

import fr.esgi.business.Joueur;

public interface JoueurService {

	void creerJoueur(String pseudo);

	Joueur recupererJoueur();

}
