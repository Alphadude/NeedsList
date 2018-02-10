package com.ng.needslist.needslist.Util;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by user on 2/3/2018.
 */

public class Validation {

    public static boolean validateFields(String name){

        return !TextUtils.isEmpty(name);
    }

    public static boolean validateEmail(String string) {

        return !(TextUtils.isEmpty(string) || !Patterns.EMAIL_ADDRESS.matcher(string).matches());
    }
}
