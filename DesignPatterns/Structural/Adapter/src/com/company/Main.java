package com.company;

public class Main {
    public static void main(String[] args) {
        RoundHole hole= new RoundHole(5);

        RoundPeg roundpeg=new RoundPeg(5);

        System.out.println(hole.isFits(roundpeg));

        SquarePeg smallSP= new SquarePeg(5);
        SquarePeg largeSP= new SquarePeg(10);

//        System.out.println(hole.isFits(smallSP));  --->>>> error

        RoundPeg smallSPAdapter= new SquarePegAdapter(smallSP);
        RoundPeg largeSPAdapter = new SquarePegAdapter(largeSP);

        System.out.println(hole.isFits(smallSPAdapter));;
        System.out.println(hole.isFits(largeSPAdapter));
    }
}
