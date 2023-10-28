package main.java.memoranda.ui;

import main.java.memoranda.*;
import main.java.memoranda.ui.table.TableSorter;
import main.java.memoranda.util.Local;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

public class TrainersTable extends JTable {
    Vector trainers = null;
    TableSorter sorter = null;

    public TrainersTable() {
        super();
        initTable();
        sorter = new TableSorter(new TrainersTableModel());
        sorter.addMouseListenerToHeaderInTable(this);
        setModel(sorter);
        this.setShowGrid(false);
        this.setFont(new Font("Dialog",0,11));
        initColumsWidth();
        CurrentProject.addProjectListener(new ProjectListener() {
            public void projectChange(Project p, NoteList nl, TaskList tl, ResourcesList rl, TrainersList tr) {

            }
            public void projectWasChanged() {
                tableChanged();
            }
        });
    }

    void initColumsWidth() {
        for (int i = 0; i < 2; i++) {
            TableColumn column = getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(32767);
            } else {
                column.setMinWidth(100);
                column.setPreferredWidth(100);
            }
        }
    }
    public void tableChanged() {
        initTable();
        sorter.tableChanged(null);
        initColumsWidth();
        updateUI();
    }

    public void initTable() {
        Vector v = CurrentProject.getTrainersList().getAllTrainers();
        trainers = new Vector();
        for (int i = 0; i < v.size(); i++) {
            Trainer r = (Trainer) v.get(i);
            trainers.add(r);
        }

    }
    public static final int _TRAINER = 100;
    public TableCellRenderer getCellRenderer(int row, int column) {
        return new javax.swing.table.DefaultTableCellRenderer() {

            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                JLabel comp;
                comp = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if(column == 0) {
                    Trainer t = (Trainer) getModel().getValueAt(row, _TRAINER);
                }
                return comp;
            }
        };

    }

    class TrainersTableModel extends AbstractTableModel {

        String[] columnNames = {
                Local.getString("Name"),
                Local.getString("Position")};

        public String getColumnName(int i) {
            return columnNames[i];
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return trainers.size();
        }



        public Object getValueAt(int row, int col) {
            Trainer t = (Trainer) trainers.get(row);
            if (col == _TRAINER)
                return t;
            else {
                if(col == 0)
                    return t.getName();
                else if(col == 1)
                    return t.getPosition();
                else return "";
            }
        }


        public Class getColumnClass(int col) {
            try {
                switch (col) {
                    case 0 :
                    case 1 :
                        return Class.forName("java.lang.String");
                }
            }
            catch (Exception ex) {new ExceptionDialog(ex);}
            return null;
        }
    }
}
