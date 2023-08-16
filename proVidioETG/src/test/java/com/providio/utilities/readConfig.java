//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.utilities;

import com.github.javafaker.Faker;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
    Properties pro;
    Faker faker = new Faker();

    public readConfig() {
        File src = new File("./Configurations/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            this.pro = new Properties();
            this.pro.load(fis);
        } catch (Exception var3) {
            System.out.println("Exception is " + var3.getMessage());
        }

    }

    public String getApplicationURL() {
        String url = this.pro.getProperty("baseURL");
        return url;
    }

    public String getUsername() {
        String username = this.pro.getProperty("name");
        return username;
    }

    public String getUsername1() {
        String username = this.pro.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = this.pro.getProperty("password");
        return password;
    }

    public String getFName() {
        String fname = this.faker.name().firstName();
        return fname;
    }

    public String getLName() {
        String lname = this.faker.name().lastName();
        return lname;
    }

    public String getAddress() {
        String address = this.faker.address().fullAddress();
        return address;
    }

    public String getCity() {
        String cityname = "Humboldt ";
        return cityname;
        //this.faker.address().city();
    }

    public String getzipcode() {
        String zipcode = "95564";
        
        return zipcode;
        //this.faker.address().zipCode();
    }

    public String getphone() {
        String phonenumber = "5555551234";
        return phonenumber;
    }

    public String getepconformMail() {
        String epconfirmEmail = this.pro.getProperty("name");
        return epconfirmEmail;
    }

    public String getepconformpassword() {
        String eppassword = this.pro.getProperty("password");
        return eppassword;
    }

    public String getepFName() {
        String epfname = this.faker.name().firstName();
        return epfname;
    }

    public String getepLName() {
        String eplname = this.faker.name().lastName();
        return eplname;
    }

    public String getepcurrentPassword() {
        String epcurrentPassword = this.pro.getProperty("password");
        return epcurrentPassword;
    }

    public String getepnewPassword() {
        String epnewPassword = this.pro.getProperty("password");
        return epnewPassword;
    }

    public String getepnewPasswordConfirm() {
        String epnewPasswordConfirm = this.pro.getProperty("password");
        return epnewPasswordConfirm;
    }

    public String getWriteAReview() {
        String writeAReviewString = this.pro.getProperty("headline");
        return writeAReviewString;
    }

    public String getComments() {
        String comments = this.pro.getProperty("comment");
        return comments;
    }

    public String getNickName() {
        String nickname = this.pro.getProperty("nickname");
        return nickname;
    }

    public String getLocation() {
        String loc = this.pro.getProperty("location");
        return loc;
    }

    public String getZipcodeInStore() {
        String zipcodeInStore = this.pro.getProperty("zipcodeStore");
        return zipcodeInStore;
    }

    public String searchSomething() {
        String typing = this.pro.getProperty("searchBar");
        return typing;
    }

    public String getFooterMail() {
        String footerMail = this.pro.getProperty("footerMail");
        return footerMail;
    }

    public String getGuestMail() {
        String guestMail = this.pro.getProperty("mail");
        return guestMail;
    }

    public String getGuestPassword() {
        String guestPassword = this.pro.getProperty("password");
        return guestPassword;
    }

    public String getReEnterMail() {
        String reEnterEmail = this.pro.getProperty("reEnterMail");
        return reEnterEmail;
    }
}
