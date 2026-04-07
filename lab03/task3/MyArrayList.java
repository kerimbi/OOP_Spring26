import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyCollection<E> {
    private Object[] data;
    private int size;

    public MyArrayList() { data = new Object[10]; }

    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return size == 0; }

    @Override
    public boolean add(E e) {
        ensureCapacity();
        data[size++] = e;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(o)) return true;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                System.arraycopy(data, i+1, data, i, size-i-1);
                data[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override public void clear() { Arrays.fill(data,0,size,null); size=0; }

    @Override
    public boolean containsAll(MyCollection<?> c) {
        for (Object e : c) if (!contains(e)) return false;
        return true;
    }
    @Override
    public boolean addAll(MyCollection<? extends E> c) {
        boolean changed = false;
        for (E e : c) changed |= add(e);
        return changed;
    }
    @Override
    public boolean removeAll(MyCollection<?> c) {
        boolean changed = false;
        for (Object e : c) changed |= remove(e);
        return changed;
    }
    @Override
    public boolean retainAll(MyCollection<?> c) {
        boolean changed = false;
        for (int i = size-1; i >= 0; i--)
            if (!c.contains(data[i])) { remove(data[i]); changed = true; }
        return changed;
    }

    @Override public Object[] toArray() { return Arrays.copyOf(data, size); }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int idx = 0;
            public boolean hasNext() { return idx < size; }
            @SuppressWarnings("unchecked")
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (E) data[idx++];
            }
        };
    }

    private void ensureCapacity() {
        if (size == data.length) data = Arrays.copyOf(data, data.length * 2);
    }
}