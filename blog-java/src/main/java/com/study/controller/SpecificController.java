package com.study.controller;

import com.study.bean.specific.*;
import com.common.bean.CommonResult;
import com.study.service.SpecificService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("specific")
public class SpecificController {

    @Autowired
    private SpecificService service;

    /**
     * 修改标签
     *
     * @param tag
     * @param validResult
     * @return
     */
    @PostMapping("/updateTag")
    public CommonResult updateTag(@RequestBody @Valid Tag tag, BindingResult validResult) {
        int result = service.updateTag(tag);
        if (result > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 分页获取标签
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getTagPage")
    public CommonResult getTagPage(@RequestParam int page, @RequestParam int limit) {
        int start = limit * page - limit;
        Map dataMap = new HashMap();
        dataMap.put("start", start);
        dataMap.put("limit", limit);
        List<Tag> dataList = service.getTagPage(dataMap);
        int count = service.getTagCount();
        return CommonResult.success(dataList, count);
    }

    /**
     * 获取所有标签
     *
     * @return
     */
    @GetMapping("/getTagAll")
    public CommonResult getTagAll() {
        List<Tag> dataList = service.getTagAll();
        return CommonResult.success(dataList);
    }

    /**
     * 分页获取友链
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getFriendPage")
    public CommonResult getFriendPage(@RequestParam int page, @RequestParam int limit) {
        int start = limit * page - limit;
        Map dataMap = new HashMap();
        dataMap.put("start", start);
        dataMap.put("limit", limit);
        List<Friend> dataList = service.getFriendPage(dataMap);
        int count = service.getFriendCount();
        return CommonResult.success(dataList, count);
    }

    /**
     * 获取友情连接
     * @return
     */
    @GetMapping("/getFriendAll")
    public CommonResult getFriendAll() {
        List<Friend> friendList = service.getFriendAll();
        return CommonResult.success(friendList);
    }
}