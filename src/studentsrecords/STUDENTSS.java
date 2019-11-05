/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsrecords;

import static com.itextpdf.svg.SvgConstants.Tags.SET;
import static com.sun.org.apache.xerces.internal.util.Status.SET;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static jdk.nashorn.internal.runtime.PropertyDescriptor.SET;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import student.record.management.system.Student;


/**
 *
 * @author ndirituedwin
 */
public class STUDENTSS extends javax.swing.JFrame {
Statement stmt;
int number;
  String filename =null;
  PreparedStatement pst;
  Connection conn;
  ResultSet rs;
  int s=0;
   private ImageIcon format = null;
   byte[] person_image = null;
  String sql,name,eng,math,kis,sci,ssc,cmb,date, act,score,average;
  int ro;
  String activity="";
 /* JasperReport jr;
    String report;
    JasperPrint jp;*/
    /**
     * Creates new form STUDENTSS
     */
    public STUDENTSS() {
        initComponents();
        conn=dbconnection.dbconnection();
         showtable();
         showtable2();
          Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");date();time();jDateChooserTerm.setDate(d);
  jButton13.setEnabled(false);
    
    
    
    }
    private void date(){
        Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        jdate.setText(s.format(d));
    }
    private void time(){
        new Timer(0,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 Date d=new Date();
                 SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss:a");
                 jtime.setText(s.format(d));
            }
            
        }).start();
    }
    private void showtable(){
        try{
            String sql="select * from studentss";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
                    }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    private void showtable2(){
        try{
            String sql="SELECT Full_Name, Student_id,Exam, Date, Total_score, Average FROM studentss ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
                    }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }    
    private void transcript(){
        try{
            
            jtranscript.append("Students Results recording system\n"
                    + "==============================\n"
                    +"Student id\t\t" + jlabel1.getText()
                    + "\nFull name\t\t" + txtname.getText()                   
                    + "\nExam\t\t" + cmbexam.getSelectedItem().toString()
                    + "\nDoB\t\t" + ((JTextField) jDateChooserTerm.getDateEditor().getUiComponent()).getText()
                    + "\nEnglish\t\t" + txtpercentage.getText()
                    + "\nMaths\t\t" + txtmath.getText()
                    + "\nKiswahili\t\t" + txtkiswahili.getText()
                    + "\n===========================\n"
                    + "\nSocial &&CRE\t\t" + txtsocial.getText()
                    + "\nTotal score\t\t" + txtscore.getText()
                    + "\nAverage\t\t" + txtaverage.getText()
                    
                   
            );

            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    private void  setenabled(){
        try{
             txtname.setEnabled(true);
            jlabel1.setEnabled(true);
            txtpercentage.setEnabled(true);
            txtmath.setEnabled(true);
             cmbexam.setEnabled(true);
            txtkiswahili.setEnabled(true);
            txtscince2.setEnabled(true);
            txtsocial.setEnabled(true);
            jDateChooserTerm.setEnabled(true);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    private void  setdisabled(){
        try{
             txtname.setEnabled(false);
            jlabel1.setEnabled(false);
            txtpercentage.setEnabled(false);
            txtmath.setEnabled(false);
             cmbexam.setEnabled(false);
            txtkiswahili.setEnabled(false);
            txtscince2.setEnabled(false);
            txtsocial.setEnabled(false);
            jDateChooserTerm.setEnabled(false);
            txtscore.setEnabled(false);
            txtaverage.setEnabled(false);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    private void reset(){
         try{
                cmbexam.setSelectedIndex(0);
                txtname.setText(null);
                jButton13.setText(null);
                txtfullname.setText(null);
                txtmao.setText(null);
                txtenga.setText(null);
                txtswa.setText(null);
                txtsci.setText(null);
                txtsokial.setText(null);
                txttoto.setText(null);
                txtranki.setText(null);
                txtstude.setText(null);
                            jlabel1.setText(null);
                            txtmath.setText(null);
                            txtpercentage.setText(null);
                            txtkiswahili.setText(null);
                            txtscince2.setText(null);
                            txtsocial.setText(null);
                            jimageicon.setIcon(null);
                            txtaverage.setText(null);
                            txtsocial.setText(null);
                            txtpercentage.setText(null);
                            txtcre2.setText(null);
                            txtkis2.setText(null);
                            txtenglish2.setText(null);
                            txtscore.setText(null);
                            txtaverage.setText(null);
                            path.setText(null);
                            act="";    
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
         }
     }
    private void delete(){
           int ro=jTable1.getSelectedRow();
                String va=jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
               int confirmdelete=JOptionPane.showConfirmDialog(null, "Do you really want to delete " +va+ "and all their records ?",  "Delete", JOptionPane.YES_NO_OPTION);
                 if(confirmdelete==0){

                      try{
                          sql="Delete from studentss where Full_Name='"+va+"'";
                 pst=conn.prepareStatement(sql);
                 pst.execute();
                 showtable();

        
             
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex);
         }
                                          }
     }
    private void save(){
         try{
              if(!(act=="me")){
                 
                      pst.setString(1,  txtname.getText());
                      String a=cmbexam.getSelectedItem().toString();
                      pst.setString(2, a);
//                        pst.setString(2,  cmbexam.getSelectedItem().toString());
                    pst.setString(3, ((JTextField) jDateChooserTerm.getDateEditor().getUiComponent()).getText());
                         pst.setString(4,  txtpercentage.getText());                       
                        pst.setString(5,  txtmath.getText());
                        pst.setString(6,  txtkiswahili.getText());
                        pst.setString(7,  txtscince2.getText());
                        pst.setString(8,  txtsocial.getText());
                        pst.setString(9,  txtscore.getText());
                        pst.setString(10,  txtaverage.getText());                  
                         pst.setBytes(11, person_image);
                           sql="INSERT INTO studentss(`Full_Name`,`Exam`,`Date`,`English`,`Maths`,`Kiswahili`,`Science`,`SocialstudiesCRE`,`Total_score`,`Average`,`Image`)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                        pst=conn.prepareStatement(sql);
                          pst.execute();
                          showtable(); 
                           JOptionPane.showMessageDialog(null,"record inserted");
                         
//                            name=txtname.getText();
//                        cmb=cmbexam.getSelectedItem().toString();
//                        date=((JTextField)jDateChooserTerm.getDateEditor().getUiComponent()).getText();
//
//                        eng=txtpercentage.getText();        
//                        math=txtmath.getText();
//                        kis=txtkiswahili.getText();
//                        sci=txtscince2.getText();
//                        ssc=txtsocial.getText();
//                      score=txtscore.getText();
//                      average=txtaverage.getText();

//                        sql="INSERT INTO studentss(`Full_Name`,`Exam`,`Date`,`English`,`Maths`,`Kiswahili`,`Science`,`SocialstudiesCRE`,`Total_score`,`Average`)VALUES('"+name+"','"+cmb+"','"+date+"','"+eng+"','"+math+"','"+kis+"','"+sci+"','"+ssc+"','"+score+"','"+average+"')";
//                        pst=conn.prepareStatement(sql);
//                        pst.execute();
                       
                        }
                 else{
                int ro=jTable1.getSelectedRow();
                String va=jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString();
                   stmt = (Statement) conn.createStatement();
                     name=txtname.getText();
                    cmb=cmbexam.getSelectedItem().toString();
                    date=((JTextField)jDateChooserTerm.getDateEditor().getUiComponent()).getText();
                    eng=txtpercentage.getText();        
                    math=txtmath.getText();
                    kis=txtkiswahili.getText();
                    sci=txtscince2.getText();
                    ssc=txtsocial.getText();
                    txtscore.getText();
                    txtaverage.getText();
                    sql="UPDATE studentss SET `Full_Name`='"+name+"',`Exam`='"+cmb+"',`Date`='"+date+"',`English`='"+eng+"',`Maths`='"+math+"',`Kiswahili`='"+kis+"',`Science`='"+sci+"',`SocialstudiesCRE`='"+ssc+"',`Total_score`='"+score+"',`Average`='"+average+"' WHERE `Student_id`='"+Integer.parseInt(va)+"'";
                      stmt.executeUpdate(sql);
                             showtable();
                             JOptionPane.showMessageDialog(null,"updated");
                          
                         }
          
                    reset();
             
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex);
         }
     }
    private void totalscore(){
        try{
            Double two = Double.parseDouble(txtpercentage.getText());
            Double one = Double.parseDouble(txtmath.getText());
            Double three = Double.parseDouble(txtkiswahili.getText());
            Double four = Double.parseDouble(txtscince2.getText());
            Double five = Double.parseDouble(txtsocial.getText());          
            Double sum = one + two + three + four + five;
            String om = String.valueOf(sum);
            txtscore.setText(om);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "you must fill the fields to get the total");
        }
    }
    private void average(){
        try{
            Double one = Double.parseDouble(txtpercentage.getText());
            Double two = Double.parseDouble(txtmath.getText());
            Double three = Double.parseDouble(txtkiswahili.getText());
            Double four = Double.parseDouble(txtscince2.getText());
            Double five = Double.parseDouble(txtsocial.getText());          
            Double sum = one + two + three + four + five;
            String om = String.valueOf(sum);
            Double average = sum / 5;
            String ave = String.valueOf(average);
            txtaverage.setText(ave);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "you must fill the Total score to get Average");
        }
    }
    private void mouseclicked(){
        
        String rec;
        act="me";
//            act="me";
        int ro=jTable1.getSelectedRow();
        String va=(jTable1.getModel().getValueAt(ro,10).toString());
         try {
            // TODO add your handling code here:
            String sql = "select Image from studentss where Student_Id='" + va + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                byte[] imagedata = rs.getBytes("Image");
                format = new ImageIcon(imagedata);
                jimageicon.setIcon(format);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
        String sql="select*from studentss where `Student_id`='"+Integer.parseInt(va)+"'";
            pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           if(rs.next()){
               name=rs.getString("Full_Name");
               txtname.setText(name);
               rec=rs.getString("Student_id");
               jlabel1.setText(rec);
               cmb=rs.getString("Exam");
               cmbexam.setSelectedItem(cmb);
               Date date=rs.getDate("Date");
               jDateChooserTerm.setDate(date);
               eng=rs.getString("English");
               txtpercentage.setText(eng);
               math=rs.getString("Maths");
               txtmath.setText(math);
                kis=rs.getString("Kiswahili");
               txtkiswahili.setText(kis);
               sci=rs.getString("Science");
               txtscince2.setText(sci);
               ssc=rs.getString("SocialstudiesCRE");
               txtsocial.setText(ssc);
               score=rs.getString("Total_score");
               txtscore.setText(score);
               average=rs.getString("Average");
               txtaverage.setText(average);
               
               
           }
            
    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    } 
    private void mouseclickedtwo(){
        String rec;
//        activity ="d";
//            act="me";
        int ro=jTable2.getSelectedRow();
        String va=(jTable2.getModel().getValueAt(ro,1).toString());
        String sql="SELECT * FROM relranking  where Student_id='"+Integer.parseInt(va)+"'";
      
        try{
            pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           if(rs.next()){
               name=rs.getString("Full_Name");
               txtfullname.setText(name);
               String re=rs.getString("Student_id");
               txtstude.setText(re);
                  String mao=rs.getString("Maths");
               txtmao.setText(mao);
               String enga=rs.getString("English");
               txtenga.setText(enga);
                  String kiswaa=rs.getString("Kiswahili");
               txtswa.setText(kiswaa);
               String sci=rs.getString("Science");
               txtsci.setText(sci);
               String ss=rs.getString("SocialstudiesCRE");
                txtsokial.setText(ss);      
               String toto=rs.getString("Total_score");
               txttoto.setText(toto);
               String ranki=rs.getString("rank");
               txtranki.setText(ranki); 
               
                          }
                
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        txtfullname.setEnabled(false);
         txtmao.setEnabled(false);
         
           txtsci.setEnabled(false);
           txtsokial.setEnabled(false);
           
    }
    private void saving(){
        try{
            if(!(act=="me")){                
               pst.setString(1,  txtname.getText());
                      String a=cmbexam.getSelectedItem().toString();
                      pst.setString(2, a);
//                        pst.setString(2,  cmbexam.getSelectedItem().toString());
                    pst.setString(3, ((JTextField) jDateChooserTerm.getDateEditor().getUiComponent()).getText());
                         pst.setString(4,  txtpercentage.getText());                       
                        pst.setString(5,  txtmath.getText());
                        pst.setString(6,  txtkiswahili.getText());
                        pst.setString(7,  txtscince2.getText());
                        pst.setString(8,  txtsocial.getText());
                        pst.setString(9,  txtscore.getText());
                        pst.setString(10,  txtaverage.getText());                  
                         pst.setBytes(11, person_image);
                         sql="INSERT INTO studentss(`Full_Name`,`Exam`,`Date`,`English`,`Maths`,`Kiswahili`,`Science`,`SocialstudiesCRE`,`Total_score`,`Average`,`Image`)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                        pst=conn.prepareStatement(sql);
                          pst.execute();
                          showtable(); 
                           JOptionPane.showMessageDialog(null,"record inserted");                        
            }
            else{
                  int ro=jTable1.getSelectedRow();
                String va=jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString();
                   stmt = (Statement) conn.createStatement();
                   
                     name=txtname.getText();
                    cmb=cmbexam.getSelectedItem().toString();
                    date=((JTextField)jDateChooserTerm.getDateEditor().getUiComponent()).getText();
                    eng=txtpercentage.getText();        
                    math=txtmath.getText();
                    kis=txtkiswahili.getText();
                    sci=txtscince2.getText();
                    ssc=txtsocial.getText();
                    txtscore.getText();
                    txtaverage.getText();
                    sql="UPDATE studentss SET `Full_Name`='"+name+"',`Exam`='"+cmb+"',`Date`='"+date+"',`English`='"+eng+"',`Maths`='"+math+"',`Kiswahili`='"+kis+"',`Science`='"+sci+"',`SocialstudiesCRE`='"+ssc+"',`Total_score`='"+score+"',`Average`='"+average+"' WHERE `Student_id`='"+Integer.parseInt(va)+"'";
                      stmt.executeUpdate(sql);
                     JOptionPane.showMessageDialog(null,"updated");
                            showtable();
                         
            }
            reset();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    private void savi(){
          try{
                                 if((!(act=="me"))){
                               sql="INSERT INTO studentss(`Full_Name`,`Exam`,`Date`,`English`,`Maths`,`Kiswahili`,`Science`,`SocialstudiesCRE`,`Total_score`,`Average`,`Image`)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                              pst=conn.prepareStatement(sql);
                      pst.setString(1,  txtname.getText());
                      String a=cmbexam.getSelectedItem().toString();
                      pst.setString(2, a);
//                        pst.setString(2,  cmbexam.getSelectedItem().toString());
                    pst.setString(3, ((JTextField) jDateChooserTerm.getDateEditor().getUiComponent()).getText());
                         pst.setString(4,  txtpercentage.getText());                       
                        pst.setString(5,  txtmath.getText());
                        pst.setString(6,  txtkiswahili.getText());
                        pst.setString(7,  txtscince2.getText());
                        pst.setString(8,  txtsocial.getText());
                        pst.setString(9,  txtscore.getText());
                        pst.setString(10,  txtaverage.getText());                  
                         pst.setBytes(11, person_image);
                          pst.execute();
                        JOptionPane.showMessageDialog(null,"record inserted");
                        showtable();  
                         }
                         else {
                                 int ro=jTable1.getSelectedRow();
                String va=jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString();
                   stmt = (Statement) conn.createStatement();
                   
                     name=txtname.getText();
                    cmb=cmbexam.getSelectedItem().toString();
                    date=((JTextField)jDateChooserTerm.getDateEditor().getUiComponent()).getText();
                    eng=txtpercentage.getText();        
                    math=txtmath.getText();
                    kis=txtkiswahili.getText();
                    sci=txtscince2.getText();
                    ssc=txtsocial.getText();
                    txtscore.getText();
                    txtaverage.getText();
                    sql="UPDATE studentss SET `Full_Name`='"+name+"',`Exam`='"+cmb+"',`Date`='"+date+"',`English`='"+eng+"',`Maths`='"+math+"',`Kiswahili`='"+kis+"',`Science`='"+sci+"',`SocialstudiesCRE`='"+ssc+"',`Total_score`='"+score+"',`Average`='"+average+"' WHERE `Student_id`='"+Integer.parseInt(va)+"'";
                     pst=conn.prepareStatement(sql);
                     pst.execute();
//                    stmt.executeUpdate(sql);
                     JOptionPane.showMessageDialog(null,"updated");
                            showtable();
                      
                         }
                                 reset();

                              }catch(Exception ex){
                                JOptionPane.showMessageDialog(this," you must first fill the fields");
                            }  
    }
    private void tabletworanking(){
        try{
            String sql="SELECT * FROM relranking  ORDER by Total_score DESC";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
  
    }
    private void piechart(){
        
    }
     private void jtextareatranscrip(){
    try{
                

        jtranscript1.append("Students Results recording system\n"
          + "==============================\n"
          + "Full_Name\t\t"+txtfullname.getText()
          + "\nStudent_Id\t"+txtstude.getText()
          + "\nMaths\t\t"+txtmao.getText()
          + "\nEnglish\t\t"+txtenga.getText()
          + "\nKiswahili\t\t"+txtswa.getText()
//          + "\nDoB\t\t"+((JTextField)jDateChooserstudents.getDateEditor().getUiComponent()).getText()
          + "\nScience\t\t"+txtsci.getText()
          +"\n===========================\n"
          + "\nSocial Studies/CRE\t"+txtsokial.getText()
          + "\nTotal Score\t\t"+txttoto.getText()
          + "\nRank\t\t"+txtranki.getText()
         
        );
              
       
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex);
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

        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        txtscore = new javax.swing.JTextField();
        txtaverage = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        txtranking2 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtranscript = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        txtcre2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtkis2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtmath = new javax.swing.JTextField();
        txtenglish2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtscince2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        txtpercentage = new javax.swing.JTextField();
        jRadioButton9 = new javax.swing.JRadioButton();
        txtkiswahili = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        txtsocial = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cmbexam = new javax.swing.JComboBox();
        jDateChooserTerm = new com.toedter.calendar.JDateChooser();
        txtname = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jlabel1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        txtsearch2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        path = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jimageicon = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jtarnscript = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txtrownumber = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtranscript1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtsokial = new javax.swing.JTextField();
        txtmao = new javax.swing.JTextField();
        txtsci = new javax.swing.JTextField();
        txtenga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtfullname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtranki = new javax.swing.JTextField();
        txtstude = new javax.swing.JTextField();
        txtswa = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txttoto = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jdate = new javax.swing.JMenu();
        jtime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel24.setBackground(new java.awt.Color(0, 204, 102));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calculations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18), new java.awt.Color(153, 102, 0))); // NOI18N

        txtscore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtscoreActionPerformed(evt);
            }
        });

        jButton25.setText("Total score");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("Average");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Ranking");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton26)
                    .addComponent(jButton27)
                    .addComponent(jButton25))
                .addGap(30, 30, 30)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtaverage, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(txtranking2)
                    .addComponent(txtscore))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27)
                    .addComponent(txtranking2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transcript", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 153, 0))); // NOI18N

        jtranscript.setColumns(20);
        jtranscript.setRows(5);
        jScrollPane10.setViewportView(jtranscript);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 153, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Student subjects", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18), new java.awt.Color(0, 204, 102))); // NOI18N

        jLabel28.setText("Ss &Cre");

        txtkis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkis2ActionPerformed(evt);
            }
        });

        jLabel29.setText("Science %");

        txtenglish2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtenglish2KeyTyped(evt);
            }
        });

        jLabel30.setText("Kiswahili");

        txtscince2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtscince2ActionPerformed(evt);
            }
        });

        jLabel31.setText("English");

        jLabel32.setText("Maths %");

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("%");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        txtpercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpercentageActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton9);
        jRadioButton9.setText("%");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        jButton22.setText("eng");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton10);
        jRadioButton10.setText("%");
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        txtsocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsocialActionPerformed(evt);
            }
        });

        jButton23.setText("kisw");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("ss&cre");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtkis2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtkiswahili))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel32)
                                .addGap(4, 4, 4)
                                .addComponent(txtmath, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(10, 10, 10)
                                .addComponent(txtscince2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton24)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcre2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton10)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtsocial, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton23)
                                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtenglish2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpercentage)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton22)
                .addGap(5, 5, 5)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtenglish2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton8)
                    .addComponent(txtpercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel32))
                    .addComponent(txtmath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtkis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton9)
                    .addComponent(txtkiswahili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel29))
                    .addComponent(txtscince2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButton24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtcre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton10)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtsocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel23);

        jPanel22.setBackground(new java.awt.Color(255, 153, 153));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel23.setText("Reg no");

        cmbexam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Opener", "MidTerm", "EndTerm" }));

        jDateChooserTerm.setDateFormatString("yyyy-MM-dd");

        jLabel24.setText("Exam");

        jLabel25.setText("Date");

        jlabel1.setText("jLabel9");

        jLabel27.setText("Full Name");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(26, 26, 26)
                        .addComponent(jDateChooserTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtname))
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addComponent(jLabel24))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbexam, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jlabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cmbexam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jDateChooserTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel26.setBackground(new java.awt.Color(0, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable1);

        jLabel33.setText("filter/search");

        txtsearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearch2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel33)
                .addGap(33, 33, 33)
                .addComponent(txtsearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtsearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton14.setText("Attach image");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jimageicon.setText("jLabel9");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jimageicon, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jimageicon, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1.setLayer(jimageicon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel17.setBackground(new java.awt.Color(0, 204, 153));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jtarnscript.setText("Transcript");
        jtarnscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtarnscriptActionPerformed(evt);
            }
        });

        jButton17.setText("print");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton6.setText("Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Image");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Piechart");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jtarnscript)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jtarnscript)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jButton14))
                                    .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Recording results", jPanel1);

        jButton5.setText("Ranking");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton11.setText("Print");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Reset");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Transcript");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton10.setText("number of rows:");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 0, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transcript", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 24), new java.awt.Color(102, 0, 102))); // NOI18N

        jtranscript1.setColumns(20);
        jtranscript1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jtranscript1.setForeground(new java.awt.Color(153, 204, 0));
        jtranscript1.setRows(5);
        jScrollPane4.setViewportView(jtranscript1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 102, 102));

        jPanel3.setBackground(new java.awt.Color(0, 153, 51));

        jLabel2.setText("Maths");

        jLabel26.setText("Kiswahili");

        jLabel36.setText("Socialcre");

        txtsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsciActionPerformed(evt);
            }
        });

        jLabel3.setText("English");

        jLabel34.setText("Science");

        txtfullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfullnameActionPerformed(evt);
            }
        });

        jLabel4.setText("Student Id");

        jLabel1.setText("Ful Name");

        txtranki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrankiActionPerformed(evt);
            }
        });

        txtstude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstudeActionPerformed(evt);
            }
        });

        jLabel37.setText("Ranking");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtstude, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(txtenga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(28, 28, 28)
                            .addComponent(txtmao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(28, 28, 28)
                        .addComponent(txtswa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtsokial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel37)
                            .addGap(32, 32, 32)
                            .addComponent(txtranki, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel34)
                            .addGap(25, 25, 25)
                            .addComponent(txtsci, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtmao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(txtenga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel26))
                    .addComponent(txtswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsokial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(txtranki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 153, 0));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton12)
                                .addGap(6, 6, 6)
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jButton10)
                                .addGap(38, 38, 38)
                                .addComponent(txtrownumber, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtrownumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5))))
                        .addGap(209, 209, 209))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton13)
                                .addComponent(jButton11)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("student details", jPanel2);

        jLabel35.setText("Total score");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jdate.setText("Date");
        jMenuBar1.add(jdate);

        jtime.setText("Time");
        jMenuBar1.add(jtime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addGap(17, 17, 17)
                .addComponent(txttoto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtenglish2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtenglish2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtenglish2KeyTyped

    private void txtscince2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtscince2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtscince2ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void txtpercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpercentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpercentageActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
         if(cmbexam.getSelectedIndex()==0){
              float score=Integer.parseInt(txtenglish2.getText());

              if(jRadioButton8.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/30 * 100;
             String xp=String.valueOf(calcpercentage);
             txtpercentage.setText(xp);
                   }
              }
        else if(cmbexam.getSelectedIndex()==1){
            float score=Integer.parseInt(txtenglish2.getText());

              if(jRadioButton8.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/50 * 100;
             String xp=String.valueOf(calcpercentage);
             txtpercentage.setText(xp);
              }
        }
        else if(cmbexam.getSelectedIndex()==2){
             float score=Integer.parseInt(txtenglish2.getText());

              if(jRadioButton8.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/70 * 100;
             String xp=String.valueOf(calcpercentage);
             txtpercentage.setText(xp);
              
        } 
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void txtsocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsocialActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
         if(cmbexam.getSelectedIndex()==0){
              float score=Integer.parseInt(txtkis2.getText());

              if(jRadioButton9.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/30 * 100;
             String xp=String.valueOf(calcpercentage);
             txtkiswahili.setText(xp);
                   }
              }
        else if(cmbexam.getSelectedIndex()==1){
            float score=Integer.parseInt(txtkis2.getText());

              if(jRadioButton9.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/50 * 100;
             String xp=String.valueOf(calcpercentage);
             txtkiswahili.setText(xp);
              }
        }
        else if(cmbexam.getSelectedIndex()==2){
             float score=Integer.parseInt(txtenglish2.getText());

              if(jRadioButton9.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/70 * 100;
             String xp=String.valueOf(calcpercentage);
             txtkiswahili.setText(xp);
              
        } 
        }
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
         if(cmbexam.getSelectedIndex()==0){
              float score=Integer.parseInt(txtcre2.getText());

              if(jRadioButton10.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/30 * 100;
             String xp=String.valueOf(calcpercentage);
             txtsocial.setText(xp);
                   }
              }
        else if(cmbexam.getSelectedIndex()==1){
            float score=Integer.parseInt(txtcre2.getText());

              if(jRadioButton10.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/50 * 100;
             String xp=String.valueOf(calcpercentage);
             txtsocial.setText(xp);
              }
        }
        else if(cmbexam.getSelectedIndex()==2){
             float score=Integer.parseInt(txtcre2.getText());

              if(jRadioButton10.isSelected()==true){
            //             int percentage=Integer.parseInt(txtenglish.getText());
             float calcpercentage=score/70 * 100;
             String xp=String.valueOf(calcpercentage);
             txtsocial.setText(xp);
              
        } 
        }
        
    }//GEN-LAST:event_jButton24ActionPerformed

    private void txtscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtscoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtscoreActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        totalscore();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
       average();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        mouseclicked();
        setdisabled();
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtsearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearch2KeyReleased
        // TODO add your handling code here:
         DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        String search=txtsearch2.getText();
        TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
        
    }//GEN-LAST:event_txtsearch2KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        savi();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setenabled();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtarnscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtarnscriptActionPerformed
        // TODO add your handling code here:
        transcript();
    }//GEN-LAST:event_jtarnscriptActionPerformed

    private void txtkis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkis2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkis2ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
           try {
            // TODO add your handling code here:
            jtranscript.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton17ActionPerformed

    private void txtsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsciActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        tabletworanking();
        jButton13.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        try{                                         
           String report="C:\\Users\\ndirituedwin\\OneDrive\\Documents\\NetBeansProjects\\ORGANIZATIONN\\orgarnization.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
            JasperViewer.viewReport(jp);
            
            
          
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
       filename = f.getAbsolutePath();
        path.setText(filename);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int numbe; (numbe = fis.read(buf)) != -1;) {

                bos.write(buf, 0, numbe);

            }
            person_image = bos.toByteArray();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try{
            String sql="SELECT Image FROM studentss WHERE Student_id=1";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                 byte[] imagedata = rs.getBytes("Image");
                format = new ImageIcon(imagedata);
                jimageicon.setIcon(format);
                
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        try{
            String sql="SELECT COUNT(Student_id) FROM studentss";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String c=rs.getString("COUNT(Student_id)");
                txtrownumber.setText(c);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
  try {
            // TODO add your handling code here:
            jtranscript1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
  jButton13.setEnabled(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
         try{
            String sql="SELECT Full_Name, Student_id,Exam, Date, Total_score, Average FROM studentss ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
reset();
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void txtfullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameActionPerformed

    private void txtrankiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrankiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrankiActionPerformed

    private void txtstudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstudeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstudeActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         jtextareatranscrip();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        mouseclickedtwo();
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(STUDENTSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STUDENTSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STUDENTSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STUDENTSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STUDENTSS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cmbexam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooserTerm;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenu jdate;
    private javax.swing.JLabel jimageicon;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JButton jtarnscript;
    private javax.swing.JMenu jtime;
    private javax.swing.JTextArea jtranscript;
    private javax.swing.JTextArea jtranscript1;
    private javax.swing.JTextField path;
    private javax.swing.JTextField txtaverage;
    private javax.swing.JTextField txtcre2;
    private javax.swing.JTextField txtenga;
    private javax.swing.JTextField txtenglish2;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtkis2;
    private javax.swing.JTextField txtkiswahili;
    private javax.swing.JTextField txtmao;
    private javax.swing.JTextField txtmath;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpercentage;
    private javax.swing.JTextField txtranki;
    private javax.swing.JTextField txtranking2;
    private javax.swing.JTextField txtrownumber;
    private javax.swing.JTextField txtsci;
    private javax.swing.JTextField txtscince2;
    private javax.swing.JTextField txtscore;
    private javax.swing.JTextField txtsearch2;
    private javax.swing.JTextField txtsocial;
    private javax.swing.JTextField txtsokial;
    private javax.swing.JTextField txtstude;
    private javax.swing.JTextField txtswa;
    private javax.swing.JTextField txttoto;
    // End of variables declaration//GEN-END:variables
}
