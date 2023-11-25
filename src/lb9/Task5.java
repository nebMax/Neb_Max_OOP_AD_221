package lb9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Car {
    int position;
    int speed;

    public Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

public class Task5 {
    public static void main(String[] args) {
        int N = 10;

        List<Car> cars = generateCars(N);


        int overtakes = countOvertakes(cars);


        System.out.println("Кількість обгонів: " + overtakes);
    }


    private static List<Car> generateCars(int N) {
        List<Car> cars = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < N; i++) {
            int position = random.nextInt(10000 - 10 + 1) + 10;
            int speed = random.nextInt(210 - 10 + 1) + 10;
            cars.add(new Car(position, speed));
        }

        return cars;
    }


    private static int countOvertakes(List<Car> cars) {
        int overtakes = 0;

        for (int i = 0; i < cars.size() - 1; i++) {
            for (int j = i + 1; j < cars.size(); j++) {
                if (cars.get(i).position < cars.get(j).position &&
                        (cars.get(i).position + cars.get(i).speed) > cars.get(j).position &&
                        cars.get(i).speed > cars.get(j).speed) {
                    overtakes++;
                }
            }
        }

        return overtakes;
    }
}
