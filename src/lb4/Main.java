package lb4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Item{
        private String name;
        private double price;
        private double discount;

        public Item(String name, double price, double discount){
            this.name = name;
            this.price = price;
            this.discount = discount;
        }

        public String getName(){
            return name;
        }
        public double getPrice(){
            return price;
        }
        public double getDiscount(){
            return discount;
        }
        public double getDiscountedPrice(){
            return price -(discount * price);
        }

        public String toString() {
            return name + " - $" + getPrice() + " (-$" + (getPrice() * getDiscount()) + ")";
        }
    }

    public static class Bill{
        private List<Item> items;
        private boolean isRegularCustomer;

        public Bill(boolean isRegularCustomer){
            this.isRegularCustomer = isRegularCustomer;
            items = new ArrayList<>();
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public double getTotal(){
            double total = 0;
            for (Item item : items) {
                if (!isRegularCustomer) {
                    total += item.getPrice(); // Для звичайних клієнтів без знижки
                } else {
                    total += item.getDiscountedPrice(); // Для постійних клієнтів зі знижкою
                }
            }
            return total;
        }

        public void printBill() {
            System.out.println("Score:\n");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println("\nTotal: $" + getTotal());
            if (isRegularCustomer) {
                double totalDiscount = 0;
                for (Item item : items) {
                    totalDiscount += item.getPrice() * item.getDiscount();
                }
                System.out.println("Total discount: $" + totalDiscount + "\n");
            }
        }
    }
    public static void main(String[]args){
        Item item1 = new Item("Super potato", 4.9, 0.3);
        Item item2 = new Item("MEGA SUPER CUCUMBER", 3.3, 0.5);
        Item item3 = new Item("Mini apple", 2.0, 0.05);

        Bill regularCustomerBill = new Bill(true);
        Bill normalCustomerBill = new Bill(false);

        regularCustomerBill.addItem(item1);
        regularCustomerBill.addItem(item2);
        regularCustomerBill.addItem(item3);

        normalCustomerBill.addItem(item1);
        normalCustomerBill.addItem(item2);
        normalCustomerBill.addItem(item3);

        regularCustomerBill.printBill();
        normalCustomerBill.printBill();
    }
}


