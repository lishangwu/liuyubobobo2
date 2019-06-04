package AInterface;

public interface Array<E> {
    int getSize();
    int getCapacity();
    boolean isEmpty();
    void addLast(E e);
    void addFirst(E e);
    void add(int index, E e);
    E get(int index);
    E getLast();
    E getFirst();
    void set(int index, E e);
    boolean contains(E e);
    int find(E e);
    E remove(int index);
    E removeFirst();
    E removeLast();
    void removeElement(E e);
    void resize(int newCapacity);
    void swap(int i, int j);
    void print();
}
