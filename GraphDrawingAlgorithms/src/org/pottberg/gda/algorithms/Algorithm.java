package org.pottberg.gda.algorithms;

public interface Algorithm {
    
    void execute();
    
    default boolean isRadialLayout() {
	return false;
    }

}
