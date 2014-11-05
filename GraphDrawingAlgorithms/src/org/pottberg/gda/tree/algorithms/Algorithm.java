package org.pottberg.gda.tree.algorithms;

public interface Algorithm {
    
    void execute();
    
    default boolean isRadialLayout() {
	return false;
    }

}
