package org.pottberg.gda.node;


public interface AttributedNode {
    
   <T> T getAttributes(Class<T> type);
   
   <T> void setAttributes(T attributes);

}
