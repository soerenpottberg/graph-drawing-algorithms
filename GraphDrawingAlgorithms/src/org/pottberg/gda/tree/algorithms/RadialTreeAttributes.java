package org.pottberg.gda.tree.algorithms;


public interface RadialTreeAttributes {

    int getLeaveNodeCount();
    
    void setLeaveNodeCount(int count);    

    void setLayer(int layer);
    
    double getStartAngle();

    double getEndAngle();

    double getAngle();

    void setAngleRange(double startAngle, double angle);

    int getLevel();

    double getMiddleAngle();

}
