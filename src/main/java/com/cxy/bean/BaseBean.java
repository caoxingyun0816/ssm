package com.cxy.bean;

/**
 * Created by caoxingyun on 2018/6/5.
 */
public class BaseBean {

    private Page page;

    public BaseBean() {
        this.page = new Page();
    }

    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }
}