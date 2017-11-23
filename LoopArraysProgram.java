public class LoopArraysProgram {

  public static void main(String[] args) {
    printMenu();
  }

  public static void printMenu() {
    System.out.println("0: Quit");
    System.out.println("1: find nth fibonacci number");
    System.out.println("2: find the maximum element of an array");
    System.out.println("3: generate a histogram from given data");
    System.out.print("Choice ->  ");

    int choice = IOUtil.readInt();
    assert (0 <= choice && choice <= 4) : "a number between 0 and 4 must be entered.";

    switch (choice) {
      case 0:
        break;
      case 1:
        printFib();
        break;
      case 2:
        printMax();
        break;
      case 3:
        histogram();
        break;
   /*   case 4:
        printMatMul();  <- did not get time to add this method
        break;
     */
      default:
        assert false : "unknown method";
        return;
    }
  }

  private static void printFib() {
    System.out.println("Please enter a number ->  ");
    int x = IOUtil.readInt();
    int fibonacci = LoopArraysLibrary.fib2(x);
    System.out.println("The " + x + "th fibonacci number is "
        + fibonacci);
  }

  private static void printMax() {

    System.out.println("enter number of elements");

    int n = IOUtil.readInt();
    int arr[] = new int[n];

    System.out.println("enter elements");

    for (int i = 0; i < n; i++) {//for reading array
      arr[i] = IOUtil.readInt();
    }

    System.out.println("The largest element in your array is: "
        + LoopArraysLibrary.maximum(arr));
  }

  private static void histogram() {

    System.out.println("Please enter the size of your data (n) set "
        + "followed by n numbers: ");
    int n = IOUtil.readInt();
    double arr[] = new double[n];
    for (int i = 0; i < n; i++) {//for reading array
      arr[i] = IOUtil.readDouble();
    }
    System.out.println("Please enter a minimum, maximum and number of buckets "
        + "to print a histogram with: ");
    double min = IOUtil.readDouble();
    double max = IOUtil.readDouble();
    int numBucks = IOUtil.readInt();

    int[] freq = LoopArraysLibrary.frequencyTable(min, max, numBucks, arr);

    int maxFreq = LoopArraysLibrary.maximum(freq);

    System.out.println("This data generates the following histogram: ");
    System.out.println();

    for (int j = 0; j < maxFreq; j++) {
      System.out.print(maxFreq - j + "|");
      for (int i = 0; i < numBucks; i++) {
        if (freq[i] >= maxFreq - j) {
          System.out.print("#");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    System.out.print(" +");
    for (int i = 0; i < numBucks; i++) {
      System.out.print("-");
    }
  }
}

