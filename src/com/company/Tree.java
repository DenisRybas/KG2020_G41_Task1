package com.company;

import java.awt.*;

public class Tree implements Drawable {
    private int x, y, h, w;
    private int n, r;
    private Color c;

    public Tree(int x, int y, int h, int w, int n, int r, Color c) {
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
        /*
        g.setColor(new Color(51, 0, 0));
        g.fillRect(x, y, w, h);

        g.setColor(Color.GREEN);
        g.fillOval(x - r, y - (r * 2), r * 2, r * 2);
        g.fillOval(x - r, y - r, r * 2, r * 2);
        g.fillOval(x - (r * 2), y - r, r * 2, r * 2);
        g.fillOval(x, y - r, r * 2, r * 2);
        */

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

            /*if (i % 2 == 0) {
                if (i == n - 1) {
                    g.fillOval(x - r / 2, y - r * (i / 2 + 1), r * 2, r * 2);
                    g.setColor(Color.black);
                    g.drawOval(x - r / 2, y - r * (i / 2 + 1), r * 2, r * 2);
                    break;
                }
                g.fillOval(x - r, y - r * (i / 2 + 1), r * 2, r * 2);
                g.setColor(Color.black);
                g.drawOval(x - r, y - r * (i / 2 + 1), r * 2, r * 2);
            } else {
                g.fillOval(x + w - r, y - r * (i / 2 + 1), r * 2, r * 2);
                g.setColor(Color.black);
                g.drawOval(x + w - r, y - r * (i / 2 + 1), r * 2, r * 2);
            }*/
        }
    }
}
