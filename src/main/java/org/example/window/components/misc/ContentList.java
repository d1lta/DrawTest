package org.example.window.components.misc;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import lombok.Getter;

public class ContentList implements Iterable<Component> {

    @Getter
    private List<Component> components = new ArrayList<>();

    public ContentList() {
    }

    public ContentList(List<Component> components) {
        this.components = components;
    }

    public void clear() {
        this.components.clear();
    }

    public void add(Component item) {
        if (item instanceof PanelContent) {
            components.addAll(((PanelContent) item).getContents());
        } else {
            components.add(item);
        }
    }

    public Component get(int i) {
        return components.get(i);
    }

    public List<Component> get(Class c) {
        List<Component> componentList = new ArrayList<>();
        components.forEach(it -> {
            if (it.getClass().equals(c)) {
                componentList.add(it);
            }
        });
        return componentList;
    }

    public Component get(String name) {
        for (Component it : components) {
            if (it.getName().equals(name)) {
                return it;
            }
        }
        return null;
    }

    @Override
    public Iterator<Component> iterator() {
        return new ContentList.MyIterator();
    }

    @Override
    public void forEach(Consumer<? super Component> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Component> spliterator() {
        return Iterable.super.spliterator();
    }

    class MyIterator implements Iterator<Component> {

        private int index = 0;

        public boolean hasNext() {
            return index < components.size();
        }

        public Component next() {
            return get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");

        }
    }

}
