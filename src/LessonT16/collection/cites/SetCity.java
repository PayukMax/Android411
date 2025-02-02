package LessonT16.collection.cites;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetCity {
    private Set<City> hash = new HashSet<>();
    private Set<City> tree = new TreeSet<>();

    public int size(){
        return hash.size()+ tree.size();
    }

    private boolean isEven(int code){
        return code%2==0; // проверка на четный/нечетный
    }

    public void removeCity(int minAmount, int maxAmount){
        hash.removeIf(x-> x.getName().length()<minAmount || x.getName().length()>maxAmount);
        tree.removeIf(x-> x.getName().length()<minAmount || x.getName().length()>maxAmount);
    }

    public void printReverse(){
        System.out.println("Печать городов в порядке убывания: ");
        TreeSet<City> treeSet = new TreeSet<>(tree);
        treeSet.addAll(hash);
        Iterator<City> iter = treeSet.descendingIterator();
        while (iter.hasNext()) System.out.println(iter.next());

    }

    public boolean addCity(String name, int code) {
        boolean result = name.length()>0 && code>0;
        if(result){
            if (isEven(code)) hash.add(new City(name,code));
            else tree.add(new City(name,code));
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Список городов с четным кодом (HashSet):\n");
        for (City c: hash){
            sb.append(c).append("\n");
        }
        sb.append("\nСписок городов с нечетным кодом (TreeSet): \n");
        for (City c: tree){
            sb.append(c).append("\n");
        }
        return sb.toString();
    }
}
