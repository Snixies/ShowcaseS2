
/*
class ListMakerTest {
    private Computer computer = new Computer("MM01", "5QPG06", DeviceType.MULTIMEDIA);
    private Computer computer1 = new Computer("Scrubber01", "01235", DeviceType.SCRUBBER);
    private DataCarrier device1 = new DataCarrier("King0001", "13x0001", DeviceType.KINGSTON);
    private Computer device = new Computer("MM02", "klmn", DeviceType.MULTIMEDIA);
    private NormalUser user = new NormalUser("334557", "Schans", Rank.Sld1, "Wachtwoord", Section.Stcie, "S@mc.nl", "0402665065", SortUser.normal);
    private ArrayList<Device> devices = new ArrayList<>();
    private ArrayList<Device> devices1 = new ArrayList<>();
    private ArrayList<Loan> allLoan = new ArrayList<>();
    private Loan loan = new Loan(user,devices, LocalDate.of(2020,6,21), LocalDate.of(2020, 6, 30));
    private Loan loan1 = new Loan(user, devices1,LocalDate.of(2020,8,5), LocalDate.of(2020,8,7));
    private ArrayList<Device> resultActual = new ArrayList<>();
    private ArrayList<Device> resultExpected = new ArrayList<>();

    @Test
    void showAvailableDevicesTestOnDate() {
        //Arrange
        devices.add(computer);
        devices.add(computer1);
        devices1.add(device);
        devices1.add(device1);
        LocalDate s = LocalDate.of(2020, 7, 28);
        LocalDate f = LocalDate.of(2020,8,14);
        SearchCriteria searchCriteria =  new SearchCriteria(s, f, DeviceType.MULTIMEDIA);
        ListMaker good = new ListMaker();
        ListMaker bad = new ListMaker();
        allLoan.add(loan);
        allLoan.add(loan1);

        //Act
        resultActual = good.showAvailableDevices(searchCriteria);
        resultExpected.add(computer);

        //Assert
        Assert.assertEquals(resultExpected, resultActual);
    }
}*/