package com.cxy.controller;

import com.cxy.dto.AdDto;
import com.cxy.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caoxingyun on 2018/6/5.
 */
@Controller
@RequestMapping(value = "/ad")
public class AdController {

    @Autowired
    private AdService adService;

    @RequestMapping(value = "/add")
    public String add(AdDto adDto , Model model) {
        if(adService.adAdd(adDto)){
            model.addAttribute("success", "添加成功!");
        }else {
            model.addAttribute("error", "添加!");
        }

        return "/content/adAdd";
    }
}
