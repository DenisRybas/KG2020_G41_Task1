package com.company;

import java.awt.*;
import java.awt.geom.Path2D;

public class World implements Drawable {
    private int w, h;
    private Color b, s;

    public World(int w, int h, Color b, Color s) {
        this.w = w;
        this.h = h;
        this.b = b;
        this.s = s;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(s);
        g.fillRect(0, 0, w, h);

        Path2D.Double bg = new Path2D.Double();
        g.setColor(b);
        bg.moveTo(0, h / 2);
        bg.curveTo(w / 3, h / 3, w / 2, h / 2, w, h / 3);
        bg.lineTo(w, h);
        bg.lineTo(0, h);
        bg.lineTo(0, h / 2);
        g.fill(bg);
        g.draw(bg);

        /*Path2D.Double sky = new Path2D.Double();
        g.setColor(s);
        sky.moveTo(0, 0);
        sky.lineTo(w, 0);
        sky.lineTo(w, h / 3);
        sky.curveTo(w, h / 3, w / 2, h / 2, 0, h / 2);
        sky.lineTo(0, 0);
        g.fill(sky);
        g.draw(sky);*/
    }
}
