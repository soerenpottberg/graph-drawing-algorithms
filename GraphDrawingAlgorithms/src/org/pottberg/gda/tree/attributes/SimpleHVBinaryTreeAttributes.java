package org.pottberg.gda.tree.attributes;



public class SimpleHVBinaryTreeAttributes implements HVBinaryTreeAttributes {
    private int width;
    private int height;
    private int xOffset;
    private int yOffset;
    
    @Override
    public void setXOffset(int offset) {
	xOffset = offset;
    }
    
    @Override
    public int getXOffset() {
	return xOffset;
    }

    @Override
    public int getBoundingBoxWidth() {
	return width;
    }

    @Override
    public int getBoundingBoxHeight() {
	return height;
    }

    @Override
    public void setBoundingBoxWidth(int width) {
	this.width = width;
    }

    @Override
    public void setBoundingBoxHeight(int height) {
	this.height = height;	
    }

    @Override
    public void setYOffset(int offset) {
	this.yOffset = offset;	
    }

    @Override
    public int getYOffset() {
	return yOffset;
    }
    
}
