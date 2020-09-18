package com.company.graphics;

import com.company.models.Drawable;
import com.company.utils.RandUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class NewDrawPanel<T extends Drawable> extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle r = new Rectangle(getWidth(), getHeight());
        RandUtils.randWorld(r).draw(g2d);
        if (RandUtils.getTime() == RandUtils.Time.Day) {
            RandUtils.randSun(r).draw(g2d);
            draw(g2d, (Collection<T>) RandUtils.randClouds(r));
        } else {
            draw(g2d,(Collection<T>) RandUtils.randStars(r));
            RandUtils.randMoon(r).draw(g2d);
        }
        draw(g2d, (Collection<T>) RandUtils.randBirds(r));
        draw(g2d,(Collection<T>) RandUtils.randStones(r));
        draw(g2d, (Collection<T>) RandUtils.randFlowers(r).values());
        draw(g2d, (Collection<T>) RandUtils.randTrees(r));

    }

    private void draw(Graphics2D g, Collection<T> c) {
        for (T obj : c) {
            obj.draw(g);
        }
    }
}
