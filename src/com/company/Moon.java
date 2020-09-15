package com.company;

import java.awt.*;

public class Moon implements Drawable {
    private int x, y, r;
    private Color c;

    public Moon(int x, int y, int r, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D g) {
        drawMoon(g);
    }

    private void drawMoon(Graphics2D g) {
        g.setColor(c);
        g.fillOval(x ,y , 2 * r, 2 * r);
    }
}
