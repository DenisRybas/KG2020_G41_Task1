package com.company;

import java.awt.*;

public class Leaf implements Drawable {
    int x, y, r, n;
    Color c;

    public Leaf(int x, int y, int r, int n, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.n = n;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        drawLeaf(g);
    }

    private void drawLeaf(Graphics2D g) {
        for (int i = 0; i < n; i++) {
            g.fillOval((x / 2) - r, (y / 2) - (r * 2), r * 2, r * 2);
            g.fillOval((x / 2) - r, (y / 2) - r, r * 2, r * 2);
            g.fillOval((x / 2) - (r * 2), (y / 2) - r, r * 2, r * 2);
            g.fillOval((x / 2), (y / 2) - r, r * 2, r * 2);
        }
    }
}
