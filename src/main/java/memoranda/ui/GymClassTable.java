package main.java.memoranda.ui;

import main.java.memoranda.*;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.date.CurrentDate;
import main.java.memoranda.date.DateListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Date;
import java.util.Vector;
/*
  File:	GymClassTable.java
  Author: Rhett Harrison
  Version: 2023.11.09

  Description: Table for GymClass(es)
*/

public class GymClassTable extends JTable {
    public static final int GYMCLASS = 100;
    public static final int GYMCLASS_ID = 101;
    Vector gymClasses = new Vector();

    public GymClassTable() {
        super();
        setModel(new GymClassTableModel());
        initTable(CurrentDate.get());
        this.setShowGrid(false);
        CurrentDate.addDateListener(new DateListener() {
            public void dateChange(CalendarDate d) {
                //updateUI();
                initTable(d);
            }
        });
    }

    public void initTable(CalendarDate calendarDate) {
        // Create three trainers to vary beltRank and trainingRank
        Trainer tmpTrainer1 = new Trainer();
        tmpTrainer1.setFirstName("FirstnameTest" + "-1");
        tmpTrainer1.setLastName("LastnameTest" + "-1");
        tmpTrainer1.setTrainingRank(BeltRank.Rank.BLUE);
        tmpTrainer1.setBeltRank(BeltRank.Rank.BLUE_STRIPE); // STRIPE on belts
        TrainerList.addTrainer(tmpTrainer1);

        Trainer tmpTrainer2 = new Trainer();
        tmpTrainer2.setFirstName("FirstnameTest" + "-2");
        tmpTrainer2.setLastName("LastnameTest" + "-2");
        tmpTrainer2.setTrainingRank(BeltRank.Rank.GREEN);
        tmpTrainer2.setBeltRank(BeltRank.Rank.GREEN_STRIPE); // STRIPE on belts
        TrainerList.addTrainer(tmpTrainer2);

        Trainer tmpTrainer3 = new Trainer();
        tmpTrainer3.setFirstName("FirstnameTest" + "-3");
        tmpTrainer3.setLastName("LastnameTest" + "-3");
        tmpTrainer3.setTrainingRank(BeltRank.Rank.BROWN1);
        tmpTrainer3.setBeltRank(BeltRank.Rank.BROWN2);
        TrainerList.addTrainer(tmpTrainer3);
        for(int i = 0; i < 10; i++) {
            Date date = CalendarDate.today().getDate();
            GymClass gymClass = new GymClass(date, tmpTrainer1);
            gymClass.setRoom(Room.GymRoom.ROOM1);
            gymClasses.add(gymClass);
        }
        getColumnModel().getColumn(0).setPreferredWidth(180);
        getColumnModel().getColumn(0).setMaxWidth(180);
        clearSelection();
        updateUI();
    }
    public void refresh() {
        initTable(CurrentDate.get());
    }
    public TableCellRenderer getCellRenderer(int row, int column) {
        return new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                GymClass gymClass = (GymClass) gymClasses.get(row);
                if (gymClass.getDate().before(CurrentDate.get().getDate())) {
                    c.setFont(new Font("Dialog", Font.ITALIC, 11));
                } else {
                    c.setFont(new Font("Dialog", Font.PLAIN, 11));
                }
                return c;
            }
        };
    }

    class GymClassTableModel extends AbstractTableModel {
        String[] columnNames = {
                "Date",
                "Class Type",
                "Trainer",
                "Room"
        };

        GymClassTableModel() {
            super();
        }

        @Override
        public int getRowCount() {
            int i;
            try {
                i = gymClasses.size();
            } catch (NullPointerException e) {
                i = 0;
            }
            return i;
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            GymClass gymClass = (GymClass) gymClasses.get(rowIndex);
            if(gymClass == null) {
                return null;
            }
            switch (columnIndex) {
                case 0:
                    return gymClass.getDate();
                case 1:
                    return gymClass.getClassType();
                case 2:
                    return gymClass.getTrainer().getName();
                case 3:
                    return gymClass.getRoom();
                default:
                    // ! This should never happen
                    return null;
            }
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }
    }

    }
