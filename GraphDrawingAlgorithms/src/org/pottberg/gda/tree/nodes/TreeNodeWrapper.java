package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;

public interface TreeNodeWrapper<T extends DrawableTreeNode<T> & AttributedNode, R extends DrawableTreeNode<R>, E> extends DrawableTreeNode<R> {
    
    T getWrappedNode();
    
    E getAttributes(Class<E> type);
    
}
