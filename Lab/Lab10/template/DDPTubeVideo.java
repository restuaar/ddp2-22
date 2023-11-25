class DDPTubeVideo extends Video {

  private String creator;

  public DDPTubeVideo(String title, int duration, String creator) {
    super(title, duration);
    this.creator = creator;
  }

  @Override
  public String toString() {
    return super.toString() + ". Dibuat oleh " + this.creator;
  }
}
