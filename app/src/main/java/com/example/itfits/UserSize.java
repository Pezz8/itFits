package com.example.itfits;

import android.util.Log;

public class UserSize {
    private String userName;
    private Double chestSize;
    private Double waistSize;
    private Double hipSize;
    private Double inseam;
    private String gender;

    public UserSize(){
        setUserName("");
        setChestSize(0.0);
        setWaistSize(0.0);
        setHipSize(0.0);
        setInseam(0.0);
        setGender("");
    };

    public UserSize(String userName,Double chestSize, Double waistSize, Double hipSize, Double inseam, String gender){
        setUserName(userName);
        setChestSize(chestSize);
        setWaistSize(waistSize);
        setHipSize(hipSize);
        setInseam(inseam);
        setGender(gender);
    };

    public UserSize(UserSize user){
        setUserName(user.getUserName());
        setChestSize(user.getChestSize());
        setWaistSize(user.getWaistSize());
        setHipSize(user.getHipSize());
        setInseam(user.getInseam());
        setGender(user.getGender());
    };

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setChestSize(Double chestSize) {
        this.chestSize = chestSize;
    }

    public void setWaistSize(Double waistSize) {
        this.waistSize = waistSize;
    }

    public void setHipSize(Double hipSize) {
        this.hipSize = hipSize;
    }

    public void setInseam(Double inseam) {
        this.inseam = inseam;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public Double getChestSize() {
        return chestSize;
    }

    public Double getWaistSize() {
        return waistSize;
    }

    public Double getHipSize() {
        return hipSize;
    }

    public Double getInseam() {
        return inseam;
    }

    public String getGender() {
        return gender;
    }

    public String toString(){
        return  (userName + ":" + chestSize.toString() + ":" + waistSize.toString() + ":" + hipSize.toString() + ":" + inseam.toString() + ":" + gender);
    }

    public UserSize fromString(String userSizeString){
        UserSize temp = new UserSize();
        String[] list = userSizeString.split(":");

        temp.setUserName(list[0]);
        Log.d("slit string ", list[0]);
        Log.d("slit string ", list[1]);
        temp.setChestSize(Double.parseDouble(list[1]));
        temp.setWaistSize(Double.parseDouble(list[2]));
        temp.setHipSize(Double.parseDouble(list[3]));
        temp.setInseam(Double.parseDouble(list[4]));
        temp.setGender(list[5]);

        return temp;
    }
}
