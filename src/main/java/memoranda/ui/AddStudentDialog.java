package main.java.memoranda.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import main.java.memoranda.BeltRank;
import main.java.memoranda.Student;
import main.java.memoranda.ui.htmleditor.util.Local;


public class AddStudentDialog extends JDialog {
    public boolean isCanceled = true;
    JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel header = new JLabel();
    Border firstNameTitleBorder;
    Border lastNameTitleBorder;
    Border beltRankTitleBorder;
    Border trainRankTitleBorder;
    JPanel jpanelHeader = new JPanel(new BorderLayout());
    JPanel jpanelActions = new JPanel(new BorderLayout());
    JPanel jpanelInputs = new JPanel(new GridLayout(5,1));
    JPanel jpanelFirstName = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jpanelLastName = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jpanelAge = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jpanelBeltRank = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jpanelTrainRank = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel jpanelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    Border border1;
    NumberFormat amountFormat;
    JFormattedTextField ageFormattedTextField = new JFormattedTextField(amountFormat);
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JButton cancelB = new JButton();
    JButton okB = new JButton();

    String[] beltRank = new String[0];
    JComboBox beltRankComboBox = new JComboBox(beltRank);
    JComboBox trainRankComboBox = new JComboBox(beltRank);
    Student newStudent;

    /**
     * Constructor to launch the add student dialog.
     * @param frame Dialog frame.
     * @param title Dialog frame title.
     */
    public AddStudentDialog(Frame frame, String title) {
        super(frame, title, true);
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }

    /**
     * Build the UI.
     */
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
        jpanelFirstName.setBorder(firstNameTitleBorder);
        jpanelFirstName.add(firstNameField);
        firstNameField.setPreferredSize(new Dimension(210, 24));

        // Last Name Field
        lastNameTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Last Name"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        jpanelLastName.setBorder(lastNameTitleBorder);
        jpanelLastName.add(lastNameField);
        lastNameField.setPreferredSize(new Dimension(210, 24));

        // Age Field
        Border ageTitle = new TitledBorder((BorderFactory.createEmptyBorder(0,0,2,0)),
                Local.getString("Age"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        jpanelAge.setBorder(ageTitle);
        jpanelAge.add(ageFormattedTextField);
        ageFormattedTextField.setPreferredSize(new Dimension(105, 24));
        ageFormattedTextField.setValue(0);

        // Belt Rank Field
        beltRankTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Belt Rank"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        jpanelBeltRank.setBorder(beltRankTitleBorder);
        jpanelBeltRank.add(beltRankComboBox);
        beltRankComboBox.setBackground(Color.white);
        beltRankComboBox.setPreferredSize(new Dimension(105, 24));

        // Train Rank Field
        trainRankTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Train Rank"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        jpanelTrainRank.setBorder(trainRankTitleBorder);
        jpanelTrainRank.add(trainRankComboBox);
        trainRankComboBox.setBackground(Color.white);
        trainRankComboBox.setPreferredSize(new Dimension(105, 24));

        int comboBoxSize = BeltRank.Rank.values().length;
        String[] beltColors = new String[comboBoxSize];
        for (int i = 0; i < comboBoxSize; i++) {
            beltRankComboBox.addItem(BeltRank.Rank.values()[i].name());
            trainRankComboBox.addItem(BeltRank.Rank.values()[i].name());
        }

        // Inputs Field
        jpanelInputs.add(jpanelFirstName);
        jpanelInputs.add(jpanelLastName);
        jpanelInputs.add(jpanelAge);
        jpanelInputs.add(jpanelBeltRank);
        jpanelInputs.add(jpanelTrainRank);

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

        jpanelButtons.add(okB);
        jpanelButtons.add(cancelB);
        jpanelButtons.setBorder(border1);

        jpanelActions.add(jpanelInputs);
        jpanelActions.add(jpanelButtons, BorderLayout.SOUTH);

        this.getContentPane().add(dialogTitlePanel, BorderLayout.NORTH);
        this.add(jpanelActions);
    }

    /**
     * Add button clicked. Construct student with given inputs.
     * @param e Add button click event.
     */
    void okB_actionPerformed(ActionEvent e) {
        newStudent = new Student(
                lastNameField.getText(),
                firstNameField.getText(),
                ((Number)ageFormattedTextField.getValue()).intValue(),
                BeltRank.Rank.valueOf(String.valueOf(beltRankComboBox.getSelectedItem())),
                BeltRank.Rank.valueOf(String.valueOf(trainRankComboBox.getSelectedItem())));
        isCanceled = false;
        this.dispose();
    }

    /**
     * Get student.
     * @return Student created from user inputs.
     */
    public Student getStudent() {
        return newStudent;
    }

    /**
     * Cancel button clicked. Exit with no changes.
     * @param e Cancel button click event.
     */
    void cancelB_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
