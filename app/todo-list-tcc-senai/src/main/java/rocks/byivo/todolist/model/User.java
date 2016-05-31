/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import rocks.byivo.todolist.interfaces.IEntity;

/**
 *
 * @author byivo
 */
@Entity
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted <> 1")
public class User extends GenericEntity<Long>{
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @Column(name = "username", length = 30, nullable = false)
    private String username;

    @Column(name = "password", length = 512, nullable = false)
    private String password;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "adm", nullable = false)
    private Boolean adm;

    @Column(name = "deleted", nullable = false)
    @JsonIgnore
    private Boolean deleted;

    public User() {
        deleted = false;
        adm = false;
    }
    
    @Override
    public void updateEntity(IEntity<Long> newEntity) {
        if (!this.isThisEntity(newEntity)) {
            return;
        }
        User newObj = (User) newEntity;

        this.setName(newObj.getName());
        this.setEmail(newObj.getEmail());
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdm() {
        return adm;
    }

    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", email=" + email + ", adm=" + adm + ", deleted=" + deleted + '}';
    }
}
