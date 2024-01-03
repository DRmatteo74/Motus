package fr.esgi.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {

    // attribut
    private Long id;
    private LocalDateTime dateHeureEnvoie;
    private LocalDateTime dateHeureReponse;
    private List<String> reponses = new ArrayList<>();
    private Mot mot;
    private Partie partie;
    private static Long compteur = 0L;

    // constructeur
    public Question(){
        id = compteur++;
    }
    public Question(LocalDateTime dateHeureEnvoie, Mot mot, Partie partie) {
        this();
        this.dateHeureEnvoie = dateHeureEnvoie;
        this.mot = mot;
        this.partie = partie;
    }

    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateHeureEnvoie() {
        return dateHeureEnvoie;
    }

    public void setDateHeureEnvoie(LocalDateTime dateHeureEnvoie) {
        this.dateHeureEnvoie = dateHeureEnvoie;
    }

    public LocalDateTime getDateHeureReponse() {
        return dateHeureReponse;
    }

    public void setDateHeureReponse(LocalDateTime dateHeureReponse) {
        this.dateHeureReponse = dateHeureReponse;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(dateHeureEnvoie, question.dateHeureEnvoie) && Objects.equals(dateHeureReponse, question.dateHeureReponse) && Objects.equals(reponses, question.reponses) && Objects.equals(mot, question.mot) && Objects.equals(partie, question.partie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateHeureEnvoie, dateHeureReponse, reponses, mot, partie);
    }

    // to string
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", dateHeureEnvoie=" + dateHeureEnvoie +
                ", dateHeureReponse=" + dateHeureReponse +
                ", reponses=" + reponses +
                ", mot=" + mot +
                ", partie=" + partie +
                '}';
    }
}
