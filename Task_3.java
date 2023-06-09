import java.util.Scanner;
import java.io.IOException;

// Задание
// Реализовать простой калькулятор (+-/*)

public class Task_3 {
    public static void main(String[] args) {
        double result;
        boolean getOut = false;
        char opChar;
        System.out.println("-----------------------------------------------");
        Scanner sc = new Scanner(System.in);

        // System.out.println("-----------------------------------------------");

        while (getOut != true) {
            System.out.printf("Enter number: ");
            double numA = sc.nextDouble();

            System.out.printf("Enter arithmetic operation symbol (one of '+','-','*','/'): ");
            opChar = sc.next().charAt(0);

            System.out.printf("Enter second number: ");
            double numB = sc.nextDouble();
            System.out.println();

            switch (opChar) {
                case '+':
                    result = numA + numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, opChar, numB, result);
                    break;
                case '-':
                    result = numA - numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, opChar, numB, result);
                    break;
                case '*':
                    result = numA * numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, opChar, numB, result);
                    break;
                case '/':
                    result = numA / numB;
                    System.out.printf("%.2f %c %.2f = %.2f\n", numA, opChar, numB, result);
                    break;
                default:
                    getOut = true;
                    break;
            
            }
            System.out.println("-----------------------------------------------");
            System.out.printf("Once more? ('Y' or 'y'): ");
            opChar = sc.next().charAt(0);
            //if(opChar != 'y') getOut = true;
            if (opChar == 'y' || opChar == 'Y') {
                getOut = false;
            } else getOut = true;
        }
        System.out.println();
        sc.close();
        
    }
}
