// Restu Ahmad Ar Ridho
// 2206028951
// Lab01

import java.util.Scanner; //import library yang dibutuhkan

public class Lab01 {
	public static void main(String[] args) {
		// inisiasi objek untuk meminta input melalui terminal
		Scanner input = new Scanner(System.in);
		double hasilPendapatan = 0; // inisiasi variable untuk total

		System.out.println("Selamat datang di Toko Fotokopi Dek Depe!");
		System.out.println("--------------------------------------------------------");

		System.out.print("Masukkan jumlah mahasiswa yang ingin melakukan fotokopi: ");
		int jumlahMahasiswa = input.nextInt(); // meminta input dari user

		for (int i = 0; i < jumlahMahasiswa; i++) {
			input.nextLine(); // membuat input dummy agar input selanjutnya dapat terbaca
			System.out.printf("--------------------DATA MAHASISWA %d--------------------", (i + 1));

			// meminta input dari user untuk nama, ipk, dan jumlah lembar
			System.out.print("\nNama: ");
			String namaMahasiswa = input.nextLine();
			System.out.print("IPK: ");
			double nilaiIPK = input.nextDouble();
			System.out.print("Jumlah lembar: ");
			int jumlahLembar = input.nextInt();

			// iniasi variable
			double hargaFotokopi = jumlahLembar * 555;
			double hargaTotal;
			int diskon = 0;
			// membagi kasus berdasarkan nilaiIPK agar setiap diskon berbeda
			if (nilaiIPK >= 0 && nilaiIPK <= 2.5) {
				diskon = 10;
			} else if (nilaiIPK > 2.5 && nilaiIPK <= 3) {
				diskon = 25;
			} else if (nilaiIPK > 3 && nilaiIPK <= 3.5) {
				diskon = 35;
			} else if (nilaiIPK > 3.5 && nilaiIPK <= 4) {
				diskon = 50;
			}
			// menghitung dan menambahkan hargaTotal kedalam variable hasilPendapatan
			hargaTotal = hargaFotokopi * (100 - diskon) / 100;
			hasilPendapatan += hargaTotal;
			System.out.printf("%s membayar seharga Rp%.2f dengan diskon sebesar %d%%\n",
					namaMahasiswa,
					hargaTotal,
					diskon); // menampilkan hasil ke terminal
		}
		System.out.println("\n---------------------RINGKASAN DATA---------------------");
		System.out.printf("Hasil pendapatan yang diperoleh Toko Fotokopi dari %d mahasiswa adalah Rp%.2f",
				jumlahMahasiswa,
				hasilPendapatan); // menampilkan ringkasan ke dalam terminal
		input.close(); // menutup object Scanner
	}
}
