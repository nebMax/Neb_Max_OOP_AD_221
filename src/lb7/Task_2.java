package lb7;

public class Task_2 {

    public static void main(String[] args) {
        PizzaStore italianizzaStore = new ItalianPizzaStore();
        italianizzaStore.orderPizza("cheese");

        PizzaStore mexicanoPizzaStore = new MexicanoPizzaStore();
        mexicanoPizzaStore.orderPizza("veggie");
    }

    static abstract class Pizza {
        void prepare() {
            System.out.println("Preparing pizza");
        }

        void bake() {
            System.out.println("Baking pizza");
        }

        void cut() {
            System.out.println("Cutting pizza");
        }

        void box() {
            System.out.println("Boxing pizza");
        }
    }

    static class ItalianCheesePizza extends Pizza {
        @Override
        void prepare() {
            System.out.println("Preparing Italian style cheese pizza");
        }
    }

    static class ItalianCarbonaraPizza extends Pizza {
        @Override
        void prepare() {
            System.out.println("Preparing Italian style carbonara pizza");
        }
    }

    static class ItalianSpecialPizza extends Pizza {
        @Override
        void prepare() {
            System.out.println("Preparing Italian special pizza");
        }
    }

    static class MexicanoCheesePizza extends Pizza {
        @Override
        void prepare() {
            System.out.println("Preparing Mexicano style Cheese pizza");
        }
    }

    static class MexicanoSuperVauPizza extends Pizza {
        @Override
        void prepare() {
            System.out.println("Preparing Mexicano style SuperVau pizza");
        }
    }

    static class MexicanoVeggiePizza extends Pizza {
        @Override
        void prepare() {
            System.out.println("Preparing Chicago style veggie pizza");
        }
    }

    interface PizzaStore {
        Pizza orderPizza(String pizzaType);
        Pizza createPizza(String pizzaType);
    }

    static class ItalianPizzaStore implements PizzaStore {
        @Override
        public Pizza orderPizza(String pizzaType) {
            Pizza pizza = createPizza(pizzaType);

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

            return pizza;
        }

        @Override
        public Pizza createPizza(String pizzaType) {
            if ("cheese".equals(pizzaType)) {
                return new ItalianCheesePizza();
            } else if ("carbonara".equals(pizzaType)) {
                return new ItalianCarbonaraPizza();
            } else if ("special".equals(pizzaType)) {
                return new ItalianSpecialPizza();
            }

            return null;
        }
    }

    static class MexicanoPizzaStore implements PizzaStore {
        @Override
        public Pizza orderPizza(String pizzaType) {
            Pizza pizza = createPizza(pizzaType);

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

            return pizza;
        }

        @Override
        public Pizza createPizza(String pizzaType) {
            if ("cheese".equals(pizzaType)) {
                return new MexicanoCheesePizza();
            } else if ("SuperVau".equals(pizzaType)) {
                return new MexicanoSuperVauPizza();
            } else if ("veggie".equals(pizzaType)) {
                return new MexicanoVeggiePizza();
            }

            return null;
        }
    }


}
