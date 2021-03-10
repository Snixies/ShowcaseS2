public class NormalUser extends User {

    public NormalUser(String vNumber, String lastName, Rank rank, String password, Section section, String mailaddress, String phonenumber, SortUser sort) {
        super(vNumber, lastName, rank, password, section, mailaddress, phonenumber, sort = SortUser.normal);
    }

}
