/**
 * Restu Ahmad Ar Ridho
 * 2206028951
 * Lab10
 */

public class Movie extends Video {
  // inisiasi atribut class
  private String director;
  private double rating;

  /**
   * Contructor
   * 
   * @param title
   * @param duration
   * @param director
   * @param rating
   */
  public Movie(String title, int duration, String director, double rating) {
    super(title, duration);
    this.director = director;
    this.rating = rating;
  }

  /**
   * Mengembalikan seberapa bagus rating suatu Movies dalam bentuk String.
   * 
   * @return rating movie
   */
  private String isRatingBagus() {
    if (rating <= 1.0)
      return "sangat rendah";
    if (rating <= 2.0)
      return "rendah";
    if (rating <= 3.0)
      return "cukup bagus";
    if (rating <= 4.0)
      return "bagus";
    return "sangat bagus";
  }

  @Override
  public String toString() {
    return super.toString() + ". Disutradarai oleh " + this.director + " dan memiliki rating " + isRatingBagus();
  }
}
