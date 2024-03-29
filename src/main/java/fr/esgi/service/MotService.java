package fr.esgi.service;

import java.util.List;

import fr.esgi.business.Mot;

/**
 * Service qui concerne toutes fonctions de la class Mot
 */
public interface MotService {
	void importerMot();

	Mot recupererMot(String nom);

	Mot recupererMotParId(Long id);

	Mot recupererMotAleatoire();

	Mot recupererMotAleatoireParNiveau(int difficulte);

	List<Mot> recupererMots();

	Mot ajouterMot(Mot mot);

	boolean appartenirAuMot(String mot);
}
