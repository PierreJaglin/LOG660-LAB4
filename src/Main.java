import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir GroupeAge (Valeur Possible=> TOUS,18,25,30,35,40,45,50,55,60,65): ");
        String groupeAgeInput = scanner.nextLine();
        System.out.println("Saisir Province (Valeur Possible=> TOUS,QC,NB,ON,NS,NT,MB,BC,SK,AB,NL): ");
        String provinceInput = scanner.nextLine();
        System.out.println("Saisir JourSemaine (Valeur Possible=> TOUS,Lundi,Mardi,Mercredi,Jeudi,Vendredi,Samedi,Dimanche): ");
        String jourSemaineInput = scanner.nextLine();
        System.out.println("Saisir Mois (Valeur Possible => TOUS,Janvier,Février,Mars,Avril,Mai,Juin,Juillet,Août,Septembre,Octobre,Novembre,Descembre): ");
        String moisInput = scanner.nextLine();

        System.out.println("Resultat Pour: " + groupeAgeInput + " - " + provinceInput + " - " +
                jourSemaineInput + " - " + moisInput);

        ConnectionBD connectionBD = new ConnectionBD();
        connectionBD.requeteAnalytique(groupeAgeInput, provinceInput, jourSemaineInput, moisInput);

        connectionBD.fermerConnectionDB();
    }
}
