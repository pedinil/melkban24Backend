package ir.melkban24.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mehdi on 4/13/17.
 */
@Entity
@Table(name = "TblAgency")
public class Agency
{
    /**
     *
     +------------+---------------+------+-----+---------+-------+
     | Field      | Type          | Null | Key | Default | Extra |
     +------------+---------------+------+-----+---------+-------+
     | IdAgency   | varchar(50)   | NO   | PRI | NULL    |       |
     | NameAgency | varchar(150)  | YES  |     | NULL    |       |
     | Tel1       | char(15)      | YES  |     | NULL    |       |
     | Tel2       | char(15)      | YES  |     | NULL    |       |
     | Moblie     | char(15)      | YES  |     | NULL    |       |
     | Adresss    | varchar(250)  | YES  |     | NULL    |       |
     | Pic1       | varchar(150)  | YES  |     | NULL    |       |
     | pic2       | varchar(150)  | YES  |     | NULL    |       |
     | CountUsers | decimal(6,0)  | YES  |     | NULL    |       |
     | Pass       | varchar(50)   | YES  |     | NULL    |       |
     | IntDateOk  | decimal(18,0) | YES  |     | NULL    |       |
     +------------+---------------+------+-----+---------+-------+
     */
    @Id
    private String idAgency;
    private String nameAgency;
    private String tel1;
    private String tel2;
    private String mobile;
    private String address;
    private String pic1;
    private String pic2;
    private String pass;
    private double countUsers;
    private double intDateOk;

    public String getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(String idAgency) {
        this.idAgency = idAgency;
    }

    public String getNameAgency() {
        return nameAgency;
    }

    public void setNameAgency(String nameAgency) {
        this.nameAgency = nameAgency;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(double countUsers) {
        this.countUsers = countUsers;
    }

    public double getIntDateOk() {
        return intDateOk;
    }

    public void setIntDateOk(double intDateOk) {
        this.intDateOk = intDateOk;
    }
}
