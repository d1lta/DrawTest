package org.example.window.graphics.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import lombok.Getter;
import org.example.window.components.misc.ContentList;

public class Dots implements Iterable<Dot> {

    @Getter
    List<Dot> dots = new ArrayList<>();

    public Dots() {
    }

    public void add(Dot dot) {
        dots.add(dot);
    }

    public Dot getDot(int id) {
        for (Dot dot : dots) {
            if (dot.id == id) {
                return dot;
            }
        }
        return null;
    }

    public Dot get(int i) {
        return dots.get(i);
    }

    public int size() {
        return dots.size();
    }

    public void clear() {
        dots.clear();
    }

    @Override
    public Iterator<Dot> iterator() {
        return new Dots.MyIterator();
    }

    @Override
    public void forEach(Consumer<? super Dot> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Dot> spliterator() {
        return Iterable.super.spliterator();
    }

    class MyIterator implements Iterator<Dot> {

        private int index = 0;

        public boolean hasNext() {
            return index < dots.size();
        }

        public Dot next() {
            return get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");

        }
    }
}
