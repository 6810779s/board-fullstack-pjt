package board.pjt.back.dto;

import java.util.Date;
import java.util.Objects;

public class UserDto {
    private String email;
    private String nickname;
    private String password;
    private String name;
    private Date birth;
    private Date createAt;
    private Date lastLogin;
    private Date updated_at;

    public UserDto() {
    }

    public UserDto(String email, String nickname, String password, String name, Date birth) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(email, userDto.email) && Objects.equals(nickname, userDto.nickname) && Objects.equals(password, userDto.password) && Objects.equals(birth, userDto.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nickname, password, birth);
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", createAt=" + createAt +
                ", lastLogin=" + lastLogin +
                ", updated_at=" + updated_at +
                '}';
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getupdated_at() {
        return updated_at;
    }

    public void setupdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}


