import java.util.Objects;

public abstract class User implements Person {
    private String vNumber;
    private String lastName;
    private Rank rank;
    private String password;
    private Section section;
    private String mailaddress;
    private String phonenumber;
    private SortUser sort;
    // Voor testen zonder verbinding met db.
    private static String dbPassword = "u0131j2";

    //getters
    @Override
    public final String getVNumber() {
        return vNumber;
    }

    @Override
    public final String getLastName() {
        return lastName;
    }

    public final Rank getRank() {
        return rank;
    }

    @Override
    public final String getPassword() {
        return password;
    }

    public final String getMailaddress() {
        return mailaddress;
    }

    public final String getPhonenumber() {
        return phonenumber;
    }

    public final Section getSection() {
        return section;
    }

    public final SortUser getSort(){
        return sort;
    }

    //setters
    public void setLastName(String userName) {
        this.lastName = userName;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setSort(SortUser sort) {
        this.sort = sort;
    }

    //constructor
    public User(String vNumber, String lastName, Rank rank, String password, Section section, String mailaddress, String phonenumber, SortUser sortUser) {
        this.vNumber = vNumber;
        this.lastName = lastName;
        this.rank = rank;
        this.password = password;
        this.section = section;
        this.mailaddress = mailaddress;
        this.phonenumber = phonenumber;
        this.sort = sortUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "vNumber='" + vNumber + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rank=" + rank +
                ", section=" + section +
                ", mailaddress='" + mailaddress + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(vNumber, user.vNumber) && Objects.equals(lastName, user.lastName) && rank == user.rank && Objects.equals(password, user.password) && section == user.section && Objects.equals(mailaddress, user.mailaddress) && Objects.equals(phonenumber, user.phonenumber) && sort == user.sort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vNumber, lastName, rank, password, section, mailaddress, phonenumber, sort);
    }

    // public void login(){
   //     if this.uAccount.equals(dbUAccount) && this.password.equals(dbPassword){
   //         // login
   //     } else{
            // System.out.println("Gebruikersnaam en/of wachtwoord is onjuist."
   //     }
   // }

    //public void changePassword(){
    //    this.password = newPassword;
    //    dbPassword = newPassword;
        // nieuwe dbPassword doorgeven aan db
    //}
}
