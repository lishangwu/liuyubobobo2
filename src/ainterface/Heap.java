package AInterface;

public interface Heap<E> {

    int size();
    boolean isEmpty();
    int parent(int index);
    int leftChild(int index);
    int rightChild(int index);
    void add(E e);
//    E findMax();
//    E extracMax();
    void siftUp(int k);
    void siftDown(int k);
    E replace(E e);
    void print();

}
