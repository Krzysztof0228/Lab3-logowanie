package program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginListener implements ActionListener {
    //Główna ramka programu
    private final JFrame frame;
    //Panel logowania
    private LoginPanel loginPanel;

    private int breakApp=0;

    public void setLoginPanel(LoginPanel loginPanel){
        this.loginPanel=loginPanel;
    }

    public LoginListener(JFrame frame){
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = loginPanel.getName();
        String password = loginPanel.getPassword();
        if(UserValidator.authenticate(name, password)){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    loginPanel.setBackground(Color.GREEN);
                    loginPanel.validate();
                }
            });
        }
        if(!UserValidator.authenticate(name, password)){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    loginPanel.setBackground(Color.RED);
                    loginPanel.validate();
                    breakApp++;
                }
            });
        }
        if(breakApp==3){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.dispose();
                }
            });
        }
    }
}
