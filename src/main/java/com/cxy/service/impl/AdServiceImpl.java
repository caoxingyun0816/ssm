package com.cxy.service.impl;

import com.cxy.bean.Ad;
import com.cxy.dao.AdDao;
import com.cxy.dto.AdDto;
import com.cxy.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoxingyun on 2018/6/6.
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    @Value("${adImage.savePath}")
    private String adImageSavePath;

    @Value("${adImage.url}")
    private String adImageUrl;

    @Override
    public boolean adAdd(AdDto adDto) {
        Ad ad = new Ad();
        ad.setTitle(adDto.getTitle());
        ad.setLink(adDto.getLink());
        ad.setWeight(adDto.getWeight());

        if(null != adDto.getImgFile() && adDto.getImgFile().getSize() >0){
            String filename =  System.currentTimeMillis() + "_"+adDto.getImgFile().getOriginalFilename();
            String fileSavePath = "D:\\workspace\\ssm\\upload\\ad\\";
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

    @Override
   public List<AdDto> searchByPage(AdDto adDto) {
            List<AdDto> result = new ArrayList<AdDto>();
            Ad condition = new Ad();
            BeanUtils.copyProperties(adDto, condition);
            List<Ad> adList = adDao.selectByPage(condition);
            for (Ad ad : adList) {
                AdDto adDtoTemp = new AdDto();
                result.add(adDtoTemp);
                adDtoTemp.setImg(adImageUrl + ad.getImgFileName());
                BeanUtils.copyProperties(ad, adDtoTemp);
            }
            return result;
        }

    @Override
    public AdDto getById(Long id) {
        AdDto result = new AdDto();
        Ad ad = adDao.selectById(id);
        BeanUtils.copyProperties(ad, result);
        result.setImg(adImageUrl + ad.getImgFileName());
        return result;
    }
}
