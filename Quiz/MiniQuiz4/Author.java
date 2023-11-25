// Restu Ahmad Ar Ridho
// 2206028951

public class Author {
  private String name;
  private String email;
  private String institution;
  private String doi;

  Author(String Name, String Email) {
    this.name = Name;
    this.email = Email;
  }

  Author(String Name, String Email, String Institution, String DOI) {
    this.name = Name;
    this.email = Email;
    this.institution = Institution;
    this.doi = DOI;
  }

  // implements another methods in here
  public String getName() {
    return this.name;
  }

  public void setName(String Name) {
    this.name = Name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String Email) {
    this.email = Email;
  }

  public String getInstitution() {
    return this.institution;
  }

  public String getDOI() {
    return this.doi;
  }

  public String toString() {
    return String.format("Author %s - %s", this.name, this.email);
  }

  public boolean equals(Author that) {
    return this.getEmail() == that.getEmail();
  }
}
