import java.sql.SQLException;
import java.util.ArrayList;

public class AllDeviceSearchStrategy implements SearchStrategy{
    private Database database;
    private ArrayList<?> result = new ArrayList<>();

    public AllDeviceSearchStrategy() {
        this.database = database;
        this.result = new ArrayList<>();
    }

    @Override
    public ArrayList<?> Search(SearchCriteria searchCriteria, Database database) throws SQLException, ClassNotFoundException {
        result = database.AllDevices();
        return result;
    }
}
