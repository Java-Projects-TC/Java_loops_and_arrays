public class LoopArraysLibrary {

  // This method of the fib function returns the nth
  // fibonacci number using a for loop.
  public static int fib(int n) {
    assert
        n >= 0 : "you must have a positive input (cant have -nth fib number)s";
    if (n == 0) {
      return 0;
    }
    int n1 = 0, n2 = 1, i, fib;
    for (i = 1; i < n; i++) {
      fib = n1 + n2;
      n1 = n2;
      n2 = fib;
    }
    return n2;
  }

  // I also created a fib method using a while loop, just for practise :)
  public static int fib2(int n) {
    assert
        n >= 0 : "you must have a positive input (cant have -nth fib number)";
    int n1 = 0, n2 = 1, fib;
    if (n == 0) {
      return 0;
    }
    while (n > 1) {
      fib = n1 + n2;
      n1 = n2;
      n2 = fib;
      n--;
    }
    return n2;
  }

  // Could've also implemented the line after the for statement as an
  // if statement e.g. (if (max < ms[i]) max = ms[i]
  public static int maximum(int[] ms) {
    int max = ms[0];
    for (int m : ms) {
      max = Math.max(max, m);
    }
    return max;
  }

  // This method generates an array with the respective frequencies of the
  // inputted data at regular intervals between the max and min values
  public static int[] frequencyTable(double minimum, double maximum,
      int numBuckets, double[] data) {

    int[] freq = new int[numBuckets];
    for (int i = 0; i < numBuckets; i++) {
      freq[i] = 0;
    }
    double intervals = (maximum - minimum) / (double) numBuckets;

    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < numBuckets; j++) {
        if (minimum + j * intervals <= data[i]
            && data[i] < minimum + intervals * (j + 1)) {
          freq[j] += 1;
          break;
        }
      }
    }
    return freq;
  }

  // This uses a triple nested for loop to calculate the product of two matrices
  public static double[][] matrixMultiply(double[][] m, double[][] n) {
    // The column indexing here assumes the user has input a matrix with
    // the same number of elements in each row (matrix is rectangular).
    int rowM = m.length;  //colM = m[0].length;
    int rowN = n.length, colN = n[0].length;

    double[][] result = new double[rowM][colN];

    for (int i = 0; i < rowM; i++) {
      assert m[i].length == rowN : "Matrix multiplication is undefined!";
      for (int j = 0; j < rowN; j++) {
        for (int k = 0; k < n[j].length; k++) {
          result[i][k] += m[i][j] * n[j][k];
        }
      }
    }
    return result;
  }
}

