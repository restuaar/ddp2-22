// Restu Ahmad Ar Ridho
// 2206028951
// Lab03

// import library yang diperlukan
import java.util.Scanner;

class Lab3 {
	// inisiasi variabel yang akan digunakan
	private static final Scanner input = new Scanner(System.in); // inisiasi object scan
	private static String[] kumpulanNamaMahasiswa;
	private static String[] kumpulanNamaMatkul;
	private static int[][] score;
	private static int banyakMatkul;

	public static void main(String[] args) {
		init(); // menjalankan method init

		// melakukan pengulangan hingga input yang diberikan untuk exit program
		while (true) {
			printMenu(); // mencetak pilihan menu
			System.out.print("Masukkan pilihan: ");
			int pilihan = input.nextInt(); // meminta input dari user untuk pilihan menu
			input.nextLine();
			switch (pilihan) { // membagi kasus untuk setiap pilihan user
				case 1: // program menambah mahasiswa
					menambahMahasiswa();
					break;
				case 2: // program menghapus mahasiswa
					menghapusMahasiswa();
					break;
				case 3: // program untuk mencetak tabel nilai
					mencetakTabel();
					break;
				case 4:
					mencetakNilai(); // program mencetak suatu nilai
					break;
				case 0: // exit dari program
					System.out.println("Terima kasih telah menggunakan BeJayNG!");
					input.close(); // menutup object Scanner
					System.exit(0);
					break;
				default: // input yang diberikan tidak sesuai
					System.out.println("Pilihan tidak valid!");
					break;
			}
		}
	}

	/**
	 * method untuk melakukan inisiasi awal pada awal program
	 */
	static void init() {
		System.out.println("Selamat datang di BeJayNG!");
		System.out.println("==============Initial Input==============");

		// meminta input untuk banyaknya mata kuliah kepada user
		System.out.print("Masukkan jumlah mata kuliah: ");
		banyakMatkul = input.nextInt();
		input.nextLine();

		// inisiasi panjang Array awal
		kumpulanNamaMatkul = new String[banyakMatkul];
		score = new int[0][banyakMatkul];
		kumpulanNamaMahasiswa = new String[0];

		// meminta input untuk setiap mata kuliah sesuai dengan banyaknya mata kuliah
		for (int i = 0; i < banyakMatkul; i++) {
			System.out.print("Masukkan nama mata kuliah: ");
			kumpulanNamaMatkul[i] = input.nextLine();
		}

		return;
	}

	/**
	 * Method untuk menampilkan menu pilihan
	 */
	static void printMenu() {
		System.out.println("==============Menu==============");
		System.out.println("[1] Menambah Mahasiswa");
		System.out.println("[2] Menghapus Mahasiswa");
		System.out.println("[3] Mencetak Tabel");
		System.out.println("[4] Mencetak Nilai");
		System.out.println("[0] Keluar");
	}

	/**
	 * Method untuk menambahkan mahasiswa ke dalam program
	 */
	static void menambahMahasiswa() {
		System.out.println("==============Menambah Mahasiswa==============");

		// meminta input untuk nama mahasiswa
		System.out.print("Masukkan nama mahasiswa: ");
		String namaMahasiwa = input.nextLine();

		// melakukan penambahan size array
		String[] kumpulanNamaMahasiswaBaru = new String[kumpulanNamaMahasiswa.length + 1];
		// meng-copy semua yang ada didalam array yang lama menjadi array yang baru
		for (int i = 0; i < kumpulanNamaMahasiswa.length; i++) {
			kumpulanNamaMahasiswaBaru[i] = kumpulanNamaMahasiswa[i];
		}
		// mengubah referensi array yang lama menjadi array yang baru
		kumpulanNamaMahasiswa = kumpulanNamaMahasiswaBaru;
		// melakukan assign nama mahasiswa yang baru kedalam array yang sudah ditambah
		// size-nya
		kumpulanNamaMahasiswa[kumpulanNamaMahasiswa.length - 1] = namaMahasiwa;

		// melakukan penambahan size array
		int[][] scoreBaru = new int[score.length + 1][banyakMatkul];
		// meng-copy semua yang ada didalam array yang lama menjadi array yang baru
		for (int i = 0; i < score.length; i++) {
			scoreBaru[i] = score[i];
		}
		// mengubah referensi array yang lama menjadi array yang baru
		score = scoreBaru;

		// melakukan pengulangan untuk input nilai sesuai dengan banyak matkul
		for (int i = 0; i < banyakMatkul; i++) {
			System.out.printf("Masukkan nilai %s: ", kumpulanNamaMatkul[i]);
			int nilai = input.nextInt();
			// melakukan assign nilai sesuai dengan banyak matkul dan diletakan pada index
			// terakhir
			score[kumpulanNamaMahasiswa.length - 1][i] = nilai;
		}

		System.out.printf("Nilai mahasiswa bernama %s berhasil diinput ke BeJayNG\n", namaMahasiwa);
		return;
	}

	/**
	 * Method untuk menghapus mahasiswa dalam program
	 */
	static void menghapusMahasiswa() {
		System.out.println("==============Menghapus Mahasiswa==============");

		if (kumpulanNamaMahasiswa.length > 0) {
			// meminta input dari user
			System.out.print("Masukkan nama mahasiswa: ");
			String namaMahasiswa = input.nextLine();
			int indexNamaMahasiswa = 0; // inisasi variable untuk index

			// melakukan iterasi untuk mendapatkan index sesuai dengan nama yang di input
			for (int i = 0; i < kumpulanNamaMahasiswa.length; i++) {
				if (kumpulanNamaMahasiswa[i].equalsIgnoreCase(namaMahasiswa)) {
					indexNamaMahasiswa = i;
				}
			}

			score = removeElement(indexNamaMahasiswa); // memanggil method removeElement dan assign pada score
			System.out.printf("Mahasiswa bernama %s telah dihapus dari BeJayNG\n", namaMahasiswa);
		} else { // kasus ketika belum ada sama sekali data mahasiswa
			System.out.println("Data mahasiswa belum ada");
		}
		return;
	}

	/**
	 * Method untuk menghapus mahasiswa target di dalam array 2D score dan
	 * kumpulanNamaMahasiswa
	 * 
	 * @param index index dari nama mahasiswa target
	 * @return array 2D score yang baru (sudah dilakukan penghapusan)
	 */
	public static int[][] removeElement(int index) {

		// melakukan pengurangan size array
		int[][] scoreBaru = new int[score.length - 1][banyakMatkul];
		String[] kumpulanNamaMahasiswaBaru = new String[kumpulanNamaMahasiswa.length - 1];
		int indexBaru = 0; // iniasi variabel untuk index yang baru

		// melakukan iterasi untuk meng-copy array yang lama
		for (int i = 0; i < score.length; i++) {
			// jika index iterasi sama dengan index yang ingin dihapus maka iterasi akan di
			// skip sehingga indexBaru akan menjadi
			// index pada array yang baru
			if (index == i) {
				continue;
			}
			// melakukan assign kembali
			scoreBaru[indexBaru] = score[i];
			kumpulanNamaMahasiswaBaru[indexBaru] = kumpulanNamaMahasiswa[i];
			indexBaru++;
		}
		kumpulanNamaMahasiswa = kumpulanNamaMahasiswaBaru; // mengubah referensi
		return scoreBaru;
	}

	/**
	 * Method untuk mencetak tabel nilai
	 */
	static void mencetakTabel() {
		System.out.println("==============Mencetak Tabel==============");

		// iniasi cetak tabel untuk bagian header
		System.out.print("Nama \t\t\t");
		for (int i = 0; i < banyakMatkul; i++) {
			System.out.printf("%s\t", kumpulanNamaMatkul[i]);
		}

		// handle untuk belum ada mahasiswa yang di input
		if (kumpulanNamaMahasiswa.length > 0) {
			// melakukan iterasi untuk setiap nama mahasiswa
			for (int i = 0; i < kumpulanNamaMahasiswa.length; i++) {
				System.out.printf("\n%s\t\t\t", kumpulanNamaMahasiswa[i]);
				// melakukan iterasi sesuai index nama mahasiswa untuk mencetak setiap nilai
				// matkul
				for (int j = 0; j < banyakMatkul; j++) {
					System.out.printf("%d\t", score[i][j]);
				}
			}
		}
		System.out.println();
		return;
	}

	/**
	 * Method untuk mencetak nilai sesuai dengan nama mahasiswa dan nama matkul
	 */
	static void mencetakNilai() {
		System.out.println("==============Mencetak Nilai==============");

		if (kumpulanNamaMahasiswa.length > 0) {
			// meminta input dari user untuk nama mahasiswa dan nama matkul
			System.out.print("Masukkan nama mahasiswa: ");
			String namaMahasiswa = input.nextLine();
			System.out.print("Masukkan nama mata kuliah: ");
			String namaMatkul = input.nextLine();

			// iniasi variabel untuk index target nama mahasiswa dan index target nama
			// matkul
			int indexNamaMahasiswa = 0;
			int indexNamaMatkul = 0;

			// mencari index nama mahasiswa target dalam array
			for (int i = 0; i < kumpulanNamaMahasiswa.length; i++) {
				if (kumpulanNamaMahasiswa[i].equalsIgnoreCase(namaMahasiswa)) {
					indexNamaMahasiswa = i;
				}
			}

			// mencari index nama matkul target dalam array
			for (int i = 0; i < kumpulanNamaMatkul.length; i++) {
				if (kumpulanNamaMatkul[i].equalsIgnoreCase(namaMatkul)) {
					indexNamaMatkul = i;
				}
			}

			// mengambil nilai dari array 2D score dengan index nama mahasiswa dan matkul
			int nilai = score[indexNamaMahasiswa][indexNamaMatkul];
			System.out.printf("Nilai %s di mata kuliah %s adalah %d\n", namaMahasiswa, namaMatkul, nilai);
		} else {
			System.out.println("Data mahasiswa belum ada");
		}
		return;
	}
}