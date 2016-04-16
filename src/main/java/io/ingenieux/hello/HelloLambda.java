package io.ingenieux.hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.InputStream;
import java.io.OutputStream;

import io.ingenieux.lambada.runtime.LambadaFunction;
import io.ingenieux.lambada.runtime.LambadaUtils;

public class HelloLambda {
    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper()
                    .enable(SerializationFeature.INDENT_OUTPUT);

    @LambadaFunction(name="hello_sayHelloToLambda",
            description="Says Hello to Lambda",
            timeout=5)
    public void sayHelloToLambda(InputStream is, OutputStream os, Context context) throws Exception {
        LambadaUtils.<ObjectNode, String>wrap(OBJECT_MAPPER, is, os, ObjectNode.class, req -> {
            System.out.println("Input Payload: " + OBJECT_MAPPER.writeValueAsString(req));

            return "ok";
        });
    }
}
