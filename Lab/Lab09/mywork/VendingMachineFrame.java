/*
 * Restu Ahmad Ar Ridho
 * 2206028951
 * Lab09
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VendingMachineFrame extends JFrame {
  // iniasi kompenen pada frame
  private JPanel vendingMachinePanel, labelPanel, buttonPanel, moneyInputPanel, purchaseProductPanel,
      purchasePanel;
  private JLabel optionLabel, enterLabel, productLabel, quantityLabel, priceLabel, totalPriceLabel;
  private JButton addMoneyButton, purchaseButton, submitButton, backButton;
  private JTextField textField, quantityField, priceField, totalPriceField;
  private JComboBox<String> menuBox;
  private Font font = new Font("SansSerif", 1, 15);

  // iniasi variabel untuk menyimpan data
  private String amount;
  private String[] menus = { "Akua", "Fruti Apel", "Palpi Jeruk", "Neskafe Latte", "Koka Kola" };
  private long harga = 5000;
  private long totalHarga;

  /**
   * Contructor
   */
  public VendingMachineFrame() {
    // set layout frame
    getContentPane().setLayout(null);

    // membuat panel untuk vendingmachine
    add(vendingMachinePanel());
    repaint();
    validate();
  }

  /**
   * Method untuk membuat tampilan vendingmachine
   * 
   * @return JPanel -> Vending Machine
   */
  private JPanel vendingMachinePanel() {
    // iniasi container keseluruhan
    vendingMachinePanel = new JPanel();
    vendingMachinePanel.setBounds(0, 0, 400, 200);
    vendingMachinePanel.setLayout(null);

    // iniasi container khusus label
    labelPanel = new JPanel();
    labelPanel.setBounds(0, 0, 400, 170);
    labelPanel.setLayout(new BorderLayout());

    // membuat label untuk option dan jumlah uang
    optionLabel = new JLabel();
    // menampilkan text yang sesuai
    if (!(amount == null)) {
      optionLabel.setText("Total Money: Rp." + amount + ".0");
    } else {
      optionLabel.setText("Please select an option");
    }
    // konfigurasi label
    optionLabel.setFont(font);
    optionLabel.setVerticalAlignment(JLabel.CENTER);
    optionLabel.setHorizontalAlignment(JLabel.CENTER);
    labelPanel.add(optionLabel);

    // membuat container untuk button
    buttonPanel = new JPanel();
    buttonPanel.setBounds(0, 170, 400, 30);
    buttonPanel.setLayout(null);

    // membuat komponen untuk addMoney
    addMoneyButton = new JButton("Add Money");
    addMoneyButton.setBounds(10, 0, 180, 30);
    // action yang dilakukan ketika ditekan
    addMoneyButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // melakukan remove panel dan mengubah menjadi panel moneyInput
        remove(vendingMachinePanel);
        add(moneyInputPanel());
        setTitle("Money Input");
        repaint();
        validate();
      }
    });
    buttonPanel.add(addMoneyButton);

    // membuat kompenen button untuk purchaseProduct
    purchaseButton = new JButton("Purchase Product");
    purchaseButton.setBounds(200, 0, 180, 30);
    // action yang dilakukan ketika ditekan
    purchaseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // melakukan remove panel dan mengubah menjadi panel purchaseProduct
        remove(vendingMachinePanel);
        add(purchaseProduct());
        setTitle("Purchase Product");
        setSize(410, 300);
        repaint();
        validate();
      }
    });
    buttonPanel.add(purchaseButton);

    // menambahkan setiap panel pada container
    vendingMachinePanel.add(labelPanel);
    vendingMachinePanel.add(buttonPanel);

    return vendingMachinePanel;
  }

  /**
   * Method untuk menampilkan moneyInputPanel
   * 
   * @return JPanel -> Money Input
   */
  private JPanel moneyInputPanel() {
    // iniasi container keseluruhan
    moneyInputPanel = new JPanel();
    moneyInputPanel.setBounds(10, 15, 400, 200);
    moneyInputPanel.setLayout(null);

    // membuat komponen label
    enterLabel = new JLabel("Enter the amount of money:");
    enterLabel.setBounds(0, 0, 370, 20);
    enterLabel.setFont(font);
    moneyInputPanel.add(enterLabel);

    // membuat kompenen text field (input user)
    textField = new JTextField();
    textField.setBounds(0, 35, 370, 100);
    textField.setFont(new Font("SansSerif", 1, 20));
    moneyInputPanel.add(textField);

    // membuat komponen button untuk submit
    submitButton = new JButton("Submit");
    submitButton.setBounds(0, 150, 370, 30);
    // action yang dilakuka
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // melakukan cek ketika sebelumnya sudah ada atau tidak
        if (!(amount == null)) {
          long temp = Long.parseLong(amount);
          amount = String.valueOf(temp + Long.parseLong(textField.getText()));
        } else {
          amount = textField.getText();
        }
        // menghapus panel dan mengubah kembali ke vendingmachine
        remove(moneyInputPanel);
        add(vendingMachinePanel());
        setTitle("Vending Machine");
        repaint();
        validate();
      }
    });
    moneyInputPanel.add(submitButton);

    return moneyInputPanel;
  }

  /**
   * Method untuk menampilkan purchaseProduct
   * 
   * @return JPanel -> Purchase Product
   */
  private JPanel purchaseProduct() {
    // iniasi panel container
    purchaseProductPanel = new JPanel();
    purchaseProductPanel.setBounds(10, 10, 375, 230);
    purchaseProductPanel.setLayout(new BorderLayout());

    // membuat panel untuk melakukan pembelian
    purchasePanel = new JPanel();
    purchasePanel.setSize(370, 270);
    purchasePanel.setLayout(new GridLayout(4, 2, -20, 10));

    // membuat komponen label untuk product
    productLabel = new JLabel("Product:");
    purchasePanel.add(productLabel);

    // membuat komponen combo box tampilan product
    menuBox = new JComboBox<>(menus);
    // action yang dilakukan ketika user mengubah combobox
    menuBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // mendapatkan input dan menyesuarkan harga
        String menu = (String) menuBox.getSelectedItem();

        switch (menu) {
          case "Akua" -> harga = 5000;
          case "Fruti Apel" -> harga = 8000;
          case "Palpi Jeruk" -> harga = 7500;
          case "Nescafe Latte" -> harga = 11000;
          case "Koka Kola" -> harga = 9500;
        }

        // update pada priceField dan totalPriceField
        priceField.setText("Rp." + harga + ".0");
        updateTotalHarga();
      }
    });
    purchasePanel.add(menuBox);

    // membuat komponen label untuk quantity
    quantityLabel = new JLabel("Quantity:");
    purchasePanel.add(quantityLabel);

    // membuat komponen textfield untuk user menginput banyak barang
    quantityField = new JTextField();
    // action ketika setiap kali isi textfield berubah
    quantityField.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        updateTotalHarga();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        updateTotalHarga();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        updateTotalHarga();
      }
    });
    purchasePanel.add(quantityField);

    // membuat komponen label price
    priceLabel = new JLabel("Price:");
    purchasePanel.add(priceLabel);

    // membuat komponen textfield dengan placehold harga akua
    priceField = new JTextField("Rp.5000.0");
    priceField.setEditable(false);
    purchasePanel.add(priceField);

    // membuat komponen label untuk total price
    totalPriceLabel = new JLabel("Total Price:");
    purchasePanel.add(totalPriceLabel);

    // membuat komponen textfield untuk menampilkan total harga
    totalPriceField = new JTextField();
    totalPriceField.setEditable(false);
    purchasePanel.add(totalPriceField);

    // membuat panel sebagai container button
    buttonPanel = new JPanel();
    buttonPanel.setSize(370, 30);

    // membuat komponen button untuk melakukan pembelian
    purchaseButton = new JButton("Purchase");
    // action yang dilakukan ketika ditekan
    purchaseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // mendapatkan total price
        String totalPrice = totalPriceField.getText();

        String message;
        // ketika user menginput jumlah barang yang tidak valid
        if (totalPrice.equals("") || totalHarga <= 0) {
          message = "Maaf, jumlah barang yang Anda masukkan tidak valid!";
          JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.ERROR_MESSAGE);
        } else {
          // dilakukan try catch untuk parse
          try {
            // ketika input user sesuai
            if (!(totalHarga > Long.parseLong(amount))) {
              long kembalian = Long.parseLong(amount) - totalHarga;
              amount = String.valueOf(kembalian);
              message = "Berhasil! Kembalian Anda sebesar Rp." + amount + ".0";
              JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
              throw new Exception();
            }
          } catch (Exception er) { // ketika gagal untuk pembelian
            message = "Maaf, Uang Anda tidak cukup!";
            JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    // membuat komponen button untuk kemabali ke panel vending machine
    backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // menghapus panel purchase product dan menampilkan panel vending machine
        remove(purchaseProductPanel);
        add(vendingMachinePanel());
        setTitle("Vending Machine");
        repaint();
        validate();
        setSize(400, 270);
      }
    });

    // menambahkan komponen button ke dalam panel button
    buttonPanel.add(backButton);
    buttonPanel.add(purchaseButton);

    // menambahkan semua panel kedalam container
    purchaseProductPanel.add(purchasePanel, BorderLayout.NORTH);
    purchaseProductPanel.add(buttonPanel, BorderLayout.SOUTH);
    return purchaseProductPanel;
  }

  /**
   * Method untuk melakukan kalkulasi harga untuk mengubah label total harga
   */
  private void updateTotalHarga() {
    // mendapatkan banyaknya barang
    String quantity = quantityField.getText();

    // untuk handle ketika user menginput selain integer
    try {
      if (Integer.parseInt(quantity) >= 0) {
        // melakukan kalkulasi dan mengubah tampilan totalPriceField
        totalHarga = Integer.parseInt(quantity) * harga;
        totalPriceField.setText("Rp." + totalHarga + ".0");
      }
    } catch (Exception e) {
      totalPriceField.setText("");
    }
  }
}
