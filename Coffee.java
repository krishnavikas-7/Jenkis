import java.util.Scanner;

class Coffee {
    private String name;
    private double price;

    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private Coffee selectedCoffee;
    private int quantity;

    public ShoppingCart(Coffee selectedCoffee, int quantity) {
        this.selectedCoffee = selectedCoffee;
        this.quantity = quantity;
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalCost() {
        return selectedCoffee.getPrice() * quantity;
    }
}

class OnlineCoffeeShop {
    public static void main(String[] args) {
        Coffee coffee1 = new Coffee("Latte", 3.50);
        Coffee coffee2 = new Coffee("Espresso", 2.50);
        Coffee coffee3 = new Coffee("Cappuccino", 4.00);

        System.out.println("Welcome to the Online Coffee Shop!");
        displayMenu();

        Scanner scanner = new Scanner(System.in);

        // Let the user choose a coffee
        System.out.print("Enter the number of the coffee you want to buy: ");
        int choice = scanner.nextInt();

        Coffee selectedCoffee;
        switch (choice) {
            case 1:
                selectedCoffee = coffee1;
                break;
            case 2:
                selectedCoffee = coffee2;
                break;
            case 3:
                selectedCoffee = coffee3;
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        // Get the quantity
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart(selectedCoffee, quantity);

        // Display the order summary
        System.out.println("\nOrder Summary:");
        System.out.println("Coffee: " + cart.getSelectedCoffee().getName());
        System.out.println("Quantity: " + cart.getQuantity());
        System.out.println("Total Cost: $" + cart.getTotalCost());

        // Handle payment (in a real application, this would involve payment gateways, etc.)
        System.out.print("\nEnter 1 to proceed with payment, 0 to cancel: ");
        int paymentChoice = scanner.nextInt();

        if (paymentChoice == 1) {
            System.out.println("Payment successful. Thank you for your purchase!");
        } else {
            System.out.println("Payment canceled. Order not processed.");
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Latte - $3.50");
        System.out.println("2. Espresso - $2.50");
        System.out.println("3. Cappuccino - $4.00");
    }
}
