package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameMainFrame extends JFrame implements KeyListener, ActionListener {
    // Pictures order
    public int[][] data = new int[4][4];
    // Correct order
    public int[][] win = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0},

    };

    // Step count
    int step = 0;


    // Location of empty block
    int x = 0;
    int y = 0;

    // path of current picture
    String path = "image/animal/animal3/";

    // Create menu items
    JMenuItem restartGameJItem = new JMenuItem("Restart");
    JMenuItem loginJItem = new JMenuItem("Login to another account");
    JMenuItem exitGameJItem = new JMenuItem("Exit Game");
    JMenu changePic = new JMenu("Change pictures");

    JMenuItem aboutUsJItem = new JMenuItem("Us");

    // Add JMenu into changePic
    JMenuItem animals = new JMenuItem("Animals");
    JMenuItem sport = new JMenuItem("Sport");

    public GameMainFrame() {
        initJFrame();

        initMenu();

        // Randomise pictures location
        initData();

        initImage();

        // Make window visible
        this.setVisible(true);
    }

    private void initData() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }

        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = arr[index];
                if (data[i][j] == 0) {
                    x = i;
                    y = j;
                }
                index++;
            }
        }
    }

    private void initImage() {
        // Clear
        this.getContentPane().removeAll();

        // Show victory if win
        if (isVictory()) {
            JLabel winJLabel = new JLabel(new ImageIcon("image/win.png"));
            winJLabel.setBounds(203, 283, 197,73);
            this.getContentPane().add(winJLabel);
        }

        // Step count
        JLabel stepCount = new JLabel("Step: " + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);


        // First add items on the top
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Create ImageIcon and JLabel container
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));

                // Set location of image
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);

                // Add border
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                // Add image to window
                this.getContentPane().add(jLabel);
            }
        }
        // Initialise background image
        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    private void initJFrame() {
        // Set dimension of window
        this.setSize(603, 680);

        // Set title of window
        this.setTitle("Puzzle Game v1.0");

        // Set window on top
        this.setAlwaysOnTop(true);

        // Set location of window
        this.setLocationRelativeTo(null);

        // Set closing mode
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Cancel default(centre) location of image
        this.setLayout(null);

        // Key Listener
        this.addKeyListener(this);
    }

    private void initMenu() {
        // Initialise Menu
        JMenuBar jMenuBar = new JMenuBar();

        // Options
        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutUsJMenu = new JMenu("About Us");

        // Add JMenu into JMenuItems
        changePic.add(animals);
        changePic.add(sport);

        // Add items into options
        functionJMenu.add(changePic);
        functionJMenu.add(restartGameJItem);
        functionJMenu.add(loginJItem);
        functionJMenu.add(exitGameJItem);

        aboutUsJMenu.add(aboutUsJItem);

        // Add options into menu bar
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutUsJMenu);

        // Place menu bar into window
        this.setJMenuBar(jMenuBar);

        // Mouse Listener for menu options
        restartGameJItem.addActionListener(this);
        loginJItem.addActionListener(this);
        exitGameJItem.addActionListener(this);
        aboutUsJItem.addActionListener(this);
        changePic.addActionListener(this);
        animals.addActionListener(this);
        sport.addActionListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == e.VK_A) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            // Initialise background image
            JLabel background = new JLabel(new ImageIcon("image/background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Check if win game
        if (isVictory()) {
            return;
        }

        int key = e.getKeyCode();

        if (key == 37) {
            if (y == 3)
                return;

            int temp = data[x][y + 1];
            data[x][y + 1] = data[x][y];
            data[x][y] = temp;
            y++;
            initImage();
            System.out.println("Move Left");
            step++;


        } else if (key == 38) {
            if (x == 3)
                return;

            int temp = data[x + 1][y];
            data[x + 1][y] = data[x][y];
            data[x][y] = temp;
            x++;
            initImage();
            System.out.println("Move Upward");
            step++;
        } else if (key == 39) {
            if (y == 0)
                return;

            int temp = data[x][y - 1];
            data[x][y - 1] = data[x][y];
            data[x][y] = temp;
            y--;
            initImage();
            System.out.println("Move Right");
            step++;
        } else if (key == 40) {
            if (x == 0)
                return;
            int temp = data[x - 1][y];
            data[x - 1][y] = data[x][y];
            data[x][y] = temp;
            x--;
            initImage();
            System.out.println("Move Downward");
            step++;
        } else if (key == 65) {
            initImage();
        } else if (key == e.VK_W) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }
    }
    
    private boolean isVictory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(restartGameJItem)) {
            initData();
            // Reset step count
            step = 0;
            initImage();
            System.out.println("Restart");
        } else if (obj.equals(loginJItem)) {
            this.setVisible(false);
            new LoginFrame();
            System.out.println("Login");
        } else if (obj.equals(exitGameJItem)) {
            System.out.println("Exit");
            System.exit(0);
        } else if (obj.equals(aboutUsJItem)) {
            System.out.println("About Us");
            JDialog aboutUs = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("image/QRcode.jpg"));
            jLabel.setBounds(0,0,258,334);
            aboutUs.getContentPane().add(jLabel);
            aboutUs.setSize(500,500);
            aboutUs.setAlwaysOnTop(true);
            aboutUs.setLocationRelativeTo(null);
            aboutUs.setModal(true);
            aboutUs.setVisible(true);
        } else if (obj.equals(animals)) {
            this.getContentPane().removeAll();
            System.out.println("Change animal picture");
            Random r = new Random();
            int pic = r.nextInt(1, 9);
            path = "image/animal/animal" + pic + "/";
            initData();
            initImage();
        } else if (obj.equals(sport)) {
            this.getContentPane().removeAll();
            System.out.println("Change sport pictures");
            Random r = new Random();
            int pic = r.nextInt(1, 11);
            path = "image/sport/sport" + pic + "/";
            initData();
            initImage();
        }
    }
}
