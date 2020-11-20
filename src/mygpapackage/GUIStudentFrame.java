/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygpapackage;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList; 
import javax.swing.JOptionPane;

/**
 *
 * @author lembuss
 */
public class GUIStudentFrame extends javax.swing.JFrame {

    /**
     * Creates new form GUIFrame
     */
    
    public GUIStudentFrame() {
        initComponents();
        
        addButton.setVisible(false);
        // section of the constructor is to update the combo with valid courses
        ArrayList<String> courses = new ArrayList<>();
        ArrayList<String> coursecodes = new ArrayList<>();
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            String myUrl = "jdbc:mysql://localhost:3306/student_info";
            String myDriver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(myDriver).newInstance();
          
            conn = DriverManager.getConnection(myUrl, "root", "");
            
            String query = "SELECT `name`, `number`, `hours` FROM `Course Information`";
            
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
                      
            while(rs.next()){
                //Retrieve by column name
                String courseName = rs.getString("name");
                String courseNumber = rs.getString("number");
                String courseHours = rs.getString("hours");

                //Display values
                String course = courseNumber + ": " + courseName + ", "+ courseHours;
                courses.add(course);
                comboCourseName.addItem(courseName);
                comboCourseCode.addItem(courseNumber);
             }
            
//            System.out.println(courses);
            
        }catch(SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException se){
            //Handle errors for JDBC

        }
        //Handle errors for Class.forName
        
    }
    
    static double calculateGPV(String credithours, String grade){
        double gradepointValue = 0.0, gradepoints, credits;
        
        switch(grade){
            case "A":
                gradepointValue = 4.0;
                break;
            case "A-":
                gradepointValue = 3.7;
                break;
            case "B+":
                gradepointValue = 3.3;
                break;
            case "B":
                gradepointValue = 3.0;
                break;
            case "B-":
                gradepointValue = 2.7;
                break;
            case "C+":
                gradepointValue = 2.3;
                break;
            case "C":
                gradepointValue = 2.0;
                break;
            case "C-":
                gradepointValue = 1.7;
                break;
            case "D+":
                gradepointValue = 1.3;
                break;
            case "D":
                gradepointValue = 1.0;
                break;
            case "D-":
                gradepointValue = 0.7;
                break;
            case "F":
                gradepointValue = 0.0;
                break;
            case "P*":
                gradepointValue = 0.7;
                break;
            default:
//                JOptionPane.showMessageDialog(this,"Grade Input Error");
                break;
        }
        
        credits = Double.valueOf(credithours);
        gradepoints = gradepointValue * credits;
        
        return gradepoints;
    }

    public void resultTable(String id, String coursename, String coursecode, String credithours, String grade){
        Connection conn = null; 
        Statement stmt = null;
        
        GUIStudentFrame gsfObject = new GUIStudentFrame();
        
        double gpoints = gsfObject.calculateGPV(credithours, grade);
        String gradepoints = String.valueOf(gpoints);
        
        String tableName = id;
        
        try {
            String myUrl = "jdbc:mysql://localhost:3306/student_info";
            String myDriver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(myDriver).newInstance();
          
            conn = DriverManager.getConnection(myUrl, "root", "");
            
            String tQuery = "CREATE TABLE `" + tableName + "` " 
                                +"(id INTEGER not NULL auto_increment, " 
                                +" coursecode VARCHAR(255), " 
                                +" coursename VARCHAR(255), "  
                                +" credits VARCHAR(255), "
                                +" grade VARCHAR(255), "
                                +" gradepoints VARCHAR(255), "
                                +" PRIMARY KEY ( id ))"; 
            
            String query = "INSERT INTO `" + tableName + "` (`id`, `coursecode`, "
                    + "`coursename`, `credits`, `grade`, `gradepoints`) "
                    + "VALUES (null, ?, ?, ?, ?, ?)";
            // create table 
            stmt = conn.createStatement();
            stmt.executeUpdate(tQuery);
            

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, coursecode);
            preparedStmt.setString (2, coursename);
            preparedStmt.setString (3, credithours);
            preparedStmt.setString (4, grade);
            preparedStmt.setString (5, gradepoints);
            
            
             // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
            
            
            
            JOptionPane.showMessageDialog(this,"Course Input successful. Add more courses or click Advance");
            
            

      
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GUIStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTable(String id, String coursename, String coursecode, String credithours, String grade){
        Connection conn = null; 
        Statement stmt = null;
        
        GUIStudentFrame gsfObject = new GUIStudentFrame();
        
        double gpoints = gsfObject.calculateGPV(credithours, grade);
        String gradepoints = String.valueOf(gpoints);
        
        String tableName = id;
        
        try {
            String myUrl = "jdbc:mysql://localhost:3306/student_info";
            String myDriver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(myDriver).newInstance();
          
            conn = DriverManager.getConnection(myUrl, "root", "");
            
            String query = "INSERT INTO `" + tableName + "` (`id`, `coursecode`, "
                    + "`coursename`, `credits`, `grade`, `gradepoints`) "
                    + "VALUES (null, ?, ?, ?, ?, ?)";
            // create table 
            stmt = conn.createStatement();
            

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, coursecode);
            preparedStmt.setString (2, coursename);
            preparedStmt.setString (3, credithours);
            preparedStmt.setString (4, grade);
            preparedStmt.setString (5, gradepoints);
            
            
             // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
            
    
            
            JOptionPane.showMessageDialog(this,"Course Input successful. Add more courses or click Advance");
            
            

      
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GUIStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dataInput(String name, String id, String gpa){
      
        Connection conn = null; 
        
        
        try {
            String myUrl = "jdbc:mysql://localhost:3306/student_info";
            String myDriver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(myDriver).newInstance();
          
            conn = DriverManager.getConnection(myUrl, "root", "");
            
            
            String query = "INSERT INTO `Student Information`(`id`, `name`, "
                    + "`studentid`, `gpa`) VALUES (null, ?, ?, ?)";
        
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, id);
            preparedStmt.setString (3, gpa);
            
            
             // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
            
//            JOptionPane.showMessageDialog(this,"Course Input successful."); 

      
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GUIStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        studentIDLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        credithoursField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        gradeField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboCourseName = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboCourseCode = new javax.swing.JComboBox<>();
        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        advanceButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboCourses = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Component");

        nameLabel.setText("Name: ");

        studentIDLabel.setText("Student ID:");

        jLabel1.setText("Credit Hours: ");

        credithoursField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credithoursFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Letter Grade: ");

        jLabel4.setText("Course:");

        comboCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Course Code:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentIDLabel)
                    .addComponent(nameLabel)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gradeField)
                    .addComponent(credithoursField)
                    .addComponent(comboCourseName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameField)
                    .addComponent(idField)
                    .addComponent(comboCourseCode, 0, 201, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(credithoursField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        titleLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        titleLabel.setText("Student Information Input");

        jLabel2.setText("Fill in the form below.");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        advanceButton.setText("Advance");
        advanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advanceButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Courses Enrolled: ");

        comboCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCoursesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(comboCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboCourses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        addButton.setText("Add Course");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(submitButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton)
                        .addGap(33, 33, 33)
                        .addComponent(advanceButton)
                        .addGap(27, 27, 27)
                        .addComponent(backButton)
                        .addGap(32, 32, 32)
                        .addComponent(addButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(advanceButton)
                    .addComponent(clearButton)
                    .addComponent(submitButton)
                    .addComponent(addButton))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        String name, id, gpa, course, credithours, grade, coursecode;
        
        gpa = "";
        
        name = nameField.getText();
        id = idField.getText();
        course = (String) comboCourseName.getSelectedItem();
        coursecode = (String) comboCourseCode.getSelectedItem();
        credithours = credithoursField.getText();
        grade = gradeField.getText();
        
        GUIStudentFrame gsfObject = new GUIStudentFrame();
        gsfObject.dataInput(name, id, gpa);
        
        gsfObject.resultTable(id, course, coursecode, credithours, grade);
        
        gsfObject.invalidate();
        gsfObject.validate();
        gsfObject.repaint();
        String courseUpdate = (String) comboCourseName.getSelectedItem();
        comboCourses.addItem(courseUpdate);
        nameField.setText(name);
        idField.setText(id);
        gradeField.setText(null);
        credithoursField.setText(null);
        addButton.setVisible(true);
        submitButton.setVisible(false);
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        GUIStudentFrame gsfObject = new GUIStudentFrame();
        
        gsfObject.invalidate();
        gsfObject.validate();
        gsfObject.repaint();
        
        nameField.setText(null);
        idField.setText(null);
        gradeField.setText(null);
        credithoursField.setText(null);
        comboCourses.removeAllItems();
        addButton.setVisible(false);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        GUIChoiceFrame gchFrame = new GUIChoiceFrame();
       
        this.dispose();
        gchFrame.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void comboCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCourseNameActionPerformed

    private void credithoursFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credithoursFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_credithoursFieldActionPerformed

    private void comboCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCoursesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCoursesActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String name, id, gpa, course, credithours, grade, coursecode;
        
        gpa = "";
        
        name = nameField.getText();
        id = idField.getText();
        course = (String) comboCourseName.getSelectedItem();
        coursecode = (String) comboCourseCode.getSelectedItem();
        credithours = credithoursField.getText();
        grade = gradeField.getText();
        
        GUIStudentFrame gsfObject = new GUIStudentFrame();
        
        gsfObject.updateTable(id, course, coursecode, credithours, grade);
        
        gsfObject.invalidate();
        gsfObject.validate();
        gsfObject.repaint();
        String courseUpdate = (String) comboCourseName.getSelectedItem();
        comboCourses.addItem(courseUpdate);
        nameField.setText(name);
        idField.setText(id);
        gradeField.setText(null);
        credithoursField.setText(null);
//        addButton.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void advanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advanceButtonActionPerformed
        // TODO add your handling code here:
        GUIStudentRecordFrame gsrFrame = new GUIStudentRecordFrame();
        this.dispose();
        gsrFrame.setVisible(true);
    }//GEN-LAST:event_advanceButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUIStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
 
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIStudentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton advanceButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox<String> comboCourseCode;
    private javax.swing.JComboBox<String> comboCourseName;
    private javax.swing.JComboBox<String> comboCourses;
    private javax.swing.JTextField credithoursField;
    private javax.swing.JTextField gradeField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
