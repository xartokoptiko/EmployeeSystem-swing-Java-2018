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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEmployee extends JPanel {
    public static JFrame frame;
    private Data data = new Data();
    public static int Width = 400;
    public static int Height;
    private JLabel add;
    private JTextField id;
    private JTextField first;
    private JTextField last;
    private JTextField hours;
    private JTextField payment;
    private JLabel okey;
    private String path = System.getProperty("user.dir") + "/Data/com.employeesystem.data.Icons/mainLogin/";
    private String ID;
    private String First;
    private String Last;
    private String Hours;
    private String Payment;

    public AddEmployee() {
        this.setPreferredSize(new Dimension(Width, Height));
        this.setMinimumSize(new Dimension(Width, Height));
        this.setMaximumSize(new Dimension(Width, Height));
        this.setBackground(Color.CYAN);
        this.setLayout((LayoutManager)null);
        this.add = new JLabel(new ImageIcon(this.path + "add.png"));
        this.id = new JTextField();
        this.first = new JTextField();
        this.last = new JTextField();
        this.hours = new JTextField();
        this.payment = new JTextField();
        this.okey = new JLabel(new ImageIcon(this.path + "ok.png"));
        this.add(this.add);
        this.add(this.id);
        this.add(this.first);
        this.add(this.last);
        this.add(this.hours);
        this.add(this.payment);
        this.add(this.okey);
        this.add.setBounds(150, 5, 100, 100);
        this.id.setBounds(80, 110, 250, 25);
        this.id.setToolTipText("ID");
        this.first.setBounds(80, 140, 250, 25);
        this.first.setToolTipText("First Name");
        this.last.setBounds(80, 170, 250, 25);
        this.last.setToolTipText("Last Name");
        this.hours.setBounds(80, 200, 250, 25);
        this.hours.setToolTipText("Working hours");
        this.payment.setBounds(80, 230, 250, 25);
        this.payment.setToolTipText("Total Payment");
        this.okey.setBounds(180, 260, 50, 50);
        this.okey.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                try {
                    AddEmployee.this.addEmpl();
                    AddEmployee.this.closeWin();
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

    public static void mainWin() {
        frame = new JFrame("Add Employee");
        frame.getContentPane().add(new AddEmployee());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
        frame.setResizable(false);
    }

    private void addEmpl() throws IOException, InterruptedException {
        this.ID = this.id.getText().toString();
        this.First = this.first.getText().toString();
        this.Last = this.last.getText().toString();
        this.Hours = this.hours.getText().toString();
        this.Payment = this.payment.getText().toString();
        this.data.addEmployee(this.ID, this.First, this.Last, this.Hours, this.Payment);
    }

    private void closeWin() {
        frame.setVisible(false);
        frame.dispose();
    }

    static {
        Height = Width / 12 * 10;
    }
}
