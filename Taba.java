import java.util.ArrayList;
import java.util.Random;

/*
 * @author Hamilton1
 */
public class Taba {
    static ArrayList<Integer>[] drawers = new ArrayList[10];

    public static ArrayList[] generateData() {
        Random randomObject = new Random();
        for (int iCount = 0; iCount < 10; iCount++) {
            // Generates 10000 random integer numbers between -10,000 and 10,000
            int[] iMyIntegerNumbers = randomObject.ints(10000, -10000, 10000).toArray();
            drawers[iCount] = new ArrayList<>();
            for (int jCount = 0; jCount < iMyIntegerNumbers.length; jCount++) {
                drawers[iCount].add(iMyIntegerNumbers[jCount]);
            }
        }
        return drawers;
    }
}
