package com.cxy.util;

import com.cxy.constant.SessionKeyConst;
import com.cxy.dto.ActionDto;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by caoxingyun on 2018/6/15.
 */
public class CommonUtil {

    /**
     * 判断session中存放的动作dto列表中是否包含指定的url
     * @param session
     * @param url
     * @param method http动作
     * @return true:包含，false：不包含
     */
    public static boolean contains(HttpSession session, String url, String method) {
        Object obj = session.getAttribute(SessionKeyConst.ACTION_INFO);
        if(obj != null) {
            @SuppressWarnings("unchecked")
            List<ActionDto> dtoList = (List<ActionDto>)obj;
            for(ActionDto actionDto : dtoList) {
                if(!isEmpty(actionDto.getMethod()) && !actionDto.getMethod().equals(method)) {
                    continue;
                }
                if(!url.matches(actionDto.getUrl())) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    /***
     * 判断是否为NULL
     * @param method
     * @return
     */
    private static boolean isEmpty(String method) {
        if("".equals(method) && null == method){
            return true;
        }
        return false;
    }
}
