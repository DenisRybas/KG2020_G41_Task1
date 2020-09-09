package com.company;

import java.awt.*;
import java.util.Random;

public class Tree implements Drawable {
    private int x, y, h, w;
    private int n, nApples, r;
    private Color c;

    public Tree(int x, int y, int h, int w, int n, int r, int nApples, Color c) {
        this.nApples = nApples;
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.n = n;
        this.r = r;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D g) {
        drawTree(g);
    }

    private void drawTree(Graphics2D g) {
        g.setColor(new Color(51, 0, 0));
        g.fillRect(x, y, w, h);
        g.setColor(Color.black);
        g.drawRect(x, y, w, h);
        for (int i = 0; i < n; i++) {
            g.setColor(c);
            if (i == n - 1 && i % 2 == 0) {
                g.fillOval(x - r / 2, y - r * (i / 2 + 1), r * 2, r * 2);
                g.setColor(Color.black);
                g.drawOval(x - r / 2, y - r * (i / 2 + 1), r * 2, r * 2);
                break;
            }
            g.fillOval(x + w * (i % 2) - r, y - r * (i / 2 + 1), r * 2, r * 2);
            g.setColor(Color.black);
            g.drawOval(x + w * (i % 2) - r, y - r * (i / 2 + 1), r * 2, r * 2);

        }

        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < nApples; i++) {
            g.setColor(Color.RED);
            int dx = rand.nextInt(2 * r - r / 2) + r / 2;
            int dy = rand.nextInt(n / 2 * r - r / 10) + r / 10;
            g.fillOval(x - r + dx, y - r * (n / 2) + dy,
                    r / 3, r / 3);
            g.setColor(Color.black);
            g.drawOval(x - r + dx, y - r * (n / 2) + dy,
                    r / 3, r / 3);
        }
    }
}
