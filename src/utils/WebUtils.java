package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/11-10:51
 */


public class WebUtils {

    public static  <T> T copyParamToBean(Map value,T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }


    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {

        }
        return defaultValue;
    }


}
