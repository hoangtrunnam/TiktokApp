package com.example.tiktokclone.model.comment;

public class Pagination {
    private int total;
    private int count;
    private int per_page;
    private int current_page;
    private int total_pages;
    private Links links;

    public Pagination() {
    }

    public Pagination(int total, int count, int per_page, int current_page, int total_pages, Links links) {
        this.total = total;
        this.count = count;
        this.per_page = per_page;
        this.current_page = current_page;
        this.total_pages = total_pages;
        this.links = links;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
