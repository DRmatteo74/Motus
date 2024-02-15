package fr.esgi.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {

	// attribut
	private Long id;
	private Long tempsReponse;
	private List<String> reponses = new ArrayList<>();
	private Mot mot;
	private Partie partie;
	private static Long compteur = 0L;

	// constructeur
	public Question() {
		id = compteur++;
	}

	// getter setter

	public Long getId() {
		return id;
	}

	public Long getTempsReponse() {
		return tempsReponse;
	}

	public void setTempsReponse(Long tempsReponse) {
		this.tempsReponse = tempsReponse;
	}

	public List<String> getReponses() {
		return reponses;
	}

	public void setReponses(List<String> reponses) {
		this.reponses = reponses;
	}

	public Mot getMot() {
		return mot;
	}

	public void setMot(Mot mot) {
		this.mot = mot;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	// hash code et equal
	@Override
	public int hashCode() {
		return Objects.hash(id, mot, partie, reponses, tempsReponse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(id, other.id) && Objects.equals(mot, other.mot) && Objects.equals(partie, other.partie)
				&& Objects.equals(reponses, other.reponses) && Objects.equals(tempsReponse, other.tempsReponse);
	}

	// to string
	@Override
	public String toString() {
		return "Question [id=" + id + ", tempsReponse=" + tempsReponse + ", reponses=" + reponses + ", mot=" + mot
				+  "]";
	}

}
