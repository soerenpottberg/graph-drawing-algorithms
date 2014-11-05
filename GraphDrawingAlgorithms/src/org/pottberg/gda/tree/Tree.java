package org.pottberg.gda.tree;


public interface Tree<T extends TreeNode<T>> extends TreeInformation{
    
    T getRoot(); 

    boolean hasRoot();
    
    Iterable<T> createPreOrderIterable();
    
    Iterable<T> createPostOrderIterable();

}
