package com.jikexueyuan.caiwen.converter;

import com.jikexueyuan.caiwen.entity.RoleName;
import org.apache.struts2.util.StrutsTypeConverter;
import java.util.Map;

/**
 * @author caiwen
 */
public class EnumConverter extends StrutsTypeConverter {

  @Override
  public Object convertFromString(Map map, String[] strings, Class aClass) {
    return RoleName.valueOf(strings[0]);
  }

  @Override
  public String convertToString(Map map, Object o) {
    return o.toString();
  }
}
