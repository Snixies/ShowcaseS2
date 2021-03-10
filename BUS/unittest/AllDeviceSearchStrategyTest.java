import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

class AllDeviceSearchStrategyTest {

    @Test
    void SearchTest() throws SQLException, ClassNotFoundException {

        //Arrange
        QueryMock dbMock = new QueryMock();
        ArrayList<?> resultActual = new ArrayList<>();
        ArrayList<Device> resultExpected = new ArrayList<>();
        AllDeviceSearchStrategy allDeviceSearchStrategy = new AllDeviceSearchStrategy();
        SearchCriteria searchCriteria = new SearchCriteria(LocalDate.of(2020, 2, 10), LocalDate.of(2020, 2, 20), DeviceType.KINGSTON, new ArrayList<>());
        Computer computer = new Computer("mm01", "SN019238", DeviceType.MULTIMEDIA);
        Computer computer1 = new Computer("Scrubber01", "SN678349", DeviceType.SCRUBBER);
        DataCarrier dataCarrier = new DataCarrier("13x0001", "SN20019384", DeviceType.KINGSTON);

        //Act
        resultActual = allDeviceSearchStrategy.Search(searchCriteria, dbMock);
        resultExpected.add(computer);
        resultExpected.add(computer1);
        resultExpected.add(dataCarrier);

        //Assert
        Assert.assertEquals(resultExpected, resultActual);

    }


}