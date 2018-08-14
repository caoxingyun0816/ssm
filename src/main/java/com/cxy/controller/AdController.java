package com.cxy.controller;

import com.cxy.constant.PageCodeEnum;
import com.cxy.dto.AdDto;
import com.cxy.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
        }else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
        }
        return "/content/adAdd";
    }

    @RequestMapping(value = "/search")
    public String search(AdDto adDto,Model model){
        model.addAttribute("list",adService.searchByPage(adDto));
        model.addAttribute("searchParam",adDto);
        return "/content/adList";
    }

    @RequestMapping(value = "/modifyInit")
    public String modifyInit(Model model, @RequestParam("id") Long id) {
        model.addAttribute("modifyObj", adService.getById(id));
        return "/content/adModify";
    }
}
