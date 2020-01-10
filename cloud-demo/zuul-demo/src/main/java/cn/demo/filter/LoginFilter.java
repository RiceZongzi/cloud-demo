package cn.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ：by wgz
 * @description：模拟登录拦截器
 * @Date ：Created in 2020/1/8 17:15
 * @Version: $
 */

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE; // 前置
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1; // 顺序
    }

    @Override
    public boolean shouldFilter() {
        return true; // 是否拦截
    }

    @Override
    public Object run() throws ZuulException {
//        获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
//        获取request
        HttpServletRequest request = ctx.getRequest();
//        获取请求参数access-token
        String token = request.getParameter("access-token");
//        判断是否存在
        if (StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
//        不存在，未登录，则拦截
        return null;
    }
}
