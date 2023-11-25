// Restu Ahmad Ar Ridho
// 2206028951

public class MiniQuiz3 {
  public static void main(String[] args) {
    int[] myInts = { 4, 3, 4, 5, 5, 9, 3, 7, 2, 3 }; // contoh array
    hitungKemunculan(myInts);
  }

  public static void hitungKemunculan(int[] arr) {
    // implements here ...

    for (int i = 1; i < 10; i++) {
      int count = 0;
      for (int j = 0; j < arr.length; j++) {
        if (i == arr[j]) {
          count += 1;
        }
      }
      if (count != 0) {
        System.out.printf("Bilangan %d muncul sebanyak %d kali\n", i, count);
      }
    }

  }
}
