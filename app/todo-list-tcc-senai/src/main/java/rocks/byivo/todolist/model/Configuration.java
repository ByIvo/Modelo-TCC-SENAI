/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import rocks.byivo.todolist.interfaces.IEntity;

/**
 *
 * @author byivo
 */
@Entity
@Table(name = "configuration")
public class Configuration extends GenericEntity<Long> {

    public static final Long EMAIL_CONFIGURATION_ID = 1l;
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "server_host", nullable = false, length = 200)
    private String serverHost;

    @Column(name = "socket_port", nullable = false, length = 10)
    private String socketPort;

    @Column(name = "socket_factory", nullable = false, length = 100)
    private String socketFactory;

    @Column(nullable = false)
    private Boolean auth;

    @Column(nullable = false, length = 10)
    private String port;

    @Column(name = "from_email", nullable = false, length = 120)
    private String fromEmail;

    @Column(name = "from_password", nullable = false, length = 200)
    private String fromPassword;

    public Configuration() {
    }

    @Override
    public void updateEntity(IEntity<Long> newEntity) {
        if (!this.isThisEntity(newEntity)) {
            return;
        }
        Configuration newObj = (Configuration) newEntity;

        this.setAuth(newObj.getAuth());
        this.setFromEmail(newObj.getFromEmail());
        this.setFromPassword(newObj.getFromPassword());
        this.setPort(newObj.getPort());
        this.setServerHost(newObj.getServerHost());
        this.setSocketFactory(newObj.getSocketFactory());
        this.setSocketPort(newObj.getSocketPort());
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public String getSocketPort() {
        return socketPort;
    }

    public void setSocketPort(String socketPort) {
        this.socketPort = socketPort;
    }

    public String getSocketFactory() {
        return socketFactory;
    }

    public void setSocketFactory(String socketFactory) {
        this.socketFactory = socketFactory;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }

    @Override
    public String toString() {
        return "Configuration{" + "id=" + id + ", serverHost=" + serverHost + ", socketPort=" + socketPort + ", socketFactory=" + socketFactory + ", auth=" + auth + ", port=" + port + ", fromEmail=" + fromEmail + ", fromPassword=" + fromPassword + '}';
    }

}
