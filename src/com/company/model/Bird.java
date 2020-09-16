package com.company.model;

import java.awt.*;

public class Bird implements Drawable {
    private int x, y, w, h;

    public Bird(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(Graphics2D g) {
        drawBird(g);
    }

    private void drawBird(Graphics2D g) {
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3));
        g.drawArc(x, y, w / 2, h, 0, 180);
        g.drawArc(x + w / 2, y, w / 2, h, 0, 180);

    }
}

