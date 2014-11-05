package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public interface TreeNodeWrapper<T extends DrawableTreeNode<T> & AttributedNode, R extends DrawableTreeNode<R>, E> extends DrawableTreeNode<R> {
    
    T getWrappedNode();
    
    E getAttributes(Class<E> type);
    
}
