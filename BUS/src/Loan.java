import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Loan {
    private int idNumber;
    private User client;
    private ArrayList<Device> device;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private SmcUser smcApproval;
    private SmcUser smcOut;
    private SmcUser smcIn;


    //Getters

    public final int getIdNumber() {
        return idNumber;
    }

    public final User getClient() {
        return client;
    }

    public final ArrayList<Device> getDevice() {
        return device;
    }

    public final LocalDate getDateStart() {
        return dateStart;
    }

    public final LocalDate getDateFinish() {
        return dateFinish;
    }

    public final SmcUser getSmcApproval() {
        return smcApproval;
    }

    public final SmcUser getSmcOut() {
        return smcOut;
    }

    public final SmcUser getSmcIn() {
        return smcIn;
    }

    //setter
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public void setSmcApproval(SmcUser smcApproval) {
        this.smcApproval = smcApproval;
    }

    public void setSmcOut(SmcUser smcOut) {
        this.smcOut = smcOut;
    }

    public void setSmcIn(SmcUser smcIn) {
        this.smcIn = smcIn;
    }

    //constructor

    public Loan(User client, ArrayList<Device> device, LocalDate dateStart, LocalDate dateFinish) {
        this.idNumber = 0;
        this.client = client;
        this.device = device;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.smcApproval = null;
        this.smcOut = null;
        this.smcIn = null;
    }

    //Methodes
    public void addDevice(Device device) {
        this.device.add(device);
    }

/*
    // uitbreiden met user gegevens
    public void getOwnLoan(User user, Device device){
        System.out.println("Naam: " + user.getLastName());
        System.out.println("Van de sectie: " + user.getSection());
        System.out.println("Heeft geleend: " + device.getName());
        System.out.println("Serienummer: " + device.getSerialNumber());
        System.out.println("Startdatum: " + getDateStart());
        System.out.println("Einddatum: " + getDateFinish());
        System.out.println("Sortuser: " + user.getSort());
    }
*/

    @Override
    public String toString() {
        return "Loan{" +
                "idNumber=" + idNumber +
                ", \n client=" + client +
                ", \n device=" + device +
                ", \n dateStart=" + dateStart +
                ", \n dateFinish=" + dateFinish +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return idNumber == loan.idNumber && Objects.equals(client, loan.client) && Objects.equals(device, loan.device) && Objects.equals(dateStart, loan.dateStart) && Objects.equals(dateFinish, loan.dateFinish) && Objects.equals(smcApproval, loan.smcApproval) && Objects.equals(smcOut, loan.smcOut) && Objects.equals(smcIn, loan.smcIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, client, device, dateStart, dateFinish, smcApproval, smcOut, smcIn);
    }
}
