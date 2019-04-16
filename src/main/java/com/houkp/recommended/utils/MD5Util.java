package com.houkp.recommended.utils;

import java.security.MessageDigest;

public class MD5Util {

    public static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.trim().getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
//        System.out.println("公司品牌：魅族;"+"操作系统：Android;IMEI:"+MD5("867031022255423"));
//        System.out.println("品牌：山寨苹果;"+"操作系统：Android;IMEI"+MD5("350998832332580"));
//        System.out.println("品牌：Lenovo K30;"+"操作系统：Android;IMEI"+MD5("867792029921198"));
//        System.out.println("公司品牌：小米NOTE4;"+"操作系统：Android;IMEI："+MD5("868942026149793"));
//        System.out.println("品牌：红米2A;"+"操作系统：Android;IMEI"+MD5("868942026149793"));
//        System.out.println("品牌：中兴远航3;"+"操作系统：Android;IMEI"+MD5("868153022515488"));
//        System.out.println("品牌：小辣椒;"+"操作系统：Android;IMEI"+MD5("867338031004605"));
//        System.out.println("品牌：魅族;867900916074530"+"操作系统：Android;IMEI:"+MD5("866090036234056"));
//        System.out.println("品牌：oppo r7007;"+"操作系统：Android;"+MD5("869241038924213"));
//        System.out.println("品牌：oppo r7007;"+"操作系统：Android;"+MD5("869241038924205"));
//        System.out.println("token;"+MD5("houkp@shuzilm.cncwxk9c2220wkpjvvughbrypay9k1x50o"));

        System.out.println("品牌：张晓达;"+"操作系统：Android;"+MD5("864664035593845  "));
        System.out.println("品牌：梁万军;"+"操作系统：Android;"+MD5("862561038556153  "));
        System.out.println("品牌：张宇平;"+"操作系统：Android;"+MD5("355464060287462  "));
        System.out.println("品牌：刘伟 ;"+"操作系统：Android;"+MD5("869204020156079   "));
        System.out.println("品牌：财良;"+"操作系统：Android;"+MD5("864447033344241  "));
        System.out.println("品牌：代立健;"+"操作系统：Android;"+MD5("358530080324001  "));
        System.out.println("品牌：王帅;"+"操作系统：Android;"+MD5("860916033907532    "));
        System.out.println("品牌：威震;"+"操作系统：Android;"+MD5("863254032611260  "));
        System.out.println("品牌：杨旗;"+"操作系统：Android;"+MD5("869161021096086  "));
        System.out.println("品牌：杨哥;"+"操作系统：Android;"+MD5("863982034145446    "));
        System.out.println("品牌：瓦科;"+"操作系统：Android;"+MD5("862949034480678   "));
        System.out.println("品牌：成杰 ;"+"操作系统：Android;"+MD5("864895027831310     "));
        System.out.println("品牌：邓为强  ;"+"操作系统：Android;"+MD5("355464060327904       "));
        System.out.println("品牌：海廷  ;"+"操作系统：Android;"+MD5("869071033474751       "));

    }
}

