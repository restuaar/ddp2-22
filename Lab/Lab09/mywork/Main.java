/*
 * Restu Ahmad Ar Ridho
 * 2206028951
 * Lab09
 */

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    // iniasi frame awal
    VendingMachineFrame frame = new VendingMachineFrame();

    // konfigurasi frame
    frame.setTitle("Vending Machine");
    frame.setSize(400, 270);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}