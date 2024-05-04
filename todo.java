import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> items;

    public ToDoList() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
        System.out.println("Item added to the to-do list: " + item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            String removedItem = items.remove(index);
            System.out.println("Item removed from the to-do list: " + removedItem);
        } else {
            System.out.println("Invalid index. Item not removed.");
        }
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("To-do list is empty.");
        } else {
            System.out.println("Items in the to-do list:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("\nTo-Do List Options:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter item to add: ");
                    String newItem = scanner.nextLine();
                    toDoList.addItem(newItem);
                    break;
                case 2:
                    System.out.print("Enter index of item to remove: ");
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    toDoList.removeItem(indexToRemove - 1); // Adjust index for ArrayList
                    break;
                case 3:
                    toDoList.viewItems();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
