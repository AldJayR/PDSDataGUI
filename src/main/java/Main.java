
import controller.PDSController;
import model.PDSData;
import view.PDSNewForm;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        // Set the Nimbus look and feel

        SwingUtilities.invokeLater(() -> {
            PDSData model = new PDSData();
            PDSNewForm view = new PDSNewForm();
            PDSController controller = new PDSController(model, view);

            view.setController(controller);
            view.setTitle("CSC Personal Data Form");
            view.setVisible(true);
        });
    }

    private static void setNimbusFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Nimbus look and feel not found. Using default.");
        }
    }
}
