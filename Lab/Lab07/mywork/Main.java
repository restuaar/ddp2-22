
/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

import card.Card;
import card.ElectronicCard;
import card.GiftCard;
import item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  private static Scanner in = new Scanner(System.in);
  private static ArrayList<Item> items = new ArrayList<>();
  private static ArrayList<Card> cards = new ArrayList<>();

  public static void main(String[] args) {
    initItems();
    showMenu();
  }

  /**
   * Method untuk inisiasi item yang dijual
   */
  private static void initItems() {
    System.out.println("\n========== Buat Item ==========");
    System.out.printf("Masukkan jumlah item: ");
    int jumlahItem = in.nextInt();
    in.nextLine();

    // membuat item sesuai dengan jumlah input
    for (int i = 0; i < jumlahItem; i++) {
      System.out.printf("========== Item ke-%d ==========%n", i + 1);
      System.out.print("Nama: ");
      String name = in.nextLine();

      System.out.print("Harga: ");
      int price = in.nextInt();
      in.nextLine();

      Item item = new Item(name, price);
      items.add(item);
    }
  }

  /**
   * Method untuk menampilkan menu user
   */
  private static void showMenu() {
    boolean isRunning = true;

    while (isRunning) {
      System.out.println("\n========== Menu ==========");
      System.out.println("1. Tambahkan Kartu");
      System.out.println("2. Tampilkan Daftar Kartu");
      System.out.println("3. Beli Item");
      System.out.println("4. Topup");
      System.out.println("5. Keluar");
      System.out.print("Masukan pilihan: ");
      int pilihan = in.nextInt();
      in.nextLine();

      isRunning = execute(pilihan);
    }
  }

  /**
   * Method untuk menghandle input dari menu user
   * 
   * @param pilihan -> pilihan sesuai dengan menu
   * @return boolean untuk melanjutkan (true) atau tidak (false)
   */
  private static boolean execute(int pilihan) {
    switch (pilihan) {
      case 1 -> addCard();
      case 2 -> showCard();
      case 3 -> buyItem();
      case 4 -> topup();
      default -> {
        return false;
      }
    }
    return true;
  }

  /**
   * Method untuk handle pilihan user "Tambah Kartu"
   */
  public static void addCard() {
    System.out.println("\n========== Tambah Kartu ==========");
    // meminta input user
    System.out.print("Company Name: ");
    String companyName = in.nextLine();

    System.out.print("Tipe: ");
    String cardType = in.nextLine().toUpperCase();

    System.out.print("Balance: ");
    double balance = in.nextDouble();
    in.nextLine();

    // membuat kartu sesuai dengan tipe
    Card card = createCard(companyName, balance, cardType);
    if (!(card == null)) { // jika tipe sesuai
      cards.add(card);
      System.out.println("Berhasil menambahkan kartu");
      return;
    }
    System.out.println("Tipe kartu tidak tersedia");
  }

  /**
   * Method untuk membuat kartu sesuai dengan tipe
   * 
   * @param companyName -> nama company kartu
   * @param balance     -> jumlah balance kartu
   * @param type        -> tipe dari kartu
   * @return jika tipe sesuai maka return subclass Object Card sesuai dengan tipe,
   *         null jika tipe tidak sesuai
   */
  private static Card createCard(String companyName, double balance, String type) {
    if (type.equalsIgnoreCase("Gift")) {
      return new GiftCard(companyName, balance);
    } else if (type.equalsIgnoreCase("Electronic")) {
      return new ElectronicCard(companyName, balance);
    }
    return null;
  }

  /**
   * Method untuk handle pilihan user "Tampilkan Daftar Kartu"
   */
  private static void showCard() {
    sortListOfCards();
    printListOfCards();
  }

  /**
   * Method untuk handle pilihan user "Beli Item"
   */
  public static void buyItem() {
    System.out.println("\n========== Daftar Item ==========");
    // menampilkan list kartu
    for (int i = 0; i < items.size(); i++) {
      System.out.printf("[%d] %s%n", i, items.get(i));
    }

    // meminta input user
    System.out.print("Pilihan Item: ");
    int pilihan = in.nextInt();
    in.nextLine();

    // pilih item
    Item itemPilihan = items.get(pilihan);

    // menampilkan dan meminta input
    showCard();
    System.out.print("Pilih id Kartu yang tersedia: ");
    int cardId = in.nextInt();
    in.nextLine();

    // pilih kartu
    Card card = getCardById(cardId);

    // melakukan pembayaran sesuai dengan kartu yang dipilih
    card.pay(itemPilihan);

    System.out.printf("Item %s dengan harga %d berhasil dibeli%n", itemPilihan.getName(), itemPilihan.getPrice());
  }

  public static void topup() {
    showCard(); // menampilkan kartu yang tersedia

    System.out.print("Pilih id Kartu yang tersedia: ");
    int cardId = in.nextInt();
    in.nextLine();

    // pilih kartu sesuai input
    Card card = getCardById(cardId);

    // meminta input banyak yang ingin di topup
    System.out.print("Amount: ");
    double amount = in.nextDouble();
    in.nextLine();

    // melakukan check kartu yang tipe electronic
    if (card instanceof ElectronicCard) {
      ((ElectronicCard) card).topup(amount); // melakukan topup
      System.out.println("Berhasil topup kartu");
    } else {
      System.out.println("Kartu yang dipilih tidak bisa topup");
    }
  }

  /**
   * Method untuk menampilkan semua kartu di ArrayList cards
   */
  private static void printListOfCards() {
    System.out.printf("========== Daftar Kartu ==========%n");

    for (int i = 0; i < cards.size(); i++) {
      System.out.printf("[%d] %s %n", i, cards.get(i));
    }
  }

  /**
   * Method untuk mendapatkan object Card yang terdaftar
   * 
   * @param id -> id dari kartu
   * @return Objecy Card jika id ditemukan, null jika id tidak ditemukan
   */
  private static Card getCardById(int id) {
    for (int i = 0; i < cards.size(); i++) {
      Card card = cards.get(i);
      if (card.getId() == id)
        return card;
    }
    return null;
  }

  /**
   * Melakukan sort list
   */
  private static void sortListOfCards() {
    Collections.sort(cards);
  }
}