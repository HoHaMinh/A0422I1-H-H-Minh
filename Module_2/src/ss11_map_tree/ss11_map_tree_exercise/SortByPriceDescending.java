package ss11_map_tree.ss11_map_tree_exercise;

import java.util.Comparator;

public class SortByPriceDescending implements Comparator<Products> {

    @Override
    public int compare(Products o1, Products o2) {
        return (int) (o2.getPrice() - o1.getPrice());
    }
}
