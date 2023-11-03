import main.java.memoranda.ui.AddStudentDialog;
import main.java.memoranda.ui.App;
import main.java.memoranda.ui.TaskDialog;
import main.java.memoranda.ui.TaskTable;
import main.java.memoranda.util.Local;

import java.awt.*;

public class dialogTest_StudentAddDialog {

    public static void main(String args[]){
        AddStudentDialog dlg = new AddStudentDialog(App.getFrame(), "New Student");
        dlg.setVisible(true);
    }

}
