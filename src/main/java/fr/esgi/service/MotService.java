package fr.esgi.service;

import java.util.List;

import fr.esgi.buisness.Mot;

public interface MotService {
	void importerMot();

	Mot recupererMot(String nom);

	Mot recupererMotParId(Long id);

	Mot recupererMotAleatoire();

	List<Mot> recupererMots();

	Mot ajouterMot(Mot mot);

}
