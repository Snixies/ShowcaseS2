import java.sql.SQLException;
import java.util.ArrayList;

public class QueryMock implements Database{

    @Override
    public User Authenticate(Authenticator authenticator) throws SQLException, ClassNotFoundException {
        NormalUser normalUser = new NormalUser("123456", "Jansen", Rank.Sgt, "Password", Section.G1, "mail@mail.com", "06-12345678", SortUser.normal);
        return normalUser;
    }

    @Override
    public ArrayList<Device> AllDevices() {
        ArrayList<Device> allDevices = new ArrayList<>();

        Computer computer = new Computer("mm01", "SN019238", DeviceType.MULTIMEDIA);
        Computer computer1 = new Computer("Scrubber01", "SN678349", DeviceType.SCRUBBER);
        DataCarrier dataCarrier = new DataCarrier("13x0001", "SN20019384", DeviceType.KINGSTON);

        allDevices.add(computer);
        allDevices.add(computer1);
        allDevices.add(dataCarrier);
        return allDevices;
    }
}
