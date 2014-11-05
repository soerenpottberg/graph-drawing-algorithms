package org.pottberg.gda.tree.attributes;


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
