package com.example.woodonggo;

public class Home_Tab_Data {
    private String user_name; //사용자 이름
    private String time; //사용자가 게시글을 등록한 시간
    private String content; //사용자가 등록한 게시글
    private int img_user_profile; //사용자 프로필 이미지
    private int img_game; //게임종목 이미지

    public Home_Tab_Data(String user_name, String time, String content, int img_user_profile, int img_game) {
        this.user_name = user_name;
        this.time = time;
        this.content = content;
        this.img_user_profile = img_user_profile;
        this.img_game = img_game;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public int getImg_user_profile() {
        return img_user_profile;
    }

    public int getImg_game() {
        return img_game;
    }
}
