import java.util.ArrayList;

public class Context {
    private SearchStrategy result;
    private ArrayList<Device> arrayList = new ArrayList<>();

    public SearchStrategy CreateSearchStrattegy(Searchway searchway){
        switch(searchway){
            case AllDeviceSeach: result = new AllDeviceSearchStrategy();
            case DeviceTypeSearch: result = new AllDevicesByTypeSearchStrategy(arrayList);
            case DeviceSearch: System.out.println("SearchStrattegy needs to be implemented");
            case AllLoanSearch: System.out.println("SearchStrattegy needs to be implemented");
            case LoanSearch: System.out.println("SearchStrattegy needs to be implemented");
            case AllUserSearch: System.out.println("SearchStrattegy needs to be implemented");
            case UserSearch: System.out.println("SearchStrattegy needs to be implemented");
        }
        return result;
    }
}
