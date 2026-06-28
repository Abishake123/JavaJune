package Amstrong;

public class Task {

    public static int input = 9474; // 153, 9474, 123

    public static void isAmstrong() {

        double result = 0;

        // int reminder = input%10; // 3
        // input = input/10; // 15

        int power = String.valueOf(input).length();

        for (int i = 0; i < power; i++) {
            int reminder = input % 10;
            input = input / 10;
            result += Math.pow(reminder, power);
            // result = result + (Math.pow(reminder, 3));
            System.out.println(result);
        }

    }

}
