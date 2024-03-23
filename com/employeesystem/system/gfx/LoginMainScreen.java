package com.employeesystem.system.gfx;

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
import javax.swing.JPanel;

public class LoginMainScreen extends JPanel {
    public static JFrame frame;
    public static final int width = 500;
    public static final int height = 369;
    private JLabel guest;
    private JLabel admin;
    private String path = System.getProperty("user.dir") + "/Data/com.employeesystem.data.Icons/mainLogin/";

    public LoginMainScreen() {
        this.guest = new JLabel(new ImageIcon(this.path + "guest.png"));
        this.admin = new JLabel(new ImageIcon(this.path + "admin.png"));
        this.setVisible(true);
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(500, 369));
        this.setMinimumSize(new Dimension(500, 369));
        this.setMaximumSize(new Dimension(500, 369));
        this.setLayout((LayoutManager)null);
        this.add(this.guest);
        this.add(this.admin);
        this.admin.setBounds(110, 110, 100, 100);
        this.admin.setHorizontalAlignment(0);
        this.admin.setToolTipText("Login as admin");
        this.guest.setBounds(300, 110, 100, 100);
        this.guest.setHorizontalAlignment(0);
        this.guest.setToolTipText("Log in as a guest");
        this.admin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                LoginScreen login = new LoginScreen();

                try {
                    LoginScreen.mainWindow();
                    LoginMainScreen.this.closeWin();
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
        this.guest.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                try {
                    MainWindow win = new MainWindow(false);
                    win.mainWindow();
                    LoginMainScreen.this.closeWin();
                } catch (IOException var3) {
                    var3.printStackTrace();
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }

            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public static void mainWindow() throws IOException, InterruptedException {
        frame = new JFrame("Employee System");
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().add(new LoginMainScreen());
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
