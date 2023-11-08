package lb6.carshop.impl;

import lb6.carshop.cars.*;
import lb6.carshop.Interfaces.*;

public class MyOwnAutoShop implements Admin, Customer {
    Car[] cars = new Car[5];

    public MyOwnAutoShop() {
        cars[0] = new Sedan(120, false, 20000, "Red", 21);
        cars[1] = new Ford(100, false, 18000, "Blue", 2023, 1000);
        cars[2] = new Ford(90, true, 15000, "Black", 2022, 500);
        cars[3] = new Truck(80, false, 25000, "White", 3000);
        cars[4] = new Truck(70, true, 22000, "Green", 2500);
    }

    public double getIncome() {
        double income = 0;
        for (Car car : cars) {
            if (car.isSellOut) {
                income += car.getSalePrice();
            }
        }
        return income;
    }


    public double getCarsPrice() {
        double total = 0;
        for (Car car : cars) {
            total += car.getSalePrice();
        }
        return total;
    }

    public String getCarColors() {
        StringBuilder colors = new StringBuilder();
        for (Car car : cars) {
            colors.append(car.color).append(", ");
        }
        return colors.substring(0, colors.length() - 2);
    }



    public double getCarPrice(int id) {
        return cars[id].getSalePrice();
    }

    public String getCarColor(int id) {
        return cars[id].color;
    }


    public void purchaseCar(int id) {
        cars[id].isSellOut = true;
    }
    public class PrimeAccumulator implements Accumulator {
        private boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

        @Override
        public int fold(int[] arr) {
            int count = 0;
            for (int n : arr) {
                if (isPrime(n)) count++;
            }
            return count;
        }
    }

    public class NonPrimeAccumulator implements Accumulator {
        private boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

        @Override
        public int fold(int[] arr) {
            int count = 0;
            for (int n : arr) {
                if (!isPrime(n)) count++;
            }
            return count;
        }
    }
}

