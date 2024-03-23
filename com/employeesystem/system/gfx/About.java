package com.employeesystem.system.gfx;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JPanel {
    public static int Width = 550;
    public static int Height;
    private JLabel about;

    public About() {
        this.setPreferredSize(new Dimension(Width, Height));
        this.setMinimumSize(new Dimension(Width, Height));
        this.setMaximumSize(new Dimension(Width, Height));
        this.setBackground(Color.CYAN);
        this.setLayout((LayoutManager)null);
        this.about = new JLabel("<html>Employee System at first started as an challenge to me to see if i'm able enough to control data stractures and data handling! Right now it's one of my biggest projects and gave a tone of more ideas for the future! Having a problem? Just go to 'Contact us' and communicate with me. I would love to help you!</html>", 0);
        this.add(this.about);
        this.about.setBounds(90, 70, 400, 300);
        this.about.setFont(new Font("TimesRoman", 1, 20));
    }

    public static void mainWin() {
        JFrame frame = new JFrame("About us");
        frame.getContentPane().add(new About());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
        frame.setResizable(false);
    }

    static {
        Height = Width / 12 * 10;
    }
}
