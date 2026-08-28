package jeu;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestJeu {
    @Test
    public void verificationdebaseJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");
        jeu.deplacerPerso(Jeu.HAUT);

        // verification des coordonnees (si bien chargé)
        int x = jeu.getPj().getX();
        int y = jeu.getPj().getY();
        assertEquals(5, x);
        assertEquals(2, y);

        // le jeu n'est pas fini
        assertFalse(jeu.etreFini());
        String s = jeu.jeuToString();
        System.out.println(s);
    }
    @Test
    public void verificationdroiteJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");
        // test pour déplacer le perso vers la droite
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.DROITE);
        });
        int x = jeu.getPj().getX();
        int y = jeu.getPj().getY();
        assertEquals(5, x);
        assertEquals(3, y);

        // le jeu n'est pas fini
        assertFalse(jeu.etreFini());
        String s = jeu.jeuToString();
        System.out.println(s);
    }
    @Test
    public void verificationgaucheJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");
        // test pour déplacer le perso vers la droite
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.GAUCHE);
        });
        int x = jeu.getPj().getX();
        int y = jeu.getPj().getY();
        assertEquals(5, x);
        assertEquals(3, y);

        // le jeu n'est pas fini
        assertFalse(jeu.etreFini());
        String s = jeu.jeuToString();
        System.out.println(s);
    }
    @Test
    public void verificationbasJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");
        jeu.deplacerPerso(Jeu.BAS);

        String s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.BAS);

        s = jeu.jeuToString();
        System.out.println(s);

        // test pour se déplace d'une case vers le bas
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.BAS);
        });

        s = jeu.jeuToString();
        System.out.println(s);
    }
    @Test
    public void verificationhautJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");
        jeu.deplacerPerso(Jeu.HAUT);
        String s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.HAUT);
        s = jeu.jeuToString();
        System.out.println(s);

        // test de déplacement d'une case vers le haut
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.HAUT);
        });
        s = jeu.jeuToString();
        System.out.println(s);
    }
    @Test
    public void verificationJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby.txt");
        jeu.deplacerPerso(Jeu.BAS);
        jeu.deplacerPerso(Jeu.BAS);

        String s = jeu.jeuToString();
        System.out.println(s);

        // test de déplacement d'une case vers la droite
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.DROITE);
        });

        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.GAUCHE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.GAUCHE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.HAUT);
        s = jeu.jeuToString();
        System.out.println(s);
        s = jeu.jeuToString();
        System.out.println(s);

        // test de déplcament d'une case vers la gauche
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.GAUCHE);
        });

        jeu.deplacerPerso(Jeu.HAUT);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.HAUT);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.GAUCHE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.HAUT);
        assertFalse(jeu.etreFini());
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.DROITE);
        jeu.deplacerPerso(Jeu.DROITE);
        jeu.deplacerPerso(Jeu.DROITE);
        jeu.deplacerPerso(Jeu.DROITE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.GAUCHE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.BAS);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.DROITE);
        // test de déplacement d'une case vers la droite
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.DROITE);
        });
        s = jeu.jeuToString();
        System.out.println(s);

        // test d'une mauvaise action
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.BAS);
            jeu.deplacerPerso(Jeu.BAS);
        });
    }
    @Test
    public void verificationsimpleJeu() throws FichierIncorrectException, IOException, ActionInconnueException {
        Jeu jeu = Chargement.chargerJeu("laby/laby_simple.txt");
        String s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.GAUCHE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.BAS);
        s = jeu.jeuToString();
        System.out.println(s);

        // test de déplcament d'une case vers le bas
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.BAS);
        });
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.DROITE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.DROITE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.HAUT);
        s = jeu.jeuToString();
        System.out.println(s);

        String result = jeu.phrasedeFin();
        System.out.println(result);

        System.out.println();

        jeu.deplacerPerso(Jeu.HAUT);
        s = jeu.jeuToString();
        System.out.println(s);

        // test de déplcament d'une case vers le haut
        assertThrows(ActionInconnueException.class, () -> {
            jeu.deplacerPerso(Jeu.HAUT);
        });
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.GAUCHE);
        s = jeu.jeuToString();
        System.out.println(s);

        jeu.deplacerPerso(Jeu.GAUCHE);
        s = jeu.jeuToString();
        System.out.println(s);

        result = jeu.phrasedeFin();

        System.out.println(result);
    }
}
