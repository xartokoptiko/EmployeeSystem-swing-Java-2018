package com.employeesystem.system.gfx.menu;

import com.employeesystem.system.gfx.About;
import com.employeesystem.system.gfx.AddEmployee;
import com.employeesystem.system.gfx.Contact;
import com.employeesystem.system.gfx.DeleteEmployee;
import com.employeesystem.system.gfx.EditEmployee;
import java.awt.Component;
import java.awt.MenuBar;
import javax.swing.JOptionPane;

public class Menu extends MenuBar {
    private Boolean admin;

    public Menu(Boolean admin) {
        this.admin = admin;
    }

    public void openAdd() {
        if (this.admin) {
            AddEmployee add = new AddEmployee();
            AddEmployee.mainWin();
        } else {
            JOptionPane.showMessageDialog((Component)null, "You can't use 'edit list functions unless you are logged in a an Admin'");
        }

    }

    public void openEdit() {
        if (this.admin) {
            EditEmployee edit = new EditEmployee();
            EditEmployee.mainWin();
        } else {
            JOptionPane.showMessageDialog((Component)null, "You can't use 'edit list functions unless you are logged in a an Admin'");
        }

    }

    public void openDel() {
        if (this.admin) {
            DeleteEmployee del = new DeleteEmployee();
            DeleteEmployee.mainWin();
        } else {
            JOptionPane.showMessageDialog((Component)null, "You can't use 'edit list functions unless you are logged in a an Admin'");
        }

    }

    public void openAb() {
        About about = new About();
        about.mainWin();
    }

    public void openCon() {
        Contact contact = new Contact();
        contact.mainWin();
    }
}
