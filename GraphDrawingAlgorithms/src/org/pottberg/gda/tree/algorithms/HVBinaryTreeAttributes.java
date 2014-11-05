package org.pottberg.gda.tree.algorithms;


public interface HVBinaryTreeAttributes {

    int getBoundingBoxWidth();

    int getBoundingBoxHeight();

    void setBoundingBoxWidth(int width);

    void setBoundingBoxHeight(int height);

    void setXOffset(int offset);

    void setYOffset(int offset);

    int getXOffset();

    int getYOffset();

}
