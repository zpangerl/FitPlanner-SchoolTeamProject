package main.java.memoranda.ui;

import main.java.memoranda.util.Context;
import main.java.memoranda.util.Local;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */

/*$Id: WorkPanel.java,v 1.9 2004/04/05 10:05:44 alexeya Exp $*/
public class WorkPanel extends JPanel {
	BorderLayout borderLayout1 = new BorderLayout();
	JToolBar toolBar = new JToolBar();
	JPanel panel = new JPanel();
	CardLayout cardLayout1 = new CardLayout();

	public JButton notesB = new JButton();
	public DailyItemsPanel dailyItemsPanel = new DailyItemsPanel(this);
	public ResourcesPanel filesPanel = new ResourcesPanel();
	public TrainersPanel trainersPanel = new TrainersPanel();
	public ClassPanel classPanel = new ClassPanel();
	public JButton agendaB = new JButton();
	public JButton classesB = new JButton();
	public JButton eventsB = new JButton();
	public JButton filesB = new JButton();
	public JButton trainersB = new JButton();
	JButton currentB = null;
	Border border1;

	public WorkPanel() {
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
		}
	}

	void jbInit() throws Exception {
		border1 =
			BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(
					BevelBorder.LOWERED,
					Color.white,
					Color.white,
					new Color(124, 124, 124),
					new Color(178, 178, 178)),
				BorderFactory.createEmptyBorder(0, 2, 0, 0));

		this.setLayout(borderLayout1);
		toolBar.setOrientation(JToolBar.VERTICAL);
		toolBar.setBackground(Color.white);

		toolBar.setBorderPainted(false);
		toolBar.setFloatable(false);
		panel.setLayout(cardLayout1);

		agendaB.setBackground(Color.white);
		agendaB.setMaximumSize(new Dimension(60, 80));
		agendaB.setMinimumSize(new Dimension(30, 30));

		agendaB.setFont(new java.awt.Font("Dialog", 1, 10));
		agendaB.setPreferredSize(new Dimension(50, 50));
		agendaB.setBorderPainted(false);
		agendaB.setContentAreaFilled(false);
		agendaB.setFocusPainted(false);
		agendaB.setHorizontalTextPosition(SwingConstants.CENTER);
		agendaB.setText(Local.getString("Agenda"));
		agendaB.setVerticalAlignment(SwingConstants.TOP);
		agendaB.setVerticalTextPosition(SwingConstants.BOTTOM);
		agendaB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendaB_actionPerformed(e);
			}
		});
		agendaB.setIcon(
			new ImageIcon(
				main.java.memoranda.ui.AppFrame.class.getResource(
					"/ui/icons/calendar_1.png")));
		agendaB.setOpaque(false);
		agendaB.setMargin(new Insets(0, 0, 0, 0));
		agendaB.setSelected(true);

		eventsB.setBackground(Color.white);
		eventsB.setMaximumSize(new Dimension(60, 80));
		eventsB.setMinimumSize(new Dimension(30, 30));

		eventsB.setFont(new java.awt.Font("Dialog", 1, 10));
		eventsB.setPreferredSize(new Dimension(50, 50));
		eventsB.setBorderPainted(false);
		eventsB.setContentAreaFilled(false);
		eventsB.setFocusPainted(false);
		eventsB.setHorizontalTextPosition(SwingConstants.CENTER);
		eventsB.setText(Local.getString("Rooms"));
		eventsB.setVerticalAlignment(SwingConstants.TOP);
		eventsB.setVerticalTextPosition(SwingConstants.BOTTOM);
		eventsB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventsB_actionPerformed(e);
			}
		});
		eventsB.setIcon(
			new ImageIcon(
				main.java.memoranda.ui.AppFrame.class.getResource(
					"/ui/icons/open-door.png")));
		eventsB.setOpaque(false);
		eventsB.setMargin(new Insets(0, 0, 0, 0));
		//eventsB.setSelected(true);

		classesB.setSelected(true);
		classesB.setFont(new java.awt.Font("Dialog", 1, 10));
		classesB.setMargin(new Insets(0, 0, 0, 0));
		classesB.setIcon(
			new ImageIcon(
				main.java.memoranda.ui.AppFrame.class.getResource(
					"/ui/icons/gym.png")));
		classesB.setVerticalTextPosition(SwingConstants.BOTTOM);
		classesB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classesB_actionPerformed(e);
			}
		});
		classesB.setVerticalAlignment(SwingConstants.TOP);
		classesB.setText(Local.getString("Classes"));
		classesB.setHorizontalTextPosition(SwingConstants.CENTER);
		classesB.setFocusPainted(false);
		classesB.setBorderPainted(false);
		classesB.setContentAreaFilled(false);
		classesB.setPreferredSize(new Dimension(50, 50));
		classesB.setMinimumSize(new Dimension(30, 30));
		classesB.setOpaque(false);
		classesB.setMaximumSize(new Dimension(60, 80));
		classesB.setBackground(Color.white);

		notesB.setFont(new java.awt.Font("Dialog", 1, 10));
		notesB.setBackground(Color.white);
		notesB.setBorder(null);
		notesB.setMaximumSize(new Dimension(60, 80));
		notesB.setMinimumSize(new Dimension(30, 30));
		notesB.setOpaque(false);
		notesB.setPreferredSize(new Dimension(60, 50));
		notesB.setBorderPainted(false);
		notesB.setContentAreaFilled(false);
		notesB.setFocusPainted(false);
		notesB.setHorizontalTextPosition(SwingConstants.CENTER);
		notesB.setText(Local.getString("Notes"));
		notesB.setVerticalAlignment(SwingConstants.TOP);
		notesB.setVerticalTextPosition(SwingConstants.BOTTOM);
		notesB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notesB_actionPerformed(e);
			}
		});
		notesB.setIcon(
			new ImageIcon(
				main.java.memoranda.ui.AppFrame.class.getResource(
					"/ui/icons/notes_1.png")));
		notesB.setMargin(new Insets(0, 0, 0, 0));
		notesB.setSelected(true);
		this.setPreferredSize(new Dimension(1073, 300));
		// comment
		trainersB.setSelected(true);
		trainersB.setMargin(new Insets(0, 0, 0, 0));
		trainersB.setIcon(
				new ImageIcon(
						main.java.memoranda.ui.AppFrame.class.getResource(
								"/ui/icons/trainer.png")));
		trainersB.setVerticalTextPosition(SwingConstants.BOTTOM);
		trainersB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainersB_actionPerformed(e);
			}
		});
		trainersB.setFont(new java.awt.Font("Dialog", 1, 10));
		trainersB.setVerticalAlignment(SwingConstants.TOP);
		trainersB.setText(Local.getString("Trainers"));
		trainersB.setHorizontalTextPosition(SwingConstants.CENTER);
		trainersB.setFocusPainted(false);
		trainersB.setBorderPainted(false);
		trainersB.setContentAreaFilled(false);
		trainersB.setPreferredSize(new Dimension(50, 50));
		trainersB.setMinimumSize(new Dimension(30, 30));
		trainersB.setOpaque(false);
		trainersB.setMaximumSize(new Dimension(60, 80));
		trainersB.setBackground(Color.white);
		// comment

		this.add(toolBar, BorderLayout.WEST);
		this.add(panel, BorderLayout.CENTER);
		panel.add(dailyItemsPanel, "DAILYITEMS");
		panel.add(filesPanel, "FILES");
		panel.add(trainersPanel, "TRAINERS");
		panel.add(classPanel, "CLASSES");
		toolBar.add(agendaB, null);
		toolBar.add(eventsB, null);
		toolBar.add(classesB, null);
		toolBar.add(notesB, null);
		toolBar.add(trainersB, null);
		currentB = agendaB;
		// Default blue color
		currentB.setBackground(new Color(215, 225, 250));
		currentB.setOpaque(true);

		toolBar.setBorder(null);
		panel.setBorder(null);
		dailyItemsPanel.setBorder(null);
		filesPanel.setBorder(null);
		trainersPanel.setBorder(null);
		classPanel.setBorder(null);

	}

	public void selectPanel(String pan) {
		if (pan != null) {
			if (pan.equals("NOTES"))
				notesB_actionPerformed(null);
			else if (pan.equals("CLASSES"))
				classesB_actionPerformed(null);
			else if (pan.equals("EVENTS"))
				eventsB_actionPerformed(null);
			else if (pan.equals("TRAINERS"))
				trainersB_actionPerformed(null);
		}
	}

	public void agendaB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "DAILYITEMS");
		dailyItemsPanel.selectPanel("AGENDA");
		setCurrentButton(agendaB);
		Context.put("CURRENT_PANEL", "AGENDA");
	}

	public void notesB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "DAILYITEMS");
		dailyItemsPanel.selectPanel("NOTES");
		setCurrentButton(notesB);
		Context.put("CURRENT_PANEL", "NOTES");
	}

	public void eventsB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "DAILYITEMS");
		dailyItemsPanel.selectPanel("EVENTS");
		setCurrentButton(eventsB);
		Context.put("CURRENT_PANEL", "EVENTS");
	}

	public void trainersB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "TRAINERS");
		setCurrentButton(trainersB);
		Context.put("CURRENT_PANEL", "TRAINERS");
	}
	public void classesB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "CLASSES");
		setCurrentButton(classesB);
		Context.put("CURRENT_PANEL", "CLASSES");
	}

	void setCurrentButton(JButton cb) {
		currentB.setBackground(Color.white);
		currentB.setOpaque(false);
		currentB = cb;
		// Default color blue
		currentB.setBackground(new Color(215, 225, 250));
		currentB.setOpaque(true);
	}
}