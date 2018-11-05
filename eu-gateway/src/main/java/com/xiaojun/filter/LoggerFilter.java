package com.xiaojun.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * Created by fp295 on 2018/6/26.
 * 网关日志
 */
@Component
public class LoggerFilter extends ZuulFilter {

//    @Autowired
//    private LogSendService logSendService;

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 901;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        logSendService.send(RequestContext.getCurrentContext());
        return null;
    }
}
