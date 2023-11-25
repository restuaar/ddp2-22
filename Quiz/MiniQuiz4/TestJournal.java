// Restu Ahmad Ar Ridho
// 2206028951

public class TestJournal {
  public static void main(String[] args) {
    // implements object of Journal in here
    Author author1 = new Author("Ayu Utami", "ayutami@mail.com");
    Author author2 = new Author("Farhan Dwi Putra", "farhan@mail.com");
    Author[] authors = { author1, author2 };
    Journal journal1 = new Journal("9786028519939", "Transformative learning", "king saud", authors,
        "doi.org/10.1016/j.scs.2020.102655");
    Journal journal2 = new Journal("9786028519902", "Transformative", "king buryan", authors,
        "doi.org/10.1016/j.scs.2020.102655");
    Journal journal3 = new Journal("9786028519902", "Transformative", "king buryan", authors,
        "doi.org/10.1016/j.scs.2021.109822");
    System.out.println(journal1.toString());
    System.out.println(journal2.toString());
    System.out.println(journal3.toString());
    System.out.println(journal1.equals(journal2));
    System.out.print(journal1.equals(journal3));
  }
}