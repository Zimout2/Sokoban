package jeu;

import java.io.*;
import java.util.Scanner;

public class MainJeu {
    /**
     * Méthode permettant de faire tourner le jeu et de l'arrêter
     * @param args liste contenant le fichier du jeu
     * @throws IOException activable si une des méthodes est mal utilisée pour le flux de chargement
     * @throws ActionInconnueException activable si une action donnée par l'utilisateur n'est pas conforme à celle demandée
     * @throws FichierIncorrectException activable si le fichier donné n'est pas conforme aux conditions pour jouer
     */
    public static void main(String[] args) throws IOException, ActionInconnueException, FichierIncorrectException {
        // Condition permettant de charger un jeu si celui-ci existe
        if (args.length != 0) {
            Jeu maPartie = Chargement.chargerJeu(args[0]);
            System.out.println("L'objectif du jeu et de déplacer les caisses du jeu vers les endroits de dépots avec un minimum de déplacements");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int nb_deplacement = 0;

            // Condition permettant de mettre fin au non au jeu
            while (!maPartie.etreFini()) {
                maPartie.jeuToString();
                System.out.println("Ou voulez-vous déplacer votre personnage ?" + "\n" + "En HAUT, en BAS, à GAUCHE, à DROITE");
                System.out.println();
                String actions = sc.next();
                actions = actions.toUpperCase();

                // Test à chaque itération de savoir si on peut déplacer, afficher et compter le nombre de déplacement.
                try {
                    maPartie.deplacerPerso(actions);
                    maPartie.jeuToString();
                    nb_deplacement++;
                    // Si l'action de l'utilisateur et inconnu alors, on lance l'exception ActionInconnueException
                } catch (ActionInconnueException e) {
                    System.out.println(e.getMessage());
                }
                maPartie.jeuToString();
                System.out.println("Vous êtes à " + nb_deplacement + " déplacement depuis le début de la partie");
                System.out.println();
            }
            System.out.println("Vous vous êtes déplacer : " + nb_deplacement + " durant la partie, sacré balade !");
            sc.close();
        }
    }
}
