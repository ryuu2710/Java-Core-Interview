package interface_theory;

interface Device {
    default void powerOn() {
        System.out.println("Simple feature");
    }
}

interface SmartDevice extends Device {
    @Override
    default void powerOn(){
        Device.super.powerOn();
    }
}

public class Iphone implements SmartDevice, Device {
    public static void main(String[] args) {
        Iphone myPhone = new Iphone();
        myPhone.powerOn();
    }
}