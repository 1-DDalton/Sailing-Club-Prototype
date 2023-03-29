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



public class DutySignIn extends javax.swing.JFrame {


    
    /**
     * Creates new form Events
     */
    public DutySignIn() {
        initComponents();
        try {
            //table_update();
            EventIDCbo_update();
            memberNameCbo_update();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DutySignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    
    public class Duty {
        //Create a Boat class to help with transferring data database to jTable
        private int duty_id;
        private String duty_name;
        private String event_id;
        private String member_id;
        private String full_name;
        
        public int getDutyID() {
            return duty_id;
        }

        public void setDutyID(int dutyId) {
            this.duty_id = dutyId;
        }

        public String getDutyName() {
            return duty_name;
        }

        public void setDutyName(String dutyName) {
            this.duty_name = dutyName;
        }

        public String getEventId() {
            return event_id;
        }

        public void setEventId(String eventId) {
            this.event_id = eventId;
        }

        public String getMemberId() {
            return member_id;
        }

        public void setMemberId(String memberId) {
            this.member_id = memberId;
        }
        
        public String getFullName() {
            return full_name;
        }

        public void setFullName(String fullName) {
            this.full_name = fullName;
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
    
    private void table_update() throws SQLException, ClassNotFoundException{
        Object eventId = eventIDCbo.getSelectedItem();
        //String eventId = eventIDCbo.getModel().toString();
        //System.out.println("String init");
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8");
            //SELECT Duty_Sign_In.*, Members.Full_Name FROM Duty_Sign_In, Members WHERE Duty_Sign_In.Membership_ID = Duty_Sign_In.Membership_ID
            statement = conn.prepareStatement("SELECT Duty_Sign_In.*, Members.Full_Name FROM Duty_Sign_In, Members WHERE Duty_Sign_In.Membership_ID = Members.Membership_ID AND Event_ID = '"+eventId.toString()+"'");
            //statement = conn.prepareStatement("SELECT * FROM Duty_Sign_In WHERE Event_ID = '"+eventId.toString()+"'");
            ResultSet rs = statement.executeQuery();
            //System.out.println("executed query");
            
                ArrayList<Duty> list = new ArrayList();
                while(rs.next()){         
                    // Create a boat object using the Boat Class
                    //System.out.println("writing to Duty object");
                    Duty duty = new Duty();
                    //Add data to the boat object from the ResultSet
                    duty.setDutyID(rs.getInt("Duty_ID"));
                    duty.setDutyName(rs.getString("Duty_Name"));
                    duty.setEventId(rs.getString("Event_ID"));
                    duty.setMemberId(rs.getString("Membership_ID"));
                    duty.setFullName(rs.getString("Full_Name"));
                    //Add the data from the boat object to the next row of the list object
                    list.add(duty);
                } 

                
                //Add data from array of Boat objects to eventsTbl
                DefaultTableModel model = (DefaultTableModel)dutyTbl.getModel();   
                model.setRowCount(0);    
                //Create a 2 dimensional array with 3 elements
                Object rowData[] = new Object[3];  
                //Fill up the array with the the next row of data from the list
                for(int i = 0; i <list.size(); i++){ 
                        //System.out.println("Writing to jttable");
                        rowData[0] = list.get(i).full_name;
                        rowData[1] = list.get(i).duty_name;
                        rowData[2] = list.get(i).member_id;                        
                        //Add the data from thew array into the next row in eventsTbl via the model
                        model.addRow(rowData);
                    }
            
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("errorMessage"+ ex);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dutySignIn = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dutyTbl = new javax.swing.JTable();
        homeBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dutyCbo = new javax.swing.JComboBox<>();
        eventStartTimeLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        memberNameCbo = new javax.swing.JComboBox<>();
        memberIDTxt = new javax.swing.JTextField();
        memberIDLbl = new javax.swing.JLabel();
        creatEventPnl1 = new javax.swing.JPanel();
        eventNameLbl1 = new javax.swing.JLabel();
        eventDateLbl1 = new javax.swing.JLabel();
        eventStartTimeLbl1 = new javax.swing.JLabel();
        eventNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        eventDateTxt = new javax.swing.JTextField();
        eventStartTimeTxt = new javax.swing.JTextField();
        eventIDCbo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(252, 4, 4));

        dutySignIn.setBackground(new java.awt.Color(252, 4, 4));
        dutySignIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dutySignIn.setForeground(new java.awt.Color(255, 255, 255));
        dutySignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Test/PSCLogoSmall.PNG"))); // NOI18N
        dutySignIn.setText("Duty Sign In");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dutySignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dutySignIn))
        );

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        dutyTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Member Name", "Duty Name", "Member ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dutyTbl.getTableHeader().setReorderingAllowed(false);
        dutyTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dutyTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dutyTbl);
        if (dutyTbl.getColumnModel().getColumnCount() > 0) {
            dutyTbl.getColumnModel().getColumn(0).setResizable(false);
            dutyTbl.getColumnModel().getColumn(1).setResizable(false);
            dutyTbl.getColumnModel().getColumn(2).setResizable(false);
        }

        homeBtn.setText("Back To Home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sign In Here"));

        dutyCbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Officer of the Day", "Race Officer", "Race Officer Assistant", "Patrol Boat Driver", "Patrol Boat Assistant", "Bar" }));
        dutyCbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dutyCboActionPerformed(evt);
            }
        });

        eventStartTimeLbl.setText("Duty");

        jLabel2.setText("Name");

        memberNameCbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        memberNameCbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNameCboActionPerformed(evt);
            }
        });

        memberIDTxt.setEditable(false);
        memberIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIDTxtActionPerformed(evt);
            }
        });

        memberIDLbl.setText("Member ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(eventStartTimeLbl))
                    .addComponent(memberIDLbl))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(memberIDTxt)
                    .addComponent(dutyCbo, 0, 161, Short.MAX_VALUE)
                    .addComponent(memberNameCbo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dutyCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventStartTimeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(memberNameCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberIDLbl))
                .addContainerGap())
        );

        creatEventPnl1.setBorder(javax.swing.BorderFactory.createTitledBorder("Event Details:"));

        eventNameLbl1.setText("Name");

        eventDateLbl1.setText("Date");

        eventStartTimeLbl1.setText("Start Time");

        eventNameTxt.setEditable(false);
        eventNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventNameTxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Event ID");

        eventDateTxt.setEditable(false);
        eventDateTxt.setToolTipText("YYYY-MM-DD");

        eventStartTimeTxt.setEditable(false);
        eventStartTimeTxt.setToolTipText("HH:MM:SS");
        eventStartTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventStartTimeTxtActionPerformed(evt);
            }
        });

        eventIDCbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventIDCboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout creatEventPnl1Layout = new javax.swing.GroupLayout(creatEventPnl1);
        creatEventPnl1.setLayout(creatEventPnl1Layout);
        creatEventPnl1Layout.setHorizontalGroup(
            creatEventPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creatEventPnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(creatEventPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventStartTimeLbl1)
                    .addComponent(eventDateLbl1)
                    .addComponent(eventNameLbl1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(creatEventPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(eventDateTxt)
                    .addComponent(eventStartTimeTxt)
                    .addComponent(eventIDCbo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        creatEventPnl1Layout.setVerticalGroup(
            creatEventPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creatEventPnl1Layout.createSequentialGroup()
                .addGroup(creatEventPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(eventIDCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(creatEventPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventNameLbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creatEventPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventDateLbl1)
                    .addComponent(eventDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creatEventPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventStartTimeLbl1)
                    .addComponent(eventStartTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(deleteBtn)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(creatEventPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(creatEventPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EventIDCbo_update() throws SQLException, ClassNotFoundException{
        try {
                 
            conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8");
            statement = conn.prepareStatement("SELECT Event_ID FROM Events");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) 
            {
                eventIDCbo.addItem(rs.getString("Event_ID"));
     
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DutySignIn.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }    

    private void memberNameCbo_update() throws SQLException, ClassNotFoundException{
        try {
                 
            conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8");
            statement = conn.prepareStatement("SELECT Full_Name FROM Members ORDER BY Full_Name DESC");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) 
            {
                memberNameCbo.addItem(rs.getString("Full_Name"));
     
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DutySignIn.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    } 
    
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // Add record to Duty Sign in table: 
        Object selectedDuty = dutyCbo.getSelectedItem();
        Object selectedEvent = eventIDCbo.getSelectedItem();
        String membershipId = memberIDTxt.getText();
        DataManipulation.addDuty(selectedDuty.toString(), selectedEvent.toString(), membershipId);
        
        
        try {
            table_update();
            JOptionPane.showMessageDialog(this, "Record Added"); 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DutySignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Empty fields for next action
        dutyCbo.setSelectedItem(" ");
        memberNameCbo.setSelectedItem("");
        memberIDTxt.setText("");
        memberNameCbo.requestFocus();
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        new HomePage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        Object selectedDuty = dutyCbo.getSelectedItem();
        Object selectedEvent = eventIDCbo.getSelectedItem();
        String membershipId = memberIDTxt.getText();

        DataManipulation.deleteDuty(selectedDuty.toString(), selectedEvent.toString(), membershipId);   
        
        JOptionPane.showMessageDialog(this, "Record Deleted"); 
        try {
            table_update();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DutySignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Empty fields for next action
        dutyCbo.setSelectedItem(" ");
        memberNameCbo.setSelectedItem("");
        memberIDTxt.setText("");
        memberNameCbo.requestFocus();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void dutyTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dutyTblMouseClicked
        // TODO add your handling code here:
        DefaultTableModel Df = (DefaultTableModel)dutyTbl.getModel();
        int selectedIndex = dutyTbl.getSelectedRow();

        String duty = Df.getValueAt(selectedIndex, 1).toString();
        dutyCbo.setSelectedItem(duty);        
        String memberName = Df.getValueAt(selectedIndex, 0).toString();      
        memberNameCbo.setSelectedItem(memberName);
        memberIDTxt.setText(Df.getValueAt(selectedIndex, 2).toString());

    }//GEN-LAST:event_dutyTblMouseClicked

    private void dutyCboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dutyCboActionPerformed
        // TODO add your handling code here:

                
        
                
        
    }//GEN-LAST:event_dutyCboActionPerformed

    private void eventNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventNameTxtActionPerformed

    private void eventIDCboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventIDCboActionPerformed
    
        Object selectedItem = eventIDCbo.getSelectedItem();
      
        
        try {
                 
            conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8");
            statement = conn.prepareStatement("SELECT Event_Name, Event_Date, Event_Start_Time FROM Events WHERE Event_ID = '"+selectedItem.toString()+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) 
            {
                eventNameTxt.setText(rs.getString("Event_Name"));
                eventDateTxt.setText(rs.getString("Event_Date"));
                eventStartTimeTxt.setText(rs.getString("Event_Start_Time"));     
            }
                   
            table_update();
            
        } catch (SQLException ex) {
            Logger.getLogger(DutySignIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DutySignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_eventIDCboActionPerformed

    private void memberIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberIDTxtActionPerformed

    private void memberNameCboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberNameCboActionPerformed
        // TODO add your handling code here:
        
        Object selectedItem = memberNameCbo.getSelectedItem();
      
        
        try {
                 
            conn = DriverManager.getConnection("jdbc:mysql://computing.gfmat.org:3306/DDalton_SailingClub?user=DDalton&useSSL=true", "DDalton", "7r66JBe3A8");
            statement = conn.prepareStatement("SELECT Membership_ID FROM Members WHERE Full_Name = '"+selectedItem.toString()+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) 
            {
                memberIDTxt.setText(rs.getString("Membership_ID"));

     
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DutySignIn.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        
    }//GEN-LAST:event_memberNameCboActionPerformed

    private void eventStartTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventStartTimeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventStartTimeTxtActionPerformed

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
            java.util.logging.Logger.getLogger(DutySignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DutySignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DutySignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DutySignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DutySignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel creatEventPnl1;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> dutyCbo;
    private javax.swing.JLabel dutySignIn;
    private javax.swing.JTable dutyTbl;
    private javax.swing.JLabel eventDateLbl1;
    private javax.swing.JTextField eventDateTxt;
    private javax.swing.JComboBox<String> eventIDCbo;
    private javax.swing.JLabel eventNameLbl1;
    private javax.swing.JTextField eventNameTxt;
    private javax.swing.JLabel eventStartTimeLbl;
    private javax.swing.JLabel eventStartTimeLbl1;
    private javax.swing.JTextField eventStartTimeTxt;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel memberIDLbl;
    private javax.swing.JTextField memberIDTxt;
    private javax.swing.JComboBox<String> memberNameCbo;
    // End of variables declaration//GEN-END:variables
}
