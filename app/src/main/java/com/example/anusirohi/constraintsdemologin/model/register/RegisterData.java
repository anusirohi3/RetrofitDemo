
package com.example.anusirohi.constraintsdemologin.model.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterData {

    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("otp")
    @Expose
    private int otp;
    @SerializedName("user_mobile")
    @Expose
    private String userMobile;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
