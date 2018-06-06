package com.cxy.dto;

import com.cxy.bean.Ad;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by caoxingyun on 2018/6/5.
 */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class AdDto extends Ad {
        private String img;

        private MultipartFile imgFile;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public MultipartFile getImgFile() {
            return imgFile;
        }

        public void setImgFile(MultipartFile imgFile) {
            this.imgFile = imgFile;
        }

}
