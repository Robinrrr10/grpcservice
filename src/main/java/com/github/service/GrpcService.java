package com.github.service;


import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcService {

    public static void main(String[] args) throws InterruptedException, IOException{
        System.out.println("starting.....GRPC--Service-----");

        Server server = ServerBuilder.forPort(8080).addService(new UserService()).build();
        server.start();
        System.out.println("Started.....Successfull");
        server.awaitTermination();
    }
    
}
