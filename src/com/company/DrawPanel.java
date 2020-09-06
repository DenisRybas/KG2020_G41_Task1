package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        Random rand = new Random(System.currentTimeMillis());
        int numOfTrees = rand.nextInt(4) + 1;
        for (int i = 0; i < numOfTrees; i++) {
            int r = rand.nextInt(35) + 40;
            int h = rand.nextInt(40) + 100;
            int w = rand.nextInt(20) + 40;
            int n = rand.nextInt(5) + 1;
            int x = rand.nextInt(getWidth() - 3 * r ) + r;
            int y = rand.nextInt(getHeight() / 10) + 9 * getHeight() / 10 -  h;
            Tree t = new Tree(x, y, h, w, n, r, Color.GREEN);
            t.draw((Graphics2D) g);
        }
    }

}
