package pl.notify.model;

import org.springframework.stereotype.Component;


public class Notification {
    private String username;
    private String email;
    private String telephone;
    private String content;

    public Notification(String username, String email, String telephone, String content) {
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
