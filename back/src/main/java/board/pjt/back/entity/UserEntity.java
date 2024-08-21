package board.pjt.back.entity;

import board.pjt.back.enums.Role;

import java.util.Date;

public class UserEntity {
    private String email;
    private String nickname;
    private String password;
    private String name;
    private String birth;
    private Role role;
    private Date last_login_at;
    private Date updated_at;
    private Date created_at;


    public UserEntity() {
    }

    public UserEntity(String email, String nickname, String password, String name, String birth, Date last_login_at, Date updated_at, Date created_at) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.last_login_at = last_login_at;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Date getLast_login_at() {
        return last_login_at;
    }

    public void setLast_login_at(Date last_login_at) {
        this.last_login_at = last_login_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
