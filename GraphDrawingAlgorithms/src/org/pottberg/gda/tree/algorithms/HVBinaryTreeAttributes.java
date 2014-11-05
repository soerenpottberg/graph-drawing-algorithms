package org.pottberg.gda.tree.algorithms;

import java.util.List;

public interface HVBinaryTreeAttributes {

    void setLeftBoundary(List<HVBinaryTreeNode> boundary);

    void setRightBoundary(List<HVBinaryTreeNode> boundary);

    List<HVBinaryTreeNode> getLeftBoundary();

    List<HVBinaryTreeNode> getRightBoundary();

    int getBoundingBoxWidth();

    int getBoundingBoxHeight();

    void setBoundingBoxWidth(int width);

    void setBoundingBoxHeight(int height);

    void setXOffset(int offset);

    void setYOffset(int offset);

    int getXOffset();

    int getYOffset();

}
