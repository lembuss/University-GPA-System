/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygpapackage;

import java.sql.*;

/**
 *
 * @author lembuss
 */
public class GUIStudentRecordFrame extends javax.swing.JFrame {

    
    
    public class GlobalConstants{
    
        
    }
    
    /**
     * Creates new form GUIStudentRecordFrame
     */
    public GUIStudentRecordFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameRecords = new javax.swing.JTextField();
        idRecords = new javax.swing.JTextField();
        nocoursesRecords = new javax.swing.JTextField();
        credithoursRecords = new javax.swing.JTextField();
        gpaRecords = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        gradesArea = new javax.swing.JTextArea();
        searchRecords = new javax.swing.JButton();
        clearRecords = new javax.swing.JButton();
        backRecords = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Records");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Student Name: ");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Number of Courses:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Student ID:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Credit Hours:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Term GPA:");

        idRecords.setText("search here....");

        gradesArea.setColumns(20);
        gradesArea.setRows(5);
        jScrollPane2.setViewportView(gradesArea);

        searchRecords.setText("Search");
        searchRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRecordsActionPerformed(evt);
            }
        });

        clearRecords.setText("Clear Fields");
        clearRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearRecordsActionPerformed(evt);
            }
        });

        backRecords.setText("Back");
        backRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backRecordsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameRecords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idRecords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(credithoursRecords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gpaRecords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nocoursesRecords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(searchRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(clearRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(nameRecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nocoursesRecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(idRecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(credithoursRecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(gpaRecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchRecords)
                    .addComponent(clearRecords)
                    .addComponent(backRecords))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRecordsActionPerformed
        // TODO add your handling code here:
        String id, name;
        
        gradesArea.setText(null);
        
        GUIStudentRecordFrame gsrfObject = new GUIStudentRecordFrame();
        
        id = idRecords.getText();
        
        name = studentSearch(id);
        nameRecords.setText(name);
        
//        double inter = gsrfObject.gradeSearch(id);
//        gpa = String.format("%.2f", inter);
        double[] result = new double[3];
        result = gradeSearch(id);
        
        double gpa = result[0];
        double credsTotal = result[2];
        double courseCount = result[1];
        
        gpaRecords.setText(String.format("%.2f", gpa));
        
        credithoursRecords.setText(String.format("%.2f", credsTotal));
        
        nocoursesRecords.setText(String.format("%.1f", courseCount));
        
        int count = (int) courseCount;
        
        String[] courses = new String[count];
        
        courses = courseSearch(id, count);
        
        String courseTitle = "Course Code\tCourse Name\tCredits\tGrade\n";
        
        gradesArea.append(courseTitle);
        for(int i = 0; i < courses.length; i++){
            gradesArea.append(courses[i]);
            gradesArea.append("\n");
        }

    }//GEN-LAST:event_searchRecordsActionPerformed

    private void clearRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearRecordsActionPerformed
        // TODO add your handling code here:
        nameRecords.setText(null);
        idRecords.setText("Search here...");
        nocoursesRecords.setText(null);
        gpaRecords.setText(null);
        credithoursRecords.setText(null);
        gradesArea.setText(null);
    }//GEN-LAST:event_clearRecordsActionPerformed

    private void backRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backRecordsActionPerformed
        // TODO add your handling code here:
        GUIChoiceFrame gcFrame = new GUIChoiceFrame();
        
        this.dispose();
        gcFrame.setVisible(true);
    }//GEN-LAST:event_backRecordsActionPerformed

    public String studentSearch(String idQuery){
        String searchQuery = idQuery;
        GUIStudentRecordFrame gsrfObject = new GUIStudentRecordFrame();
        
        String studentName = null;
        Connection conn = null;
        Statement stmt = null;
        
        try{
            String myUrl = "jdbc:mysql://localhost:3306/student_info";
            String myDriver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(myDriver).newInstance();
          
            conn = DriverManager.getConnection(myUrl, "root", "");
            
            String query = "SELECT `name` FROM `Student Information` WHERE "
                    + "`studentid` = " + searchQuery + "";
            
           
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                studentName = rs.getString("name");
//                nameRecords.setText(studentName);
                System.out.print(studentName);
            }

            conn.close();
            
        }catch(SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException se){
            //Handle errors for JDBC

        }
        
        return studentName;
    }
    
    public double gpaCalculation(double points, double credits){
        double gpa = 0;
        gpa = points / credits;
        
        return gpa;
    }
    
    public double[] gradeSearch(String idQuery){
        
        String courseCode;
        String courseName ;
        String credits ;
        String grade   ;
        String gradePoints ;

        int courseCount = 0;
        double gps, creds, gpa;
        double gpsTotal = 0, credsTotal = 0;    
        String courseData; 
        String tableName = idQuery;
        GUIStudentRecordFrame gsrfObject = new GUIStudentRecordFrame();
       
        Connection conn = null;
        Statement stmt = null;
        
        try{
            String myUrl = "jdbc:mysql://localhost:3306/student_info";
            String myDriver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(myDriver).newInstance();
          
            conn = DriverManager.getConnection(myUrl, "root", "");
            
            String query = "SELECT `coursecode`, `coursename`, `credits`, "
                    + "`grade`, `gradepoints` FROM `"+tableName+"`";
            
           
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                courseCode = rs.getString("coursecode");
                courseName = rs.getString("coursename");
                credits = rs.getString("credits");
                grade   = rs.getString("grade");
                gradePoints = rs.getString("gradepoints");
                
                courseData = courseCode + "\t" + courseName + "\t\t" + credits 
                        + "\t" + grade;
                
//                courses.add(courseData);
                
                
                courseCount ++;
                creds = Double.valueOf(credits);
                gps = Double.valueOf(gradePoints);
                
                
                credsTotal += creds;
                gpsTotal += gps;
            }

            conn.close();
            
            
        }catch(SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException se){
            //Handle errors for JDBC

        }
//        gradesArea.append(courses);
        
        gpa = gsrfObject.gpaCalculation(gpsTotal, credsTotal);
        double[] result = new double[3];
        
        result[0] = gpa;
        result[1] = (double) courseCount;
        result[2] = credsTotal;
        
        return result;
    }
    
    public String[] courseSearch(String idQuery, int number){
        
        String[] courses = new String[number];
        
        String courseCode;
        String courseName ;
        String credits ;
        String grade   ;
        String gradePoints ;

        int courseCount = 0;
        double gps, creds, gpa;
        double gpsTotal = 0, credsTotal = 0;    
        String courseData; 
        String tableName = idQuery;
        GUIStudentRecordFrame gsrfObject = new GUIStudentRecordFrame();
       
        Connection conn = null;
        Statement stmt = null;
        
        try{
            String myUrl = "jdbc:mysql://localhost:3306/student_info";
            String myDriver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(myDriver).newInstance();
          
            conn = DriverManager.getConnection(myUrl, "root", "");
            
            String query = "SELECT `coursecode`, `coursename`, `credits`, "
                    + "`grade`, `gradepoints` FROM `"+tableName+"`";
            
           
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                courseCode = rs.getString("coursecode");
                courseName = rs.getString("coursename");
                credits = rs.getString("credits");
                grade   = rs.getString("grade");
                gradePoints = rs.getString("gradepoints");
                
                courseData = courseCode + "\t" + courseName + "\t" + credits 
                        + "\t" + grade;
                
                courses[courseCount] = courseData;
                
                courseCount ++ ; 
            }

            conn.close();
            
            
        }catch(SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException se){
            //Handle errors for JDBC

        }
        
        return courses;
    }
    
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
            java.util.logging.Logger.getLogger(GUIStudentRecordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIStudentRecordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIStudentRecordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIStudentRecordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIStudentRecordFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backRecords;
    private javax.swing.JButton clearRecords;
    private javax.swing.JTextField credithoursRecords;
    private javax.swing.JTextField gpaRecords;
    private javax.swing.JTextArea gradesArea;
    private javax.swing.JTextField idRecords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameRecords;
    private javax.swing.JTextField nocoursesRecords;
    private javax.swing.JButton searchRecords;
    // End of variables declaration//GEN-END:variables
}
