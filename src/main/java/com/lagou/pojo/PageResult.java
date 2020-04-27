package com.lagou.pojo;

public class PageResult<T> {
    public T model;
    public int count;
    public int pageNo;
    public int pageSize;

    public boolean hasNext(){
        if(pageNo<(count/pageSize+1)){
            return true;
        }
        return false;
    }
    public boolean hasPre(){
        if(pageNo>1){
            return true;
        }
        return false;
    }
}
