package com.r00t.cleanaf.domain.util;

public interface EntityMapper<E, D> {

    D mapFromEntity(E e);

    E mapToEntity(D d);
}
