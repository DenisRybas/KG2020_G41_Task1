package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    private Random rand = new Random(System.currentTimeMillis());

    private enum Season {
        Fall,
        Summer
    }

    private final DrawPanel.Season szn = rand.nextInt(2) == 0 ? Season.Summer : Season.Fall;

    @Override
    public void paint(Graphics g) {
        drawWorld((Graphics2D) g);
        drawSun((Graphics2D) g);
        drawClouds((Graphics2D) g);
        drawStones((Graphics2D) g);
        drawTrees((Graphics2D) g);
    }

    private void drawClouds(Graphics2D g) {
        int numOfClouds = szn == Season.Fall ? rand.nextInt(10) + 20 : rand.nextInt(8) + 1;
        for (int i = 0; i < numOfClouds; i++) {
            int r = rand.nextInt(60) + 30;
            int n = rand.nextInt(5) + 4;
            int x = rand.nextInt(getWidth() - n * r);
            int y = rand.nextInt(getHeight() / 10);
            Cloud c = new Cloud(x, y, r, n);
            c.draw(g);
        }
    }

    private void drawWorld(Graphics2D g) {
        World world = new World(getWidth(), getHeight(),
                szn == Season.Summer ? new Color(96, 128, 56) : new Color(243, 188, 46),
                szn == Season.Summer ? new Color(149, 200, 216) : new Color(129, 182, 221));
        world.draw(g);
    }

    private void drawSun(Graphics2D g) {
        int r = 40;
        Sun sun = new Sun(getWidth() - 2 * r, 2 * r, r, 2 * r, rand.nextInt(12) + 8,
                rand.nextInt(2) == 0 ? Color.ORANGE : Color.YELLOW);
        sun.draw(g);
    }

    private void drawStones(Graphics2D g) {
        int numberOfStones = rand.nextInt(5) + 5;
        for (int i = 0; i < numberOfStones; i++) {
            int w = rand.nextInt(20) + 10;
            int h = rand.nextInt(10) + 5;
            Stone s = new Stone(rand.nextInt(getWidth() - 2 * w / 10) + w / 10,
                    rand.nextInt(getHeight() / 2 - h) + getHeight() / 2, w, h);
            s.draw(g);
        }
    }

    private void drawTrees(Graphics2D g) {
        int numOfTrees = rand.nextInt(5) + 1;
        Color c = szn == Season.Fall ? new Color(224, 204, 119) : new Color(11, 102, 35);
        for (int i = 0; i < numOfTrees; i++) {
            int r = rand.nextInt(35) + 40;
            int h = rand.nextInt(40) + 100;
            int w = rand.nextInt(20) + 40;
            int n = rand.nextInt(3) + 3;
            int x = rand.nextInt(getWidth() - 3 * r - i * r / numOfTrees) + r;
            int y = rand.nextInt(getHeight() / 10) + 9 * getHeight() / 10 - h;
            int nApples = szn == Season.Fall ? 0 : rand.nextInt(5) + 5;
            Tree t = new Tree(x, y, h, w, n, r, nApples, c);
            t.draw(g);
        }
    }
}
