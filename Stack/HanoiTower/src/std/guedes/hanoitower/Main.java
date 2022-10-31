package std.guedes.hanoitower;

import std.guedes.hanoitower.util.HanoiTower;

public class Main {

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower(6);
        hanoiTower.show();
        hanoiTower.solve();
        hanoiTower.show();
    }

}