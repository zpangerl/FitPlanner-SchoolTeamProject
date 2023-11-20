package main.java.memoranda.ui;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import main.java.memoranda.GymClass;
import main.java.memoranda.GymClassList;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.date.CurrentDate;
import main.java.memoranda.date.DateListener;

/**
 *  File: GymClassTable.java
 *  Author: Rhett Harrison
 *  Version: 2023.11.09
 *  Description: Table for GymClass(es)
*/
public class GymClassTable extends JTable {
    /**
     * Constructor for GymClassTable.
     */
    public GymClassTable() {
        super();
        setModel(new GymClassTableModel());
        initTable(CurrentDate.get());
        this.setShowGrid(false);
        CurrentDate.addDateListener(new DateListener() {
            public void dateChange(CalendarDate date) {
                updateUI();
                initTable(date);
            }
        });
    }

    /**
     * Initializes the table with the given date.
     * @param date date to sort or filter table data by
     */
    public void initTable(CalendarDate date) {
        // TODO: filter/sort table data by date
        getColumnModel().getColumn(0).setPreferredWidth(180);
        getColumnModel().getColumn(0).setMaxWidth(180);
        clearSelection();
        updateUI();
    }

    public void refresh() {
        initTable(CurrentDate.get());
    }

    /**
     * Returns the cell renderer for the given row and column.
     * @param row row of the cell
     * @param column column of the cell
     * @return TableCellRenderer
     */
    public TableCellRenderer getCellRenderer(int row, int column) {
        return new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component tableCellRendererComponent = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                GymClass gymClass = GymClassList.getGymClasses().get(row);
                if (gymClass.getDate().before(CurrentDate.get().getDate())) {
                    tableCellRendererComponent.setFont(new Font("Dialog", Font.ITALIC, 11));
                } else {
                    tableCellRendererComponent.setFont(new Font("Dialog", Font.PLAIN, 11));
                }
                return tableCellRendererComponent;
            }
        };
    }

    /**
     * Table model for GymClassTable.
     */
    static class GymClassTableModel extends AbstractTableModel {
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
                i = GymClassList.getGymClasses().size();
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
            GymClass gymClass = GymClassList.getGymClasses().get(rowIndex);
            if (gymClass == null) {
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
