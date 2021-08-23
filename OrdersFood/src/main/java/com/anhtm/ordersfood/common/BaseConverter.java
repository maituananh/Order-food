package com.anhtm.ordersfood.common;

public interface BaseConverter<D, E> {
    
    public E dtoToEntity (D d);

    public D entityToDto (E e);
}
