package org.pottberg.gda.tree.algorithms;

import java.util.List;

public interface LayeredBinaryTreeAttributes {

    void setLeftBoundary(List<LayeredBinaryTreeNode> boundary);
    
    void setRightBoundary(List<LayeredBinaryTreeNode> boundary);
    
    List<LayeredBinaryTreeNode> getLeftBoundary();
    
    List<LayeredBinaryTreeNode> getRightBoundary();
    
    void setXOffset(int offset);
    
    int getXOffset();

}
