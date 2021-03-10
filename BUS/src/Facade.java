import java.sql.SQLException;
import java.util.ArrayList;

public class Facade {
    private Database database;
    private ArrayList<?> result  = new ArrayList<>();
    private Context context = new Context();
    private SearchStrategy strategy;

    //constructor main
    public Facade(Database database) {
        this.database = database;
    }

    public static void setDatabase(Database database) {
        database = database;
    }

    public User Login(Authenticator authenticator) throws SQLException, ClassNotFoundException {
        return database.Authenticate(authenticator);
    }

    public ArrayList<?> showAllDevices(SearchCriteria searchCriteria) throws SQLException, ClassNotFoundException {
        strategy = context.CreateSearchStrattegy(Searchway.AllDeviceSeach);
        result = strategy.Search(searchCriteria, database);
        return result;
    }

    public ArrayList<?> showAllDevicesByType(SearchCriteria searchCriteria) throws SQLException, ClassNotFoundException {
        result = showAllDevices(searchCriteria);
        strategy = context.CreateSearchStrattegy(Searchway.DeviceTypeSearch);
        strategy = new AllDevicesByTypeSearchStrategy(result);
        return strategy.Search(searchCriteria, database);
    }

    public ArrayList<?> showOwnLoan(User user){
        return result;
    }

    public ArrayList<?> showAllLoan(){
        return result;
    }

}

