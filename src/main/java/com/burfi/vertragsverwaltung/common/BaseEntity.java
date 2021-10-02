package com.burfi.vertragsverwaltung.common;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity<PrimaryKey> {

    public abstract PrimaryKey getId();

    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getSimpleName(), getId());
    }
}
