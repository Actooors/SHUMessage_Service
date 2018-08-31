package com.shu.message.service;

import com.shu.message.dao.IframeMapper;
import com.shu.message.model.Json.HostInfo;
import com.shu.message.model.entity.Iframe;
import com.shu.message.model.entity.IframeExample;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.resultsetting.IfreamResultInfo;
import com.shu.message.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-31 16:26
 */
@Service
public class IframeService {
    @Resource
    private IframeMapper iframeMapper;

    public Result newUrl(HostInfo hostInfo) {
        String host = hostInfo.getHost();
        boolean judge = hostInfo.getSupport();
        IframeExample iframeExample = new IframeExample();
        iframeExample.createCriteria()
                .andHostEqualTo(host);
        List<Iframe> iframe = iframeMapper.selectByExample(iframeExample);
        if(iframe.isEmpty()) {
            if(!judge) {
                return ResultTool.success(new IfreamResultInfo(false));
            } else {
                iframeMapper.insert(new Iframe(host));
                return ResultTool.success(new IfreamResultInfo(true));
            }
        } else {
            if(!judge) {
                iframeMapper.deleteByExample(iframeExample);
                return ResultTool.success(new IfreamResultInfo(false));
            } else {
                return ResultTool.success(new IfreamResultInfo(true));
            }
        }

    }

    public Result findUrl(String host) {
        IframeExample iframeExample = new IframeExample();
        iframeExample.createCriteria()
                .andHostEqualTo(host);
        if(iframeMapper.selectByExample(iframeExample).isEmpty()) {
            return ResultTool.success(new IfreamResultInfo(false));
        } else {
            return ResultTool.success(new IfreamResultInfo( (int)(Math.random()*100+1) % 100 > 10));
        }
    }
}
