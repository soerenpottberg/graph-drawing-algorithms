package org.pottberg.gda.node;

public interface ValueNode<T> {

    T getValue();

    void setValue(T value);

}
