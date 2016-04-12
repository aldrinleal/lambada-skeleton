package io.ingenieux.hello;

import com.amazonaws.services.lambda.runtime.Context;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;

import io.ingenieux.lambada.runtime.LambadaFunction;

public class HelloLambda {
    @LambadaFunction(name="hello_sayHelloToLambda",
            description="Says Hello to Lambda",
            timeout=5)
    public void sayHelloToLambda(InputStream is, OutputStream os, Context context) throws Exception {
        String inputPayload = IOUtils.toString(is);

        System.out.println("input payload: " + inputPayload);

        IOUtils.write("\"ok\"", os);
    }
}
