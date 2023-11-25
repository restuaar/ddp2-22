// Restu Ahmad Ar Ridho
// 2206028951

public class TestAuthor {
  public static void main(String[] args) {
    // implements object of author in here
    Author author0 = new Author("Tanmay Kumar Aja", "tanmay.nitr@gmail.com");
    Author author1 = new Author("Tanmay Kumar Behera", "tanmay.nitr@gmail.com");
    Author author2 = new Author("Restu Ahmad Ar Ridho", "restu.ahmad@ui.ac.id");
    System.out.println(author1);
    System.out.println(author2);
    System.out.println(author1.equals(author2));
    System.out.println(author1.equals(author0));
  }
}
