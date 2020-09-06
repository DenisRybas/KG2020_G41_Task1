package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    //private Sun sun = new Sun(200, 300, 50, 120, 70, Color.ORANGE);
    @Override
    public void paint(Graphics g) {
        Random rand = new Random(System.currentTimeMillis());
        int numOfTrees = rand.nextInt(4) + 1;
        for (int i = 0; i < numOfTrees; i++) {
            int h = rand.nextInt(40) + 100;
            int w = rand.nextInt(20) + 40;
            int r = rand.nextInt(35) + 40;
            int n = rand.nextInt(5) + 1;
            int x = rand.nextInt(getWidth() - 3 * r) + r;
            int y = rand.nextInt(getHeight() - 3 * h) + 2 * h;
            Tree t = new Tree(x, y, h, w, n, r, Color.GREEN);
            t.draw((Graphics2D) g);
        }
    }

}
