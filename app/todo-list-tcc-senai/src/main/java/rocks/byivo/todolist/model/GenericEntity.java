/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.model;

import java.util.Objects;
import rocks.byivo.todolist.interfaces.IEntity;

/**
 *
 * @author byivo
 */
public abstract class GenericEntity<ID> implements IEntity<ID> {

    public GenericEntity() {
    }

    public boolean isThisEntity(Object obj) {
        if (obj == null) {
            return false;
        }

        return getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.isThisEntity(obj)) {
            return false;
        }

        final GenericEntity<?> other = (GenericEntity<?>) obj;
        return Objects.equals(this.getId(), other.getId());
    }

}
