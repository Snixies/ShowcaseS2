import java.time.LocalDate;
import java.util.ArrayList;

public class SearchCriteria {
private LocalDate start;
private LocalDate finish;
private DeviceType deviceType;
private int loanIdNumber;
private String lastname;
private ArrayList<Loan> loanlist = new ArrayList<>();

    public SearchCriteria(LocalDate start, LocalDate finish, DeviceType deviceType, ArrayList<Loan> loanlist) {
        this.start = start;
        this.finish = finish;
        this.deviceType = deviceType;
        this.loanIdNumber = 0;
        this.lastname = null;
        this.loanlist = loanlist;
    }

    public SearchCriteria(int loanIdNumber) {
        this.start = null;
        this.finish = null;
        this.deviceType = null;
        this.loanIdNumber = loanIdNumber;
        this.lastname = null;
        this.loanlist = new ArrayList<>();
    }

    public SearchCriteria(String lastname){
        this.start = null;
        this.finish = null;
        this.deviceType = null;
        this.loanIdNumber = 0;
        this.lastname = lastname;
        this.loanlist = new ArrayList<>();
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public int getLoanIdNumber() {
        return loanIdNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public ArrayList<Loan> getLoanlist() {
        return loanlist;
    }
}
