package com.wokebryant.anythingdemo.personsetting.Audio;

/**
 * @author wb-lj589732
 */
public interface ISoundPlayer {

    void showPlayAnim(String currentTime);

    void showPauseView();

    void setSoundDuration(String duration);

    void showRecorderDialog();

    void deleteView();
}