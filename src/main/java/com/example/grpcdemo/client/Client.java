package com.example.grpcdemo.client;

import com.example.grpcdemo.StudentRequest;
import com.example.grpcdemo.StudentResponse;
import com.example.grpcdemo.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    static Logger logger= LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) {
        ManagedChannel managedChannel= ManagedChannelBuilder.forAddress("localhost",6565).usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub=StudentServiceGrpc.newBlockingStub(managedChannel);
        StudentResponse response=blockingStub.getStudent(StudentRequest.newBuilder().setId(1).build());
        logger.info("response"+response.getName()+" "+response.getAge());
    }
}
