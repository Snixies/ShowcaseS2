import java.util.ArrayList;

public class ListMaker {
    private ArrayList<?> list = new ArrayList<>();
    private ArrayList<Loan> allLoan = new ArrayList<>();
    private ArrayList<Loan> ownLoan = new ArrayList<>();
    private ArrayList<Device> allDevices = new ArrayList<>();
    private ArrayList<Device> allAvailableDevicesByType = new ArrayList<>();
    private ArrayList<Device> allDevicesByType = new ArrayList<>();

    //TODO opruimen als db werkend is
    public void setAllLoan(ArrayList<Loan> allLoan) {
        this.allLoan = allLoan;
    }
    //TODO opruimen als db werkend is
    public void setAllDevices(ArrayList<Device> allDevices) {
        this.allDevices = allDevices;
    }

    public ListMaker(){
        this.list = new ArrayList<>();
    }

    /**
     * This method loop through all loans and returns a list that are not on a loan in a specific timestamp.
     * @param searchCriteria gives the following criteria
     *                       Startdate for a new loan.
     *                       finishdate for a new loan.
     *                       Devicetype that the user want to loan.
     * @return a list of available device of the asked devicetype
     */
    public ArrayList<Device> showAvailableDevices(SearchCriteria searchCriteria) {
        allAvailableDevicesByType = showAllDevicesByType(searchCriteria.getDeviceType());
        if(allLoan != null) {
            for (Loan loan : allLoan) {
                ArrayList<Device> loandevices = new ArrayList<>();
                loandevices.addAll(loan.getDevice());

                for (Device device : loandevices) {
                    if (searchCriteria.getStart().isAfter(loan.getDateStart()) && searchCriteria.getStart().isBefore(loan.getDateFinish()) || searchCriteria.getStart().isEqual(loan.getDateStart())) {
                        allAvailableDevicesByType.remove(device);
                    }
                    if (searchCriteria.getFinish().isAfter(loan.getDateStart()) && searchCriteria.getFinish().isBefore(loan.getDateFinish()) || searchCriteria.getFinish().isEqual(loan.getDateFinish())) {
                        allAvailableDevicesByType.remove(device);
                    }
                    if (searchCriteria.getStart().isBefore(loan.getDateStart()) && searchCriteria.getFinish().isAfter(loan.getDateFinish())) {
                        allAvailableDevicesByType.remove(device);
                    }
                }
            }
        }
        return allAvailableDevicesByType;
    }

    /**
     * This methode gives all the loan from the db.
     *
     */
    //TODO implementatie
    public ArrayList<Loan> showAllLoan() {
        return allLoan;
    }

    /**
     * This method shows a list of loans of the user itself.
     * @param user the user who wants to see theirown loans.
     *
     */
    public ArrayList<Loan> showOwnLoan(User user) {
        showAllLoan();
        if (showAllLoan() != null){
            for (Loan loan : showAllLoan()){
                if (loan.getClient().getVNumber().equals(user.getVNumber())){
                    ownLoan.add(loan);
                }
            }
        }
        return ownLoan;
    }

    /**
     * This method gives a list of all devices known in the db.
     * @return a list of all the devices.
     */
    //TODO implementatie vanuit db ipv handmatige lijst
    private ArrayList<Device> showAllDevices(){
        Computer computer = new Computer("MM01", "5QPG06", DeviceType.MULTIMEDIA);
        Computer computer1 = new Computer("Scrubber01", "01235", DeviceType.SCRUBBER);
        DataCarrier device1 = new DataCarrier("King0002", "13x0002", DeviceType.KINGSTON);
        Computer device = new Computer("MM02", "klmn", DeviceType.MULTIMEDIA);
        allDevices.add(computer);
        allDevices.add(computer1);
        allDevices.add(device);
        allDevices.add(device1);
        return allDevices;
    }

    /**
     * This method makes a list of Devices of one kind of devicetype.
     * This is necessary for the method showAvailableDevices().
     * It loops through a list of devices that came out of the db.
     * @param type The devicetype which you a list of.
     * @return the list of all that devices.
     */
    private ArrayList<Device> showAllDevicesByType(DeviceType type) {
        if(showAllDevices() != null) {
            for (Device device : showAllDevices()) {
                if (device.getType() == type) allDevicesByType.add(device);
            }
        }
    return allDevicesByType;
    }
}
