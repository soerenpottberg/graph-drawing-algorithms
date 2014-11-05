package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.function.Function;

public class WrapperIterator<T, R> implements Iterator<R> {

    private Iterator<T> wrappedIterator;
    private Function<T, R> wrapper;

    public WrapperIterator(Iterator<T> wrappedIterator, Function<T, R> wrapper) {
	this.wrappedIterator = wrappedIterator;
	this.wrapper = wrapper;
    }

    @Override
    public boolean hasNext() {
	return wrappedIterator.hasNext();
    }

    @Override
    public R next() {
	T nextValue = wrappedIterator.next();
	if(nextValue == null) {
	    return null;
	}
	return wrapper.apply(nextValue);
    }

}
