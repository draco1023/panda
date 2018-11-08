package com.yukong.panda.gen.controller;

import com.yukong.panda.common.util.ApiResult;
import com.yukong.panda.gen.model.dto.BuildConfigDTO;
import com.yukong.panda.gen.model.entity.TableInfo;
import com.yukong.panda.gen.model.query.TableInfoQuery;
import com.yukong.panda.gen.service.SysGenService;
import com.yukong.panda.gen.service.TableInfoService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yukong
 * @date: 2018/11/8 10:33
 */
@Controller
public class SysGenController {

    @Autowired
    private TableInfoService tableInfoService;

    @Autowired
    private SysGenService sysGenService;

    @ResponseBody
    @GetMapping("/table/page")
    public ApiResult<TableInfoQuery> page(TableInfoQuery query){
        return new ApiResult<>(tableInfoService.pageByQuery(query));
    }


    @PostMapping("/code")
    public void code(@RequestBody BuildConfigDTO buildConfigDTO, HttpServletResponse response) throws IOException {

        byte[] data = sysGenService.genCodeByTableName(buildConfigDTO);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

}
