// Restu Ahmad Ar Ridho
// 2206028951

public class Journal {
  private String isbn;
  private String title;
  private Author[] authors;
  private String doi;
  private String journalname;
  // implements every field in here

  // implements every constructor in here
  Journal(String isbn, String title) {
    this.isbn = isbn;
    this.title = title;
  }

  Journal(String isbn, String title, String journalname) {
    this.isbn = isbn;
    this.title = title;
    this.journalname = journalname;
  }

  Journal(String isbn, String title, String journalname, Author[] authors, String doi) {
    this.isbn = isbn;
    this.title = title;
    this.journalname = journalname;
    this.authors = authors;
    this.doi = doi;
  }

  // implements another methods in here
  public String getisbn() {
    return this.isbn;
  }

  public String gettitle() {
    return this.title;
  }

  public void settitle(String title) {
    this.title = title;
  }

  public Author[] getAuthors() {
    return this.authors;
  }

  public void setAuthors(Author[] authors) {
    this.authors = authors;
  }

  public String getdoi() {
    return this.doi;
  }

  public String getjournalname() {
    return this.journalname;
  }

  public void setjournalname(String journalname) {
    this.journalname = journalname;
  }

  public String toString() {
    String authorContainer = "";
    for (Author author : this.authors) {
      String authorstring = author.toString();
      authorContainer += authorstring + "\n";
    }
    return String.format("Journal %s - %s - %s - %s\nAuthors:\n%s", this.isbn, this.title, this.journalname, this.doi,
        authorContainer);
  }

  public boolean equals(Journal that) {
    return this.getdoi() == that.getdoi();
  }
}
