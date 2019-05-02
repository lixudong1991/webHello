package lxd.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class People {
    int id;
    String name;
    int sex;
    Date birthday;
    String address;
    int education;
    String phone;
    String email;
    String identity;
    int regAddrId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getRegAddrId() {
        return regAddrId;
    }

    public void setRegAddrId(int regAddrId) {
        this.regAddrId = regAddrId;
    }
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public String toString() {

        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + dateFormat.format(birthday) +
                ", address='" + address + '\'' +
                ", education=" + education +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", regAddrId=" + regAddrId +
                '}';
    }
}
