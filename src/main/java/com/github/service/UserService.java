package com.github.service;

import com.github.User.AccountRequest;
import com.github.User.Empty;
import com.github.User.LoginLogoutResponse;
import com.github.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

    @Override
    public void login(AccountRequest request, StreamObserver<LoginLogoutResponse> response) {
        System.out.println("Came inside login");
        String username = request.getName();
        String password = request.getPassword();
        LoginLogoutResponse.Builder responseBuilder = LoginLogoutResponse.newBuilder();
        if(username.equals(password)){
            responseBuilder.setStatus(100).setMessage("Successfull");
        }
        else {
            responseBuilder.setStatus(1002).setMessage("Invalid login");
        }
        response.onNext(responseBuilder.build());
        response.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<LoginLogoutResponse> response) {
        
    }
}
