package com.company.graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        NewDrawPanel dp = new NewDrawPanel();
        //DrawPanel dp = new DrawPanel();
        this.add(dp);
    }
}
