/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import rocks.byivo.todolist.interfaces.IEntity;

/**
 *
 * @author byivo
 */
@Entity
@Table(name = "email_layout")
public class EmailLayout extends GenericEntity<String> {

    @Enumerated(EnumType.STRING)
    @Id
    @Column(name = "layout_name")
    private TLayoutName layoutName;

    @Column(name = "editable_layout", nullable = false)
    private String editableLayout;

    public EmailLayout() {
    }

    @Override
    public void updateEntity(IEntity<String> newEntity) {
        if (!this.isThisEntity(newEntity)) {
            return;
        }
        
        EmailLayout newObj = (EmailLayout) newEntity;

        this.setEditableLayout(newObj.getEditableLayout());
        this.setLayoutName(newObj.getLayoutName());
    }

    @Override
    public void setId(String id) {
        this.layoutName = TLayoutName.valueOf(id);
    }

    @Override
    public String getId() {
        return layoutName.toString();
    }

    public TLayoutName getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(TLayoutName layoutName) {
        this.layoutName = layoutName;
    }

    public String getEditableLayout() {
        return editableLayout;
    }

    public void setEditableLayout(String editableLayout) {
        this.editableLayout = editableLayout;
    }
}
