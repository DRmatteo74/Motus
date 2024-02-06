package fr.esgi.business;

import java.util.Objects;

public class Difficulte {

	// attribut
	private Long id;
	private String labelDifficulte;
	private static Long compteur = 0L;

	// constructeur
	public Difficulte() {
		id = ++compteur;
	}

	public Difficulte(String labelDifficulte) {
		this();
		this.labelDifficulte = labelDifficulte;
	}

	// getter setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabelDifficulte() {
		return labelDifficulte;
	}

	public void setLabelDifficulte(String labelDifficulte) {
		this.labelDifficulte = labelDifficulte;
	}

	public static Long getCompteur() {
		return compteur;
	}

	public static void setCompteur(Long compteur) {
		Difficulte.compteur = compteur;
	}

	// hashcode et equal
	@Override
	public int hashCode() {
		return Objects.hash(id, labelDifficulte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Difficulte other = (Difficulte) obj;
		return Objects.equals(id, other.id) && Objects.equals(labelDifficulte, other.labelDifficulte);
	}

	// to string
	@Override
	public String toString() {
		return "Difficulte [id=" + id + ", labelDifficulte=" + labelDifficulte + "]";
	}

}
