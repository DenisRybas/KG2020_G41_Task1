package com.company;

import java.awt.*;
import java.util.Random;

public class FractalTree implements Drawable {
    private int x, y, n;
    private double angle;
    private Random rand = new Random(System.currentTimeMillis());

    public FractalTree(int x, int y, int n, double angle) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.angle = angle;
    }

    @Override
    public void draw(Graphics2D g) {
        drawTree(g, this.x, this.y, this.angle, this.n);
    }

    private void drawTree(Graphics2D g, int x, int y, double angle, int n) {
        g.setStroke(new BasicStroke(n * 2));
        g.setColor(new Color(51, 0, 0));
        if (n == 0) return;
        int nn = rand.nextInt(15) + 4;
        int x2 = x + (int) (Math.cos(Math.toRadians(angle)) * n * nn);
        int y2 = y + (int) (Math.sin(Math.toRadians(angle)) * n * nn);
        g.drawLine(x, y, x2, y2);
        drawTree(g, x2, y2, angle - 20, n - 1);
        drawTree(g, x2, y2, angle + 20, n - 1);
    }

}
