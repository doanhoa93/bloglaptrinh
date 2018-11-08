package com.bloglaptrinh.app.common.constant;

public class Constant {
    public static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public interface URL_REMOTE{
        static String URL_ADD_POST = "/private/post/add";
    }
}
