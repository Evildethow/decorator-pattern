package org.evildethow.decorator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NotNullList<E> implements List<E> {

    private final List<E> listWrapper;

    public NotNullList(List<E> listWrapper) {
        this.listWrapper = listWrapper;
    }

    @Override
    public int size() {
        return listWrapper.size();
    }

    @Override
    public boolean isEmpty() {
        return listWrapper.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return listWrapper.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return listWrapper.iterator();
    }

    @Override
    public Object[] toArray() {
        return listWrapper.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return listWrapper.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        return listWrapper.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }
        return listWrapper.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            return false;
        }
        return listWrapper.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            return false;
        }
        return listWrapper.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index <= 0 || c == null || listWrapper.size() < index) {
            return false;
        }
        return listWrapper.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            return false;
        }
        return listWrapper.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return listWrapper.retainAll(c);
    }

    @Override
    public void clear() {
        listWrapper.clear();
    }

    @Override
    public E get(int index) {
        return listWrapper.get(index);
    }

    @Override
    public E set(int index, E element) {
        if (element == null || index > listWrapper.size()) {
            return element;
        }
        return listWrapper.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        if (element == null || index > listWrapper.size()) {
            return;
        }
        listWrapper.add(index, element);
    }

    @Override
    public E remove(int index) {
        return listWrapper.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return listWrapper.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return listWrapper.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return listWrapper.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return listWrapper.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return listWrapper.subList(fromIndex, toIndex);
    }
}
