package AInterface;

public interface BST<E> {

    int size();
    boolean isEmpty();
    void add(E e);
    boolean contains(E e);
    void preOrder();
    void inOrder();
    void postOrder();
    void levelOrder();
    E minimum();
    E maxmum();
    E removeMin();
    E removeMax();
    void remove(E e);

    //二叉树中和为某一值的路径
    boolean hasPathSum(int sum);

//https://www.jianshu.com/p/ff15cdc6d873
    //二叉树深度

    //判断平衡二叉树

    //使二叉树变为其镜像


    //树的子结构

    //二叉搜索树的第k个节点

}
