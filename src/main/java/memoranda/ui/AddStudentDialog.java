package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import main.java.memoranda.BeltRank;
import main.java.memoranda.Student;
import main.java.memoranda.util.Local;

public class AddStudentDialog extends JDialog {

    public boolean canceled = true;

    JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel header = new JLabel();
    Border firstNameTitleBorder;
    Border lastNameTitleBorder;
    Border beltRankTitleBorder;
    Border trainRankTitleBorder;
    JPanel headerPanel = new JPanel(new BorderLayout());
    JPanel actionsPanel = new JPanel(new BorderLayout());
    JPanel inputsPanel = new JPanel(new GridLayout(5,1));
    JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel beltRankPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel trainingRankPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
     * @throws Exception exception thrown.
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
        firstNamePanel.setBorder(firstNameTitleBorder);
        firstNamePanel.add(firstNameField);
        firstNameField.setPreferredSize(new Dimension(210, 24));

        // Last Name Field
        lastNameTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Last Name"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        lastNamePanel.setBorder(lastNameTitleBorder);
        lastNamePanel.add(lastNameField);
        lastNameField.setPreferredSize(new Dimension(210, 24));

        // Age Field
        Border ageTitle = new TitledBorder((BorderFactory.createEmptyBorder(0,0,2,0)),
                Local.getString("Age"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        agePanel.setBorder(ageTitle);
        agePanel.add(ageFormattedTextField);
        ageFormattedTextField.setPreferredSize(new Dimension(105, 24));
        ageFormattedTextField.setValue(0);

        // Belt Rank Field
        beltRankTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Belt Rank"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        beltRankPanel.setBorder(beltRankTitleBorder);
        beltRankPanel.add(beltRankComboBox);
        beltRankComboBox.setBackground(Color.white);
        beltRankComboBox.setPreferredSize(new Dimension(105, 24));

        // Train Rank Field
        trainRankTitleBorder = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0),
                Local.getString(" Train Rank"), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
        trainingRankPanel.setBorder(trainRankTitleBorder);
        trainingRankPanel.add(trainRankComboBox);
        trainRankComboBox.setBackground(Color.white);
        trainRankComboBox.setPreferredSize(new Dimension(105, 24));

        int comboBoxSize = BeltRank.Rank.values().length;
        String[] beltColors = new String[comboBoxSize];
        for (int i = 0; i < comboBoxSize; i++) {
            beltRankComboBox.addItem(BeltRank.Rank.values()[i].name());
            trainRankComboBox.addItem(BeltRank.Rank.values()[i].name());
        }

        // Inputs Field
        inputsPanel.add(firstNamePanel);
        inputsPanel.add(lastNamePanel);
        inputsPanel.add(agePanel);
        inputsPanel.add(beltRankPanel);
        inputsPanel.add(trainingRankPanel);

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

        buttonsPanel.add(okB);
        buttonsPanel.add(cancelB);
        buttonsPanel.setBorder(border1);

        actionsPanel.add(inputsPanel);
        actionsPanel.add(buttonsPanel, BorderLayout.SOUTH);

        this.getContentPane().add(dialogTitlePanel, BorderLayout.NORTH);
        this.add(actionsPanel);
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
                BeltRank.Rank.valueOf(String.valueOf(trainRankComboBox.getSelectedItem()))
        );
        canceled = false;
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
