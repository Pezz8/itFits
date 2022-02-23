package com.example.itfits;

public class CloathingItem {

    String itemBrand;
    String itemGender;
    String itemType;
    String itemSize;
    Double itemChestMin;
    Double itemChestMax;
    Double itemWaistMin;
    Double itemWaistMax;
    Double itemHipsMin;
    Double itemHipsMax;
    Double itemInseam;
    //String itemImage;

    CloathingItem(){
        setItemBrand("");
        setItemGender("");
        setItemType("");
        setItemSize("");
        setItemChestMin(0.0);
        setItemChestMax(.0);
        setItemWaistMin(.0);
        setItemWaistMax(.0);
        setItemHipsMin(.0);
        setItemInseam(.0);
        setItemGender("");
        //setItemImage(brand);
    }

    CloathingItem(String brand, String gender,String type,String size,Double chestMin, Double chestMax, Double waistMin, Double waistMax, Double hipsMin, Double hipsMax, Double inseam){
        setItemBrand(brand);
        setItemGender(gender);
        setItemType(type);
        setItemSize(size);
        setItemChestMin(chestMin);
        setItemChestMax(chestMax);
        setItemWaistMin(waistMin);
        setItemWaistMax(waistMax);
        setItemHipsMin(hipsMin);
        setItemHipsMax(hipsMax);
        setItemInseam(inseam);
        setItemGender(gender);
        //setItemImage(brand);
    }

    public void setItemBrand(String itemBrand){
        this.itemBrand = itemBrand;
    }

    public void setItemGender(String itemGender) {
        this.itemGender = itemGender;
    }

    public void setItemType(String itemType){
        this.itemType = itemType;
    }

    public void setItemSize(String itemSize){
        this.itemSize = itemSize;
    }

    public void setItemChestMax(Double itemChestMax) {
        this.itemChestMax = itemChestMax;
    }

    public void setItemChestMin(Double itemChestMin) {
        this.itemChestMin = itemChestMin;
    }

    public void setItemWaistMin(Double itemWaistMin) {
        this.itemWaistMin = itemWaistMin;
    }

    public void setItemWaistMax(Double itemWaistMax) {
        this.itemWaistMax = itemWaistMax;
    }

    public void setItemHipsMin(Double itemHipsMin) {
        this.itemHipsMin = itemHipsMin;
    }

    public void setItemHipsMax(Double itemHipsMax) {
        this.itemHipsMax = itemHipsMax;
    }

    public void setItemInseam(Double itemInseam) {
        this.itemInseam = itemInseam;
    }

    //    public void setItemImage(String brand){
//        this.itemImage += brand.toLowerCase() + ".png";
//    }

    public String getItemBrand(){
        return this.itemBrand;
    }

    public String getItemType(){
        return this.itemType;
    }

    public String getItemSize(){
        return this.itemSize;
    }

    public Double getItemChestMin() {
        return itemChestMin;
    }

    public Double getItemChestMax() {
        return itemChestMax;
    }

    public Double getItemWaistMin() {
        return itemWaistMin;
    }

    public Double getItemWaistMax() {
        return itemWaistMax;
    }

    public Double getItemHipsMin() {
        return itemHipsMin;
    }

    public Double getItemHipsMax() {
        return itemHipsMax;
    }

    public Double getItemInseam() {
        return itemInseam;
    }

    public String getItemGender() {
        return itemGender;
    }

    //    public String getItemImage(){
//        return this.itemImage;
//    }



}
