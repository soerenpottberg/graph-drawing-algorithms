package org.pottberg.gda.tree;


public interface TreeNode<T extends TreeNode<T>> {
    
   boolean isRootNode();
    
   T getParentNode();
   
   T getThisNode();

}
