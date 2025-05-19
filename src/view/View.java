package view;

import java.awt.Component;
import utils.MessageDisplayer;
import view.modules.login.LoginWindow;
import view.modules.signup.RegisterWindow;
import view.windows.MainWindow;

/**
 * Esta clase representa la vista principal de la aplicación.
 * Contiene las ventanas de inicio de sesión, registro y la ventana principal.
 */
public class View {

    private LoginWindow loginWindow;
    private RegisterWindow registerWindow;
    private MainWindow mainWindow;

    /**
     * Constructor de la clase View.
     * Inicializa las ventanas de inicio de sesión, registro y la ventana principal.
     */
    public View() {
        loginWindow = new LoginWindow();
        registerWindow = new RegisterWindow();
        mainWindow = new MainWindow();
    }

    /**
     * Muestra un mensaje de error.
     * @param parent El componente padre desde el cual se muestra el mensaje.
     * @param message El mensaje de error a mostrar.
     */
    public void showErrorMessage(Component parent, String message) {
        MessageDisplayer.showErrorMessage(parent, message, "Error");
    }

    /**
     * Muestra un mensaje de error.
     * @param message El mensaje de error a mostrar.
     */
    public void showErrorMessage(String message) {
        showErrorMessage(mainWindow, message);
    }

    /**
     * Muestra un mensaje de información.
     * @param parent El componente padre desde el cual se muestra el mensaje.
     * @param message El mensaje de información a mostrar.
     */
    public void showInfoMessage(Component parent, String message) {
        MessageDisplayer.showInfoMessage(parent, message, "Information");
    }

    /**
     * Muestra un mensaje de información.
     * @param message El mensaje de información a mostrar.
     */
    public void showInfoMessage(String message) {
        showInfoMessage(mainWindow, message);
    }

    /**
     * Obtiene la ventana de inicio de sesión.
     * @return La ventana de inicio de sesión.
     */
    public LoginWindow getLoginWindow() {
        return loginWindow;
    }

    /**
     * Establece la ventana de inicio de sesión.
     * @param loginWindow La ventana de inicio de sesión a establecer.
     */
    public void setLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
    }

    /**
     * Obtiene la ventana de registro.
     * @return La ventana de registro.
     */
    public RegisterWindow getRegisterWindow() {
        return registerWindow;
    }

    /**
     * Establece la ventana de registro.
     * @param registerWindow La ventana de registro a establecer.
     */
    public void setRegisterWindow(RegisterWindow registerWindow) {
        this.registerWindow = registerWindow;
    }

    /**
     * Obtiene la ventana principal.
     * @return La ventana principal.
     */
    public MainWindow getMainWindow() {
        return mainWindow;
    }

    /**
     * Establece la ventana principal.
     * @param mainWindow La ventana principal a establecer.
     */
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
}
