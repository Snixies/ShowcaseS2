import java.sql.SQLException;
import java.util.ArrayList;

public interface SearchStrategy {
    ArrayList<?> Search(SearchCriteria searchCriteria, Database database) throws SQLException, ClassNotFoundException;
}
