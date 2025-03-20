package com.wonderrobot.ankenmatchingu.entity;

import java.util.Date;

public class JobDetail {
    private Integer id;
    private String emailTitle;
    private String recruitment;
    private String emailSender;
    private String emailSendTime;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    public String getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(String recruitment) {
        this.recruitment = recruitment;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public String getEmailSendTime() {
        return emailSendTime;
    }

    public void setEmailSendTime(String emailSendTime) {
        this.emailSendTime = emailSendTime;
    }
}