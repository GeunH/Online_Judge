import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.nextLine();
        int number = scanner.nextInt();

        System.out.print(input.charAt(number-1));

        scanner.close();
    }
}
