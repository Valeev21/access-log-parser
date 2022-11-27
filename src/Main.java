import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите два числа через пробел:");
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;
        int multiplication = firstNumber * secondNumber;
        double quotient = (double) firstNumber/secondNumber;
        System.out.println("Сумма двух чисел: "+ sum);
        System.out.println("Разность двух чисел: "+ difference);
        System.out.println("Произведение двух чисел: "+ multiplication);
        System.out.println("Частное5 двух чисел: "+ quotient);
    }
}
