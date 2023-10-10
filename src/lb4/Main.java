package lb4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String toString() {
            return name + " - $" + price;
        }
    }

    public static class DiscountedItem extends Item {
        private double discount;

        public DiscountedItem(String name, double price, double discount) {
            super(name, price);
            this.discount = discount;
        }

        public double getDiscount() {
            return discount;
        }

        public double getDiscountedPrice() {
            return getPrice() - (getPrice() * discount);
        }

        public String toString() {
            return super.getName() + " - $" + super.getPrice() + " (-$" + (super.getPrice() * discount) + ")";
        }
    }

    public static class Bill {
        private List<Item> items;
        private boolean isRegularCustomer;

        public Bill(boolean isRegularCustomer) {
            this.isRegularCustomer = isRegularCustomer;
            items = new ArrayList<>();
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public double getTotal() {
            double total = 0;
            for (Item item : items) {
                if (item instanceof DiscountedItem && isRegularCustomer) {
                    total += ((DiscountedItem) item).getDiscountedPrice();
                } else {
                    total += item.getPrice();
                }
            }
            return total;
        }

        public double getTotalDiscount() {
            double totalDiscount = 0;
            for (Item item : items) {
                if (item instanceof DiscountedItem && isRegularCustomer) {
                    totalDiscount += ((DiscountedItem) item).getDiscountedPrice() - item.getPrice(); // Calculate the discount for each discounted item
                } else {
                    totalDiscount += 0; // No discount for regular items
                }
            }
            return totalDiscount;
        }

        public void printBill() {
            System.out.println("Score:");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println("\nTotal: $" + getTotal());
            System.out.println("Total discount: $" + getTotalDiscount()+"\n");
        }
    }

    public static void main(String[] args) {
        DiscountedItem item1 = new DiscountedItem("Super potato", 4.9, 0.3);
        DiscountedItem item2 = new DiscountedItem("MEGA SUPER CUCUMBER", 3.3, 0.5);
        DiscountedItem item3 = new DiscountedItem("Mini apple", 2.0, 0.05);

        Bill regularCustomerBill = new Bill(true); // Постійний клієнт
        Bill normalCustomerBill = new Bill(false); // Звичайний клієнт

        regularCustomerBill.addItem(item1);
        regularCustomerBill.addItem(item2);
        regularCustomerBill.addItem(item3);

        normalCustomerBill.addItem(item1);
        normalCustomerBill.addItem(item2);
        normalCustomerBill.addItem(item3); // Додати товар item3 до звичайного клієнта

        regularCustomerBill.printBill();
        normalCustomerBill.printBill();
    }
}

