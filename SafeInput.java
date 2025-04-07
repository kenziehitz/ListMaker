import java.util.Scanner;

public class SafeInput {
    private static Scanner scanner = new Scanner(System.in);
    public static String getRegExString(String prompt, String regex) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.matches(regex)) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }}
        return input;}
    public static int getRangedInt(String prompt, int low, int high) {
        int input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextInt();
            if (input >= low && input <= high) {
                break;
            } else {
                System.out.println("Please enter a number between " + low + " and " + high + ".");
            }}
        return input;}
    public static boolean getYNConfirm(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y") || input.equals("n")) {
                return input.equals("y");
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }}}}
