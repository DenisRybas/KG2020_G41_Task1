package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Flower implements Drawable {
    private int x, y, n, r;
    private Color c;

    public Flower(int x, int y, int n, int r, Color c) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.r = r;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D g) {
        drawFlower(g);
    }

    private void drawFlower(Graphics2D g) {
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawLine(x + r / 2, y, x + r / 2, y + 3 * r);
        double da = 2 * Math.PI / n;
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, r, r);
        g.setStroke(new BasicStroke(1));
        for (int i = 0; i < n; i++) {
            g.setColor(c);
            double dx = r * Math.cos(da * i);
            double dy = r * Math.sin(da * i);
            g.fillOval(x + (int) dx, y + (int) dy, r, r);
            g.setColor(Color.BLACK);
            g.drawOval(x + (int) dx, y + (int) dy, r, r);
        }
    }
}

