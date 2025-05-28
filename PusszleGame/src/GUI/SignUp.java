package GUI;

import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {

    public SignUp() {
        // Set dimension of window
        this.setSize(488, 500);

        // Set title of window
        this.setTitle("Puzzle Game Sign Up");

        // Set window on top
        this.setAlwaysOnTop(true);

        // Set location of window
        this.setLocationRelativeTo(null);

        // Set closing mode
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Make window visible
        this.setVisible(true);
    }
}
