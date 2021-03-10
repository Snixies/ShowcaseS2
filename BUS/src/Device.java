import java.util.Objects;

public abstract class Device {
    private final String name;
    private final String serialNumber;
    private final DeviceType type;
    private String curiosity;


    //getters
    public final String getName() {
        return name;
    }

    public final String getSerialNumber() {
        return serialNumber;
    }

    public final DeviceType getType() {
        return type;
    }

    public final String getCuriosity() {
        return curiosity;
    }

    //setter Alleen curiosity moet gezet kunnen worden
    public void setCuriosity(String curiosity) {
        this.curiosity = curiosity;
    }

    //Constructor database
    public Device(String name, String serialNumber, DeviceType type, String curiosity) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.type = type;
        this.curiosity = curiosity;
    }

    //constructor
    public Device(String name, String serialNumber, DeviceType type) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.type = type;
        this.curiosity = "Geen.";
    }


    //Methodes

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", type=" + type +
                ", curiosity='" + curiosity + '\'' +
                '}';
    }

    // Override om in unittesten het equals attribuut te kunnen gebruiken op Arraylists.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(name, device.name) && Objects.equals(serialNumber, device.serialNumber) && type == device.type && Objects.equals(curiosity, device.curiosity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, serialNumber, type, curiosity);
    }

    /*
    public boolean addDevice(Device device){
    }
    */

}
