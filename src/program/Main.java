package program;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }
}
