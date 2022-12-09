package com.example.userportal.constant;

/**
 * @author jeremy on 2022/12/8
 */
public class Authority {
    // annotation(user:read): have the permission to read the user information
    public static final String[] USER_AUTHORITIES = {"user:read"};
    public static final String[] HR_AUTHORITIES = {"user:read", "user:update"};
    public static final String[] MANAGER_AUTHORITIES = {"user:read", "user:update"};
    public static final String[] ADMIN_AUTHORITIES = {
            "user:read",
            "user:update",
            "user:create"
    };
    public static final String[] SUPER_ADMIN_AUTHORITIES = {
            "user:read",
            "user:update",
            "user:create",
            "user:delete"
    };
}
