import java.util.Scanner;

/**
 * La classe findannee permet de déterminer le nombre de jours pour un mois donné dans une année donnée,
 * ainsi que de vérifier la validité d'une date saisie par l'utilisateur.
 */
public class findannee {

    /**
     * Point d'entrée du programme.
     * @param args Les arguments de la ligne de commande (non utilisés dans ce programme).
     */
    public static void main(String[] args) {
        int mois=' ';

        // Appel de la méthode equivalencemois avec le mois saisi par l'utilisateur.
        equivalencemois(mois);

    }

    /**
     * Vérifie si une année est bissextile.
     * @param annee L'année à vérifier.
     * @return true si l'année est bissextile, sinon false.
     */
    public static boolean estBissextile(int annee) {
        if ((annee % 400 == 0) || (annee%4==0 && annee%100>0)) {
            return true ;
        }
        else {
            return false ;
        }
    }

    /**
     * Calcule le nombre de jours dans un mois donné d'une année donnée.
     * @param mois Le mois (1 pour janvier, 2 pour février, etc.).
     * @param annee L'année.
     * @return Le nombre de jours dans le mois spécifié pour l'année spécifiée.
     */
    public static int nbJours(int mois, int annee) {
        int nbJours;
        boolean Bissextile=estBissextile(annee);
        if (mois==1||mois==3||mois==5||mois==7||mois==8||mois==10||mois==12) {
            nbJours=31;
        }
        else {
            if (mois==4||mois==6||mois==9||mois==11){
                nbJours=30;
            }
            else {
                if (mois==2 && Bissextile==true){
                    nbJours=29;
                }
                else {
                    nbJours=28;
                }
            }
        }
        return nbJours;
    }

    /**
     * Vérifie si une date donnée est valide.
     * @param jour Le jour.
     * @param mois Le mois.
     * @param annee L'année.
     * @return true si la date est valide, sinon false.
     */
    public static boolean estValide(int jour, int mois, int annee) {
        int nbjours= nbJours(mois, annee);
        if (annee<1582){
            return false;
        }
        else {
            if (mois<1 || mois>12) {
                return false;
            }
            else {
                if (jour<1 || jour>nbjours) {
                    return false;
                }
                else {
                    return true;
                }

            }
        }
    }

    /**
     * Saisit une année depuis la console.
     * @return L'année saisie.
     */
    public static int saisieEntieranne() {
        System.out.println("Saisir une annee");
        Scanner clavier = new Scanner(System.in) ;
        int annee = clavier.nextInt() ;
        // Vérifie que l'année est supérieure à 1582 (date de début du calendrier grégorien).
        while (annee<1582){
            System.out.println("ressaisissez");
            annee= clavier.nextInt() ;
        }
        return annee;
    }

    /**
     * Saisit un mois depuis la console.
     * @return Le mois saisi.
     */
    public static int saisieEntiermois() {
        System.out.println("Saisir un mois");
        Scanner clavier = new Scanner(System.in) ;
        int mois = clavier.nextInt() ;
        // Vérifie que le mois est compris entre 1 et 12.
        while (mois>12 || mois<1){
            System.out.println("ressaisissez");
            mois= clavier.nextInt() ;
        }
        return mois;
    }

    /**
     * Affiche le nombre de jours pour un mois donné dans une année donnée.
     * @param mois Le mois.
     */
    public static void equivalencemois(int mois){
        // Saisie du mois et de l'année depuis la console.
        mois=saisieEntiermois();
        int annee= saisieEntieranne();
        // Affichage du nombre de jours pour le mois spécifié.
        switch(mois){

            case 1:
                System.out.println("janvier"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 2:
                System.out.println("fevrier"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 3:
                System.out.println("Mars"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 4:
                System.out.println("avril"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 5:
                System.out.println("mai"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 6:
                System.out.println("juin"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 7:
                System.out.println("juillet"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 8:
                System.out.println("aout"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 9:
                System.out.println("septembre"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 10:
                System.out.println("octobre"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 11:
                System.out.println("novembre"+" "+nbJours(mois,annee)+" "+annee);
                break;

            case 12:
                System.out.println("decembre"+" "+nbJours(mois,annee)+" "+annee);
                break;

            default:
                System.out.println("Choix incorrect");

        }
    }
}
