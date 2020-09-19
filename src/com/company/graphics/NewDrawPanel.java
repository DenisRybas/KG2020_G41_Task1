package com.company.graphics;

import com.company.models.Drawable;
import com.company.utils.RandUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class NewDrawPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        drawAll((Graphics2D) g);
    }

    Collection<Drawable> world;

    private void drawAll(Graphics2D g2d) {
        Rectangle r = new Rectangle(getWidth(), getHeight());
        RandUtils.randWorld(r).draw(g2d);
        if (RandUtils.getTime() == RandUtils.Time.Day) {
            RandUtils.randSun(r).draw(g2d);
            draw(g2d, RandUtils.randClouds(r));
            draw(g2d, RandUtils.randBirds(r));
            g2d.setColor(Color.WHITE);
        } else {
            draw(g2d, RandUtils.randStars(r));
            RandUtils.randMoon(r).draw(g2d);
        }
        draw(g2d, RandUtils.randStones(r));
        draw(g2d, RandUtils.randFlowers(r).values());
        draw(g2d, RandUtils.randTrees(r));
        g2d.setColor(Color.WHITE);
        if (RandUtils.getTime() == RandUtils.Time.Day) {
            g2d.setFont(new Font("DayFont", Font.ITALIC, 30));
            g2d.drawString("Солнце ещё высоко", getWidth() / 2 - g2d.getFontMetrics().stringWidth("Солнце ещё высоко") / 2,
                    getHeight() - g2d.getFontMetrics().getHeight() / 2);
        } else {
            g2d.setFont(new Font("NightFont", Font.ITALIC, 30));
            g2d.drawString("В поисках созвездий", getWidth() / 2 - g2d.getFontMetrics().stringWidth("В поисках созвездий") / 2,
                    getHeight() - g2d.getFontMetrics().getHeight() / 2);
        }
    }

    private static <T extends Drawable> void draw(Graphics2D g, Collection<T> c) {
        for (T obj : c) {
            obj.draw(g);
        }
    }
}
