package com.company;

import java.awt.*;

public class Stone implements Drawable {
    int x, y, w, h;

    public Stone(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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
        g.setColor(Color.GRAY);
        g.fillArc(x, y, w, h, 0 ,180);
    }
}
