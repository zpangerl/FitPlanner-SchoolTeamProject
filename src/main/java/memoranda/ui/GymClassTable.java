package main.java.memoranda.ui;

import main.java.memoranda.GymClass;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.date.CurrentDate;
import main.java.memoranda.date.DateListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Vector;

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
        for(int i = 0; i < 10; i++) {
            gymClasses.add(new GymClass(calendarDate.getDate(), null));
        }
        getColumnModel().getColumn(0).setPreferredWidth(60);
        getColumnModel().getColumn(0).setMaxWidth(60);
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
                // TODO: Add room variable
//                "Room"
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
            // TODO: Add room variable
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            GymClass gymClass = (GymClass) gymClasses.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return gymClass.getDate();
                case 1:
                    return gymClass.getClassType();
                case 2:
                    return gymClass.getTrainer();
                // TODO: Add room variable
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
