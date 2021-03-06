package com.wokebryant.anythingdemo.laifeng.dynamicsitem.decorate;

public interface DynamicsItemClickCallBack {

    void onDetailClick();

    void onShortVideoClick(String playUrl);

    void onReplayClick(String playUrl);

    void onPhotoListClick(int position);

    void onCommentClick();

    void onPraiseClick();

    void onTeaseClick();

}
