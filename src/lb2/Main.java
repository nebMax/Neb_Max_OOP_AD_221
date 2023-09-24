package lb2;

//import java.util.LinkedList;

//Task1
class Item{
    private String name;
    private float price;

    public Item(String name, float price){
        this.name = name;
        if(price < 0){
            this.price = 0;
        }
        else {
            this.price = price;
        }
    }

    public void increasePrice(float percent){
        if(percent >=0){
            this.price += (this.price * percent) / 100;
        }
    }
    public void decreasePrice(float percent){
        if(percent >=0){
            this.price -= (this.price * percent) / 100;
            if(this.price < 0){
                this.price = 0;
            }
        }
    }

    public float getPrice() {
        return price;
    }
}


//Task2
class Cart{
    private Item[] stack;
    private int maxSize;
    private int top;

    public Cart(int maxSize){
        this.maxSize = maxSize;
        this.stack = new Item[maxSize];
        this.top = -1;
    }

    public void addItem(Item item){
        if(top < maxSize -1){
            stack[++top] = item;
        }
        else {
            System.out.println("Curt is full.");
        }
    }

    public Item removeItem(){
        if (top >= 0) {
            return stack[top--];
        } else {
            System.out.println("Curt is empty.");
            return null;
        }
    }

    public float calculateTotalPrice(){
        float totalPrice = 0;
        for(int i=0; i <= top; i ++){
            totalPrice += stack[i].getPrice();
        }
        return totalPrice;
    }

    public void increasePrices(float percent){
        for(int i = 0; i <= top; i++){
            stack[i].increasePrice(percent);
        }
    }

    public void decreasePrices(float percent){
        for(int i = 0; i <= top; i++){
            stack[i].decreasePrice(percent);
        }
    }
}


//Task3
public class Main{
    public static void main(String[] args){
        Cart cart = new Cart(7);

        cart.addItem(new Item("Item 1", 20));
        cart.addItem(new Item("Item 2", 50));
        cart.addItem(new Item("Item 3", 100));
        cart.addItem(new Item("Item 4", 70));
        cart.addItem(new Item("Item 5", 300));

        System.out.println("Toal price item on cart: " + cart.calculateTotalPrice());

        cart.increasePrices(15);

        System.out.println("Total price after 15% price increase: " + cart.calculateTotalPrice());

        cart.decreasePrices(30);

        System.out.println("Sum of prices after 30% price reduction: " + cart.calculateTotalPrice());
    }
}


//Task4

//class Cart {
//    private LinkedList<Item> queue; // Використовуємо LinkedList для черги (кошика)
//    private int maxSize; // Максимальна кількість елементів у черзі
//
//    // Конструктор класу з параметром - максимальна кількість елементів у черзі
//    Cart(int maxSize) {
//        this.maxSize = maxSize;
//        this.queue = new LinkedList<>(); // Використовуємо LinkedList для черги
//    }
//
//    // Метод для додавання товару до черги (кошика)
//    void addItem(Item item) {
//        if (queue.size() < maxSize) {
//            queue.offer(item);
//        } else {
//            System.out.println("Кошик переповнений. Неможливо додати товар.");
//        }
//    }
//
//    // Метод для видалення товару з черги (кошика)
//    void removeItem() {
//        if (!queue.isEmpty()) {
//            queue.poll();
//        } else {
//            System.out.println("Кошик порожній. Неможливо видалити товар.");
//        }
//    }// Метод для підрахунку суми цін товарів у кошику
//    float calculateTotalPrice() {
//        float totalPrice = 0;
//        for (Item item : queue) {
//            totalPrice += item.getPrice();
//        }
//        return totalPrice;
//    }
//
//    // Метод для підвищення ціни всіх товарів у черзі на певний відсоток
//    void increasePrices(float percent) {
//        for (Item item : queue) {
//            item.increasePrice(percent);
//        }
//    }
//
//    // Метод для зниження ціни всіх товарів у черзі на певний відсоток
//    void decreasePrices(float percent) {
//        for (Item item : queue) {
//            item.decreasePrice(percent);
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // Створюємо об'єкт класу Кошик з максимальною кількістю елементів 10
//        Cart cart = new Cart(10);
//
//        // Заповнюємо кошик об'єктами класу Item
//        cart.addItem(new Item("Item 1", 20));
//        cart.addItem(new Item("Item 2", 50));
//        cart.addItem(new Item("Item 3", 100));
//        cart.addItem(new Item("Item 4", 70));
//        cart.addItem(new Item("Item 5", 300));
//
//        System.out.println("Toal price item on cart: " + cart.calculateTotalPrice());
//
//        cart.increasePrices(15);
//
//        System.out.println("Total price after 15% price increase: " + cart.calculateTotalPrice());
//
//        cart.decreasePrices(30);
//
//        System.out.println("Sum of prices after 30% price reduction: " + cart.calculateTotalPrice());
//    }
//}


