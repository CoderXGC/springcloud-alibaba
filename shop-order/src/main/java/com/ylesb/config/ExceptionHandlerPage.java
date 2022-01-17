package com.ylesb.config;
/**
 * @title: ExceptionHandlerPage
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1215:48
 */

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className    : ExceptionHandlerPage
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/12 15:48]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/12 15:48]
 * @updateRemark : [描述说明本次修改内容] 
 */

public class ExceptionHandlerPage implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        //解决中文乱码
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResponseData data = null;
        if (e instanceof FlowException) {
            data = new ResponseData(-1, "限流了");
        } else if (e instanceof DegradeException) {
            data = new ResponseData(-2, "降级了");
        } else if (e instanceof ParamFlowException) {
            data = new ResponseData(-3, "参数限流了");
        } else if (e instanceof SystemBlockException) {
            data = new ResponseData(-4, "系统负载异常了");
        } else if (e instanceof AuthorityException) {
            data = new ResponseData(-5, "授权异常");
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(data));

    }
}
@Data
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
class ResponseData{
    private int code;
    private String message;
}