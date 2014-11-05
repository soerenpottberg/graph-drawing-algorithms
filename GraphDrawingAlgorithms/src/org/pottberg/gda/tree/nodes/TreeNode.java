package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.tree.TreeInformation;


public interface TreeNode<T extends TreeNode<T>> extends TreeInformation {
    
   boolean isRootNode();

   boolean isLeaveNode();
    
   T getParentNode();
   
   T getThisNode();
   
   Iterable<T> createChildNodeIterable();

}
