package func_interface;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface TaxCalculator {
    double calculate(double amount);
}

public class Main {
    public static void main(String[] args) {
        TaxCalculator taxCal = (amount -> amount * 10.0);
        System.out.println("Calculated Tax Value: " + taxCal.calculate(50.0));

        List<String> names = Arrays.asList("An", "Binh", "Cuong");

        names.forEach(s -> System.out.println(s));
        names.forEach(System.out::println);
    }
}
