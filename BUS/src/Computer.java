public class Computer extends Device {

    public Computer(String name, String serialNumber, DeviceType type, String curiosity) {
        super(name, serialNumber, type, curiosity);
    }

    //constructor
    public Computer(String name, String serialNumber, DeviceType type) {
        super(name, serialNumber, type);
    }
}
