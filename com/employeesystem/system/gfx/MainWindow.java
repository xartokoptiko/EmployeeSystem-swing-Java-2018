package com.employeesystem.system.gfx;

import com.employeesystem.data.Data;
import com.employeesystem.system.gfx.menu.Menu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow extends JPanel {
    public static JFrame frame;
    private static int width = 800;
    private static int height;
    private DefaultListModel id = new DefaultListModel();
    private DefaultListModel first = new DefaultListModel();
    private DefaultListModel last = new DefaultListModel();
    private DefaultListModel hours = new DefaultListModel();
    private DefaultListModel payment = new DefaultListModel();
    private static boolean admin;
    private JLabel idLabel;
    private JLabel firstLabel;
    private JLabel lastLAbel;
    private JLabel hoursLAbel;
    private JLabel paymentLabel;
    private JList IDList;
    private JList FirstList;
    private JList LastList;
    private JList HoursList;
    private JList PaymentList;
    private JScrollPane idScroll;
    private JScrollPane FirstScroll;
    private JScrollPane LastScroll;
    private JScrollPane HoursScroll;
    private JScrollPane PaymentScroll;
    public static JMenuBar menubar;
    public static JMenu Settings;
    public static JMenu EditList;
    private String path = System.getProperty("user.dir") + "/Data/com.employeesystem.data.Icons/mainWin/";

    public MainWindow(boolean admin) throws IOException, InterruptedException {
        MainWindow.admin = admin;
        Data data = new Data();
        Data.printID();
        Data.printFirst();
        Data.printLast();
        Data.printHours();
        Data.printPayment();
        final Menu MenuFuncs = new Menu(admin);
        this.setVisible(true);
        this.setBackground(Color.CYAN);
        Iterator var4 = Data.id.iterator();

        String row;
        String[] count;
        while(var4.hasNext()) {
            row = (String)var4.next();
            count = row.split("/");
            if (count.length == 1) {
                this.id.addElement(row);
            }
        }

        var4 = Data.first.iterator();

        while(var4.hasNext()) {
            row = (String)var4.next();
            count = row.split("/");
            if (count.length == 1) {
                this.first.addElement(row);
            }
        }

        var4 = Data.last.iterator();

        while(var4.hasNext()) {
            row = (String)var4.next();
            count = row.split("/");
            if (count.length == 1) {
                this.last.addElement(row);
            }
        }

        var4 = Data.hours.iterator();

        while(var4.hasNext()) {
            row = (String)var4.next();
            count = row.split("/");
            if (count.length == 1) {
                this.hours.addElement(row);
            }
        }

        var4 = Data.payment.iterator();

        while(var4.hasNext()) {
            row = (String)var4.next();
            count = row.split("/");
            if (count.length == 1) {
                this.payment.addElement(row);
            }
        }

        this.idLabel = new JLabel();
        this.firstLabel = new JLabel();
        this.lastLAbel = new JLabel();
        this.hoursLAbel = new JLabel();
        this.paymentLabel = new JLabel();
        this.IDList = new JList(this.id);
        this.FirstList = new JList(this.first);
        this.LastList = new JList(this.last);
        this.HoursList = new JList(this.hours);
        this.PaymentList = new JList(this.payment);
        this.idScroll = new JScrollPane();
        this.idScroll.setViewportView(this.IDList);
        this.idScroll.setHorizontalScrollBarPolicy(31);
        this.idScroll.setVerticalScrollBarPolicy(20);
        this.FirstScroll = new JScrollPane();
        this.FirstScroll.setViewportView(this.FirstList);
        this.FirstScroll.setHorizontalScrollBarPolicy(31);
        this.FirstScroll.setVerticalScrollBarPolicy(20);
        this.LastScroll = new JScrollPane();
        this.LastScroll.setViewportView(this.LastList);
        this.LastScroll.setHorizontalScrollBarPolicy(31);
        this.idScroll.setVerticalScrollBarPolicy(20);
        this.HoursScroll = new JScrollPane();
        this.HoursScroll.setViewportView(this.HoursList);
        this.HoursScroll.setHorizontalScrollBarPolicy(31);
        this.HoursScroll.setVerticalScrollBarPolicy(20);
        this.PaymentScroll = new JScrollPane();
        this.PaymentScroll.setViewportView(this.PaymentList);
        this.PaymentScroll.setHorizontalScrollBarPolicy(31);
        this.PaymentScroll.setVerticalScrollBarPolicy(20);
        JMenuItem exit = new JMenuItem("Exit program");
        exit.setBackground(Color.darkGray);
        exit.setForeground(Color.white);
        exit.setBorderPainted(false);
        JMenuItem aboutUs = new JMenuItem("About Us");
        aboutUs.setBorderPainted(false);
        aboutUs.setForeground(Color.white);
        aboutUs.setBackground(Color.darkGray);
        JMenuItem contact = new JMenuItem("Contact us");
        contact.setBackground(Color.darkGray);
        contact.setForeground(Color.white);
        contact.setBorderPainted(false);
        JMenuItem refresh = new JMenuItem("Refresh");
        refresh.setBackground(Color.darkGray);
        refresh.setBorderPainted(false);
        refresh.setForeground(Color.white);
        JMenuItem editEmpl = new JMenuItem("Edit Employee");
        editEmpl.setBackground(Color.darkGray);
        editEmpl.setForeground(Color.white);
        editEmpl.setBorderPainted(false);
        JMenuItem addEmpl = new JMenuItem("Add Employee");
        addEmpl.setBorderPainted(false);
        addEmpl.setForeground(Color.white);
        addEmpl.setBackground(Color.darkGray);
        JMenuItem deleteEmpl = new JMenuItem("Delete Employee");
        deleteEmpl.setBackground(Color.darkGray);
        deleteEmpl.setForeground(Color.white);
        deleteEmpl.setBorderPainted(false);
        menubar = new JMenuBar();
        menubar.setBackground(Color.darkGray);
        menubar.setBorderPainted(false);
        menubar.setForeground(Color.white);
        Settings = new JMenu("Settings");
        Settings.setForeground(Color.white);
        Settings.setBackground(Color.darkGray);
        Settings.add(exit);
        Settings.add(aboutUs);
        Settings.add(contact);
        Settings.add(refresh);
        Settings.setBorderPainted(false);
        EditList = new JMenu("Edit List");
        EditList.setForeground(Color.white);
        EditList.setBackground(Color.darkGray);
        EditList.add(editEmpl);
        EditList.add(addEmpl);
        EditList.add(deleteEmpl);
        EditList.setBorderPainted(false);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        aboutUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuFuncs.openAb();
            }
        });
        contact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuFuncs.openCon();
            }
        });
        addEmpl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuFuncs.openAdd();
            }
        });
        editEmpl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuFuncs.openEdit();
            }
        });
        deleteEmpl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuFuncs.openDel();
            }
        });
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainWindow.this.closeWin();

                try {
                    MainWindow.this.mainWindow();
                } catch (IOException var3) {
                    var3.printStackTrace();
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }

            }
        });
        this.IDList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int value = MainWindow.this.IDList.getSelectedIndex();
                MainWindow.this.FirstList.setSelectedIndex(value);
                MainWindow.this.LastList.setSelectedIndex(value);
                MainWindow.this.HoursList.setSelectedIndex(value);
                MainWindow.this.PaymentList.setSelectedIndex(value);
            }
        });
        this.FirstList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int value = MainWindow.this.FirstList.getSelectedIndex();
                MainWindow.this.IDList.setSelectedIndex(value);
                MainWindow.this.LastList.setSelectedIndex(value);
                MainWindow.this.HoursList.setSelectedIndex(value);
                MainWindow.this.PaymentList.setSelectedIndex(value);
            }
        });
        this.LastList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int value = MainWindow.this.LastList.getSelectedIndex();
                MainWindow.this.FirstList.setSelectedIndex(value);
                MainWindow.this.LastList.setSelectedIndex(value);
                MainWindow.this.HoursList.setSelectedIndex(value);
                MainWindow.this.PaymentList.setSelectedIndex(value);
            }
        });
        this.IDList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int value = MainWindow.this.IDList.getSelectedIndex();
                MainWindow.this.FirstList.setSelectedIndex(value);
                MainWindow.this.IDList.setSelectedIndex(value);
                MainWindow.this.HoursList.setSelectedIndex(value);
                MainWindow.this.PaymentList.setSelectedIndex(value);
            }
        });
        this.HoursList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int value = MainWindow.this.HoursList.getSelectedIndex();
                MainWindow.this.FirstList.setSelectedIndex(value);
                MainWindow.this.LastList.setSelectedIndex(value);
                MainWindow.this.IDList.setSelectedIndex(value);
                MainWindow.this.PaymentList.setSelectedIndex(value);
            }
        });
        this.PaymentList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int value = MainWindow.this.PaymentList.getSelectedIndex();
                MainWindow.this.FirstList.setSelectedIndex(value);
                MainWindow.this.LastList.setSelectedIndex(value);
                MainWindow.this.HoursList.setSelectedIndex(value);
                MainWindow.this.IDList.setSelectedIndex(value);
            }
        });
        menubar.add(Settings);
        menubar.add(EditList);
        this.idLabel.setIcon(new ImageIcon(this.path + "hashtag.png"));
        this.firstLabel.setIcon(new ImageIcon(this.path + "name.png"));
        this.lastLAbel.setIcon(new ImageIcon(this.path + "name.png"));
        this.hoursLAbel.setIcon(new ImageIcon(this.path + "clock.png"));
        this.paymentLabel.setIcon(new ImageIcon(this.path + "money.png"));
        this.setPreferredSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.setLayout((LayoutManager)null);
        this.add(this.idLabel);
        this.add(this.firstLabel);
        this.add(this.lastLAbel);
        this.add(this.hoursLAbel);
        this.add(this.paymentLabel);
        this.add(this.idScroll);
        this.add(this.FirstScroll);
        this.add(this.LastScroll);
        this.add(this.HoursScroll);
        this.add(this.PaymentScroll);
        this.idLabel.setBounds(5, 0, 158, 40);
        this.idLabel.setFont(new Font("OpenSans", 1, 20));
        this.idLabel.setHorizontalAlignment(0);
        this.idLabel.setForeground(Color.white);
        this.firstLabel.setBounds(163, 0, 158, 40);
        this.firstLabel.setFont(new Font("TimesRoman", 1, 20));
        this.firstLabel.setHorizontalAlignment(0);
        this.firstLabel.setForeground(Color.white);
        this.lastLAbel.setBounds(321, 0, 158, 40);
        this.lastLAbel.setFont(new Font("TimesRoman", 1, 20));
        this.lastLAbel.setHorizontalAlignment(0);
        this.lastLAbel.setForeground(Color.white);
        this.hoursLAbel.setBounds(479, 0, 158, 40);
        this.hoursLAbel.setFont(new Font("TimesRoman", 1, 20));
        this.hoursLAbel.setHorizontalAlignment(0);
        this.hoursLAbel.setForeground(Color.white);
        this.paymentLabel.setBounds(637, 0, 158, 40);
        this.paymentLabel.setFont(new Font("TimesRoman", 1, 20));
        this.paymentLabel.setHorizontalAlignment(0);
        this.paymentLabel.setForeground(Color.white);
        this.idScroll.setBounds(5, 40, 153, height - 65);
        this.IDList.setFont(new Font("Open Sans", 1, 16));
        this.FirstScroll.setBounds(163, 40, 153, height - 65);
        this.FirstList.setFont(new Font("Open Sans", 1, 16));
        this.LastScroll.setBounds(321, 40, 153, height - 65);
        this.LastList.setFont(new Font("Open Sans", 1, 16));
        this.HoursScroll.setBounds(479, 40, 153, height - 65);
        this.HoursList.setFont(new Font("Open Sans", 1, 16));
        this.PaymentScroll.setBounds(637, 40, 153, height - 65);
        this.PaymentList.setFont(new Font("Open Sans", 1, 16));
    }

    public void mainWindow() throws IOException, InterruptedException {
        frame = new JFrame("Employee List");
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().add(new MainWindow(admin));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
        frame.setResizable(true);
        frame.setJMenuBar(menubar);
    }

    private void closeWin() {
        frame.setVisible(false);
        frame.dispose();
        this.id.removeAllElements();
        this.first.removeAllElements();
        this.last.removeAllElements();
        this.hours.removeAllElements();
        this.payment.removeAllElements();
        Data.id.clear();
        Data.first.clear();
        Data.last.clear();
        Data.hours.clear();
        Data.payment.clear();
    }

    static {
        height = width / 12 * 9;
    }
}
