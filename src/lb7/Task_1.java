package lb7;

public class Task_1 {
    interface Coffee {
        void brew();}

    public static void main(String[] args) {
        CoffeeMaker englishCoffeeMaker = new EnglishCoffeeMaker();
        englishCoffeeMaker.serveCoffee();

        CoffeeMaker spanishCoffeeMaker = new SpanishCoffeeMaker();
        spanishCoffeeMaker.serveCoffee();
    }


        static class EnglishCoffee implements Coffee {
            @Override
            public void brew() {
                System.out.println("Making English Coffe");
            }
        }

        static class SpanishCoffee implements Coffee {
            @Override
            public void brew() {
                System.out.println("Making English Coffe");
            }
        }

        static abstract class CoffeeMaker {
            abstract Coffee createCoffee();

            void serveCoffee() {
                Coffee coffee = createCoffee();
                coffee.brew();
                System.out.println("Serve the coffee.");
            }
        }

        static class EnglishCoffeeMaker extends CoffeeMaker {
            @Override
            Coffee createCoffee() {
                return new EnglishCoffee();
            }
        }

        static class SpanishCoffeeMaker extends CoffeeMaker {
            @Override
            Coffee createCoffee() {
                return new SpanishCoffee();
            }
        }


}
