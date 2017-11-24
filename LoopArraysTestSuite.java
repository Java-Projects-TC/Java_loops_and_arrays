import java.util.Arrays;

public class LoopArraysTestSuite {

  public static void main(String[] args) {
    System.out.println("Running tests...");

    fibTests();
    maximumTests();
    frequencyTableTests();
    matrixMultiplyTests();

    System.out.println("...tests complete.");
  }

  public static void fibTests() {
    testFib(5, 5);
    testFib(0, 0);
    testFib(1, 1);
    testFib(2, 1);
    testFib(20, 6765);
  }

  public static void maximumTests() {
    testMaximum(new int[]{1, 3, 2}, 3);
    testMaximum(new int[]{0, 0, 0}, 0);
    testMaximum(new int[]{500, -500, -1000}, 500);
    testMaximum(new int[]{-1, -1, -1}, -1);

  }

  public static void frequencyTableTests() {
    testFrequencyTable(-1.5, 1.5, 6
        , new double[]{-1.1, 1.1, 1.2, -0.8, 1.6}
        , new int[]{1, 1, 0, 0, 0, 2});
    testFrequencyTable(-8, 8, 8
        , new double[]{-5, -5, 9, 0, -8, 2, 0, 10}
        , new int[]{1, 2, 0, 0, 2, 1, 0, 0});
    testFrequencyTable(15, 29, 3
        , new double[]{22, 20, 18, 23, 20, 25, 22, 20, 18, 20}
        , new int[]{2, 7, 1});
  }

  public static void matrixMultiplyTests() {

    testMatrixMultiply(new double[][]{{1, 2, 3, 4}
            , {5, 6, 7, 8}
            , {9, 1, 2, 3}
        }
        , new double[][]{{1, 2, 3}
            , {4, 5, 6}
            , {7, 8, 9}
            , {1, 2, 3}
        }
        , new double[][]{{34, 44, 54}
            , {86, 112, 138}
            , {30, 45, 60}});
    testMatrixMultiply(new double[][]{{4, 5, 6, 0}
            , {3, 7, 1, 8}
            , {2, 9, 10, 11}
            , {-1, 12, 13, -3}
        }
        , new double[][]{{4, 5}
            , {3, 7}
            , {2, -2}
            , {9, -1}
        }
        , new double[][]{{43, 43}
            , {107, 54}
            , {154, 42}
            , {31, 56}});
    testMatrixMultiply(new double[][]{{1, 0, 0}
            , {0, 1, 0}
            , {0, 0, 1}
        }
        , new double[][]{{-4, 7, -2}
            , {0, 4, 2}
            , {-3, 3, 5}
        }
        , new double[][]{{-4, 7, -2}
            , {0, 4, 2}
            , {-3, 3, 5}});
  }

  private static final double EPSILON = 0.001;

  private static boolean approxEqualDouble(double a, double b) {
    return a == b
        || Math.abs(a - b) / Math.max(Math.abs(a), Math.abs(b)) < EPSILON;
  }

  private static boolean approxEqualDoubleArrays(double[][] x, double[][] y) {
    if (x.length != y.length) {
      return false;
    }
    for (int i = 0; i < x.length; i++) {
      if (x[i].length != y[i].length) {
        return false;
      }
      for (int j = 0; j < x[i].length; j++) {
        if (!approxEqualDouble(x[i][j], y[i][j])) {
          return false;
        }
      }
    }
    return true;
  }

  private static void testFib(int n, int expected) {
    int actual = LoopArraysLibrary.fib(n);
    if (expected != actual) {
      System.out.println("fib(" + n + "); expected: " + expected
          + " got: " + actual);
    }
  }

  private static void testMaximum(int[] vs, int expected) {
    int actual = LoopArraysLibrary.maximum(vs);
    if (expected != actual) {
      System.out.println("maximum(" + Arrays.toString(vs)
          + "); expected: " + expected + " got: " + actual);
    }
  }

  private static void testFrequencyTable(double minimum, double maximum,
      int numBuckets, double[] data, int[] expected) {
    int[] actual = LoopArraysLibrary.frequencyTable(minimum, maximum,
        numBuckets, data);

    if (!Arrays.equals(expected, actual)) {
      System.out.println("frequencyTable(" + minimum + ", " + maximum
          + ", " + numBuckets + ", " + Arrays.toString(data)
          + "); expected: " + Arrays.toString(expected) + " got: "
          + Arrays.toString(actual));
    }
  }

  private static void testMatrixMultiply(double[][] m, double[][] n,
      double[][] expected) {
    double[][] actual = LoopArraysLibrary.matrixMultiply(m, n);

    if (!approxEqualDoubleArrays(expected, actual)) {
      System.out.println("matrixMultiply(" + Arrays.deepToString(m)
          + ", " + Arrays.deepToString(n) + "); expected: "
          + Arrays.deepToString(expected) + ", got: "
          + Arrays.deepToString(actual));
    }
  }
}
