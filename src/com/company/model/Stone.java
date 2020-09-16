package com.company.model;

import java.awt.*;

public class Stone implements Drawable {
    private int x, y, w, h;
    private Color c;

    public Stone(int x, int y, int w, int h, Color c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
    }


    @Override
    public void draw(Graphics2D g) {
        /*Path2D.Double bg = new Path2D.Double();
        bg.moveTo(x, y);
        bg.curveTo(x + w / 3, y - h / 3, x + w / 2, y - h / 2, x + w, y);
        bg.lineTo(x + w, y + h / 3);
        bg.lineTo(x + w, y + h);
        bg.lineTo(x, y + h);
        g.setColor(Color.GRAY);
        g.fill(bg);
        g.draw(bg);
         */
        g.setColor(c);
        g.fillArc(x, y, w, h, 0 ,180);
    }
}
