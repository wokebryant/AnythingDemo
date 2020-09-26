package com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.factory;

import android.content.Context;
import android.view.View;

import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.CommonItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.DynamicsItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.DynamicsListIItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.GroupItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.PhotoItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.PhotoWallItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.RecorderItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.TagInActivityItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.item.TagInFragmentItem;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.DynamicsItemViewHolder;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.PhotoViewHolder;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.PhotoWallViewHolder;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.CommonViewHolder;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.RecorderViewHolder;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.BaseViewHolder;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.GroupViewHolder;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.TagInActivityViewHolder;
import com.wokebryant.anythingdemo.PersonSetting.MulitTypeRV.viewholder.TagInFragmentViewHolder;
import com.wokebryant.anythingdemo.R;

/**
 * @author wb-lj589732
 */
public class ItemTypeFactory implements TypeFactory {

  public static final int RECORD_ITEM_LAYOUT = R.layout.lf_person_setting_recorder_item;
  public static final int PHOTO_WALL_ITEM_LAYOUT = R.layout.lf_person_setting_photo_wall_item;
  public static final int PHOTO_ITEM_LAYOUT = R.layout.lf_person_setting_photo_item;
  public static final int COMMON_ITEM_LAYOUT = R.layout.lf_person_setting_common_item;
  public static final int GROUP_ITEM_LAYOUT = R.layout.lf_person_setting_group_item;
  public static final int TAG_IN_FRAGMENT_ITEM_LAYOUT = R.layout.lf_person_setting_tag_view;
  public static final int TAG_IN_ACTIVITY_ITEM_LAYOUT = R.layout.lf_person_setting_tag_item;
  public static final int DYNAMICS_ITEM_LIST_LAYOUT = R.layout.lf_personal_dynamics_item;
  public static final int DYNAMICS_ITEM_LAYOUT = R.layout.lf_dynamics_item_view;


  @Override
  public int type(RecorderItem recorderBean) {
    return RECORD_ITEM_LAYOUT;
  }

  @Override
  public int type(CommonItem commonItem) {
    return COMMON_ITEM_LAYOUT;
  }

  @Override
  public int type(PhotoWallItem headItem) {
    return PHOTO_WALL_ITEM_LAYOUT;
  }

  @Override
  public int type(PhotoItem photoItem) {
    return PHOTO_ITEM_LAYOUT;
  }

  @Override
  public int type(TagInActivityItem tagItem) {
    return TAG_IN_ACTIVITY_ITEM_LAYOUT;
  }

  @Override
  public int type(TagInFragmentItem tagItem) {
    return TAG_IN_FRAGMENT_ITEM_LAYOUT;
  }

  @Override
  public int type(GroupItem groupItem) {
    return GROUP_ITEM_LAYOUT;
  }

  @Override
  public int type(DynamicsListIItem dynamicsListIItem) {
    return 0;
  }

  @Override
  public int type(DynamicsItem dynamicsItem) {
    return 0;
  }


  @Override
  public BaseViewHolder createViewHolder(Context context, int type, boolean isSelfPage, View itemView) {
    switch (type) {
      case RECORD_ITEM_LAYOUT:
        return new RecorderViewHolder(context, itemView);
      case COMMON_ITEM_LAYOUT:
        return new CommonViewHolder(itemView, isSelfPage);
      case PHOTO_WALL_ITEM_LAYOUT:
        return new PhotoWallViewHolder(context, itemView);
      case PHOTO_ITEM_LAYOUT:
        return new PhotoViewHolder(itemView);
      case TAG_IN_FRAGMENT_ITEM_LAYOUT:
        return new TagInFragmentViewHolder(context, itemView);
      case TAG_IN_ACTIVITY_ITEM_LAYOUT:
        return new TagInActivityViewHolder(context, itemView);
      case GROUP_ITEM_LAYOUT:
        return new GroupViewHolder(itemView, isSelfPage);
      case DYNAMICS_ITEM_LAYOUT:
        return new DynamicsItemViewHolder(context, itemView);
      default:
        return null;
    }
  }
}
