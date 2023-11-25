import java.util.Scanner;

public class Lab02 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    // Loop hingga exit
    boolean isRunning = true;
    while (isRunning) {
      System.out.println("Halo! Apa yang ingin kamu lakukan?");
      System.out.println("[1] Buat kupon");
      System.out.println("[2] Validasi kupon");
      System.out.println("[3] Keluar");
      System.out.print("Pilihan: ");
      int option = s.nextInt();
      // Process \n
      s.nextLine();

      switch (option) {
        case 1:
          // Buat kupon
          System.out.print("Nama kupon: ");
          String couponName = s.nextLine();
          String coupon = generateCoupon(couponName);
          System.out.println("Kode kupon adalah: " + coupon);
          break;

        case 2:
          // Validasi kupon
          System.out.print("Kupon: ");
          String couponId = s.nextLine();
          if (validateCoupon(couponId)) {
            System.out.println("Kupon yang diberikan valid");
          } else {
            System.out.println("Kupon yang diberikan tidak valid");
          }
          break;

        case 3:
        default:
          // Exist
          isRunning = false;
          break;
      }
      System.out.println();
    }
    s.close();
  }

  static int generateChecksum(String coupon) {
    // Stop jika sudah di akhir string
    if (coupon.isEmpty()) {
      return 0;
    }

    // Nilai karakter sebelumnya + offset di abjad
    int charValue = coupon.charAt(0) - 'A';
    // Hapus karakter sekarang dan lanjut ke selanjutnya
    return (charValue + generateChecksum(coupon.substring(1))) % 26;
  }

  static String generateCoupon(String couponName) {
    // Lakukan generation in-place
    couponName = couponName + (char) ('A' + generateChecksum(couponName));
    couponName = couponName + (char) ('A' + generateChecksum(couponName));
    return couponName;
  }

  static boolean validateCoupon(String coupon) {
    // Cukup regenerate dan cek apakah checksumnya sama atau tidak
    String couponName = coupon.substring(0, coupon.length() - 2);
    String newCoupon = generateCoupon(couponName);
    return newCoupon.equals(coupon);
  }
}