package main.java.memoranda.ui;

import javax.swing.*;
import java.awt.*;

public class AddStudentDialog extends JDialog {
    JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel header = new JLabel();
    public JTextField firstNameField = new JTextField();
    public JTextField lastNameField = new JTextField();
    JButton okB = new JButton();
    JButton cancelB = new JButton();

    public AddStudentDialog(Frame frame, String title) {
        super(frame, title, true);
        try {
            jbInit();
            pack();
        }
        catch (Exception ex) {
            new ExceptionDialog(ex);
            ex.printStackTrace();
        }
    }

    void jbInit() throws Exception {
        this.setResizable(false);
    }
}