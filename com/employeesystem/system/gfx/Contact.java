package com.employeesystem.system.gfx;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Contact extends JPanel {
    public static int Width = 550;
    public static int Height;
    private JLabel emailIcon;
    private JLabel email;
    private String path = System.getProperty("user.dir") + "/Data/com.employeesystem.data.Icons/mainWin/";

    public Contact() {
        this.setPreferredSize(new Dimension(Width, Height));
        this.setMinimumSize(new Dimension(Width, Height));
        this.setMaximumSize(new Dimension(Width, Height));
        this.setBackground(Color.CYAN);
        this.setLayout((LayoutManager)null);
        this.emailIcon = new JLabel(new ImageIcon(this.path + "email.png"));
        this.email = new JLabel("lamproskarachristos@yahoo.com");
        this.add(this.emailIcon);
        this.add(this.email);
        this.emailIcon.setBounds(90, 200, 25, 25);
        this.email.setBounds(120, 200, 340, 25);
        this.email.setFont(new Font("TimesRoman", 1, 18));
    }

    public static void mainWin() {
        JFrame frame = new JFrame("Contact us");
        frame.getContentPane().add(new Contact());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        mainWin();
    }

    static {
        Height = Width / 12 * 10;
    }
}
