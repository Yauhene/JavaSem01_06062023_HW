import java.lang.Integer;
import java.util.Scanner;

// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
// Под знаком вопроса - всегда одинаковая ЦИФРА.
// Введите уравнение: ?? + ?? = 44
// Решение: 22 + 22 = 44

// Программа работает только со строками, содержащими знак сложения.
// Разрядность чисел в слагаемых произвольная и ограничена только возможностями типа Integer

public class Task_4 {
    public static void main(String[] args) {
        String taskStr = "";
        int numOne = 0;
        int numTwo = 0;
        int exprResult = 0;
        String strOne="";
        String strTwo="";
        String strOneVers ="";
        String strTwoVers ="";
        int myDigit = 0;

        System.out.println("=======================================================================");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an expression like this:  ?54 + 1?1 = 375");
        System.out.println("By default (pressing Enter) the expression will be equal to '?54 + 1?1 = 375'");
        System.out.println("Enter your expression or press Enter, please: ");
        taskStr = sc.nextLine();
        if (taskStr == "") {
            taskStr = "?54 + 1?1 = 375";
        }
        System.out.println(taskStr);
        // отсечь (выделить из строки) результат выражения------------------
        String expressionArr[] = taskStr.split("=");
        // очистить результат от пробелов------------------------------
        int size = expressionArr.length;
        try {
            exprResult = Integer.parseInt(expressionArr[(size - 1)].trim());
            expressionArr[(size - 1)] = expressionArr[(size - 1)].trim();
        } 
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        
        // получить массив строк-слагаемых-----------------------------------------
        String terms = expressionArr[0];
        int plusIndex = terms.indexOf("+");

        // получить первое слагаемое (строка)-----------------------------------------
        for (int i=0; i < terms.indexOf("+"); i++) {
            strOne = strOne + terms.charAt(i);
        }
        strOne = strOne.trim();
        // получить второе слагаемое (строка)-----------------------------------------
        for (int i=terms.indexOf("+")+1; i < terms.length()-1; i++) {
            strTwo = strTwo + terms.charAt(i);
        }
        strTwo = strTwo.trim();

        // "Лобовой" способ решения, тупая подстановка-----------------------------
        for(int i = 0; i < 10; i++ ) // подставляем цифры от 0 до 9 вместо занков "?"
        {
            for(int j = 0; j < strOne.length(); j++) {
                if (strOne.charAt(j) =='?') {
                    strOneVers = strOneVers + i;
                }
                else {
                    strOneVers = strOneVers + strOne.charAt(j);
                }
            }
            for(int j = 0; j < strTwo.length(); j++) {
                if (strTwo.charAt(j) =='?') {
                    strTwoVers = strTwoVers + i;
                }
                else {
                    strTwoVers = strTwoVers + strTwo.charAt(j);
                }
            }
            try {
                numOne = Integer.parseInt(strOneVers);
                numTwo = Integer.parseInt(strTwoVers);
            } 
            catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException " + nfe.getMessage());
            }
            
            if (numOne + numTwo == exprResult)
            {
                myDigit = i;
                break;
            }
            strOneVers = "";
            strTwoVers = "";
        }
        System.out.println("BINGO !!!");
        System.out.println("The desired digit is " + myDigit);
        System.out.printf("%s + %s = %s\n",strOneVers, strTwoVers, exprResult);
        System.out.println("=======================================================================");
    }

}
