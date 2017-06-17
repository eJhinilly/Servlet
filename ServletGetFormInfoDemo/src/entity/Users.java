package entity;

import java.util.Date;

/**
 * Created by localhost on 17-6-14.
 */

//用户实体类
public class Users {

    private String username;
    private String mypassword;
    private String email;
    private String gender;
    private Date birthday;
    private String[] favorites;
    private String introduce;//自我介绍
    private boolean flag;//是否接受协议

    public Users(){

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMypassword() {
        return mypassword;
    }

    public void setMypassword(String mypassword) {
        this.mypassword = mypassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
