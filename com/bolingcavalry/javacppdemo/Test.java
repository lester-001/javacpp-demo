package com.bolingcavalry.javacppdemo;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

@Platform(include="NativeLibrary.h",link="MyFunc")
@Namespace("NativeLibrary")
public class Test {
    public static class MyFunc extends Pointer {
        static { Loader.load(); }
        public MyFunc() { allocate(); }
        private native void allocate();

        public native int add(int a, int b);
    }

    public static void main(String[] args) {
        MyFunc myFunc = new MyFunc();
        System.out.println(myFunc .add(111,222));
    }
}
