package org.pottberg.gda.tree;


public interface Tree<T extends TreeNode<T>> {
    
    T getRoot(); 

    boolean hasRoot();
    
    Iterable<T> createPreOrderIterable();
    
    Iterable<T> createPostOrderIterable();

}
