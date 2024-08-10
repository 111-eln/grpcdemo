package com.example.grpcdemo.server;

import com.example.grpcdemo.StudentResponse;
import com.example.grpcdemo.StudentServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class Server extends StudentServiceGrpc.StudentServiceImplBase {
    Logger logger= LoggerFactory.getLogger(Server.class);
    public void getStudent(com.example.grpcdemo.StudentRequest request,
                           io.grpc.stub.StreamObserver<com.example.grpcdemo.StudentResponse> responseObserver) {
        logger.info("got request="+request.getId());
        StudentResponse studentResponse=StudentResponse.newBuilder().setAge(10).setName("asd").build();
        responseObserver.onNext(studentResponse);
        responseObserver.onCompleted();
    }


}
