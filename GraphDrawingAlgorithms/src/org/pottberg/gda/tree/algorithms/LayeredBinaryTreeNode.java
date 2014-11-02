package org.pottberg.gda.tree.algorithms;

import java.util.List;

import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public interface LayeredBinaryTreeNode<T extends LayeredBinaryTreeNode<T>> extends BinaryTreeNode<T>, DrawableTreeNode<T> {

    void setLeftBoundary(List<T> boundary);
    
    void setRightBoundary(List<T> boundary);
    
    List<T> getLeftBoundary();
    
    List<T> getRightBoundary();
    
    void setXOffset(int offset);
    
    int getXOffset();

}
