package aoc.utils;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class HashAlgUtils {

    public static long findMD5HashStartingWith(String password, String prefix) {
        long i = 1;

        while (true) {
            String md5 = md5Hex(password + i);
            if (md5.startsWith(prefix)) {
                break;
            }
            i++;
        }
        return i;
    }
}
