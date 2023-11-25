// Restu Ahmad Ar Ridho
// 2206028951
// Lab02

import java.util.Scanner; // import library yang dibutuhkan

public class Lab02 {
	// inisiasi objek scanner untuk meminta input
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int pilihan; // iniasi variable untuk memilih mode
		while (true) {
			showMenu(); // memanggil method showMenu
			System.out.print("Pilihan: ");
			pilihan = input.nextInt(); // meminta input dari user untuk pilihan mode
			input.nextLine(); // dummy input

			// membagi kasus untuk setiap mode
			if (pilihan == 1) { // Buat kupon
				// meminta input untuk nama kupon
				System.out.print("Nama kupon: ");
				String namaKupon = input.nextLine();
				// memanggil method buatkupon untuk menghasilkan string kupon
				String kupon = buatKupon(namaKupon);
				System.out.printf("Kode kupon adalah: %s\n", kupon);

			} else if (pilihan == 2) { // Validasi kupon
				// meminta input untuk kupon
				System.out.print("Kupon: ");
				String kupon = input.nextLine();
				// mengambil string nama kupon yaitu string kupon dari index 0 sampai 2 belakang
				String namaKupon = kupon.substring(0, kupon.length() - 2);
				// membagi kasus jika kupon yang diberikan valid
				if (kupon.equals(buatKupon(namaKupon))) {
					System.out.println("Kupon yang diberikan valid");
				} else {
					System.out.println("Kupon yang diberikan tidak valid");
				}
			} else if (pilihan == 3) { // Keluar
				break;
			} else {
				System.out.println("Pilihan tidak tersedia");
			}
		}

	}

	/**
	 * Method untuk menampilkan Menu
	 */
	private static void showMenu() {
		System.out.println("\nHalo! Apa yang ingin kamu lakukan?");
		System.out.println("[1] Buat kupon\n[2] Validasi kupon\n[3] Keluar");
	}

	/**
	 * Method untuk menghitung jumlah kedudukan setiap huruf
	 * 
	 * @param str Input berupa String
	 * @return Mengembalikan kedudukan suatu huruf dengan tipe data integer
	 */
	private static int buatIndexHurufKupon(String str) {
		// iniasi variable
		String namaKupon = str; // String sekarang
		int indexHuruf; // Kedudukan huruf dalam integer

		// base case jika panjang string yang ingin dihitung jumlah setiap hurufnya
		// kosong / tidak ada huruf lagi
		if (namaKupon.length() == 0) {
			return 0;
		} else {
			indexHuruf = namaKupon.charAt(namaKupon.length() - 1) - 'A'; // menghitung kedudukan huruf
		}
		// mengembalikan rekursif dari jumlah kedudukan setiap huruf dan modulo agar
		// kedudukan hanya dari A-Z
		return (indexHuruf % 26 + buatIndexHurufKupon(namaKupon.substring(0, namaKupon.length() - 1)) % 26) % 26;
	}

	/**
	 * Method untuk mengubah index huruf menjadi string utuh
	 * 
	 * @param str Input berupa String
	 * @return Mengembalikan String utuh hasil dari penambahan dengan index huruf 2x
	 */
	private static String buatKupon(String str) {
		// melakukan iterasi untuk membuat char dibelakang nama kupon sebanyak 2x
		for (int i = 0; i < 2; i++) {
			// mengubah index huruf menjadi char dan menggabungkan dengan String awal
			str += (char) (buatIndexHurufKupon(str) + 'A');
		}
		return str;
	}
}
