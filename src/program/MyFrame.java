package program;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    public MyFrame() {
        super("Okienko logowania");
        LoginListener listener = new LoginListener(this);
        JPanel loginPanel = new LoginPanel(listener);
        add(loginPanel);

        setPreferredSize(new Dimension(600,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
