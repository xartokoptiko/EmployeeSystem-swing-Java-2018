package com.employeesystem.system.gfx;

import com.employeesystem.data.Data;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeleteEmployee extends JPanel {
    public static JFrame frame;
    private Data data = new Data();
    public static int Width = 400;
    public static int Height;
    private JLabel del;
    private JComboBox ID;
    private JLabel okey;
    private String path = System.getProperty("user.dir") + "/Data/com.employeesystem.data.Icons/mainLogin/";

    public DeleteEmployee() {
        this.setPreferredSize(new Dimension(Width, Height));
        this.setMinimumSize(new Dimension(Width, Height));
        this.setMaximumSize(new Dimension(Width, Height));
        this.setBackground(Color.CYAN);
        this.setLayout((LayoutManager)null);
        this.del = new JLabel(new ImageIcon(this.path + "delete.png"));
        this.ID = new JComboBox();
        Iterator var1 = Data.id.iterator();

        while(var1.hasNext()) {
            String line = (String)var1.next();
            String[] count = line.split("/");
            if (count.length == 1) {
                this.ID.addItem(line);
            }
        }

        this.okey = new JLabel(new ImageIcon(this.path + "ok.png"));
        this.add(this.del);
        this.add(this.ID);
        this.add(this.okey);
        this.del.setBounds(150, 5, 100, 100);
        this.ID.setBounds(80, 160, 250, 25);
        this.okey.setBounds(180, 260, 50, 50);
        this.okey.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                try {
                    DeleteEmployee.this.data.deleteEmployee(DeleteEmployee.this.ID.getSelectedItem().toString());
                    DeleteEmployee.this.closeWin();
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
        frame = new JFrame("Delete Employee");
        frame.getContentPane().add(new DeleteEmployee());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
        frame.setResizable(false);
    }

    private void closeWin() {
        frame.setVisible(false);
        frame.dispose();
    }

    static {
        Height = Width / 12 * 10;
    }
}
