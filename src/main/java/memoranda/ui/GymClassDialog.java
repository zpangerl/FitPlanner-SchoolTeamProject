package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.java.memoranda.CurrentProject;
import main.java.memoranda.Room;
import main.java.memoranda.TrainerList;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.util.Local;

public class GymClassDialog extends JDialog {

    Border titledBorder;
    JPanel mPanel = new JPanel(new BorderLayout());
    JPanel areaPanel = new JPanel(new BorderLayout());
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton cancelB = new JButton();
    JButton okB = new JButton();
    Border border1;
    Border border2;
    JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel header = new JLabel();
    public boolean CANCELLED = true;
    JPanel jPanel8 = new JPanel(new GridBagLayout());
    Border border4;
    JPanel jPanel2 = new JPanel(new GridLayout(3, 2));

    JLabel jLabelClassName = new JLabel();
    JTextField classNameField = new JTextField();
    JLabel jLabelRoom = new JLabel();
    JComboBox<Room.GymRoom> jComboBoxRoom = new JComboBox<>(Room.GymRoom.values());
    JLabel jLabelTrainer = new JLabel();
    JComboBox<String> jComboBoxTrainer = new JComboBox<String>(TrainerList.getTrainerNames());

    Border border8;
    JPanel jPanel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel jPanel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel jLabel6 = new JLabel();
    JButton setStartDateB = new JButton();
    JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JLabel jLabel2 = new JLabel();
    JSpinner startDate;
    CalendarFrame startCalFrame = new CalendarFrame();
    boolean ignoreStartChanged = false;

    public GymClassDialog(Frame frame, String title) {
        super(frame, title, true);
        try {
            jbInit();
            pack();
        } catch (Exception e) {
            new ExceptionDialog(e);
        }
    }

    void jbInit() throws Exception {
        this.setResizable(false);
        this.setSize(new Dimension(430, 300));

        border1 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        border2 = BorderFactory.createEtchedBorder(Color.white,
                new Color(142, 142, 142));
        border4 = BorderFactory.createEmptyBorder(0, 5, 0, 5);
        border8 = BorderFactory.createEtchedBorder(Color.white,
                new Color(178, 178, 178));

        // Cancel button
        cancelB.setMaximumSize(new Dimension(100, 26));
        cancelB.setMinimumSize(new Dimension(100, 26));
        cancelB.setPreferredSize(new Dimension(100, 26));
        cancelB.setText(Local.getString("Cancel"));
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelB_actionPerformed(e);
            }
        });

        // Okay button
        okB.setMaximumSize(new Dimension(100, 26));
        okB.setMinimumSize(new Dimension(100, 26));
        okB.setPreferredSize(new Dimension(100, 26));
        okB.setText(Local.getString("Create"));
        okB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okB_actionPerformed(e);
            }
        });

        this.getRootPane().setDefaultButton(okB);
        mPanel.setBorder(border1);
        areaPanel.setBorder(border2);
        dialogTitlePanel.setBackground(Color.WHITE);
        dialogTitlePanel.setBorder(border4);
        header.setFont(new java.awt.Font("Dialog", 0, 20));
        header.setForeground(new Color(0, 0, 124));
        header.setText(Local.getString("New Class"));
        header.setIcon(new ImageIcon(main.java.memoranda.ui.TaskDialog.class.getResource(
                "/ui/icons/class48.png")));

        GridBagLayout gbLayout = (GridBagLayout) jPanel8.getLayout();
        jPanel8.setBorder(titledBorder);

        // The lable for class name
        jLabelClassName.setMaximumSize(new Dimension(100, 16));
        jLabelClassName.setMinimumSize(new Dimension(60, 16));
        jLabelClassName.setText(Local.getString("Class Name"));
        GridBagConstraints gbCon = new GridBagConstraints();
        gbCon.gridwidth = GridBagConstraints.REMAINDER;
        gbCon.weighty = 1;
        gbCon.anchor = GridBagConstraints.WEST;
        gbLayout.setConstraints(jLabelClassName, gbCon);

        // The field for class name
        classNameField.setBorder(border8);
        classNameField.setPreferredSize(new Dimension(375, 24));
        gbCon = new GridBagConstraints();
        gbCon.gridwidth = GridBagConstraints.REMAINDER;
        gbCon.weighty = 1;
        gbLayout.setConstraints(classNameField, gbCon);

        // TODO: Add label for room, trainer, date, class type
        // The label for Room
        jLabelRoom.setMaximumSize(new Dimension(100, 16));
        jLabelRoom.setMinimumSize(new Dimension(60, 16));
        jLabelRoom.setText(Local.getString("Room"));
        gbCon = new GridBagConstraints();
        gbCon.gridwidth = GridBagConstraints.REMAINDER;
        gbCon.weighty = 1;
        gbCon.anchor = GridBagConstraints.WEST;
        gbLayout.setConstraints(jLabelRoom, gbCon);

        // The combobox for Room
        jComboBoxRoom.setBorder(border8);
        jComboBoxRoom.setPreferredSize(new Dimension(375, 24));
        gbCon = new GridBagConstraints();
        gbCon.gridwidth = GridBagConstraints.REMAINDER;
        gbCon.weighty = 1;
        gbLayout.setConstraints(jComboBoxRoom, gbCon);

        // The label for Trainer
        jLabelTrainer.setMaximumSize(new Dimension(100, 16));
        jLabelTrainer.setMinimumSize(new Dimension(60, 16));
        jLabelTrainer.setText(Local.getString("Trainer"));
        gbCon = new GridBagConstraints();
        gbCon.gridwidth = GridBagConstraints.REMAINDER;
        gbCon.weighty = 1;
        gbCon.anchor = GridBagConstraints.WEST;
        gbLayout.setConstraints(jLabelTrainer, gbCon);

        // The combobox for Trainer
        jComboBoxTrainer.setBorder(border8);
        jComboBoxTrainer.setPreferredSize(new Dimension(375, 24));
        gbCon = new GridBagConstraints();
        gbCon.gridwidth = GridBagConstraints.REMAINDER;
        gbCon.weighty = 1;
        gbLayout.setConstraints(jComboBoxTrainer, gbCon);

        // TODO: Start date
        startDate = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_WEEK));
        startDate.setBorder(border8);
        startDate.setPreferredSize(new Dimension(80, 24));
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
        // //Added by (jcscoobyrs) on 14-Nov-2003 at 10:45:16 PM
        startDate.setEditor(new JSpinner.DateEditor(startDate, sdf.toPattern()));
        startDate.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // it's an ugly hack so that the spinner can increase day by day
                SpinnerDateModel sdm = new SpinnerDateModel((Date) startDate.getModel().getValue(), null, null,
                        Calendar.DAY_OF_WEEK);
                startDate.setModel(sdm);

                if (ignoreStartChanged)
                    return;
                ignoreStartChanged = true;
                Date sd = (Date) startDate.getModel().getValue();
                startCalFrame.cal.set(new CalendarDate(sd));
                ignoreStartChanged = false;
            }
        });
        setStartDateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setStartDateB_actionPerformed(e);
            }
        });
        startCalFrame.cal.addSelectionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ignoreStartChanged)
                    return;
                startDate.getModel().setValue(startCalFrame.cal.get().getCalendar().getTime());
            }
        });

        jLabel6.setText(Local.getString("Start date"));
        // jLabel6.setPreferredSize(new Dimension(60, 16));
        jLabel6.setMinimumSize(new Dimension(60, 16));
        jLabel6.setMaximumSize(new Dimension(100, 16));
        setStartDateB.setMinimumSize(new Dimension(24, 24));
        setStartDateB.setPreferredSize(new Dimension(24, 24));
        setStartDateB.setText("");
        setStartDateB.setIcon(
                new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/calendar.png")));

        // Add components to panel
        getContentPane().add(mPanel);
        mPanel.add(areaPanel, BorderLayout.CENTER);
        mPanel.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.add(okB, null);
        buttonsPanel.add(cancelB, null);
        this.getContentPane().add(dialogTitlePanel, BorderLayout.NORTH);
        dialogTitlePanel.add(header, null);
        areaPanel.add(jPanel8, BorderLayout.NORTH);
        // TODO
        jPanel8.add(jLabelClassName);
        jPanel8.add(classNameField, null);
        jPanel8.add(jLabelRoom);
        jPanel8.add(jComboBoxRoom);
        jPanel8.add(jLabelTrainer);
        jPanel8.add(jComboBoxTrainer);

        areaPanel.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jPanel6, null);
        jPanel6.add(jLabel6, null);
        jPanel6.add(startDate, null);
        jPanel6.add(setStartDateB, null);
        jPanel2.add(jPanel1, null);
        jPanel1.add(jLabel2, null);
    }

    void setStartDateB_actionPerformed(ActionEvent e) {
        startCalFrame.setLocation(setStartDateB.getLocation());
        startCalFrame.setSize(200, 200);
        this.getLayeredPane().add(startCalFrame);
        startCalFrame.show();
    }

    public void setStartDate(CalendarDate d) {
        this.startDate.getModel().setValue(d.getDate());
    }

    void okB_actionPerformed(ActionEvent e) {
        CANCELLED = false;
        this.dispose();
    }

    void cancelB_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
