package org.notes.service;

import org.notes.exceptions.MauvaisEpreuve;
import org.notes.exceptions.MauvaisEtudiant;
import org.notes.exceptions.MauvaisNote;
import org.notes.modele.Epreuve;
import org.notes.modele.Etudiant;
import org.notes.modele.Note;

import java.util.ArrayList;
import java.util.List;

public class ServiceImplementations implements Service{

    private List<Epreuve> epreuves = new ArrayList<Epreuve>();
    private List<Etudiant> etudiants = new ArrayList<Etudiant>();
    private List<Note> notes = new ArrayList<Note>();

    @Override
    public void creerEpreuve(Epreuve e) throws MauvaisEpreuve {
        if(e.name == null) throw new MauvaisEpreuve();
        if(e.ponderation < 0 || e.ponderation > 100) throw new MauvaisEpreuve();

        epreuves.add(e);

    }

    @Override
    public void creerEtudiant(Etudiant etudiant) throws MauvaisEtudiant {
        if(etudiant.contenu == null) throw new MauvaisEtudiant();
        if(etudiant.contenu.length() < 5) throw new MauvaisEtudiant();
        etudiants.add(etudiant);
    }

    @Override
    public void creerNotes(Note note) throws MauvaisNote {
        if(note.contenu < 0 || note.contenu > 100) throw new MauvaisNote();
        if(etudiants.contains(note.elementContenu) || notes.contains(note.elementContenu)){
        }
        else {
            throw new MauvaisNote();
        }
        notes.add(note);

    }

    @Override
    public List<Epreuve> tousLesEpreuves() {
        return new ArrayList<Epreuve>(epreuves);
    }

    @Override
    public List<Etudiant> tousLesEtudiants() {
        return new ArrayList<Etudiant>(etudiants);
    }

    @Override
    public List<Etudiant> etudiantPour(Epreuve e) {
        return null;
    }

    @Override
    public Note notesPour(Etudiant etu, Epreuve ep) {
        Note resultat = new Note();

        for(Note n : notes){
            if(n.epreuve.equals(ep) && n.elementContenu.equals(etu)){
                resultat = n;
            }
        }
        return resultat;
    }



}
