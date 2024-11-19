package LessonT5;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
    double num1=getNumber();
    double num2=getNumber();
    char operation = getOperation();
    double result = calc(num1,num2,operation);
        System.out.println("Результат: "+result);

    }

    public static double getNumber(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число: ");
        if (input.hasNextDouble()){
            return input.nextDouble();
        } else {
            System.out.println("Ошибка при вводе. Повторите ввод.");
            return getNumber();
        }

    }

    public static char getOperation(){
        Scanner input = new Scanner(System.in);
        System.out.print("1 - сумма\n2 - разность\n3 - произведение\n4 - частное\nВыберите номер операции: ");
        int operationNumber;
        if (input.hasNextInt()) {
            operationNumber = input.nextInt();
        } else {
            System.out.println("Вы ввели не число... Повторите...");
            return getOperation();

        }
        switch (operationNumber){
            case 1:
                return '+';
            case 2:
                return '-';
            case 3:
                return '*';
            case 4:
                return '/';
            default:
                System.out.println("Не правильная операция. Повторите ввод.");
                return getOperation();
        }


    }

    public static double calc(double n1, double n2, char o) {
        switch (o){
            case '+':
                return add(n1,n2);
            case '-':
                return minus(n1,n2);
            case '*':
                return umn(n1,n2);
            case '/':
                return delenie(n1,n2);

            default:
                return Double.NaN;
        }
    }

    public static double add(double n1, double n2){
        return n1+n2;
    }
    public static double minus(double n1, double n2){
        return n1-n2;
    }
    public static double umn(double n1, double n2){
        return n1*n2;
    }
    public static double delenie(double n1, double n2){
        if (n2!=0) return n1/n2; else {
            System.out.println("На 0 делить нельзя...");
            return Double.NaN;
        }
    }



}
