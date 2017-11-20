package hash;

import org.apache.shiro.codec.CodecSupport;

import java.util.Arrays;

public class CodecSupportDemo {

    public static void main(String[] args) {
        byte[] bytes1 = CodecSupport.toBytes("123");
        byte[] bytes2 = "123".getBytes();
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes1));
    }
}
