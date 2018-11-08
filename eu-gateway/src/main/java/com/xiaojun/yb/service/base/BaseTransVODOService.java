package com.xiaojun.yb.service.base;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseTransVODOService {

    private Class oClass;
    private Class tClass;


    protected List getVOList(List doList) {
        ArrayList var2 = new ArrayList();
        if (doList == null) {
            return var2;
        } else {
            Iterator a2;
            Iterator var10000 = a2 = doList.iterator();
            while (var10000.hasNext()) {
                Object var3;
                if ((var3 = a2.next()) == null) {
                    var10000 = a2;
                } else {
                    var3 = this.getVO(var3);
                    var10000 = a2;
                    var2.add(var3);
                }
            }
            return var2;
        }
    }

    protected BaseTransVODOService(Class a1, Class a2) {
        this.oClass = a1;
        this.tClass = a2;
    }

    protected Object getDO(Object a1) {
        Object var2;
        try {
            var2 = this.tClass.newInstance();
        } catch (Exception var4) {
            return null;
        }

        if (a1 == null) {
            return null;
        } else {
            BeanUtils.copyProperties(a1, var2);
            return var2;
        }
    }

    protected Object getVO(Object a1) {
        Object var2;
        try {
            var2 = this.oClass.newInstance();
        } catch (Exception var4) {
            return null;
        }

        if (a1 == null) {
            return null;
        } else {
            BeanUtils.copyProperties(a1, var2);
            return var2;
        }
    }
}
