public class SmcUser extends User {

    public SmcUser(String vNumber, String lastName, Rank rank, String password, Section section, String mailaddress, String phonenumber, SortUser sort) {
        super(vNumber, lastName, rank, password, section, mailaddress, phonenumber, sort = SortUser.BDI);
    }

    /*

    public void addUser(User user){
        User user = new NormalUser("");
        doorgeven aan db
    }

    public boolean addSmcUser() {
        SmcUser newbdimdw = new SmcUser("");
         doorgeven aan db
    }
    public boolean upgreadeUser(){
        SmcUser bdimdw = new SmcUser("");

    public boolean sendLoanApproval(){
    }

        //delete user met uAccount in db
        //smc doorgeven aan db
    }

     */
}
