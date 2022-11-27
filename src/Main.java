import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите два числа через пробел:");
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        double sum = (double) firstNumber + secondNumber;
        double difference = (double) firstNumber - secondNumber;
        double multiplication = (double) firstNumber * secondNumber;
        double quotient = (double) firstNumber/secondNumber;
        System.out.println(sum);
        System.out.println(difference);
        System.out.println(multiplication);
        System.out.println(quotient);
    }
}
