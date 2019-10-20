package com.jdr.maven.sc.integration.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author zhoude
 * @date 2019/10/20 9:44
 */
@Component
public class LogFilter extends ZuulFilter {

    /**
     * 过滤器类型
     *
     * @return pre、route、post、err
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器执行顺序，越小越先执行
     *
     * @return 执行序列
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否应该过滤（此函数可以增加一些开关的逻辑，来达到动态控制）
     *
     * @return true-应该执行过滤，false-不应该执行过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体执行逻辑
     *
     * @return target
     * @throws ZuulException 执行发生异常时抛出ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.err.println("这是日志");
        return null;
    }
}
