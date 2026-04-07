import java.util.Iterator;

public interface MyCollection<E> extends Iterable<E> {

    int     size();
    boolean isEmpty();
    boolean contains(Object o);

    boolean add(E e);
    boolean remove(Object o);
    void    clear();

    boolean containsAll(MyCollection<?> c);
    boolean addAll(MyCollection<? extends E> c);
    boolean removeAll(MyCollection<?> c);
    boolean retainAll(MyCollection<?> c);

    Object[] toArray();

    Iterator<E> iterator();   

    default boolean notEmpty() { return !isEmpty(); }
}