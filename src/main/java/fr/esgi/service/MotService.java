package fr.esgi.service;

import fr.esgi.business.Mot;

public interface MotService {
	void importerMot();

	Mot recupererMot(String nom);

	Mot ajouterMot(Mot mot);

}
