学习笔记
1.HashMap中的hash算法
HashMap中定位到桶的位置 是根据Key的hash值与数组的长度取模来计算的。 
看下JDK8中的hash 算法：

 static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
首先是取key的hashCode算法，然后对16进行异或运算和右移运算。 
在分析上面异或运算和右移运算问题之前，我们需要先看看另一个事情，什么呢？就是 HashMap 如何根据 hash 值找到数组种的对象，我们看看 get 方法的代码：

  final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            // 我们需要关注下面这一行
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
我们看看代码中注释下方的一行代码：first = tab[(n - 1) & hash])。 
使用数组长度减一 与运算 hash 值。这行代码就是为什么要让前面的 hash 方法移位并异或。
2.树的面试解法一般都是递归，为什么？
树的数据结构表明，树与其子树具有结构上的相似性，可以把树的处理拆分为对多个子树的处理，子树的处理又可以拆分为多个子子树的处理，结构上的相似性让树，子树，子子树的处理具有共同的逻辑，这与递归中的子问题契合，所以树的处理一般应考虑递归解决。