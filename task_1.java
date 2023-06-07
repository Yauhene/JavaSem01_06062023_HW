import java.util.Scanner;

// Задание

// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)


public class Task_1 {
    static int fact (int n) {
        if (n == 1) return 1;
        else return n * fact(n-1);
    }
    static int triNum (int n) {
        if (n == 1) return 1;
        else return n + triNum(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.printf("Enter integer number: ");
        int num = sc.nextInt();
        sc.close();
        System.out.println("number = " + num);
        System.out.println();
        System.out.println("factorial of " + num + " is " + fact(num));
        System.out.println("triangle number of " + num + " is " + triNum(num));
        System.out.println();
        
    }
}