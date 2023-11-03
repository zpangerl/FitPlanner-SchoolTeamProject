import main.java.memoranda.ui.AddStudentDialog;
import main.java.memoranda.ui.App;
import main.java.memoranda.ui.TaskDialog;
import main.java.memoranda.util.Local;

public class dialogTest_StudentAddDialog {

    public static void main(String args[]){
        AddStudentDialog dlg = new AddStudentDialog(App.getFrame(), Local.getString("New Student"));
    }

}
