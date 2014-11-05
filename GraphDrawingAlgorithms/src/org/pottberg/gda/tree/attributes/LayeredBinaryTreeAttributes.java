package org.pottberg.gda.tree.attributes;

import java.util.List;

import org.pottberg.gda.tree.nodes.LayeredBinaryTreeNode;

public interface LayeredBinaryTreeAttributes {

    void setLeftBoundary(List<LayeredBinaryTreeNode<?>> boundary);
    
    void setRightBoundary(List<LayeredBinaryTreeNode<?>> boundary);
    
    List<LayeredBinaryTreeNode<?>> getLeftBoundary();
    
    List<LayeredBinaryTreeNode<?>> getRightBoundary();
    
    void setXOffset(int offset);
    
    int getXOffset();

}
