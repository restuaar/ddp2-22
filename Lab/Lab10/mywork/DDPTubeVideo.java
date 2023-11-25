/**
 * Restu Ahmad Ar Ridho
 * 2206028951
 * Lab10
 */

class DDPTubeVideo extends Video {
  // atribut class
  private String creator;

  /**
   * Contructor
   * 
   * @param title
   * @param duration
   * @param creator
   */
  public DDPTubeVideo(String title, int duration, String creator) {
    super(title, duration);
    this.creator = creator;
  }

  @Override
  public String toString() {
    return super.toString() + ". Dibuat oleh " + this.creator;
  }
}
