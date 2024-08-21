package board.pjt.back.dto.user;

import board.pjt.back.enums.Role;

import java.util.Date;

public class UserResponseDto {
    private String email;
    private String nickname;
    private String password;
    private String name;
    private String birth;
    private Role role;
    private Date last_login_at;

    public UserResponseDto() {
    }

    public UserResponseDto(String email, String nickname, String password, String name, String birth, Role role, Date last_login_at) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.role = role;
        this.last_login_at = last_login_at;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getLast_login_at() {
        return last_login_at;
    }

    public void setLast_login_at(Date last_login_at) {
        this.last_login_at = last_login_at;
    }
}
