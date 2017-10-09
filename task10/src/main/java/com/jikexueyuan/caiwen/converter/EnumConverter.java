package com.jikexueyuan.caiwen.converter;

import com.jikexueyuan.caiwen.entity.Auth;
import org.apache.struts2.util.StrutsTypeConverter;
import java.util.Map;

public class EnumConverter extends StrutsTypeConverter {

    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        return Auth.valueOf(strings[0]);
    }

    @Override
    public String convertToString(Map map, Object o) {
        return o.toString();
    }
}
