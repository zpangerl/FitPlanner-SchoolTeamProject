package main.java.memoranda.ui;

import javax.swing.*;
import java.awt.*;

public class ClassPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JScrollPane scrollPane = new JScrollPane();

    public ClassPanel() {
        try {
            jbInit();
        }
        catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }

    void jbInit() throws Exception {
        this.setLayout(borderLayout1);
        scrollPane.getViewport().setBackground(Color.white);

    }

}
