package com.fh.typete.model;

public class GoodsValue {
    private Integer id;
    private Integer goodid;
    private String goodvalue;
    private Double price;
    private Integer storcks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getGoodvalue() {
        return goodvalue;
    }

    public void setGoodvalue(String goodvalue) {
        this.goodvalue = goodvalue;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStorcks() {
        return storcks;
    }

    public void setStorcks(Integer storcks) {
        this.storcks = storcks;
    }
}
