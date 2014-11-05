package org.pottberg.gda.tree;

import org.pottberg.gda.tree.nodes.TreeNode;


public interface Tree<T extends TreeNode<T>> extends TreeInformation{
    
    T getRoot(); 

    boolean hasRoot();
    
    Iterable<T> createPreOrderIterable();
    
    Iterable<T> createPostOrderIterable();

}
