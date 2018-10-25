package com.auto.insurance;

/**
 * Created by uengine on 2018. 10. 25..
 */
public class CustomerRegisteredEvent {

    String ssn;
    String emailAddress;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
