package co.inventorsoft.academy.collections.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private List<T> elements;

    public Range() {
        elements = new ArrayList<T>();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean contains(Object o) {
        return elements.contains(o);
    }

    public Iterator<T> iterator() {
        return elements.iterator();
    }

    public Object[] toArray() {
        return elements.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) elements.toArray();
    }

    public boolean add(T t) {
        boolean isAdded = elements.stream().anyMatch(element -> element.equals(t));
        return isAdded ? false : elements.add(t);
    }

    public boolean remove(Object o) {
        return elements.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return elements.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return elements.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    public void clear() {
        elements.clear();
    }

    static <T extends Comparable> Range<T> of(T first, T last, Function<T, T> function) {
        Range<T> range = new Range<>();
        if (first == last) {
            return range;
        } else {
            while (first.compareTo(last) < 0) {
                range.add(first);
                first = function.apply(first);
            }
            range.add(first);
            return range;
        }
    }

    public static Range<Integer> of(int first, int last) {
        return Range.of(first, last, element -> element + 1);
    }


    public static Range<Float> of(float start, float end) {
        return Range.of(start, end, aFloat -> aFloat + 0.1f);
    }
}
