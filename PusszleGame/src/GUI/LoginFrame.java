package GUI;

import javax.print.DocFlavor;
import javax.swing.*;

import User.User;
import Utils.VerifyingCodeUtil;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginFrame extends JFrame implements MouseListener {
    static ArrayList<User> user = new ArrayList<>();

    // Create default user
    static {
        User admin = new User("admin", "0000");
        user.add(admin);
    }

    // Create buttons
    JButton loginBtn = new JButton(new ImageIcon("image/login/登录按钮.png"));
    JButton signupBtn = new JButton(new ImageIcon("image/login/注册按钮.png"));

    // Create verifying code
    JLabel codeText = new JLabel();

    // Add username, pwd, verifying Textbox, verifying code
    JTextField usernameText = new JTextField();
    JPasswordField pwdText = new JPasswordField();
    JTextField verifyCodeText = new JTextField();
    int numberOfDigitOfVerifyingCode = 5;
    String code = VerifyingCodeUtil.generateCode(numberOfDigitOfVerifyingCode);

    public LoginFrame() {
        initJFrame();
        initImage();
    }

    private void initImage() {
        this.getContentPane().removeAll();

        // Add username image
        JLabel username = new JLabel(new ImageIcon("image/login/用户名.png"));
        username.setBounds(116, 135, 47, 17);
        this.getContentPane().add(username);

        // Configure username Textbox
        usernameText.setBounds(195, 134, 200, 30);
        this.getContentPane().add(usernameText);


        // Add pwd image
        JLabel pwd = new JLabel(new ImageIcon("image/login/密码.png"));
        pwd.setBounds(130, 195, 32, 16);
        this.getContentPane().add(pwd);

        // Configure pwd Textbox
        pwdText.setBounds(195, 195, 200, 30);
        this.getContentPane().add(pwdText);


        // Add verifying code image
        JLabel verifyCode = new JLabel(new ImageIcon("image/login/验证码.png"));
        verifyCode.setBounds(133, 256, 50, 30);
        this.getContentPane().add(verifyCode);

        // Configure verifying code textbox
        verifyCodeText.setBounds(195, 256, 100, 30);
        this.getContentPane().add(verifyCodeText);

        // configure verifying code
        codeText.setText(code);
        codeText.setBounds(300, 256, 50, 30);
        codeText.addMouseListener(this);
        this.getContentPane().add(codeText);


        // Add login button
        loginBtn.setBounds(123, 310, 128, 47);
        // Remove border
        loginBtn.setBorderPainted(false);
        // Remove background
        loginBtn.setContentAreaFilled(false);
        loginBtn.addMouseListener(this);
        this.getContentPane().add(loginBtn);


        // Add sign up button
        signupBtn.setBounds(256, 310, 128, 47);
        // Remove border
        signupBtn.setBorderPainted(false);
        // Remove background
        signupBtn.setContentAreaFilled(false);
        signupBtn.addMouseListener(this);
        this.getContentPane().add(signupBtn);


        // Add background image
        JLabel bg = new JLabel(new ImageIcon("image/login/background.png"));
        bg.setBounds(0, 0, 470, 390);
        this.getContentPane().add(bg);

        this.getContentPane().repaint();
    }

    private void initJFrame() {
        // Set dimension of window
        this.setSize(488, 430);

        // Set title of window
        this.setTitle("Puzzle Game Login");

        // Set window on top
        this.setAlwaysOnTop(true);

        // Set location of window
        this.setLocationRelativeTo(null);

        // Set closing mode
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Cancel default(centre) location of image
        this.setLayout(null);

        // Make window visible
        this.setVisible(true);
    }

    private boolean contains(User user) {
        String username = user.getId();
        String pwd = user.getPassword();

        for (User u : LoginFrame.user) {
            if (u.getId().equals(username) && u.getPassword().equals(pwd)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == loginBtn) {
            System.out.println("Login button is pressed");
            String username = usernameText.getText();
            char[] pwdArr = pwdText.getPassword();
            String pwd = new String(pwdArr);
            String code = verifyCodeText.getText();

            // Check if username or pwd or code is empty
            if (code.isEmpty()) {
                System.out.println("verifying code cannot be empty");
            }

            if (username.isEmpty() || pwd.isEmpty()) {
                System.out.println("username or password cannot be Empty");
            } else {
                // Check if User exists
                User user = new User(username, pwd);
                boolean doesContain = contains(user);

                // Check if verifying code is correct
                // Enter game when username and pwd are correct
                if (!code.equals(this.code)) {
                    System.out.println("Verifying code is incorrect");
                    showDialog("Verifying code is incorrect");
                    this.code = Utils.VerifyingCodeUtil.generateCode(numberOfDigitOfVerifyingCode);
                } else if (doesContain) {
                    System.out.println("Successfully Login");
                    this.setVisible(false);
                    new GameMainFrame();
                } else {
                    showDialog("username or password is Incorrect");
                    this.code = Utils.VerifyingCodeUtil.generateCode(numberOfDigitOfVerifyingCode);
                }
            }
        } else if (e.getSource() == signupBtn) {
            System.out.println("Register button is pressed but code for sign up is not implemented");
        } else if (e.getSource() == codeText) {
            System.out.println("Regenerate code is pressed");
            this.code = VerifyingCodeUtil.generateCode(numberOfDigitOfVerifyingCode);
            codeText.setText(code);
            codeText.revalidate();
            codeText.repaint();
        }
    }

    private void showDialog(String content) {
        // Initialise jDialog
        JDialog jDialog = new JDialog();
        jDialog.setSize(200, 150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);

        // initialise content shown on dialog
        JLabel jLabel = new JLabel(content);
        jLabel.setBounds(0,0,200,150);
        jDialog.getContentPane().add(jLabel);

        jDialog.setVisible(true);
    }

    // Press without release
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == loginBtn) {
            loginBtn.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if (e.getSource() == signupBtn) {
            signupBtn.setIcon(new ImageIcon("image/login/注册按下.png"));
        }
    }

    // Mouse is released
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == loginBtn) {
            loginBtn.setIcon(new ImageIcon("image/login/登录按钮.png"));
        } else if (e.getSource() == signupBtn) {
            signupBtn.setIcon(new ImageIcon("image/login/注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
