package main.java.memoranda.ui;

import main.java.memoranda.CurrentProject;
import main.java.memoranda.util.Local;
import main.java.memoranda.util.MimeType;
import main.java.memoranda.util.MimeTypesList;
import main.java.memoranda.util.Util;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class StudentPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JToolBar toolBar = new JToolBar();
    JButton newStudentB = new JButton();
    TrainersTable studentsTable = new TrainersTable();
    JButton removeStudentB = new JButton();
    JScrollPane scrollPane = new JScrollPane();
    JButton refreshB = new JButton();
    JPopupMenu studentPPMenu = new JPopupMenu();
    JMenuItem ppRun = new JMenuItem();
    JMenuItem ppRemoveStudent = new JMenuItem();
    JMenuItem ppNewStudent = new JMenuItem();
    JMenuItem ppRefresh = new JMenuItem();



    public StudentPanel() {
        try {
            jbInit();
        }
        catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }
    void jbInit() throws Exception {
        toolBar.setFloatable(false);
        this.setLayout(borderLayout1);
        newStudentB.setIcon(
                new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/addresource.png")));
        newStudentB.setEnabled(true);
        newStudentB.setMaximumSize(new Dimension(24, 24));
        newStudentB.setMinimumSize(new Dimension(24, 24));
        newStudentB.setToolTipText(Local.getString("New Student"));
        newStudentB.setRequestFocusEnabled(false);
        newStudentB.setPreferredSize(new Dimension(24, 24));
        newStudentB.setFocusable(false);
        newStudentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newStudentB_actionPerformed(e);
            }
        });
        newStudentB.setBorderPainted(false);

        studentsTable.setMaximumSize(new Dimension(32767, 32767));
        studentsTable.setRowHeight(24);

        removeStudentB.setBorderPainted(false);
        removeStudentB.setFocusable(false);
        removeStudentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeStudentB_actionPerformed(e);
            }
        });
        removeStudentB.setPreferredSize(new Dimension(24, 24));
        removeStudentB.setRequestFocusEnabled(false);
        removeStudentB.setToolTipText(Local.getString("Remove Student"));
        removeStudentB.setMinimumSize(new Dimension(24, 24));
        removeStudentB.setMaximumSize(new Dimension(24, 24));
        removeStudentB.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/removeresource.png")));
        scrollPane.getViewport().setBackground(Color.white);

        toolBar.addSeparator(new Dimension(8, 24));
        toolBar.addSeparator(new Dimension(8, 24));

        StudentPanel.PopupListener ppListener = new StudentPanel.PopupListener();
        scrollPane.addMouseListener(ppListener);
        studentsTable.addMouseListener(ppListener);
        studentsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                boolean enbl = (studentsTable.getRowCount() > 0) && (studentsTable.getSelectedRow() > -1);

                removeStudentB.setEnabled(enbl); ppRemoveStudent.setEnabled(enbl);
                ppRun.setEnabled(enbl);
            }
        });
        refreshB.setBorderPainted(false);
        refreshB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshB_actionPerformed(e);
            }
        });
        refreshB.setFocusable(false);
        refreshB.setPreferredSize(new Dimension(24, 24));
        refreshB.setRequestFocusEnabled(false);
        refreshB.setToolTipText(Local.getString("Refresh"));
        refreshB.setMinimumSize(new Dimension(24, 24));
        refreshB.setMaximumSize(new Dimension(24, 24));
        refreshB.setEnabled(true);
        refreshB.setIcon(
                new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png")));
        studentPPMenu.setFont(new java.awt.Font("Dialog", 1, 10));
        ppRun.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRun.setText(Local.getString("Open resource")+"...");
        ppRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRun_actionPerformed(e);
            }
        });
        ppRun.setEnabled(false);

        ppRemoveStudent.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRemoveStudent.setText(Local.getString("Remove Student"));
        ppRemoveStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRemoveRes_actionPerformed(e);
            }
        });
        ppRemoveStudent.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/removeresource.png")));
        ppRemoveStudent.setEnabled(false);
        ppNewStudent.setFont(new java.awt.Font("Dialog", 1, 11));
        ppNewStudent.setText(Local.getString("New Student")+"...");
        ppNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppNewStudent_actionPerformed(e);
            }
        });
        ppNewStudent.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/addresource.png")));

        ppRefresh.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRefresh.setText(Local.getString("Refresh"));
        ppRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRefresh_actionPerformed(e);
            }
        });
        ppRefresh.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png")));

        toolBar.add(newStudentB, null);
        toolBar.add(removeStudentB, null);
        toolBar.addSeparator();
        toolBar.add(refreshB, null);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(studentsTable, null);
        this.add(toolBar, BorderLayout.NORTH);
        studentPPMenu.add(ppRun);
        studentPPMenu.addSeparator();
        studentPPMenu.add(ppNewStudent);
        studentPPMenu.add(ppRemoveStudent);
        studentPPMenu.addSeparator();
        studentPPMenu.add(ppRefresh);
        studentsTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e){
                if(studentsTable.getSelectedRows().length>0
                        && e.getKeyCode()==KeyEvent.VK_DELETE)
                    ppRemoveRes_actionPerformed(null);
            }
            public void	keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });
    }
    void newStudentB_actionPerformed(ActionEvent e) {
        AddStudentDialog dlg = new AddStudentDialog(App.getFrame(), Local.getString("New Student"));
        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x, (frmSize.height - dlg.getSize().height) / 2 + loc.y);
        dlg.setVisible(true);
        if (dlg.CANCELLED)
            return;
    }
    void removeStudentB_actionPerformed(ActionEvent e) {
        System.out.println("[DEBUG] removeResB_actionPerformed");
        // TODO: The resources equivalent of this method is in ResourcesPanel.java
    }
    class PopupListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // TODO: Equivalent method in TaskPanel.java
            //editTaskB_actionPerformed(null);
        }

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                studentPPMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

    }
    void ppRun_actionPerformed(ActionEvent e) {

    }
    void ppRefresh_actionPerformed(ActionEvent e) {
        studentsTable.tableChanged();
    }
    void refreshB_actionPerformed(ActionEvent e) {
        studentsTable.tableChanged();
    }
    void ppRemoveRes_actionPerformed(ActionEvent e) {
        removeStudentB_actionPerformed(e);
    }
    void ppNewStudent_actionPerformed(ActionEvent e) {
        newStudentB_actionPerformed(e);
    }
/*--------------------------------------------------------------------------------------------------------*/
private JTable studentsTable;
    private DefaultTableModel trainersTableModel;
    String[][] trainersDataArray;
    final String[] trainersTableColumnNames = {"First Name", "Last Name", "Training Rank", "Belt Rank"};

    /* default constructor */
    TrainersPanel() {
        boolean testDataEnabled = true; // TODO: set to false or remove test code below before merge to dev
        if(testDataEnabled) {
            // create some test trainers
            for (int i = 0; i < 1; i++) {
                // Create three trainers to vary beltRank and trainingRank
                Trainer tmpTrainer1 = new Trainer();
                tmpTrainer1.setFirstName("FirstnameTest" + i + "-1");
                tmpTrainer1.setLastName("LastnameTest" + i + "-1");
                tmpTrainer1.setTrainingRank(BeltRank.Rank.BLUE);
                tmpTrainer1.setBeltRank(BeltRank.Rank.BLUE_STRIPE); // STRIPE on belts
                TrainerList.addTrainer(tmpTrainer1);

                Trainer tmpTrainer2 = new Trainer();
                tmpTrainer2.setFirstName("FirstnameTest" + i + "-2");
                tmpTrainer2.setLastName("LastnameTest" + i + "-2");
                tmpTrainer2.setTrainingRank(BeltRank.Rank.GREEN);
                tmpTrainer2.setBeltRank(BeltRank.Rank.GREEN_STRIPE); // STRIPE on belts
                TrainerList.addTrainer(tmpTrainer2);

                Trainer tmpTrainer3 = new Trainer();
                tmpTrainer3.setFirstName("FirstnameTest" + i + "-3");
                tmpTrainer3.setLastName("LastnameTest" + i + "-3");
                tmpTrainer3.setTrainingRank(BeltRank.Rank.BROWN1);
                tmpTrainer3.setBeltRank(BeltRank.Rank.BROWN2);
                TrainerList.addTrainer(tmpTrainer3);
            }
        }

        // Set layout
        this.setLayout(new BorderLayout());

        /* Trainers title */
        // Reference: https://www.tutorialspoint.com/swingexamples/add_title_to_border_panel.htm
        Border trainersPanelTitle = BorderFactory.createTitledBorder("Manage Trainers");
        this.setBorder(trainersPanelTitle);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanelSqueeze = new JPanel();
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        JPanel tablePanel = new JPanel();
        /* Add new trainer button */
        // Reference: https://www.geeksforgeeks.org/java-swing-jpanel-with-examples/
        JButton addTrainerButton = new JButton("Add Trainer");
        buttonPanel.add(addTrainerButton);

        /* Delete trainer button */
        JLabel trainerDeleteLabel = new JLabel();
        trainerDeleteLabel.setText("Select a Trainer row to delete:");
        buttonPanel.add(trainerDeleteLabel);
        JButton deleteTrainerButton = getDeleteTrainerButton();
        buttonPanel.add(deleteTrainerButton);

        buildTrainersTable();
        tablePanel.add(new JScrollPane(trainersTable), BorderLayout.CENTER);

        // Combine JPanel's
        buttonPanelSqueeze.add(buttonPanel, BorderLayout.CENTER);
        // Reference: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(buttonPanelSqueeze, c);
        c.gridy = 1;
        mainPanel.add(tablePanel, c);
        this.add(mainPanel, BorderLayout.CENTER);

    }

    /**
     * Create the delete trainer button
     * @return JButton delete trainer button
     */
    private JButton getDeleteTrainerButton() {
        JButton deleteTrainerButton = new JButton("Delete Trainer");
        deleteTrainerButton.addActionListener(e -> {
            final int NO_ROW_SELECTED = -1;
            int rowSelectedIdx = trainersTable.getSelectedRow();
            if(rowSelectedIdx != NO_ROW_SELECTED) {
                TrainerList.removeTrainerByIndex(rowSelectedIdx);
                refreshTrainersTable();
            }
        });
        return deleteTrainerButton;
    }

    /**
     * builds the JTable trainers table and store to member variable trainersTable
     */
    private void buildTrainersTable() {
        // Reference: https://www.geeksforgeeks.org/java-swing-jtable/
        trainersDataArray = TrainerList.getTrainersArray();
        trainersTableModel = new DefaultTableModel(trainersDataArray, trainersTableColumnNames);
        trainersTable = new JTable(trainersTableModel) {
            // Alternate row color. white, light_gray
            // Reference: https://blog.marcnuri.com/jtable-alternate-row-background
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component returnComp = super.prepareRenderer(renderer, row, column);
                Color grayColor = Color.LIGHT_GRAY;
                Color whiteColor = Color.WHITE;
                if (!returnComp.getBackground().equals(getSelectionBackground())) {
                    Color bg = (row % 2 == 0 ? whiteColor : grayColor);
                    returnComp.setBackground(bg);
                }
                return returnComp;
            }
        };
        trainersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // important for delete button
    }

    /**
     * refresh JTable trainersTable after changes
     */
    void refreshTrainersTable() {
        trainersDataArray = TrainerList.getTrainersArray(); // refresh
        trainersTableModel = new DefaultTableModel(trainersDataArray, trainersTableColumnNames);
        trainersTable.setModel(trainersTableModel);
    }
}
