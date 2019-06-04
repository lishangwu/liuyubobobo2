package AInterface;

public interface Queue<E> {

    int getCapacity();
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
    void print();
}
