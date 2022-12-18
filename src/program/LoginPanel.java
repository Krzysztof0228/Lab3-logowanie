package program;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private LoginListener listener;

    //Nazwa użytkownika
    public String getName(){
        return nameField.getText();
    }

    //Hasło
    public String getPassword(){
        String password="";
        char[] pass = passwordField.getPassword();
        for(int i=0;i<pass.length;i++){
            password+=pass[i];
        }
        return password;
    }

    public LoginPanel(LoginListener listener){
        super();
        //Layout
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBagLayout.setConstraints(this, constraints);
        setLayout(gridBagLayout);
        //Komponent logowania
        this.listener = listener;
        this.listener.setLoginPanel(this);
        createComponents();
    }

    private void createComponents(){
        JLabel name = new JLabel("Nazwa: ");
        JLabel password = new JLabel("Hasło: ");
        nameField = new JTextField();
        nameField.setSize(150, 20);
        passwordField = new JPasswordField();
        passwordField.setSize(150, 20);

        //Panel do wprowadzania danych
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,2));
        inputPanel.add(name);
        inputPanel.add(nameField);
        inputPanel.add(password);
        inputPanel.add(passwordField);
        //Przycisk logowania
        loginButton=new JButton("Zaloguj");
        loginButton.addActionListener(listener);

        //Panel do wyśrodkowania elementów
        JPanel parentPanel=new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);
        parentPanel.add(loginButton, BorderLayout.SOUTH);

        this.add(parentPanel);
    }

}
