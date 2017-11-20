package hash;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

public class Base64Demo {

    public static void main(String[] args) {
        String str = "123";
        String base64Str = Base64.encodeToString(str.getBytes());
        System.out.println(base64Str);
        String str1 = Base64.decodeToString(base64Str);
        System.out.println(str1);

        String str2 = new Sha256Hash(str, "123").toString();
        String str3 = new Sha256Hash(str, "123").toBase64();
        String str4 = new Sha256Hash(str, "123").toHex();
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);

        String str5 = new Sha256Hash(str, new SimpleByteSource("0ef77cfb7aafd7a2022ceb8552acfabe")).toString();
        System.out.println(str5);
    }
}
