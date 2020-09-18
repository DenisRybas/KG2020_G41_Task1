package com.company.models;

import java.awt.*;

public class Cloud implements Drawable {
    private int x, y, r, n;

    public Cloud(int x, int y, int r, int n) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.n = n;
    }

    @Override
    public void draw(Graphics2D g) {
        for (int i = 0; i < n; i++) {
            g.setColor(new Color(255, 255, 255, 127));
            g.fillOval(x + r * i / 3, y + r * (i % 2 + 1) / 2, r, r);
            g.setColor(Color.black);
        }
    }
}
