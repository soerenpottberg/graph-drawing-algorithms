package org.pottberg.gda.tree.attributes;



public class SimpleRadialTreeAttributes implements RadialTreeAttributes {
    private int layer;
    private int count;
    private double startAngle;
    private double angle;
    private double actualAngle;
    
    @Override
    public void setLayer(int layer) {
	this.layer = layer;
    }
    
    @Override
    public int getLevel() {
	return layer;
    }

    @Override
    public double getActualAngle() {
	return actualAngle;
    }

    @Override
    public int getLeaveNodeCount() {
	return count;	
    }

    @Override
    public void setLeaveNodeCount(int count) {
	this.count = count;	
    }

    @Override
    public void setAngleRange(double startAngle, double angle) {
	this.startAngle = startAngle;
	this.angle = angle;	
    }

    @Override
    public double getStartAngle() {
	return startAngle;
    }

    @Override
    public double getAngle() {
	return angle;
    }

    @Override
    public double getEndAngle() {
	return startAngle + angle;
    }

    @Override
    public void setActualAngle(double angle) {
	actualAngle = angle;	
    }
    
}
