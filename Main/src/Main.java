import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static User logedinUser;
    private static Scanner scanner = new Scanner(System.in);
    private static Facade facade;

    public static void main(String[] args) throws Exception {

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Device> devices = new ArrayList<>();
        ArrayList<Loan> loans = new ArrayList<>();
        ArrayList<?> result = new ArrayList<>();


        System.out.println("\n ********************* \n");
        Database database = new DbQuery();
        Facade facade = new Facade(database);

        System.out.println("Wat uw Peopelesoftnummer? (Vnummer) ");
        String vNumber = scanner.next();
        System.out.println("Wat is uw wachtwoord?");
        String password = scanner.next();


        Authenticator loginId = new Authenticator(vNumber, password);
        logedinUser = facade.Login(loginId);

        String userInfo = logedinUser.toString();
        System.out.println(userInfo);

        menu();
    }

    private static void menu() throws SQLException, ClassNotFoundException {
        if(logedinUser.getSort().equals(SortUser.BDI)){
            System.out.println("Wat wilt u uitvoeren?");
            System.out.println("\n ********************* \n");
            System.out.println("1. Beschikbaarheid opvragen.");
            System.out.println("2. Eigen bruikleen opvragen.");
            System.out.println("3. Alle bruiklenen opvragen.");
            System.out.println("4. Alle apparaten opvragen.");
            System.out.println("5. Alle apparaten per type opvragen.");
            System.out.println("6. Apparaat toevoegen.");
            System.out.println("7. Aanvragen goedkeuren.");
            System.out.println("8. Persoon registreren.");
            System.out.println("\n ********************* \n");
        } else{
            System.out.println("Wat wilt u uitvoeren?");
            System.out.println("\n ********************* \n");
            System.out.println("1. Beschikbaarheid opvragen.");
            System.out.println("2. Eigen bruikleen opvragen.");
            System.out.println("\n ********************* \n");
        }
        int menuChoise = scanner.nextInt();

        switch (menuChoise){
            case 1: SearchCriteriaAsking1();
            case 2: facade.showOwnLoan(logedinUser);
            case 3: if (logedinUser.getSort().equals(SortUser.BDI)) {
                facade.showAllLoan();
                }
            case 4: if (logedinUser.getSort().equals(SortUser.BDI)) {
                facade.showAllDevices(new SearchCriteria("Empty"));
                }
            case 5:if (logedinUser.getSort().equals(SortUser.BDI)) {
                SearchCriteriaAsking1();
                facade.showAllDevicesByType(SearchCriteriaAsking1());
                }
            default:
                    System.out.println("Verkeerde invoer probeer het opnieuw!");
                    menu();
        }
    }

    private static SearchCriteria SearchCriteriaAsking1() throws SQLException, ClassNotFoundException {
        System.out.println("Geef een begindatum: (voer de dag, maand en het jaar in en toets na ieder getal op enter)");
        int startDay = scanner.nextInt();
        int startMonth = scanner.nextInt();
        int startYear = scanner.nextInt();
        if (startMonth <=0 || startMonth>=13){
            SearchCriteriaAsking1();
        }
        if (startDay <=0 || startDay >=32){
            SearchCriteriaAsking1();
        }

        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);

        System.out.println("Geef een einddatum: (voer de dag, maand en het jaar in en toets na ieder getal op enter)");
        int finishDay = scanner.nextInt();
        int finishMonth = scanner.nextInt();
        int finishYear = scanner.nextInt();
        if (startMonth <=0 || startMonth>=13){
            SearchCriteriaAsking1();
        }
        if (startDay <=0 || startDay >=32){
            SearchCriteriaAsking1();
        }
        LocalDate finishDate = LocalDate.of(finishYear, finishMonth, finishDay);

        System.out.println("Watvoor type device zoekt u?");
        System.out.println("1. DatashurPro usb (t/m Staatsgeheim Zeer Geheim.");
        System.out.println("2. Fat Client.");
        System.out.println("3. Ironkey usb (t/m Staatsgeheim Zeer Geheim).");
        System.out.println("4. Kingston usb (t/m Dpartementaal Vertrouwlijk.");
        System.out.println("5. Mulan Laptop.");
        System.out.println("6. Multi Media laptop.");
        System.out.println("7. Plotter laptop");
        System.out.println("8. Scrubber laptop.");
        System.out.println("9. Thin Client.");
        int deviceChoise = scanner.nextInt();
        DeviceType deviceType = DeviceType.UNKNOWN;

        switch (deviceChoise){
            case 1: deviceType = DeviceType.DatashurPro;
            case 2: deviceType = DeviceType.FAT_CLIENT;
            case 3: deviceType = DeviceType.IRONKEY;
            case 4: deviceType = DeviceType.KINGSTON;
            case 5: deviceType = DeviceType.MULAN;
            case 6: deviceType = DeviceType.MULTIMEDIA;
            case 7: deviceType = DeviceType.PLOTTER;
            case 8: deviceType = DeviceType.SCRUBBER;
            case 9: deviceType = DeviceType.THIN_CLIENT;
            default: System.out.println("Verkeerde invoer probeer het opnieuw!");
                menu();
        }
        ArrayList<Loan> loans = new ArrayList<>();

        SearchCriteria searchCriteria = new SearchCriteria(startDate, finishDate, deviceType, loans);
    return searchCriteria;
    }
    private static void SearchCriteriaAsking2(){

    }

    private static void SearchCriteriaAsking3(){

    }
}
