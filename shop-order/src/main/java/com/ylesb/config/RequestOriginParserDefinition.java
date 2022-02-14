package com.ylesb.config;
/**
 * @title: RequestOriginParserDefinition
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/2/1417:16
 */

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @className    : RequestOriginParserDefinition
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/2/14 17:16]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/2/14 17:16]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Component
public class RequestOriginParserDefinition implements RequestOriginParser {
    //定义请求区分来源
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String serviceName = httpServletRequest.getParameter("serviceName");
        if(StringUtils.isEmpty(serviceName)){
            throw new RuntimeException("服务为空");
        }
        return serviceName;
    }
}
