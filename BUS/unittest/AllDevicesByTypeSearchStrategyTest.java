import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

class AllDevicesByTypeSearchStrategyTest {

    @Test
    void SearchTest(){

    //Arrange
    QueryMock dbMock = new QueryMock();
    ArrayList<Device> allDevices = dbMock.AllDevices();
    ArrayList<?> resultActual = new ArrayList<>();
    ArrayList<Device> resultExpected = new ArrayList<>();
    SearchCriteria searchCriteria = new SearchCriteria(LocalDate.of(2020, 2, 10), LocalDate.of(2020, 2, 20), DeviceType.KINGSTON, new ArrayList<>());
    AllDevicesByTypeSearchStrategy allDevicesByTypeSearchStrategy = new AllDevicesByTypeSearchStrategy(allDevices);
    DataCarrier dataCarrier = new DataCarrier("13x0001", "SN20019384", DeviceType.KINGSTON);

    //Act
    resultActual = allDevicesByTypeSearchStrategy.Search(searchCriteria, dbMock);
    resultExpected.add(dataCarrier);

    //Assert
        Assert.assertEquals(resultExpected, resultActual);
}

}