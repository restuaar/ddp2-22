/**
 * Restu Ahmad Ar Ridho
 * 2206028951
 * Lab10
 */

//  Hal yang perlu diimplementasi:
//  -) Buat class ini dapat menerima object apapun yang berupa Video
//  -) Atribut videoList
//  -) Constructor
//  -) Method insertVide(), deleteVideo(), getVideoList(), getFirst()

import java.util.ArrayList;

// class yang dapat menerima object apapun berupa video
public class VideoList<T extends Video> {
  // atribut class
  private ArrayList<T> videoList;

  /**
   * Constructor
   */
  public VideoList() {
    videoList = new ArrayList<>();
  }

  /**
   * Mengembalikan list video.
   * 
   * @return videoList
   */
  public ArrayList<T> getVideoList() {
    return videoList;
  }

  /**
   * Mengembalikan video yang berada di posisi paling depan di videoList.
   * 
   * @return Video pada arrayList index pertama
   */
  public T getFirst() {
    return videoList.get(0);
  }

  /**
   * Menghapus video yang ada di posisi paling depan di videoList. Video yang
   * berada pada posisi kedua dari depan akan menjadi posisi pertama dari depan
   * setelah penghapusan video.
   * 
   * @return
   */
  public T deleteVideo() {
    T video = videoList.get(0);
    videoList.remove(0);
    return video;
  }

  /**
   * Menambahkan Video baru ke dalam videoList. Jika isFront = true, maka video
   * baru akan ditambahkan ke posisi paling depan di videoList. Jika tidak, maka
   * video baru akan ditambahkan ke posisi paling akhir di videoList.
   *
   * @param newVideo
   * @param isFront
   */
  public void insertVideo(T newVideo, boolean isFront) {
    if (isFront) {
      videoList.add(0, newVideo);
    } else {
      videoList.add(newVideo);
    }
  }
}
