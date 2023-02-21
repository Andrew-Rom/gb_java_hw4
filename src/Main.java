import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        HW4 Task 1
        Реализовать консольное приложение, которое:
        1. принимает от пользователя строку вида text~num;
        2. нужно рассплитить строку по ~, сохранить text в связный список на позицию num;
        3. если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
         */

        System.out.println("Java HW4. Task 1 - Get value from console and back selected value");

        Scanner in = new Scanner(System.in);
        System.out.println("""
                Enter value and its key (integer number) (e.g. text~4).
                Enter "print" and key (integer number) for output value (e.g. print~4).
                Enter "exit" for stop program.""");

        LinkedList<String> valueList = new LinkedList<>();
        while (true) {
            System.out.print("> ");
            String readLine = in.nextLine();
            if (isCorrectInput(readLine)) {
                String[] dataArray = readLine.split("~");
                if (dataArray[0].equals("print") && valueList.contains(dataArray[1])) {
                    String value = getValue(valueList, dataArray[1]);
                    System.out.println(value);
                    valueList.remove(value);
                    valueList.remove(dataArray[1]);
                } else if (dataArray[0].equals("print") && !(valueList.contains(dataArray[1]))) {
                    System.out.println("\"\"");
                } else if (!(dataArray[0].equals("print")) && valueList.contains(dataArray[1])) {
                    System.out.println("You have already used this key. Try again with another key");
                } else {
                    valueList.add(dataArray[0]);
                    valueList.add(dataArray[1]);
                }
            } else if (readLine.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Incorrect input");
            }
        }
    }

    private static boolean isCorrectInput(String str) {
        if (str.contains("~")) {
            String[] strArr = str.split("~");
            return isDigit(strArr[1]);
        } else {
            return false;
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String getValue(LinkedList<String> lst, String key) {
        String value = "";
        for (int i = 1; i < lst.size(); i += 2) {
            if (lst.get(i).equals(key)) {
                value = lst.get(i - 1);
                break;
            }
        }
        return value;
    }
}