package com.fh.typete.vo;

import com.fh.typete.model.Goods;

public class GoodsVo extends Goods {
    private Integer startIndex;
    private Integer page;
    private Integer limit;

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
