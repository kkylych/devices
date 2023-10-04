class Laptop extends Devices{
    private String cpu;
    private int memory;
    public Laptop(String type, double price, double weight, String cpu, int memory){
        super(type, price, weight);
        this.cpu = cpu;
        this.memory = memory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
