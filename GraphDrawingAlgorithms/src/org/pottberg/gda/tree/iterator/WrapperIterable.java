package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.function.Function;

public class WrapperIterable<T, R> implements Iterable<R> {

    private Function<T, R> wrapper;
    private Iterable<T> wrappedIterable;

    public WrapperIterable(Iterable<T> wrappedIterable, Function<T,R> wrapper) {
	this.wrappedIterable = wrappedIterable;
	this.wrapper = wrapper;
    }

    @Override
    public Iterator<R> iterator() {
	return new WrapperIterator<T, R>(wrappedIterable.iterator(), wrapper);
    }

}
