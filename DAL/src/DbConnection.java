import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public Connection connection(){

        try {
        /*
        Error: Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
        https://stackoverflow.com/questions/52032739/loading-class-com-mysql-jdbc-driver-this-is-deprecated-the-new-driver-class

        Error: java.sql.SQLException: The server time zone value 'West-Europa (standaard tijd)' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the 'serverTimezone' configuration property) to use a more specific time zone value if you want to utilize time zone support.
        https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue

         */
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:330/smc_loan?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "televisie");
            System.out.println("Connected.");
            return conn;
        } catch (Exception exception) {
            System.out.println("Geen connectie met database mogelijk.");
        }
        return null;
    }
}
