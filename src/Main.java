import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir GroupeAge (Exemple => 20): ");
        String groupeAgeInput = scanner.nextLine();
        System.out.println("Saisir Province (Exemple => QC): ");
        String provinceInput = scanner.nextLine();
        System.out.println("Saisir JourSemaine (Exemple => Lundi): ");
        String jourSemaineInput = scanner.nextLine();
        System.out.println("Saisir Mois (Exemple => Janvier): ");
        String moisInput = scanner.nextLine();

        System.out.println("Resultat Pour: " + groupeAgeInput + " - " + provinceInput + " - " +
                jourSemaineInput + " - " + moisInput);

        ConnectionBD connectionBD = new ConnectionBD();
        //connectionBD.requeteAnalytique(groupeAgeInput, provinceInput, jourSemaineInput, moisInput);

        connectionBD.fermerConnectionDB();
    }
}
