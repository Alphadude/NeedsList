package com.ng.needslist.needslist.Network;

import com.ng.needslist.needslist.Modal.AuthenticationData;
import com.ng.needslist.needslist.Modal.LoginCredentials;
import com.ng.needslist.needslist.Modal.UserRegistration;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by user on 2/3/2018.
 */

public interface NeedslistInterface {

    @POST("/login")
    Observable<com.ng.needslist.needslist.Modal.Response<AuthenticationData>> login(@Body LoginCredentials userLogin);


}
