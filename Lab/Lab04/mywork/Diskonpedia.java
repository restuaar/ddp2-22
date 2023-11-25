/*
 * Nama = Restu Ahmad Ar Ridho
 * NPM = 2206028951
 * Lab04
 */

// import library yang diperlukan
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Diskonpedia {

	// Inisiasi awal properti class Diskonpedia
	private static InputReader in = new InputReader(System.in);
	private static PrintWriter out = new PrintWriter(System.out);
	private static ArrayList<Barang> listBarang = new ArrayList<>();
	private static ArrayList<Pembeli> listPembeli = new ArrayList<>();

	/*
	 * Method utama program
	 */
	public static void main(String[] args) {

		// Inisiasi Barang
		int jumlahBarang = in.nextInt();

		// Meminta input barang sesuai dengan banyak barang
		for (int i = 0; i < jumlahBarang; i++) {
			String namaBarang = in.next();
			long harga = in.nextLong();
			int stok = in.nextInt();

			listBarang.add(new Barang(harga, namaBarang, stok));
		}

		// Inisiasi Pembeli
		int jumlahPembeli = in.nextInt();

		// Meminta input pembeli sesuai dengan banyak barang
		for (int i = 0; i < jumlahPembeli; i++) {
			String namaPembeli = in.next();
			long jumlahUang = in.nextLong();

			listPembeli.add(new Pembeli(namaPembeli, jumlahUang));
		}

		// Jalanin Query
		int jumlahPerintah = in.nextInt();

		// Meminta input perintah sesuai dengan banyak perintah
		for (int i = 0; i < jumlahPerintah; i++) {
			String perintah = in.next();
			// Membagi kasus sesuai dengan input
			switch (perintah) {
				case "PESAN" -> { // Ketika input "PESAN"
					// Meminta input user
					String namaPembeli = in.next();
					String namaBarang = in.next();
					int jumlah = in.nextInt();
					// Mencetak hasil dari method pesan
					out.println(pesan(namaPembeli, namaBarang, jumlah));
					break;
				}
				case "BAYAR" -> { // Ketika input "BAYAR"
					// Meminta input user
					String namaPembeli = in.next();
					bayar(namaPembeli); // Method handle bayar
					break;
				}
				case "DISKON" -> { // Ketika input "DISKON"
					// Meminta input user
					String namaPembeli = in.next();
					diskon(namaPembeli); // Method handle diskon
					break;
				}
				case "RESTOCK" -> { // Ketika input "RESTOCK"
					// Meminta input user
					String namaBarang = in.next();
					int jumlah = in.nextInt();
					restock(namaBarang, jumlah); // Method handle bayar
					break;
				}
				default -> { // Ketika input tidak sesuai"
					out.println("Perintah tidak sesuai!");
					break;
				}
			}
		}
		out.close();
	}

	/**
	 * Method untuk perintah PESAN
	 * 
	 * @param namaPembeli
	 * @param namaBarang
	 * @param jumlah
	 * @return Pesan yang dihasilkan dari method PESAN
	 */
	public static String pesan(String namaPembeli, String namaBarang, int jumlah) {

		// Mencari pembeli dan barang dalam list dan men-assign
		Pembeli pembeli = cariPembeli(namaPembeli);
		Barang barang = cariBarang(namaBarang);

		// Mendapatkan sisa uang dari pembeli
		long uangSisaPembeli = pembeli.sisaUang();

		// Membagi kasus pada case pesan
		if (barang.getStok() < jumlah) { // Ketika stok barang tidak cukup
			return String.format("Tidak bisa memesan %s sebanyak %d buah. Stok barang tidak cukup",
					namaBarang, jumlah);
		} else if ((pembeli.getJumlahBarang() + jumlah) > pembeli.getMaksJumlahBarang()) { // Ketika melebihi kapasitas
																																												// pembeli
			return String.format("Tidak bisa memesan %s sebanyak %d buah. List pesanan %s melebihi kapasitas.",
					namaBarang, jumlah, namaPembeli);
		} else if (uangSisaPembeli < barang.getHarga() * jumlah) { // Ketika uang pembeli tidak cukup
			return String.format("Tidak bisa memesan %s sebanyak %d buah. Uang %s tidak cukup",
					namaBarang, jumlah, namaPembeli);
		} else { // Ketika berhasil untuk memesan
			return pembeli.tambahPesanan(barang, jumlah);
		}
	}

	/**
	 * Method untuk perintah BAYAR
	 * 
	 * @param namaPembeli
	 */
	public static void bayar(String namaPembeli) {

		// Mencari pembeli dalam list dan men-assign
		Pembeli pembeli = cariPembeli(namaPembeli);

		// Mencetak hasil pembayaran
		out.printf("%s berhasil melakukan pembelian barang dan pembayaran!\n", pembeli.getNama());
		out.println("########## Detail Pembayaran ##########");
		// Mendapatkan list pesanan dari pembeli yang sesuai
		ArrayList<Pesanan> banyakPesanan = pembeli.getPesanan();
		long totalHarga = 0; // Inisiasi variabel awal untuk total harga
		// Melakukan iterasi pada setiap pesanan yang dipesan pembeli
		for (Pesanan pesanan : banyakPesanan) {
			// Mendapatkan barang pada pesanan
			Barang barang = pesanan.getBarang();
			// Mencetak dan me-assign total harga setiap barang menjadi total harga
			// keseluruhan
			long totalHargaBarang = pesanan.totalHarga();
			totalHarga += totalHargaBarang;
			out.printf("%s: %d * %d = %d\n", barang.getNama(), barang.getHarga(), pesanan.getJumlahBarang(),
					totalHargaBarang);
		}
		out.println("_______________________________________");
		out.printf("Total harga = %d\n", totalHarga);

		// Menghitung diskon yang didapat pembeli
		long totalDiskon = hitungDiskon(pembeli);
		out.printf("Diskon = (%d)\n", totalDiskon);

		// Menghitung pembayaran dan sisa uang pembeli
		long hargaBayar = totalHarga - totalDiskon;
		out.printf("Harga bayar = %d\n", hargaBayar);
		long sisaUang = pembeli.getJumlahUang() - hargaBayar;
		out.printf("Sisa uang = %d\n", sisaUang);

		out.println("#######################################");
		pembeli.resetPesanan(); // Menghapus semua pesanan pembeli
		pembeli.setJumlahUang(sisaUang); // Mengurangi uang pembeli menjadi sisa uang
	}

	/**
	 * Method untuk perintah RESTOCK
	 * 
	 * @param namaBarang
	 * @param jumlah
	 */
	public static void restock(String namaBarang, int jumlah) {

		// Mencari barang dalam list dan men-assign
		Barang barang = cariBarang(namaBarang);

		// Membagi kasus ketika input user tidak valid
		if (jumlah > 0) {
			// Menambahkan stok barang
			int stokSekarang = barang.getStok();
			barang.setStok(stokSekarang + jumlah);
			out.printf("Berhasil menambahkan stok barang %s. Sisa stok sekarang = %d", barang.getNama(),
					barang.getStok());
		} else {
			out.println("Maaf, stok tambahan yang dimasukkan tidak valid");
		}
	}

	/**
	 * Method untuk perintah DISKON.
	 * 
	 * @param namaPembeli
	 */
	public static void diskon(String namaPembeli) {

		// Mencari pembeli dalam list dan men-assign
		Pembeli pembeli = cariPembeli(namaPembeli);
		// Mencetak total diskon yang didapat
		int diskon = pembeli.getDiskon();
		out.printf("%s mendapatkan diskon sebesar %d%%\n", pembeli.getNama(), diskon);
	}

	/*
	 * Method untuk mencari persentase diskon yang didapat oleh pembeli.
	 * Method ini mengembalikan persentase diskon yang didapat.
	 */
	public static long hitungDiskon(Pembeli pembeli) {

		// Mendapatkan diskon pembeli
		int diskon = pembeli.getDiskon();
		// Menghitung diskon yang didapat
		long hargaPesanan = pembeli.getJumlahUang() - pembeli.sisaUang();
		long besarDiskon = (long) (hargaPesanan * diskon / 100);
		return besarDiskon;
	}

	/*
	 * Method untuk mencari Barang berdasarkan nama
	 */
	public static Barang cariBarang(String nama) {
		for (Barang barang : listBarang) {
			if (barang.getNama().equals(nama))
				return barang;
		}
		return null;
	}

	/*
	 * Method untuk mencari Pembeli berdasarkan nama
	 */
	public static Pembeli cariPembeli(String nama) {
		for (Pembeli pembeli : listPembeli) {
			if (pembeli.getNama().equals(nama))
				return pembeli;
		}
		return null;
	}

	// taken from https://codeforces.com/submissions/Petr
	// together with PrintWriter, these input-output (IO) is much faster than the
	// usual Scanner(System.in) and System.out
	// please use these classes to avoid your fast algorithm gets Time Limit
	// Exceeded caused by slow input-output (IO)
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
