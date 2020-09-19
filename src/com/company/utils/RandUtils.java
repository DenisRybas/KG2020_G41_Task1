package com.company.utils;

import com.company.models.*;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RandUtils {
    public enum Time {
        Day,
        Night
    }

    private static Time time;

    public static Time randTime() {
        Random rand = new Random(System.currentTimeMillis());
        return Time.values()[rand.nextInt(Time.values().length)];
    }

    public static Time getTime() {
        return time;
    }

    static {
        time = RandUtils.randTime();
    }

    public static LinkedList<Star> randStars(Rectangle rec) {
        Random rand = new Random(System.currentTimeMillis());
        LinkedList<Star> stars = new LinkedList<>();
        int numOfStars = rand.nextInt(30) + 10;
        for (int i = 0; i < numOfStars; i++) {
            int r = rand.nextInt(5) + 5;
            Color c = new Color(250, 253, 236);

            Star s = new Star(rand.nextInt((int) rec.getWidth() - r), rand.nextInt((int) rec.getHeight() / 4),
                    r, c);
            stars.add(s);
        }
        return stars;
    }

    public static Moon randMoon(Rectangle rec) {
        Random rand = new Random(System.currentTimeMillis());
        int r = 40;
        Color c = new Color(244, 241, 201);
        return new Moon(rand.nextInt((int) rec.getWidth() - 2 * r), rand.nextInt((int) rec.getHeight() / 10),
                r, c);
    }

    public static TreeMap<Integer, Flower> randFlowers(Rectangle rec) {
        Random rand = new Random(System.currentTimeMillis());
        Color[] dayColors = {new Color(233, 103, 117), new Color(197, 29, 52),
                new Color(139, 122, 168), new Color(207, 157, 230)};
        Color[] nightColors = {new Color(172, 85, 64), new Color(84, 115, 133)};

        LinkedHashMap<Integer, Flower> flowers = new LinkedHashMap<>();
        int numOfFlowers = rand.nextInt(10) + 150;
        for (int i = 0; i < numOfFlowers; i++) {
            int r = rand.nextInt(10) + 5;
            int n = rand.nextInt(5) + 5;
            Color c = time == Time.Day ? dayColors[rand.nextInt(dayColors.length)] : nightColors[rand.nextInt(nightColors.length)];
            Flower f = new Flower(rand.nextInt(rec.width - r),
                    rand.nextInt(rec.height / 2) + rec.height / 2 - 2 * r,
                    n, r, c);
            flowers.put(f.getY(), f);
        }
        return new TreeMap<>(flowers);
    }

    public static LinkedList<Bird> randBirds(Rectangle rec) {
        Random rand = new Random(System.currentTimeMillis());
        int numOfBirds = rand.nextInt(5) + 4;
        LinkedList<Bird> birds = new LinkedList<>();
        for (int i = 0; i < numOfBirds; i++) {
            int w = rand.nextInt(40) + 35;
            int h = rand.nextInt(10) + 10;
            Bird brd = new Bird(rand.nextInt((int) rec.getWidth() - w), rand.nextInt((int) rec.getHeight() / 4), w, h);
            birds.add(brd);
        }
        return birds;
    }

    public static Collection<Cloud> randClouds(Rectangle rec) {
        Random rand = new Random(System.currentTimeMillis());
        int numOfClouds = rand.nextInt(8) + 1;
        LinkedList<Cloud> clouds = new LinkedList<>();
        for (int i = 0; i < numOfClouds; i++) {
            int r = rand.nextInt(60) + 30;
            int n = rand.nextInt(5) + 4;
            int x = rand.nextInt((int) rec.getWidth() - n * r);
            int y = rand.nextInt((int) rec.getHeight() / 10);
            Cloud c = new Cloud(x, y, r, n);
            clouds.add(c);
        }
        return clouds;
    }

    public static World randWorld(Rectangle rec) {
        World world = new World((int) rec.getWidth(), (int) rec.getHeight(),
                time == Time.Day ? new Color(96, 128, 56) : new Color(18, 52, 73),
                time == Time.Day ? new Color(129, 182, 221) : new Color(59, 60, 72));
        return world;
    }

    public static Sun randSun(Rectangle rec) {
        Random rand = new Random(System.currentTimeMillis());
        int r = 40;
        int n = rand.nextInt(12) + 8;
        Color c = rand.nextInt(2) == 0 ? Color.ORANGE : Color.YELLOW;
        return new Sun((int) rec.getWidth() - 2 * r, 2 * r, r, 2 * r, n, c);
    }


    public static LinkedList<Stone> randStones(Rectangle rec) {
        Random rand = new Random(System.currentTimeMillis());
        int numberOfStones = rand.nextInt(5) + 10;
        LinkedList<Stone> stones = new LinkedList<>();
        for (int i = 0; i < numberOfStones; i++) {
            int w = rand.nextInt(10) + 15;
            int h = rand.nextInt(10) + 15;
            Color c = time == Time.Day ? new Color(136, 140, 141) : new Color(74, 72, 77);
            Stone s = new Stone(rand.nextInt((int) rec.getWidth() - 2 * w / 10) + w / 10,
                    rand.nextInt((int) rec.getHeight() / 2 - h) + (int) rec.getHeight() / 2,
                    w, h, c);
            stones.add(s);
        }
        return stones;
    }

    public static LinkedList<FractalTree> randTrees(Rectangle rec) {
        /*int numOfTrees = rand.nextInt(10) + 5;
        Color c = szn == Season.Fall ? new Color(224, 204, 119) : new Color(11, 102, 35);
        for (int i = 0; i < numOfTrees; i++) {
            int r = rand.nextInt(35) + 40;
            int h = rand.nextInt(40) + 100;
            int w = rand.nextInt(10) + 20;
            int n = rand.nextInt(3) + 3;
            int x = getWidth() * i / numOfTrees + r / 2;
            int y = rand.nextInt(getHeight() / 10) + 9 * getHeight() / 10 - h;
            int nApples = szn == Season.Fall ? 0 : rand.nextInt(5) + 5;
            Tree t = new Tree(x, y, h, w, n, r, nApples, c);
            t.draw(g);
        }*/
        Random rand = new Random(System.currentTimeMillis());
        int numberOfTrees = rand.nextInt(3) + 4;
        LinkedList<FractalTree> trees = new LinkedList<>();
        for (int i = 0; i < numberOfTrees; i++) {
            int n = rand.nextInt(2) + 6;
            Color c = time == Time.Day ? new Color(112, 199, 78) : new Color(2, 37, 59);
            Color cc = time == Time.Day ? new Color(51, 0, 0) : new Color(38, 18, 14);
            FractalTree t = new FractalTree((int) rec.getWidth() * i / numberOfTrees + (int) rec.getWidth() / numberOfTrees / n,
                    rand.nextInt((int) rec.getHeight() / 10) + 9 * (int) rec.getHeight() / 10,
                    n, -90, c, cc);
            trees.add(t);
        }
        return trees;
    }

}
