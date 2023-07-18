package org.example.window.primary;

import java.awt.event.WindowEvent;
import org.example.Main;
import org.example.window.primary.Window;

public class WindowListener implements java.awt.event.WindowListener {

    public WindowListener(Window window) {
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        Main.windows.remove(e.getWindow());
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
