package com.houkp.recommended.config;

import com.houkp.recommended.service.Fruits;
import com.houkp.recommended.service.impl.Apple;
import com.houkp.recommended.service.impl.Orange;


/**
* @Description:   接口的工厂模式  使用反射来接收接口对象
* @Author:         houkp
* @CreateDate:     2018/5/31 15:21
* @UpdateUser:     houkp
* @UpdateDate:     2018/5/31 15:21
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class FruitsFactory {

    public static Fruits getFruits(String className) {
        Fruits fruits = null;

        try {
          fruits= (Fruits) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruits;
    }
}
