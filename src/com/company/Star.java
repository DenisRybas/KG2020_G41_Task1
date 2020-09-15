package com.company;

import java.awt.*;

public class Star implements Drawable {
    private int x, y, r;
    private Color c;

    public Star(int x, int y, int r, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D g) {
        drawStar(g);
    }

    private void drawStar(Graphics2D g) {
        g.setColor(c);
        g.fillOval(x, y, r, r);
    }
}
