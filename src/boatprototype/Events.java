/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boatprototype;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danka
 */
public class Events extends javax.swing.JFrame {

    /**
     * Creates new form Events
     */
    public Events() {
        initComponents();
        try {
            table_update();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class Event {

        //Create a Boat class to help with transferring data database to jTable
        private String event_id;
        private String event_name;
        private String event_date;
        private String event_start_time;

        public String getEventId() {
            return event_id;
        }

        public void setEventId(String eventId) {
            this.event_id = eventId;
        }

        public String getEventName() {
            return event_name;
        }

        public void setEventName(String eventName) {
            this.event_name = eventName;
        }

        public String getEventDate() {
            return event_date;
        }

        public void setEventDate(String eventDate) {
            this.event_date = eventDate;
        }

        public String getEventStartTime() {
            return event_start_time;
        }

        public void setEventStartTime(String eventStartTime) {
            this.event_start_time = eventStartTime;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    Connection conn;
    PreparedStatement statement;

    private void table_update() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8");
            statement = conn.prepareStatement("SELECT * FROM Events ORDER BY event_date asc");
            ResultSet rs = statement.executeQuery();

            ArrayList<Event> list = new ArrayList();
            while (rs.next()) {
                // Create an event object using the Event Class
                Event event = new Event();
                //Add data to the event object from the ResultSet
                event.setEventId(rs.getString("event_id"));
                event.setEventName(rs.getString("event_name"));
                event.setEventDate(rs.getString("event_date"));
                event.setEventStartTime(rs.getString("event_start_time"));
                //Add the data from the event object to the next row of the list object
                list.add(event);
            }

            //Add data from array of Event objects to eventsTbl
            DefaultTableModel model = (DefaultTableModel) eventsTbl.getModel();
            model.setRowCount(0);
            //Create a 2 dimensional array with 3 elements
            Object rowData[] = new Object[4];
            //Fill up the array with the the next row of data from the list
            for (int i = 0; i < list.size(); i++) {
                rowData[0] = list.get(i).event_id;
                rowData[1] = list.get(i).event_name;
                rowData[2] = list.get(i).event_date;
                rowData[3] = list.get(i).event_start_time;
                //Add the data from the array into the next row in eventsTbl via the model
                model.addRow(rowData);
            }

        } catch (SQLException ex) {
            System.out.println("errorMessage" + ex);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dutySignIn = new javax.swing.JLabel();
        creatEventPnl = new javax.swing.JPanel();
        eventNameLbl = new javax.swing.JLabel();
        eventDateLbl = new javax.swing.JLabel();
        eventStartTimeLbl = new javax.swing.JLabel();
        eventNameTxt = new javax.swing.JTextField();
        eventIdTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        eventIDGeneratorBtn = new javax.swing.JButton();
        eventDateTxt = new javax.swing.JTextField();
        eventStartTimeTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsTbl = new javax.swing.JTable();
        homeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(252, 4, 4));

        dutySignIn.setBackground(new java.awt.Color(252, 4, 4));
        dutySignIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dutySignIn.setForeground(new java.awt.Color(255, 255, 255));
        dutySignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Test/PSCLogoSmall.PNG"))); // NOI18N
        dutySignIn.setText("Event Diary");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(dutySignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dutySignIn, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        creatEventPnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Create Event Here:"));

        eventNameLbl.setText("Name");

        eventDateLbl.setText("Date");

        eventStartTimeLbl.setText("Start Time");

        eventNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventNameTxtActionPerformed(evt);
            }
        });

        eventIdTxt.setEditable(false);
        eventIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventIdTxtActionPerformed(evt);
            }
        });

        jLabel1.setText("Event ID");

        eventIDGeneratorBtn.setText("New");
        eventIDGeneratorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventIDGeneratorBtnActionPerformed(evt);
            }
        });

        eventDateTxt.setToolTipText("YYYY-MM-DD");

        eventStartTimeTxt.setToolTipText("HH:MM:SS");

        javax.swing.GroupLayout creatEventPnlLayout = new javax.swing.GroupLayout(creatEventPnl);
        creatEventPnl.setLayout(creatEventPnlLayout);
        creatEventPnlLayout.setHorizontalGroup(
            creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creatEventPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventStartTimeLbl)
                    .addComponent(eventDateLbl)
                    .addComponent(eventNameLbl)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creatEventPnlLayout.createSequentialGroup()
                        .addComponent(eventIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(eventIDGeneratorBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(creatEventPnlLayout.createSequentialGroup()
                        .addGroup(creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eventNameTxt)
                            .addComponent(eventDateTxt)
                            .addComponent(eventStartTimeTxt))
                        .addContainerGap())))
        );
        creatEventPnlLayout.setVerticalGroup(
            creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creatEventPnlLayout.createSequentialGroup()
                .addGroup(creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(eventIDGeneratorBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventNameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventDateLbl)
                    .addComponent(eventDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creatEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventStartTimeLbl)
                    .addComponent(eventStartTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        eventsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Event ID", "Name", "Date", "Start Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eventsTbl.getTableHeader().setReorderingAllowed(false);
        eventsTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventsTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(eventsTbl);

        homeBtn.setText("Back To Home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creatEventPnl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(deleteBtn)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(creatEventPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteBtn)
                            .addComponent(updateBtn)
                            .addComponent(addBtn))
                        .addGap(63, 63, 63)
                        .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eventNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventNameTxtActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // Add record to events table:
        String eventName = eventNameTxt.getText();
        String eventId = eventIdTxt.getText();
        String eventDate = eventDateTxt.getText();
        String eventStartTime = eventStartTimeTxt.getText();
        if (Validation.lengthCheck(1, eventName, 30) && Validation.timeCheck(eventStartTime) && Validation.dateCheck(eventDate)) {
            DataManipulation.addEvents(eventId, eventName, eventDate, eventStartTime);

            JOptionPane.showMessageDialog(this, "Record Added");
            try {
                table_update();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "please enter in the correct format and make sure that the event name is less than 30 characters");
        }

        //Empty fields for next action
        eventIdTxt.setText("");
        eventNameTxt.setText("");
        eventDateTxt.setText("");
        eventStartTimeTxt.setText("");
        eventIdTxt.requestFocus();
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        String eventId = eventIdTxt.getText();
        String eventName = eventNameTxt.getText();
        String eventDate = eventDateTxt.getText();
        String eventStartTime = eventStartTimeTxt.getText();
        DataManipulation.updateEvents(eventId, eventName, eventDate, eventStartTime);

        JOptionPane.showMessageDialog(this, "Record Updated");
        try {
            table_update();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Empty fields for next action
        eventIdTxt.setText("");
        eventNameTxt.setText("");
        eventDateTxt.setText("");
        eventStartTimeTxt.setText("");
        eventIdTxt.requestFocus();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        new HomePage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        String eventId = eventIdTxt.getText();
        String eventName = eventNameTxt.getText();
        String eventDate = eventDateTxt.getText();
        String eventStartTime = eventStartTimeTxt.getText();
        DataManipulation.deleteEvents(eventId, eventName, eventDate, eventStartTime);

        JOptionPane.showMessageDialog(this, "Record Deleted");
        try {
            table_update();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Empty fields for next action
        eventIdTxt.setText("");
        eventNameTxt.setText("");
        eventDateTxt.setText("");
        eventStartTimeTxt.setText("");
        eventIdTxt.requestFocus();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void eventsTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventsTblMouseClicked
        // TODO add your handling code here:
        DefaultTableModel Df = (DefaultTableModel) eventsTbl.getModel();
        int selectedIndex = eventsTbl.getSelectedRow();

        eventIdTxt.setText(Df.getValueAt(selectedIndex, 0).toString());
        eventNameTxt.setText(Df.getValueAt(selectedIndex, 1).toString());
        eventDateTxt.setText(Df.getValueAt(selectedIndex, 2).toString());
        eventStartTimeTxt.setText(Df.getValueAt(selectedIndex, 3).toString());
    }//GEN-LAST:event_eventsTblMouseClicked

    private void eventIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventIdTxtActionPerformed

    private void eventIDGeneratorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventIDGeneratorBtnActionPerformed
        // TODO add your handling code here:
        String event_id = "E-";

        // Format Current date as YYMMddhhmmss
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("YYMMddhhmmss");
        String formattedDate = myDateObj.format(myFormatObj);

        // concatonate E-and date in format E-YYMMddhhmmss
        event_id = event_id + formattedDate;

        //write new event ID to the event ID textfield
        eventIdTxt.setText(event_id);
    }//GEN-LAST:event_eventIDGeneratorBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Events().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel creatEventPnl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel dutySignIn;
    private javax.swing.JLabel eventDateLbl;
    private javax.swing.JTextField eventDateTxt;
    private javax.swing.JButton eventIDGeneratorBtn;
    private javax.swing.JTextField eventIdTxt;
    private javax.swing.JLabel eventNameLbl;
    private javax.swing.JTextField eventNameTxt;
    private javax.swing.JLabel eventStartTimeLbl;
    private javax.swing.JTextField eventStartTimeTxt;
    private javax.swing.JTable eventsTbl;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
