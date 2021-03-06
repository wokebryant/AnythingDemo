package com.wokebryant.anythingdemo.laifeng.dynamicsitem.item;

import com.wokebryant.anythingdemo.laifeng.dynamicsitem.factory.DynamicsTypeFactory;

import java.util.Map;

public class DynamicsPhotoItem extends BaseDynamicsItem{

    public int photoUrl;

    public DynamicsPhotoItem(int photoUrl) {
        this.photoUrl = photoUrl;
    }


    @Override
    public BaseDynamicsItem parsingItemData(Map map) {
        return null;
    }

    @Override
    public String getItemMediaType() {
        return BaseDynamicsItem.TYPE_PHOTO;
    }

    @Override
    public int type(DynamicsTypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
