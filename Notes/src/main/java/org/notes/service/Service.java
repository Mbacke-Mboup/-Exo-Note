package org.notes.service;

import org.notes.exceptions.MauvaisEpreuve;
import org.notes.exceptions.MauvaisEtudiant;
import org.notes.exceptions.MauvaisNote;
import org.notes.modele.Epreuve;
import org.notes.modele.Etudiant;
import org.notes.modele.Note;

import java.util.List;

public interface Service {

    void creerEpreuve(Epreuve e) throws MauvaisEpreuve;
    void creerEtudiant(Etudiant etudiant) throws MauvaisEtudiant;

    void creerNotes(Note note) throws MauvaisNote;

    List<Epreuve> tousLesEpreuves();

    List<Etudiant> tousLesEtudiants();

    List<Etudiant> etudiantPour(Epreuve e);

    Note notesPour(Etudiant etu,Epreuve ep);
}
