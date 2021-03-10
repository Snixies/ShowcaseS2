import java.util.ArrayList;

public class AllDevicesByTypeSearchStrategy implements SearchStrategy{
    private ArrayList<?> result = new ArrayList<>();

    public AllDevicesByTypeSearchStrategy(ArrayList<?> result) {
        this.result = result;
    }

    @Override
    public ArrayList<?> Search(SearchCriteria searchCriteria, Database database) {
        ArrayList<Device> devicelist = new ArrayList<>();
        for (Object object:result) {
            if (object instanceof Device){
                devicelist.add((Device) object);
            }
        }

        devicelist.removeIf((Device d) -> d.getType() != searchCriteria.getDeviceType());

        return devicelist;
    }
}
