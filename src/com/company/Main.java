package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MainFrame mw = new MainFrame();
        mw.setSize(new Dimension(800, 600));
        mw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mw.setVisible(true);
    }
}
