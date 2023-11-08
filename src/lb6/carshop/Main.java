package lb6.carshop;

import lb6.carshop.impl.MyOwnAutoShop;
import lb6.carshop.Interfaces.Accumulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyOwnAutoShop shop = new MyOwnAutoShop();

        System.out.println("Car colors in the store: " + shop.getCarColors());
        System.out.println("The total cost of cars in the store: " + shop.getCarsPrice());

        System.out.println("The price of a car with ID 0: " + shop.getCarPrice(0));
        System.out.println("The colors of a car with ID 0: " + shop.getCarColor(0));

        shop.purchaseCar(0);
        System.out.println("A car with ID 0 was purchased");
        System.out.println("Income from the sale of cars: " + shop.getIncome());

        System.out.println("-----------------------________---------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        Accumulator primeAccumulator = new Accumulator.PrimeAccumulator();
        Accumulator nonPrimeAccumulator = new Accumulator.NonPrimeAccumulator();

        int primeCount = primeAccumulator.fold(arr);
        int nonPrimeCount = nonPrimeAccumulator.fold(arr);

        System.out.println("Количество простых чисел: " + primeCount);
        System.out.println("Количество непростых чисел: " + nonPrimeCount);
    }
}