class Tablet extends Devices{
    private int battery;
    private String keyboard;
    public Tablet(String type, double price, double weight, int battery, String keyboard){
        super(type, price, weight);
        this.battery = battery;
        this.keyboard = keyboard;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
}
