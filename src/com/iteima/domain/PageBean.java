package com.iteima.domain;

import java.util.List;

public class PageBean<T> {

    private int currentPage = 1;                //��ǰҳ��Ĭ����ʾ��һҳ
    private int pageCount = 3;                //ÿҳ��ʾ����������ѯ���ص���������Ĭ��ÿҳ��ʾ3��
    private int totalCount ;                        //���ݿ���е��ܼ�¼��
    private int totalPage;                        //��ҳ��  =  �ܼ�¼��  /    ÿҳ��ʾ��������+1��
    private List<T> list;                           //��ҳ��ѯ��������
    
    
    //������ҳ��
    public int getTotalPage() {
        
        //����ҳ����������ҳ�����ӵ��߼��ж�
        
        if(totalCount % pageCount == 0){
            totalPage = totalCount / pageCount;
        }else{
            totalPage = totalCount / pageCount +1;
        }
        
        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }



    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}