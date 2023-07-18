package org.example.window.components.misc;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import lombok.Getter;

public class PanelContent extends Component implements Iterable<Component> {

    @Getter
    private List<Component> contents = new ArrayList<>();

    public PanelContent() {
    }

    public PanelContent(List<Component> list) {
        this.contents = list;
    }

    public int contentsSize() {
        return contents.size();
    }

    public void add(Component component) {
        contents.add(component);
    }

    public Component getDeeper(String name) {
        for (Component c: contents) {
            if (c instanceof PanelContent) {
                return ((PanelContent) c).get(name);
            }
        }
        return null;
    }

    public Component get(int i) {
        return contents.get(i);
    }

    public Component get(String name) {
        for (Component it : contents) {
            if (it.getName().equals(name)) {
                return it;
            }
        }
        return null;
    }

    public boolean contains(Component component) {
        return contents.contains(component);
    }

    public void addAll(PanelContent panelContent) {
        panelContent.getContents().forEach(this::add);

    }

    public void clear() {
        this.contents.clear();
    }

    public void remove(Component component) {
        contents.remove(component);
    }

    @Override
    public Iterator<Component> iterator() {
        return new MyIterator();
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
            return index < contentsSize();
        }

        public Component next() {
            return get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");

        }
    }
}
