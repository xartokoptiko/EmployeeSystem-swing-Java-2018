package com.employeesystem.system;

import com.employeesystem.system.gfx.LoginMainScreen;
import java.io.IOException;

public class Window {
    public Window() throws IOException, InterruptedException {
        LoginMainScreen loginMain = new LoginMainScreen();
        LoginMainScreen.mainWindow();
    }
}
