import java.util.ArrayList;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = SafeInput.getRegExString("Enter letter of choice: ", "[AaDdIiPpQq]");
            switch (choice) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quitProgram();
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add line to list");
        System.out.println("D - Delete line from list");
        System.out.println("I - Insert line into list");
        System.out.println("P - Print list");
        System.out.println("Q - Quit program");
    }

    private static void addItem() {
        String line = SafeInput.getRegExString("Enter line youd like to add: ", ".+");
        list.add(line);
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("There are no items able to delete.");
            return;
        }

        printList();
        int lineNumber = SafeInput.getRangedInt("Enter line number to delete from list: ", 1, list.size());
        list.remove(lineNumber - 1);
    }

    private static void insertItem() {
        printList();
        int position = SafeInput.getRangedInt("Enter a position to insert the line: ", 1, list.size() + 1);
        String line = SafeInput.getRegExString("Enter line to insert: ", ".+");
        list.add(position - 1, line);
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("Your list has nothing on it.");
        } else {
            System.out.println("List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private static void quitProgram() {
        boolean confirm = SafeInput.getYNConfirm("Would you like to stop? (y/n): ");
        if (confirm) {
            System.out.println("Goodbye!");
        }
    }
}
