/**
 * Restu Ahmad Ar Ridho
 * 2206028951
 * Lab10
 */

public class Video {
  // atribute class
  private String title;
  private int duration;
  public static int videoAmount;

  /**
   * Constructor
   * 
   * @param title
   * @param duration
   */
  public Video(String title, int duration) {
    this.title = title;
    this.duration = duration;
    videoAmount++;
  }

  /**
   * Mengembalikan durasi video
   * 
   * @return duration
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Mengembalikan judul suatu video
   * 
   * @return title
   */
  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return this.getTitle() + " - " + this.getDuration() + " menit";
  }
}
