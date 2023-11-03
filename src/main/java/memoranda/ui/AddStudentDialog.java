package main.java.memoranda.ui;

import main.java.memoranda.CurrentProject;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.util.Local;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddStudentDialog extends JDialog {

    public boolean CANCELLED = true;

    JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel header = new JLabel();
    Border firstNameTitleBorder;
    Border lastNameTitleBorder;
    Border beltRankTitleBorder;
    Border trainRankTitleBorder;
    JPanel jPanelHeader = new JPanel(new BorderLayout());
    JPanel jPanelActions = new JPanel(new BorderLayout());
    JPanel jPanelInputs = new JPanel(new GridLayout(4,1));
    JPanel jPanelFirstName = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jPanelLastName = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jPanelBeltRank = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jPanelTrainRank = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jPanelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    Border border1;
    Border border4;
    Border border8;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();


    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JButton cancelB = new JButton();
    JButton okB = new JButton();

    String[] beltRank = {Local.getString("White"), Local.getString("Yellow"),
            Local.getString("Green"), Local.getString("Red"),
            Local.getString("Black")};
    JComboBox beltRankCB = new JComboBox(beltRank);
    JComboBox trainRankCB = new JComboBox(beltRank);

    public AddStudentDialog(Frame frame, String title) {
        super(frame, title, true);
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }

    void jbInit() throws Exception {
        this.setPreferredSize(new Dimension(240, 400));
        this.setResizable(false);

        border1 = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        // Dialog Header
        header.setFont(new java.awt.Font("Dialog", 0, 20));
        header.setForeground(new Color(0, 0, 124));
        header.setText(Local.getString("Add Student"));
        header.setIcon(new ImageIcon(main.java.memoranda.ui.TaskDialog.class.getResource(
                "/ui/icons/student_48.png")));

        dialogTitlePanel.setBackground(Color.white);
        dialogTitlePanel.add(header, null);

        // First Name Field
        firstNameTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0),
                Local.getString(" First Name"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        jPanelFirstName.setBorder(firstNameTitleBorder);
        jPanelFirstName.add(firstNameField);
        firstNameField.setPreferredSize(new Dimension(210, 24));

        // Last Name Field
        lastNameTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Last Name"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        jPanelLastName.setBorder(lastNameTitleBorder);
        jPanelLastName.add(lastNameField);
        lastNameField.setPreferredSize(new Dimension(210, 24));

        // Belt Rank Field
        beltRankTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Belt Rank"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        jPanelBeltRank.setBorder(beltRankTitleBorder);
        jPanelBeltRank.add(beltRankCB);
        beltRankCB.setBackground(Color.white);
        beltRankCB.setPreferredSize(new Dimension(105, 24));

        // Train Rank Field
        trainRankTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Train Rank"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        jPanelTrainRank.setBorder(trainRankTitleBorder);
        jPanelTrainRank.add(trainRankCB);
        trainRankCB.setBackground(Color.white);
        trainRankCB.setPreferredSize(new Dimension(105, 24));

        // Inputs Field
        jPanelInputs.add(jPanelFirstName);
        jPanelInputs.add(jPanelLastName);
        jPanelInputs.add(jPanelBeltRank);
        jPanelInputs.add(jPanelTrainRank);

        // Cancel Button
        cancelB.setMaximumSize(new Dimension(100, 26));
        cancelB.setMinimumSize(new Dimension(100, 26));
        cancelB.setPreferredSize(new Dimension(100, 26));
        cancelB.setText(Local.getString("Cancel"));
        cancelB.setForeground(Color.red);
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelB_actionPerformed(e);
            }
        });

        // OK Button
        okB.setMaximumSize(new Dimension(100, 26));
        okB.setMinimumSize(new Dimension(100, 26));
        okB.setPreferredSize(new Dimension(100, 26));
        okB.setText(Local.getString("Ok"));
        okB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okB_actionPerformed(e);
            }
        });

        jPanelButtons.add(okB);
        jPanelButtons.add(cancelB);
        jPanelButtons.setBorder(border1);

        jPanelActions.add(jPanelInputs);
        jPanelActions.add(jPanelButtons, BorderLayout.SOUTH);

        this.getContentPane().add(dialogTitlePanel, BorderLayout.NORTH);
        this.add(jPanelActions);
    }

    void okB_actionPerformed(ActionEvent e) {
        CANCELLED = false;
        this.dispose();
    }

    void cancelB_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}