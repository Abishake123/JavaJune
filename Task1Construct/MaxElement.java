package Task1Construct;

public class MaxElement {

    public static void findMaxElemnet() {

        int numb[] = { 1, 4, 67, 34, 45 };
        int hist = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println(numb[i]);

            if (hist < numb[i]) {
                hist = numb[i];
                
            }

        }
        System.out.println("Max Element is " + hist);

    }
}
