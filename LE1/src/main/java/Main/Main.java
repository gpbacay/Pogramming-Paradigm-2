/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Classes.HealthWorker;
import Classes.HealthWorkerCRUD;
import static Classes.HealthWorkerCRUD.AccountList;
import Classes.MainCRUD;
import static Classes.MainCRUD.PatientList;
import Classes.Patient;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gianne Bacay
 */
public class Main extends javax.swing.JFrame {

    private String LoggedAcc;
    
    public Main() {
        initComponents();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        String formattedDate = dateFormat.format(new Date());
        dateLabel.setText(formattedDate);

        LoggedAcc = "";
        HealthWorkerCRUD.Populate_Database();
        MainCRUD.PopulateDatabase();
        PopulateTable();
        
        L0LoginPage.setVisible(true);
        L1Dashboard.setVisible(false);
        L2Database.setVisible(false);
        L3About.setVisible(false);
        
        
        jComboBox1.setSelectedIndex(0);
        
        jTable1.setRowSelectionInterval(0, 0);
        int selectedRow = jTable1.getSelectedRow();
        String Id = jTable1.getValueAt(selectedRow, 0).toString();
        String Name = jTable1.getValueAt(selectedRow, 1).toString();
        String VaccineName = jTable1.getValueAt(selectedRow, 5).toString();
        String DateGiven = jTable1.getValueAt(selectedRow, 7).toString();
        String NextDoseDate = jTable1.getValueAt(selectedRow, 9).toString();
        String VaccineType = jTable1.getValueAt(selectedRow, 6).toString();
        String AdministeredBy = jTable1.getValueAt(selectedRow, 8).toString();
        String Allergies = jTable1.getValueAt(selectedRow, 10).toString();
        String Reactions = jTable1.getValueAt(selectedRow, 11).toString();
        jLabel23.setText(Id);
        jLabel12.setText(Name);
        jLabel15.setText(VaccineName);
        jLabel16.setText(DateGiven);
        jLabel17.setText(NextDoseDate);
        jLabel19.setText(VaccineType);
        jLabel20.setText(AdministeredBy);
        jTextArea1.setText(Allergies);
        jTextArea3.setText(Reactions);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        
        //Table Sorter
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(sorter);
        jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }
            private void filter() {
                String text = jTextField1.getText();
                int columnIndex = jComboBox1.getSelectedIndex();
                if (text.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
                }
            }
        });

    }
    
    //Populate Table
    public static void PopulateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //Patient_List into patientTable
        for (Patient patient : PatientList) {
            int ID = patient.getID();
            String Name = patient.getName();
            String Address = patient.getAddress();
            String Age = patient.getAge();
            String Sex = patient.getSex();
            String VaccineName = patient.getVaccineName();
            String VaccineType = patient.getVaccineType();
            String DateGiven = patient.getDateGiven();
            String AdministeredBy = patient.getAdministeredBy();
            String NextDoseDate = patient.getNextDoseDate();
            String Allergies = patient.getAllergies();
            String Reactions = patient.getReactions();
                
            model.addRow(new Object[]{String.format("%06d", ID), Name, Address, Age, Sex, VaccineName, VaccineType, DateGiven, AdministeredBy, NextDoseDate, Allergies, Reactions});
        }
    }
    
    public static void PopulateTable1() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //Patient_List into patientTable
        for (Patient patient : PatientList) {
            int ID = patient.getID();
            String Name = patient.getName();
            String Address = patient.getAddress();
            String Age = patient.getAge();
            String Sex = patient.getSex();
            
            model.addRow(new Object[]{String.format("%06d", ID), Name, Address, Age, Sex});
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

        LoadingScreen = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        L0LoginPage = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        L1Dashboard = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        L2Database = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        L3About = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Logging in...");
        jLabel10.setAlignmentY(0.0F);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setVerifyInputWhenFocusTarget(false);

        jProgressBar1.setForeground(new java.awt.Color(102, 102, 255));
        jProgressBar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LoadingScreenLayout = new javax.swing.GroupLayout(LoadingScreen);
        LoadingScreen.setLayout(LoadingScreenLayout);
        LoadingScreenLayout.setHorizontalGroup(
            LoadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoadingScreenLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(LoadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        LoadingScreenLayout.setVerticalGroup(
            LoadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoadingScreenLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(860, 510));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane2.setMaximumSize(new java.awt.Dimension(860, 510));
        jLayeredPane2.setMinimumSize(new java.awt.Dimension(860, 510));
        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L0LoginPage.setMaximumSize(new java.awt.Dimension(860, 510));
        L0LoginPage.setMinimumSize(new java.awt.Dimension(860, 510));
        L0LoginPage.setPreferredSize(new java.awt.Dimension(860, 510));
        L0LoginPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Account ID:");
        L0LoginPage.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 90, 20));

        ID.setText("000000");
        ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        L0LoginPage.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 230, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Authentication Passcode:");
        L0LoginPage.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 180, -1));

        Password.setText("admin1");
        Password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        L0LoginPage.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 230, 30));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("Login");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        L0LoginPage.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 410, 80, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\BARANGAY CHILD HEALTH MONITORING (7).png")); // NOI18N
        L0LoginPage.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        jLayeredPane2.add(L0LoginPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        L1Dashboard.setMaximumSize(new java.awt.Dimension(860, 510));
        L1Dashboard.setMinimumSize(new java.awt.Dimension(860, 510));
        L1Dashboard.setPreferredSize(new java.awt.Dimension(860, 510));
        L1Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(242, 242, 242));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DASHBOARD");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 30));

        jButton2.setBackground(new java.awt.Color(242, 242, 242));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DATABASE");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, 40));

        jButton4.setBackground(new java.awt.Color(242, 242, 242));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ABOUT");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 20));

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\icons8-update-16.png")); // NOI18N
        jButton5.setText("Update");
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 70, 20));

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\icons8-remove-16.png")); // NOI18N
        jButton6.setText("Remove");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setIconTextGap(6);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 70, 20));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 180, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Address", "Age", "Sex", "Vaccine" }));
        jComboBox1.setBorder(null);
        jComboBox1.setName(""); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 90, 20));

        jTable1.setBackground(new java.awt.Color(102, 102, 255));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "Age", "Sex", "Vaccine", "Type", "Date Given", "Administered By", "Next Dose Date", "Allergies", "Reactions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 51));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTable1HierarchyChanged(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        L1Dashboard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 610, 190));

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\icons8-back-21.png")); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\icons8-add-16 (2).png")); // NOI18N
        jButton21.setText("Add");
        jButton21.setAlignmentY(0.0F);
        jButton21.setBorderPainted(false);
        jButton21.setContentAreaFilled(false);
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton21.setIconTextGap(3);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        L1Dashboard.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, 20));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 230, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Vaccine:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Date Given:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 79, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Next Dose Date:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 100, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 80, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Type:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 31, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 75, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Administered By:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 112, 20));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 105, 20));

        jLabel23.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("000000");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 20));

        jTabbedPane1.addTab("Medical Details", jPanel2);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Allergies:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Reactions:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jTextArea1.setSelectionColor(new java.awt.Color(255, 153, 0));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setBorder(null);
        jTextArea3.setFocusable(false);
        jTextArea3.setSelectionColor(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextArea3)
                    .addComponent(jTextArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jTabbedPane1.addTab("Notes", jPanel1);

        L1Dashboard.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 310, 140));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Current Date:");
        L1Dashboard.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, 20));

        dateLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        L1Dashboard.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 140, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\Dashboard (11).png")); // NOI18N
        L1Dashboard.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 510));

        jLayeredPane2.setLayer(L1Dashboard, javax.swing.JLayeredPane.POPUP_LAYER);
        jLayeredPane2.add(L1Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, -1, -1));

        L2Database.setBackground(new java.awt.Color(255, 255, 255));
        L2Database.setMaximumSize(new java.awt.Dimension(860, 510));
        L2Database.setMinimumSize(new java.awt.Dimension(860, 510));
        L2Database.setPreferredSize(new java.awt.Dimension(860, 510));
        L2Database.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton12.setBackground(new java.awt.Color(242, 242, 242));
        jButton12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("DASHBOARD");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setOpaque(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        L2Database.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 30));

        jButton14.setBackground(new java.awt.Color(242, 242, 242));
        jButton14.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("DATABASE");
        jButton14.setBorder(null);
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setOpaque(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        L2Database.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, 40));

        jButton15.setBackground(new java.awt.Color(242, 242, 242));
        jButton15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("ABOUT");
        jButton15.setBorder(null);
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setOpaque(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        L2Database.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 130, 40));

        jButton22.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\icons8-back-21.png")); // NOI18N
        jButton22.setBorderPainted(false);
        jButton22.setContentAreaFilled(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        L2Database.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 153, 51));
        jButton3.setText("Authorized Health Workers");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        L2Database.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 280, 30));

        jButton13.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 153, 0));
        jButton13.setText("Immunized Child Records");
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        L2Database.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 260, 30));

        jButton16.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\icons8-open-16.png")); // NOI18N
        jButton16.setToolTipText("Open");
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        L2Database.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 40, 20));

        jButton18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\icons8-open-16.png")); // NOI18N
        jButton18.setToolTipText("Open");
        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        L2Database.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 40, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\about (2).png")); // NOI18N
        L2Database.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLayeredPane2.add(L2Database, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, -1));

        L3About.setMaximumSize(new java.awt.Dimension(860, 510));
        L3About.setMinimumSize(new java.awt.Dimension(860, 510));
        L3About.setPreferredSize(new java.awt.Dimension(860, 510));
        L3About.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("DASHBOARD");
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        L3About.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));

        jButton10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("DATABASE");
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        L3About.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, 40));

        jButton11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("ABOUT");
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        L3About.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 130, 40));

        jButton24.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\icons8-back-21.png")); // NOI18N
        jButton24.setBorderPainted(false);
        jButton24.setContentAreaFilled(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        L3About.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\about.png")); // NOI18N
        L3About.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLayeredPane2.add(L3About, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(true);
        L2Database.setVisible(false);
        L3About.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(false);
        L2Database.setVisible(true);
        L3About.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(false);
        L2Database.setVisible(false);
        L3About.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        try {
            try (FileWriter fileWriter = new FileWriter("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Databases\\Patients.csv")) {   
                // Write the data rows
                for (int row = 0; row < rowCount; row++) {
                    for (int column = 0; column < columnCount; column++) {
                        Object cellValue = model.getValueAt(row, column);
                        fileWriter.append(cellValue.toString());
                        if (column < columnCount - 1) {
                            fileWriter.append(",");
                        } else {
                            fileWriter.append("\n");
                        }
                    }
                }fileWriter.flush();
                 // Display a message or perform any other necessary actions after saving
                 JOptionPane.showMessageDialog(null, "Records successfully updated!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmation == JOptionPane.YES_OPTION) {
                LoadingScreen.setVisible(false);
                L0LoginPage.setVisible(true);
                L1Dashboard.setVisible(false);
                L2Database.setVisible(false);
                L3About.setVisible(false);
            }
            else {}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (ID.getText().isEmpty() || Password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
        else {
            String identification = ID.getText().trim();
            String password = Password.getText().trim();
            
            
            for (HealthWorker hW : AccountList) {
                System.out.println(String.valueOf(hW.getID()));
                if(identification.equalsIgnoreCase(String.format("%06d",hW.getID())) && password.equalsIgnoreCase(hW.getPassword())) {
                    LoggedAcc = hW.getName();
                    
                    L0LoginPage.setVisible(false);
                    L1Dashboard.setVisible(true);
                    L2Database.setVisible(false);
                    L3About.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Account not found! Access denied!");
                    ID.setText("");
                    Password.setText("");
                }
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this,
                "No row is selected! Please select one row",
                "Select row",
                JOptionPane.ERROR_MESSAGE);
        } else {
            if (row >= 0 && row < PatientList.size()) {
                PatientList.remove(row);
            } else {}
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.removeRow(row);
                    
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();

            try {
                try (FileWriter fileWriter = new FileWriter("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Databases\\Patients.csv")) {
                    // Write the data rows
                    for (row = 0; row < rowCount; row++) {
                        for (int column = 0; column < columnCount; column++) {
                            Object cellValue = model.getValueAt(row, column);
                            fileWriter.append(cellValue.toString());
                            if (column < columnCount - 1) {
                                fileWriter.append(",");
                            } else {
                                fileWriter.append("\n");
                            }
                        }
                    }fileWriter.flush();
                    // Display a message or perform any other necessary actions after saving
                    JOptionPane.showMessageDialog(null, "Record successfully deleted!");
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(true);
        L2Database.setVisible(false);
        L3About.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(false);
        L2Database.setVisible(true);
        L3About.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(false);
        L2Database.setVisible(false);
        L3About.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(true);
        L2Database.setVisible(false);
        L3About.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(false);
        L2Database.setVisible(true);
        L3About.setVisible(false);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        LoadingScreen.setVisible(false);
        L0LoginPage.setVisible(false);
        L1Dashboard.setVisible(false);
        L2Database.setVisible(false);
        L3About.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String prevID = (String) model.getValueAt(model.getRowCount()-1, 0);
        Patient patientToAdd = new Patient(Integer.parseInt(String.format("%06d", Integer.parseInt(prevID) +01)),null, null, null, null, null, null, null, LoggedAcc, null, null, null);
        PatientList.add(patientToAdd);
        model.addRow(new Object[]{String.format("%06d", Integer.parseInt(prevID) +01),null, null, null, null, null, null, null, LoggedAcc, null, null, null});
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        String Id = jTable1.getValueAt(selectedRow, 0).toString();
        String Name = jTable1.getValueAt(selectedRow, 1).toString();
        String VaccineName = jTable1.getValueAt(selectedRow, 5).toString();
        String DateGiven = jTable1.getValueAt(selectedRow, 7).toString();
        String NextDoseDate = jTable1.getValueAt(selectedRow, 9).toString();
        String VaccineType = jTable1.getValueAt(selectedRow, 6).toString();
        String AdministeredBy = jTable1.getValueAt(selectedRow, 8).toString();
        String Allergies = jTable1.getValueAt(selectedRow, 10).toString();
        String Reactions = jTable1.getValueAt(selectedRow, 11).toString();
        jLabel23.setText(Id);
        jLabel12.setText(Name);
        jLabel15.setText(VaccineName);
        jLabel16.setText(DateGiven);
        jLabel17.setText(NextDoseDate);
        jLabel19.setText(VaccineType);
        jLabel20.setText(AdministeredBy);
        jTextArea1.setText(Allergies);
        jTextArea3.setText(Reactions);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmation == JOptionPane.YES_OPTION) {
                LoadingScreen.setVisible(false);
                L0LoginPage.setVisible(true);
                L1Dashboard.setVisible(false);
                L2Database.setVisible(false);
                L3About.setVisible(false);
            }
            else {}
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmation == JOptionPane.YES_OPTION) {
                LoadingScreen.setVisible(false);
                L0LoginPage.setVisible(true);
                L1Dashboard.setVisible(false);
                L2Database.setVisible(false);
                L3About.setVisible(false);
            }
            else {}
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        String Id = jTable1.getValueAt(selectedRow, 0).toString();
        String Name = jTable1.getValueAt(selectedRow, 1).toString();
        String VaccineName = jTable1.getValueAt(selectedRow, 5).toString();
        String DateGiven = jTable1.getValueAt(selectedRow, 7).toString();
        String NextDoseDate = jTable1.getValueAt(selectedRow, 9).toString();
        String VaccineType = jTable1.getValueAt(selectedRow, 6).toString();
        String AdministeredBy = jTable1.getValueAt(selectedRow, 8).toString();
        String Allergies = jTable1.getValueAt(selectedRow, 10).toString();
        String Reactions = jTable1.getValueAt(selectedRow, 11).toString();
        jLabel23.setText(Id);
        jLabel12.setText(Name);
        jLabel15.setText(VaccineName);
        jLabel16.setText(DateGiven);
        jLabel17.setText(NextDoseDate);
        jLabel19.setText(VaccineType);
        jLabel20.setText(AdministeredBy);
        jTextArea1.setText(Allergies);
        jTextArea3.setText(Reactions);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() && evt.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();

            try {
                try (FileWriter fileWriter = new FileWriter("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Databases\\Patients.csv")) {   
                    // Write the data rows
                    for (int row = 0; row < rowCount; row++) {
                        for (int column = 0; column < columnCount; column++) {
                            Object cellValue = model.getValueAt(row, column);
                            fileWriter.append(cellValue.toString());
                            if (column < columnCount - 1) {
                                fileWriter.append(",");
                            } else {
                                fileWriter.append("\n");
                            }
                        }
                    }fileWriter.flush();
                     // Display a message or perform any other necessary actions after saving
                     JOptionPane.showMessageDialog(null, "Records successfully updated!");
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately
            }
            // Add your code here
        } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();

            try {
                try (FileWriter fileWriter = new FileWriter("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Databases\\Patients.csv")) {   
                    // Write the data rows
                    for (int row = 0; row < rowCount; row++) {
                        for (int column = 0; column < columnCount; column++) {
                            Object cellValue = model.getValueAt(row, column);
                            fileWriter.append(cellValue.toString());
                            if (column < columnCount - 1) {
                                fileWriter.append(",");
                            } else {
                                fileWriter.append("\n");
                            }
                        }
                    }fileWriter.flush();
                     // Display a message or perform any other necessary actions after saving
                     JOptionPane.showMessageDialog(null, "Records successfully updated!");
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately
            }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTable1HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1HierarchyChanged

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        MainCRUD.OpenCSV();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        HealthWorkerCRUD.OpenCSV();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        HealthWorkerCRUD.OpenCSV();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        MainCRUD.OpenCSV();
    }//GEN-LAST:event_jButton18ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main frame = new Main();
                frame.setResizable(false);
                frame.setTitle("CliniTrack");
                frame.setIconImage(new ImageIcon("C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Resources\\Untitled design (11).png").getImage());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JPanel L0LoginPage;
    private javax.swing.JPanel L1Dashboard;
    private javax.swing.JPanel L2Database;
    private javax.swing.JPanel L3About;
    private static javax.swing.JPanel LoadingScreen;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
