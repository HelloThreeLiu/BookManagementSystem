package com.itlsr.utils;

/**
 * @author liusr
 * @create 2021-12-28
 * 分页类
 */
public class PageSupport {
    //定义当前页
    private int pageNum=1;

    //页面容量
    private int pageSize=0;

    //总数量
    private int totalCount=0;

    //总页数
    private int totalPageCount=1;

    public PageSupport() {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = totalPageCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum>0){
            this.pageNum = pageNum;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize>0){
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount>0){
            this.totalCount = totalCount;
            //计算总页数
            setTotalPageCountRS();
        }

    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        if (this.totalPageCount>0){
            this.totalPageCount = totalPageCount;
        }

    }

    //总页数
    public void setTotalPageCountRS(){
        if (this.totalCount % this.pageSize==0){
            this.totalPageCount=this.totalCount/this.pageSize;
        }else if (this.totalCount % this.pageSize>0){
            this.totalPageCount=this.totalCount/this.pageSize+1;
        }else {
            this.totalPageCount=0;
        }
    }
}
