package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    private Random rand = new Random(System.currentTimeMillis());

    private enum Time {
        Day,
        Night
    }

    private final DrawPanel.Time time = rand.nextInt(2) == 0 ? Time.Day : Time.Night;

    @Override
    public void paint(Graphics g) {
        drawWorld((Graphics2D) g);
        if (time == Time.Day) {
            drawSun((Graphics2D) g);
            drawClouds((Graphics2D) g);
            drawBirds((Graphics2D) g);
        } else {
            drawStars((Graphics2D) g);
            drawMoon((Graphics2D) g);
        }
        drawStones((Graphics2D) g);
        drawFlowers((Graphics2D) g);
        drawTrees((Graphics2D) g);
    }

    private void drawStars(Graphics2D g) {
        int numOfStars = rand.nextInt(30) + 10;
        for (int i = 0; i < numOfStars; i++) {
            int r = rand.nextInt(5) + 5;
            Star s = new Star(rand.nextInt(getWidth() - r), rand.nextInt(getHeight() / 4), r,
                    new Color(250, 253, 236));
            s.draw(g);
        }
    }

    private void drawMoon(Graphics2D g) {
        int r = 40;
        Moon m = new Moon(rand.nextInt(getWidth() - 2 * r), rand.nextInt(getHeight() / 10), r, new Color(244, 241, 201));
        m.draw(g);
    }

    private void drawFlowers(Graphics2D g) {
        Color[] dayColors = {new Color(233, 103, 117), new Color(197, 29, 52),
                new Color(139, 122, 168), new Color(207, 157, 230)};
        Color[] nightColors = {new Color(172, 85, 64), new Color(84, 115, 133)};

        int numOfFlowers = rand.nextInt(30) + 150;
        for (int i = 0; i < numOfFlowers; i++) {
            int r = rand.nextInt(10) + 5;
            Flower f = new Flower(getWidth() * i / numOfFlowers,
                    rand.nextInt(getHeight() / 2 - r) + getHeight() / 2, rand.nextInt(5) + 5,
                    r, time == Time.Day ? dayColors[rand.nextInt(dayColors.length)] : nightColors[rand.nextInt(nightColors.length)]);
            f.draw(g);
        }
    }

    private void drawBirds(Graphics2D g) {
        int numOfBirds = rand.nextInt(5) + 4;
        for (int i = 0; i < numOfBirds; i++) {
            int w = rand.nextInt(40) + 35;
            int h = rand.nextInt(10) + 10;
            Bird brd = new Bird(rand.nextInt(getWidth() - w), rand.nextInt(getHeight() / 4), w, h);
            brd.draw(g);
        }
    }

    private void drawClouds(Graphics2D g) {
        int numOfClouds = rand.nextInt(8) + 1;
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
                time == Time.Day ? new Color(96, 128, 56) : new Color(18, 52, 73),
                time == Time.Day ? new Color(129, 182, 221) : new Color(59, 60, 72));
        world.draw(g);
    }

    private void drawSun(Graphics2D g) {
        int r = 40;
        Sun sun = new Sun(getWidth() - 2 * r, 2 * r, r, 2 * r, rand.nextInt(12) + 8,
                rand.nextInt(2) == 0 ? Color.ORANGE : Color.YELLOW);
        sun.draw(g);
    }

    private void drawStones(Graphics2D g) {
        int numberOfStones = rand.nextInt(5) + 10;
        for (int i = 0; i < numberOfStones; i++) {
            int w = rand.nextInt(10) + 15;
            int h = rand.nextInt(10) + 15;
            Stone s = new Stone(rand.nextInt(getWidth() - 2 * w / 10) + w / 10,
                    rand.nextInt(getHeight() / 2 - h) + getHeight() / 2, w, h,
                    time == Time.Day ? new Color(136, 140, 141) : new Color(74, 72, 77));
            s.draw(g);
        }
    }

    private void drawTrees(Graphics2D g) {
        /*int numOfTrees = rand.nextInt(10) + 5;
        Color c = szn == Season.Fall ? new Color(224, 204, 119) : new Color(11, 102, 35);
        for (int i = 0; i < numOfTrees; i++) {
            int r = rand.nextInt(35) + 40;
            int h = rand.nextInt(40) + 100;
            int w = rand.nextInt(10) + 20;
            int n = rand.nextInt(3) + 3;
            int x = getWidth() * i / numOfTrees + r / 2;
            int y = rand.nextInt(getHeight() / 10) + 9 * getHeight() / 10 - h;
            int nApples = szn == Season.Fall ? 0 : rand.nextInt(5) + 5;
            Tree t = new Tree(x, y, h, w, n, r, nApples, c);
            t.draw(g);
        }*/
        int numberOfTrees = rand.nextInt(3) + 4;
        for (int i = 0; i < numberOfTrees; i++) {
            int n = rand.nextInt(2) + 6;
            FractalTree t = new FractalTree(getWidth() * i / numberOfTrees + getWidth() / numberOfTrees / n,
                    rand.nextInt(getHeight() / 10) + 9 * getHeight() / 10,
                    n, -90, time == Time.Day ? new Color(112, 199, 78) : new Color(2, 37, 59),
                    time == Time.Day ? new Color(51, 0, 0) : new Color(38, 18, 14));
            t.draw(g);
        }
    }
}
