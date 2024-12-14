package dacn_letrananhnhung;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Client_GUI extends javax.swing.JFrame {

    TCPClient client = new TCPClient();
    DefaultTableModel model = new DefaultTableModel();

    public Client_GUI() {
        initComponents();
        myInit();
    }

    public void myInit() {
        setTitle("Client Quản lý đơn hàng");
        bt_disconnect.setEnabled(false);
    }

    public void addmess(String mess) {
        ketqua.append(mess + "\n");
    }

    public void resetLabel() {
        txtmaDH.setText("");
        txttenKH.setText("");
        txtdiaChi.setText("");
        txttenSP.setText("");
        txtDonGia.setText("");
        txtsoLuong.setText("");
        txtngayDat.setText("");
        txttrangThai.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        txtmaDH = new javax.swing.JTextField();
        txttenKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtdiaChi = new javax.swing.JTextField();
        txttenSP = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtsoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtngayDat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttrangThai = new javax.swing.JTextField();
        panel2 = new java.awt.Panel();
        bt_disconnect = new javax.swing.JButton();
        bt_connect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ketqua = new javax.swing.JTextArea();
        bt_madh = new javax.swing.JButton();
        bt_trangthai = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_dsdh = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("QUẢN LÝ ĐƠN HÀNG");

        txttenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenKHActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã đơn hàng");

        jLabel4.setText("Tên khách hàng");

        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        jLabel5.setText("Địa chỉ");

        jLabel6.setText("Tên sản phẩm");

        txtngayDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtngayDatActionPerformed(evt);
            }
        });

        jLabel7.setText("Đơn giá");

        jLabel8.setText("Số lượng");

        jLabel9.setText("Ngày đặt");

        jLabel10.setText("Trạng thái");

        jLabel11.setText("Thông tin");

        txttrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtsoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtngayDat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtsoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtngayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txttrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        bt_disconnect.setText("Disconnect");
        bt_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_disconnectActionPerformed(evt);
            }
        });

        bt_connect.setText("Connect");
        bt_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_connectActionPerformed(evt);
            }
        });

        ketqua.setColumns(20);
        ketqua.setRows(5);
        jScrollPane1.setViewportView(ketqua);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(bt_connect)
                        .addGap(64, 64, 64)
                        .addComponent(bt_disconnect)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_connect)
                    .addComponent(bt_disconnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bt_madh.setText("Tìm kiếm theo mã ĐH");
        bt_madh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_madhActionPerformed(evt);
            }
        });

        bt_trangthai.setText("Tìm kiếm theo trạng thái");
        bt_trangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_trangthaiActionPerformed(evt);
            }
        });

        tb_dsdh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Tên Khách hàng", "Địa chỉ", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền", "Ngày đặt", "Trạng thái"
            }
        ));
        tb_dsdh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_dsdhMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_dsdh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_madh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_trangthai))
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(313, 313, 313))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_trangthai)
                            .addComponent(bt_madh))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_dsdhMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tb_dsdhMouseClicked
        DefaultTableModel model = (DefaultTableModel) tb_dsdh.getModel();
        int selectedRow = tb_dsdh.getSelectedRow();
        txtmaDH.setText(model.getValueAt(selectedRow, 0).toString());
        txttenKH.setText(model.getValueAt(selectedRow, 1).toString());
        txtdiaChi.setText(model.getValueAt(selectedRow, 2).toString());
        txttenSP.setText(model.getValueAt(selectedRow, 3).toString());
        txtDonGia.setText(model.getValueAt(selectedRow, 4).toString());
        txtsoLuong.setText(model.getValueAt(selectedRow, 8).toString());
        txtngayDat.setText(model.getValueAt(selectedRow, 6).toString());
        txttrangThai.setText(model.getValueAt(selectedRow, 7).toString());
    }// GEN-LAST:event_tb_dsdhMouseClicked

    private void txttrangThaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txttrangThaiActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txttrangThaiActionPerformed

    private void txtngayDatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtngayDatActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtngayDatActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtDonGiaActionPerformed

    private void txttenKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txttenKHActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txttenKHActionPerformed
    
    private void bt_connectActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bt_connectActionPerformed
        int port = 2004;
            try {
                client.ConnectServer("localhost", port);
                addmess("Kết nối thành công");
                bt_connect.setEnabled(false);
                bt_disconnect.setEnabled(true);

            } catch (IOException e) {
                addmess(e.getMessage());
            }
        
    }

    private void bt_disconnectActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bt_disconnectActionPerformed
        client.Close();
        bt_connect.setEnabled(true);
        bt_disconnect.setEnabled(false);
    }// GEN-LAST:event_bt_disconnectActionPerformed

    private void bt_trangthaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bt_trangthaiActionPerformed
        String mess = JOptionPane.showInputDialog(bt_trangthai, "Nhập trạng thái đơn hàng!");
        String mess1;
        resetLabel();
        try {
            client.output("trangThai:" + mess);
            addmess("Client: " + mess);
            mess1 = client.input();
            System.out.println(mess);
            if (mess1.equalsIgnoreCase("null")) {
                JOptionPane.showMessageDialog(bt_trangthai, "Không tìm thấy !");
                addmess("Không tìm thấy !");

            } else {
                String[] output = mess1.split(";");
                DefaultTableModel model = (DefaultTableModel) tb_dsdh.getModel();
                model.setRowCount(0); // Clear existing rows
                for (String x : output) {
                    String[] data = x.split(", ");
                    model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],data[8]});
                    txtmaDH.setText(data[0]);
                    txttenKH.setText(data[1]);
                    txtdiaChi.setText(data[2]);
                    txttenSP.setText(data[3]);
                    txtDonGia.setText(data[4]);
                    txtsoLuong.setText(data[5]);
                    txtngayDat.setText(data[6]);
                    txttrangThai.setText(data[7]);
                }
                addmess("Đã nhận dữ liệu từ server");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(bt_madh, e.getMessage());
            addmess(e.getMessage());
        }
    }
    private void bt_madhActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bt_madhActionPerformed
        String mess = JOptionPane.showInputDialog(bt_madh, "Nhập mã đơn hàng!");
        String mess1;
        resetLabel();
        try {
            client.output("maDH:" + mess);
            addmess("Client: " + mess);
            mess1 = client.input();
            System.out.println(mess);
            if (mess1.equalsIgnoreCase("null")|| mess1.equalsIgnoreCase("Không tìm thấy!")) {
                JOptionPane.showMessageDialog(bt_madh, "Không tìm thấy mã đơn hàng!");
                addmess("Không tìm thấy mã đơn hàng!");

            } else {
                String[] output = mess1.split(";");
                DefaultTableModel model = (DefaultTableModel) tb_dsdh.getModel();
                model.setRowCount(0);
                for (String s : output) {
                    String[] data = s.split(", ");
                    model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4],
                        data[5], data[8], data[6], data[7],data});
                    txtmaDH.setText(data[0]);
                    txttenKH.setText(data[1]);
                    txtdiaChi.setText(data[2]);
                    txttenSP.setText(data[3]);
                    txtDonGia.setText(data[4]);
                    txtsoLuong.setText(data[5]);
                    txtngayDat.setText(data[6]);
                    txttrangThai.setText(data[7]);

                }
            }
            addmess("Đã nhận dữ liệu từ server");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(bt_madh, e.getMessage());
            addmess(e.getMessage());
        }

    }// GEN-LAST:event_bt_madhActionPerformed

    private void txt_portActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_portActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_portActionPerformed

    // GEN-LAST:event_bt_trangthaiActionPerformed

    // GEN-LAST:event_bt_connectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client_GUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_GUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_GUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_GUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_connect;
    private javax.swing.JButton bt_disconnect;
    private javax.swing.JButton bt_madh;
    private javax.swing.JButton bt_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea ketqua;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTable tb_dsdh;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtdiaChi;
    private javax.swing.JTextField txtmaDH;
    private javax.swing.JTextField txtngayDat;
    private javax.swing.JTextField txtsoLuong;
    private javax.swing.JTextField txttenKH;
    private javax.swing.JTextField txttenSP;
    private javax.swing.JTextField txttrangThai;
    // End of variables declaration//GEN-END:variables
}
