package org.notes;

import junit.framework.TestCase;
import org.notes.exceptions.MauvaisEpreuve;
import org.notes.exceptions.MauvaisEtudiant;
import org.notes.exceptions.MauvaisNote;
import org.notes.modele.Epreuve;
import org.notes.modele.Etudiant;
import org.notes.modele.Note;
import org.notes.service.Service;
import org.notes.service.ServiceImplementations;

public class TestService extends TestCase {


    public void testTousEpreuvesAvecEtudiants() throws MauvaisEtudiant, MauvaisNote, MauvaisEpreuve {
        Service service = new ServiceImplementations();

        Epreuve ep = new Epreuve();
        Epreuve ep1 = new Epreuve();

        Etudiant e = new Etudiant();
        Etudiant e1 = new Etudiant();

        Note n = new Note();
        Note n1 = new Note();
        Note n2 = new Note();
        Note n3 = new Note();

        ep.name = "Examen 1";
        ep1.name = "Examen 2";

        ep.ponderation = 20;
        ep1.ponderation = 30;

        e.contenu = "Billy Monseau";
        e1.contenu = "Johny Bravo";

        service.creerEtudiant(e);
        service.creerEtudiant(e1);

        ep.elementContenus.add(e);
        ep.elementContenus.add(e1);

        n.epreuve = ep;
        n1.epreuve = ep1;
        n2.epreuve = ep1;
        n3.epreuve = ep;
        n.elementContenu = e;
        n1.elementContenu = e1;
        n2.elementContenu = e;
        n3.elementContenu = e1;
        n.contenu = 35;
        n1.contenu = 75;
        n2.contenu = 85;
        n3.contenu = 95;
        service.creerNotes(n);
        service.creerNotes(n1);
        service.creerNotes(n2);
        service.creerNotes(n3);
        service.creerEpreuve(ep);
        service.creerEpreuve(ep1);


        for(Epreuve eps : service.tousLesEpreuves()){

            System.out.println(eps.name + " // "+eps.ponderation + "%");
            for(Etudiant etu : service.tousLesEtudiants()){
                Note note = service.notesPour(etu,eps);
                System.out.println(note.elementContenu.contenu + " >>> " +note.contenu+ "%");
            }
            System.out.println();
        }

    }


}
