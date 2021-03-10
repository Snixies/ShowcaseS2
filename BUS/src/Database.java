import java.sql.SQLException;
import java.util.ArrayList;

public interface Database {
    public User Authenticate(Authenticator authenticator) throws SQLException, ClassNotFoundException;
    public ArrayList<Device> AllDevices() throws SQLException, ClassNotFoundException;

}
