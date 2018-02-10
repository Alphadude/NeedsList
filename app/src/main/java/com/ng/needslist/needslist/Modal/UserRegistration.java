package com.ng.needslist.needslist.Modal;

/**
 * Created by user on 2/3/2018.
 */

public class UserRegistration {
    private String password;
    private String name;
    private String email;
    private String access_token;
    private Boolean designer;
    private Long  d_o_b;

    public UserRegistration(String password, String name, String email, String access_token, Boolean designer, Long d_o_b){
        this.password = password;
        this.access_token = access_token;
        this.email = email;
        this.name = name;
        this.d_o_b = d_o_b;
        this.designer = designer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Boolean getDesigner() {
        return designer;
    }

    public void setDesigner(Boolean designer) {
        this.designer = designer;
    }

    public Long getD_o_b() {
        return d_o_b;
    }

    public void setD_o_b(Long d_o_b) {
        this.d_o_b = d_o_b;
    }
}
