package com.company;

import java.awt.*;
import java.util.Random;

public class FractalTree implements Drawable {
    private int x, y, n;
    private Color c;
    private double angle;
    private Random rand = new Random(System.currentTimeMillis());

    public FractalTree(int x, int y, int n, double angle, Color c) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.angle = angle;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D g) {
        drawTree(g, this.x, this.y, this.angle, this.n);
    }

    private void drawTree(Graphics2D g, int x, int y, double angle, int n) {
        int nn = rand.nextInt(8) + 10;
        int x2 = x + (int) (Math.cos(Math.toRadians(angle)) * n * nn);
        int y2 = y + (int) (Math.sin(Math.toRadians(angle)) * n * nn);
        if (n == 0) {
            drawLeaf(g, x2, y2, 22, 22);
            return;
        }
        g.setColor(new Color(51, 0, 0));
        g.setStroke(new BasicStroke(n * 2));
        g.drawLine(x, y, x2, y2);

        if (n <= 3) {
            drawLeaf(g, x, y, 22, 22);
        }


        drawTree(g, x2, y2, angle - 20, n - 1);
        drawTree(g, x2, y2, angle + 20, n - 1);
    }

    private void drawLeaf(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(c);
        g.fillOval(x - w, y - h, w, h);
        g.fillOval(x, y - h / 2, w, h);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.black);
        g.drawOval(x - w, y - h, w, h);
        g.drawOval(x, y - h / 2, w, h);
    }

}
