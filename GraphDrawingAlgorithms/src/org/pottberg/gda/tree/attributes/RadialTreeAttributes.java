package org.pottberg.gda.tree.attributes;


public interface RadialTreeAttributes {

    int getLeaveNodeCount();
    
    void setLeaveNodeCount(int count);    

    void setLayer(int layer);
    
    double getStartAngle();

    double getEndAngle();

    double getAngle();

    void setAngleRange(double startAngle, double angle);

    int getLevel();
    
    void setActualAngle(double angle);

    double getActualAngle();

}
