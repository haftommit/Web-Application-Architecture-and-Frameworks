/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545;

/**
 *
 * @author Haftom Alemayehu <Haftom Alemayehu>
 */

public class UserManager {

    private final static int MAX_ATTEMPT = 3;

    public LoginEstate performLoginAction(User user) {
        if (user == null) {
            return LoginEstate.FAILED;
        }
        if (user.getWrongAttemptCount() == MAX_ATTEMPT) {
            return LoginEstate.LOCKEDOUT;
        } 
        if (!user.getPassword().equals("apple")) {
            user.setWrongAttemptCount(user.getWrongAttemptCount() + 1);

            if (user.getWrongAttemptCount() == MAX_ATTEMPT) {
                return LoginEstate.LOCKEDOUT;
            } else {
                return LoginEstate.FAILED;
            } 
        } else {
            return LoginEstate.APPROVED;
        }
    }

    public enum LoginEstate { 
        APPROVED,
        FAILED,
        LOCKEDOUT
    }
}
