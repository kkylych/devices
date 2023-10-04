import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number od devices(1-20)");
        int numDevices = scanner.nextInt();

        if(numDevices < 0 || numDevices > 20){
            System.out.println("Your input is invalid! Please, try it again");
            return;
        }
        List<Devices> devices = generateRandomDevices(numDevices);

        int deviceType = calculateDeviceType(devices);
        double totalPrice =  calculatePrice(devices);
        double totalWeight = calculateWeight(devices);

        System.out.println("Amount of distinct device types: " + deviceType);
        System.out.println("The total price of all devices: €" + totalPrice);
        System.out.println("The total weight of all devices: " + totalWeight);
    }

    public static List<Devices> generateRandomDevices(int numDevices){
        Random random = new Random();
        List<Devices> devices = new ArrayList<>();

        String[] deviceTypes = {"Smartphone", "Laptop", "Tablet"};

        for (int i = 0; i < numDevices; i++){
            String randomType = deviceTypes[random.nextInt(deviceTypes.length)];
            double randomPrice = 150 + random.nextDouble(100);
            double randomWeight = 100 + random.nextDouble(2000);

            if(randomType.equals("Smartphone")){
                double randomScreenSize = 4 + random.nextDouble(8);
                int randomCameraResolution = 5 + random.nextInt(16);
                devices.add(new Smartphone(randomType, randomPrice, randomWeight, randomScreenSize, randomCameraResolution));
            }else if (randomType.equals("Laptop")){
                String[] processors = {"Intel Core i3", "Intel Core i7", "AMD Ryzen 4"};
                String randomCpu = processors[random.nextInt(processors.length)];
                int randomMemory= 4 + random.nextInt(9);
                devices.add(new Laptop(randomType, randomPrice, randomWeight, randomCpu, randomMemory));
            }else if (randomType.equals("Tablet")){
                String[] keyboards = {"Apple", "Microsoft", "Cooper"};
                int randomBattery = 88 + random.nextInt(100);
                String randomKeyboard = keyboards[random.nextInt(keyboards.length)];
                devices.add(new Tablet(randomType, randomPrice, randomWeight, randomBattery, randomKeyboard));
            }
        }
        return devices;
    }

    private static int calculateDeviceType(List<Devices> devices){
        Set<String> distinctTypes = new HashSet<>();
        for (Devices device : devices){
            distinctTypes.add(device.getType());
        }
        return distinctTypes.size();
    }
    private static double calculatePrice(List<Devices> devices){
        double totalPrice = 0;
        for (Devices device : devices){
            totalPrice += device.getPrise();
        }
        return totalPrice;
    }


    private static double calculateWeight(List<Devices> devices){
        double totalWeight = 0;
        for (Devices device : devices){
            totalWeight += device.getWeight();
        }
        return totalWeight;
    }
}



