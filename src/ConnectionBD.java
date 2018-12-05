import javax.management.Query;
import java.sql.*;

public class ConnectionBD {

    public Connection connection;

    public ConnectionBD() {
        connectionToDB();
    }

    public void requeteAnalytique(String groupeAgeInput, String provinceInput, String jourSemaineInput, String moisInput) throws SQLException {

        Statement statement = connection.createStatement();

        String sqlQuery = "SELECT COUNT(*) FROM F_LOCATIONFILM l, D_CLIENT c, D_TEMPS t, WHERE " +
                "l.IDCLIENT = c.IDCLIENT AND l.IDTEMPS = t.IDTEMPS";

        if(!groupeAgeInput.toUpperCase().equals("TOUS") || groupeAgeInput == null) {
            int groupeAge = Integer.parseInt(groupeAgeInput);
            sqlQuery += " AND c.GROUPEAGE =" + groupeAge;
        }
        if(!provinceInput.toUpperCase().equals("TOUS") || provinceInput == null) {
            sqlQuery += " AND UPPER(c.PROVINCE) = '" + provinceInput.toUpperCase() + "'";
        }
        if(!provinceInput.toUpperCase().equals("TOUS") || jourSemaineInput == null) {
            sqlQuery += " AND d.JOURSEMAINE = '" + jourSemaineInput + "'";
        }
        if(!moisInput.toUpperCase().equals("TOUS") || moisInput == null) {
            sqlQuery += " AND d.MOIS = '" + moisInput + "'";
        }

        ResultSet query = statement.executeQuery(sqlQuery);

        while(query.next())
        System.out.println("Nombre de Location: " + query.getInt(1));
    }

    private void connectionToDB() {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@ log660ora12c.logti.etsmtl.ca:1521:LOG660","equipe35","xgq6N7xa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fermerConnectionDB() {
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
