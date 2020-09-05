package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private Sun sun = new Sun(200, 300, 50, 120, 70, Color.ORANGE);
    private Root root = new Root(250, 250, 40, 5);
    @Override
    public void paint(Graphics g) {
        sun.draw((Graphics2D) g);
        g.setColor(new Color(51,0,0));
        root.draw((Graphics2D) g);
    }

}
