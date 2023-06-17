package com.messaging.messagingmicroservice.domain.service;

import com.messaging.messagingmicroservice.domain.exceptions.EmptyFieldFoundException;
import com.messaging.messagingmicroservice.domain.exceptions.InvalidFormatMailException;
import com.messaging.messagingmicroservice.domain.exceptions.InvalidPhoneException;
import com.messaging.messagingmicroservice.domain.exceptions.InvalidPhoneLengthException;

public class Validator {
    public boolean isValidPhone(String phone){
        if (phone.isEmpty()) {
            throw new EmptyFieldFoundException();
        }
        if (phone.length() > 13) {
            throw new InvalidPhoneLengthException();
        }
        if (phone.length() > 10) {
            char[] charPhone = phone.toCharArray();
            if (charPhone[0] != 43) {
                throw new InvalidPhoneException();
            }
            for (int i = 1; i < charPhone.length; i++) {
                if (charPhone[i] < 48 || charPhone[i] > 57) {
                    throw new InvalidPhoneException();
                }
            }
        }
        if (phone.length() <= 10) {
            throw new InvalidPhoneLengthException();
        }
        return true;
    }

    public boolean isValidMail(String mail) {
        if (mail == null || mail.isEmpty()) {
            throw new EmptyFieldFoundException();
        }
        if (!(mail.contains("@") && mail.contains("."))) {
            throw new InvalidFormatMailException();
        }
        return true;
    }
}
