package com.example.tw2ver01;

public class RegisterRequest {

    private String contactPerson;//聯絡人
    private String email;
    private String password;
    private String contactNo;//電話
    private String relationship;//稱謂
    private  String deviceCode;

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }
}