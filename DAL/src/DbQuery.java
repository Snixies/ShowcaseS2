import java.sql.*;
import java.util.ArrayList;


public class DbQuery implements Database {

    public DbQuery() {

    }

    public void connection() throws SQLException, ClassNotFoundException {

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
        } catch (Exception exception) {
            System.out.println("Geen connectie met database mogelijk.");
        }
    }

    @Override
    public User Authenticate(Authenticator authenticator) throws SQLException, ClassNotFoundException {
        Connection conn = new DbConnection().connection();

        User user = new NormalUser("", "", Rank.Unknown, "", Section.Unknown, "", "", SortUser.normal);

   /*     String query = "select Password from user where Vnumber = ? ";

        //TODO weghalen na controleren
        System.out.println(query);

  //      try {
            PreparedStatement preparedStatementstmt = conn.prepareStatement(query);
            preparedStatementstmt.setString(1, authenticator.getvNumber());
            ResultSet rs = preparedStatementstmt.executeQuery();
            String dbPassword = null;
            if (rs.next()) {
                dbPassword = rs.getString("Password");
            }
            //TODO weghalen na controleren
            System.out.println(dbPassword + authenticator.getPassword());

            if (authenticator.getPassword().equals(dbPassword)){
                query = "SELECT 'Vnumber', 'lastname', 'rank', 'Password', 'Section', 'Mailaddress', 'Phonenumber', 'Type' from user where vNumber is '?'";
                preparedStatementstmt.setString(1,authenticator.getvNumber());
                ResultSet rs1 = preparedStatementstmt.executeQuery();

                while (rs1.next()) {
                    String vnumber = rs1.getString("Vnumber");
                    String lastName = rs1.getString(1);
                    String rank = rs1.getString(2);
                    String password = rs1.getString(3);
                    String section = rs1.getString(4);
                    String mailaddress = rs1.getString(5);
                    String phonenumber = rs1.getString(6);
                    String sort = rs1.getString(7);

                    // Casten van Strings uit de DB naar Enums uit de code.
                    Rank rank1 = Rank.Unknown;
                    switch (rank){
                        case "Burger": rank1 = Rank.Burger;
                        case "Sld3": rank1 = Rank.Sld3;
                        case "Sld2": rank1 = Rank.Sld2;
                        case "Sld1": rank1 = Rank.Sld1;
                    }

                    Section section1 = Section.Unknown;
                    switch (section){
                        case "Cogp": section1 = Section.Cogp;
                        case "Stcie": section1 = Section.Stcie;
                    }

                    SortUser sort1 = SortUser.normal;
                    if (sort.equals("BDI")) {
                        sort1 = SortUser.BDI;
                    }

                    if(sort1.equals(SortUser.BDI)){
                        sort1 = SortUser.BDI;
                        SmcUser user1 = new SmcUser(vnumber, lastName, rank1, password, section1, mailaddress, phonenumber, sort1);
                    return user1;
                    } else {
                        user = new NormalUser(vnumber, lastName, rank1, password, section1, mailaddress, phonenumber, sort1);
                    return user;
                    }
                }
            }*/

 /*       }
        catch (Exception e){
            System.out.println("Query wordt niet uitgevoerd.");
        }*/
        return user;
    }

    @Override
    public ArrayList<Device> AllDevices() throws SQLException, ClassNotFoundException {
        ArrayList<Device> result = new ArrayList<>();

 //       try{
            connection();

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:330/smc_loan?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "televisie");
            Statement stmt = conn.createStatement();
            String query = "select * from Device";
            ResultSet rs1 = stmt.executeQuery(query);

            while (rs1.next()) {
                String name = rs1.getString("DeviceName");
                String serial = rs1.getString("Serialnumber");
                String type = rs1.getString("Type");
                String curiosity = rs1.getString("Curiosity");

                DeviceType devicetype = DeviceType.UNKNOWN;
                devicetype = devicetype.getDeclaringClass().cast(type);

                if (devicetype.equals(DeviceType.KINGSTON) || devicetype.equals(DeviceType.DatashurPro) || devicetype.equals(DeviceType.IRONKEY) ) {
                    DataCarrier device = new DataCarrier(name, serial, devicetype, curiosity);
                    result.add(device);
                } else{
                    Computer device = new Computer(name, serial, devicetype, curiosity);
                    result.add(device);
                }

            }

 /*       } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        return result;
    }

}
