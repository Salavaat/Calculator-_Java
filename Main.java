import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¬ведите математическое выражение");
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }

    public static String calc(String input) throws Exception {
        String[] sign = input.split(" ");
        int result = 0;

        String num1 = sign[0];
        String num2 = sign[2];
        String oper = sign[1];

        if (sign.length >= 4)
            throw new Exception("‘ормат математической операции не удовлетвор€ет заданию - два операнда и один оператор (+, -, /, *)");

        if (isRoman(num1, num2)) {
            num1 = convertRomanToArabic(sign[0]);
            num2 = convertRomanToArabic(sign[2]);
            result = calculation(num1, num2, oper);
            if (result<=0) {
                throw new Exception("–езультатом работы калькул€тора с римскими числами могут быть только положительные числа");
            }
            return convertArabicToRoman(result);
        } else {
            checkBounds(sign,num1,num2);
            result = calculation(num1, num2, oper);
            return Integer.toString(result);
        }
    }


    private static String convertRomanToArabic(String num) {
        switch (num) {
            case "I":
                return "1";
            case "II":
                return "2";
            case "III":
                return "3";
            case "IV":
                return "4";
            case "V":
                return "5";
            case "VI":
                return "6";
            case "VII":
                return "7";
            case "VIII":
                return "8";
            case "IX":
                return "9";
            case "X":
                return "10";
        }
        return num;
    }

    private static int calculation(String num1, String num2, String oper) throws Exception {
        int result = 0;
        switch (oper) {
            case "+":
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                break;
            case "-":
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                break;
            case "/":
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                break;
            case "*":
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                break;
            default:
                throw new Exception(" алькул€тор умеет выполн€ть только операции сложени€, вычитани€, умножени€ и делени€");
        }
        return result;
    }

    private static String convertArabicToRoman(int result) {
        int[] romanInt = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanChar = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String romanResult = "";
        for (int i = 0; i < romanInt.length; i++) {
            while (result >= romanInt[i]) {
                result -= romanInt[i];
                romanResult += romanChar[i];
            }
        }
        return romanResult;
    }

    private static boolean isRoman(String num1, String num2) throws Exception {
        String[] romanChar = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int count = 0;
        for (int i = 0; i < romanChar.length; i++) {
            if (romanChar[i].equals(num1))
                count++;
            if (romanChar[i].equals(num2))
                count++;
        }
            return count==2;
    }

    private static void checkBounds(String[] array, String num1, String num2) throws Exception {
        if ((Integer.parseInt(num1) >= 11) || ((Integer.parseInt(num1) <= 0)))
            throw new Exception(" алькул€тор должен принимать на вход числа от 1 до 10 включительно, не более");

        if ((Integer.parseInt(num2) >= 11) || ((Integer.parseInt(num2) <= 0)))
            throw new Exception(" алькул€тор должен принимать на вход числа от 1 до 10 включительно, не более");
    }

}



