import java.util.Scanner;

public class Lab01 {
	public static void main(String[] args) throws Exception {
		// Pesan selamat datang
		System.out.println("Selamat datang di Toko Fotokopi Dek Depe!");
		System.out.println("--------------------------------------------------------");

		Scanner in = new Scanner(System.in);

		System.out.print("Masukkan jumlah mahasiswa yang ingin melakukan fotokopi: ");
		int jumlahMahasiswa = in.nextInt();
		in.nextLine();

		double totalPendapatan = 0;

		for (int i = 1; i <= jumlahMahasiswa; i++) {
			System.out.printf("--------------------DATA MAHASISWA %d--------------------\n", i);
			System.out.print("Nama: ");
			String nama = in.nextLine();
			System.out.print("IPK: ");
			double ipk = in.nextDouble();
			System.out.print("Jumlah lembar: ");
			int jumlahLembar = in.nextInt();
			in.nextLine();

			// Penentuan jumlah diskon
			double diskon;
			String persentaseDiskon;

			if (ipk <= 2.5) {
				diskon = 0.1;
				persentaseDiskon = "10%";
			} else if (ipk <= 3.0) {
				diskon = 0.25;
				persentaseDiskon = "25%";
			} else if (ipk <= 3.5) {
				diskon = 0.35;
				persentaseDiskon = "35%";
			} else {
				diskon = 0.5;
				persentaseDiskon = "50%";
			}

			int hargaFotokopiPerLembar = 555;
			double totalPembayaran = jumlahLembar * hargaFotokopiPerLembar;
			double totalPembayaranSetelahDiskon = totalPembayaran - totalPembayaran * diskon;

			System.out.printf("%s membayar seharga %.2f dengan diskon sebesar %s%n", nama, totalPembayaranSetelahDiskon,
					persentaseDiskon);

			totalPendapatan += totalPembayaranSetelahDiskon;
		}

		System.out.println("---------------------RINGKASAN DATA---------------------");
		System.out.printf("Hasil pendapatan yang diperoleh Toko fotokopi dari %d mahasiswa adalah %.2f",
				jumlahMahasiswa, totalPendapatan);

		in.close();
	}
}