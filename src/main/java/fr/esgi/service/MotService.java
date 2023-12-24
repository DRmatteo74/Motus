package fr.esgi.service;

import fr.esgi.buisness.Mot;

public interface MotService {
	void importerMot();

	Mot recupererMot(String nom);

	Mot ajouterMot(Mot mot);

}
