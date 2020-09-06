package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawPanel extends JPanel {
    Random rand = new Random(System.currentTimeMillis());

    @Override
    public void paint(Graphics g) {
        drawTree((Graphics2D) g);
        drawSun((Graphics2D) g);

    }

    private void drawSun(Graphics2D g) {
        int r = 40;
        Sun sun = new Sun(getWidth() - 2 * r, 2 * r, r, 2 * r, rand.nextInt(12) + 8,
                rand.nextInt(2) == 0 ? Color.ORANGE: Color.YELLOW);
        sun.draw(g);
    }

    private void drawTree(Graphics2D g) {
        int numOfTrees = rand.nextInt(4) + 1;
        for (int i = 0; i < numOfTrees; i++) {
            int r = rand.nextInt(35) + 40;
            int h = rand.nextInt(40) + 100;
            int w = rand.nextInt(20) + 40;
            int n = rand.nextInt(5) + 1;
            int x = rand.nextInt(getWidth() - 3 * r) + r;
            int y = rand.nextInt(getHeight() / 10) + 9 * getHeight() / 10 - h;
            Tree t = new Tree(x, y, h, w, n, r, Color.GREEN);
            t.draw(g);
        }
    }

    private void drawBackground() {

    }
}
