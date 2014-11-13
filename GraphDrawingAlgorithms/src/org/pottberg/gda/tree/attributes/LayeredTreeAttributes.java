package org.pottberg.gda.tree.attributes;

import java.util.List;

import org.pottberg.gda.tree.nodes.LayeredTreeNode;

public interface LayeredTreeAttributes {

    void setLeftBoundary(List<LayeredTreeNode<?>> boundary);
    
    void setRightBoundary(List<LayeredTreeNode<?>> boundary);
    
    List<LayeredTreeNode<?>> getLeftBoundary();
    
    List<LayeredTreeNode<?>> getRightBoundary();
    
    void setXOffset(int offset);
    
    int getXOffset();

}
