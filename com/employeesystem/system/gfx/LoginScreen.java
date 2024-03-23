package com.employeesystem.system.gfx;

import com.employeesystem.data.Data;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends JPanel {
    public static JFrame frame;
    public static final int width = 400;
    public static final int height = 231;
    private JLabel login;
    private JLabel admin;
    private JTextField user;
    private JPasswordField pass;
    private String path = System.getProperty("user.dir") + "/Data/com.employeesystem.data.Icons/mainLogin/";
    private String username;
    private String password;

    public LoginScreen() {
        final Data data = new Data();
        this.login = new JLabel(new ImageIcon(this.path + "ok.png"));
        this.admin = new JLabel(new ImageIcon(this.path + "admin.png"));
        this.user = new JTextField();
        this.pass = new JPasswordField();
        this.setVisible(true);
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(400, 231));
        this.setMinimumSize(new Dimension(400, 231));
        this.setMaximumSize(new Dimension(400, 231));
        this.setLayout((LayoutManager)null);
        this.add(this.login);
        this.add(this.admin);
        this.add(this.user);
        this.add(this.pass);
        this.admin.setBounds(160, 0, 100, 100);
        this.user.setBounds(85, 105, 250, 20);
        this.pass.setBounds(85, 130, 250, 20);
        this.login.setBounds(180, 155, 50, 50);
        this.login.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                try {
                    LoginScreen.this.username = LoginScreen.this.user.getText().toString();
                    LoginScreen.this.password = String.valueOf(LoginScreen.this.pass.getPassword());
                    Data var10000 = data;
                    Data.printLogin(LoginScreen.this.username, LoginScreen.this.password);
                    String[] count = Data.login.split("/");
                    if (count.length == 2) {
                        MainWindow win = new MainWindow(true);
                        win.mainWindow();
                        LoginScreen.this.closeWin();
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Wrong Username or password !");
                        System.out.println("Counts lenght: " + count.length);
                    }
                } catch (IOException var4) {
                    var4.printStackTrace();
                } catch (InterruptedException var5) {
                    var5.printStackTrace();
                }

            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public static void mainWindow() throws IOException, InterruptedException {
        frame = new JFrame("Login");
        frame.getContentPane().add(new LoginScreen());
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
        frame.setResizable(false);
    }

    private void closeWin() {
        frame.setVisible(false);
        frame.dispose();
    }
}
