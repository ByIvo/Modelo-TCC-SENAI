/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.interfaces;

import java.io.Serializable;

/**
 *
 * @author byivo Interface que marca que toda classe de entidade deve ter os
 * métodos ID:getId() e void:SetId(ID id)
 * @param <ID> É o tipo de dado do ID da entidade, normalmente um Integer ou
 * Long.
 *
 */
public interface IEntity<ID> extends Serializable {

    public void setId(ID id);

    public ID getId();
    
    public void updateEntity(IEntity<ID> newEntity);
}
