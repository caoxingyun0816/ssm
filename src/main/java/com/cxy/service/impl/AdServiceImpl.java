package com.cxy.service.impl;

import com.cxy.bean.Ad;
import com.cxy.dao.AdDao;
import com.cxy.dto.AdDto;
import com.cxy.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by caoxingyun on 2018/6/6.
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    @Override
    public boolean adAdd(AdDto adDto) {
        Ad ad = new Ad();
        ad.setTitle(adDto.getTitle());
        ad.setLink(adDto.getLink());
        ad.setWeight(adDto.getWeight());

        if(null != adDto.getImgFile() && adDto.getImgFile().getSize() >0){
            String filename =  System.currentTimeMillis() + "_"+adDto.getImgFile().getOriginalFilename();
            String fileSavePath = "D:\\workspace\\ssm\\upload\\ad";
            File adFile = new File(fileSavePath+filename);
            File derectory = new File(fileSavePath);
            if(!derectory.exists()){
                derectory.mkdirs();
            }
            try {
                adDto.getImgFile().transferTo(adFile);
                ad.setImgFileName(filename);
                adDao.insert(ad);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }

    }
}
