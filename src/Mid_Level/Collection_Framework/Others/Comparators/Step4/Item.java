package Mid_Level.Collection_Framework.Others.Comparators.Step4;

import Mid_Level.Collection_Framework.ArrayList.Generic.Step5.LOL;

public class Item implements LOL,Comparable<Item> {
    public String name;
    public int price;

    public Item() {

    }
    public Item(String name) {
        this.name = name;
    }

    public void effect() {
        System.out.println("物品使用后，可以有效果");
    }

    public boolean disposable() {
        return false;
    }

    public int compareTo(Item o) {
        return o.price - price;
    }

    public String toString() {
        return "Item [name = "+ name +",price="+ price +"]\r\n";
    }
}
