package ru.kerporation.datastoremicroservice.web.mapper;

import java.util.List;

public interface Mappable<E, D> {

    E toEntity(D d);

    List<E> toEntity(final List<D> d);

    D toDto(E e);

    List<D> toDto(final List<E> e);

}