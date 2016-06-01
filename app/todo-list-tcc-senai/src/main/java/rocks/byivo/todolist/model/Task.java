/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Basic;
import rocks.byivo.todolist.interfaces.IEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author byivo
 */
@Entity
@Table(name = "task")
@SQLDelete(sql = "UPDATE task SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted <> 1")
public class Task extends GenericEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private TBoard board;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "task_has_user",
//            joinColumns = {
//                @JoinColumn(name = "task_id")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "user_id")})
//    private List<User> users;

    @Column(name = "deleted")
    @JsonIgnore
    private Boolean deleted;

    public Task() {
        deleted = false;
    }

    @Override
    public void updateEntity(IEntity<Long> newEntity) {
        if (!this.isThisEntity(newEntity)) {
            return;
        }
        Task newObj = (Task) newEntity;

        this.setBoard(newObj.getBoard());
        this.setName(newObj.getName());
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

    public TBoard getBoard() {
        return board;
    }

    public void setBoard(TBoard board) {
        this.board = board;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", board=" + board + ", deleted=" + deleted + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

}
