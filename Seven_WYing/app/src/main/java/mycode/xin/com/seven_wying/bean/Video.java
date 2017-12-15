package mycode.xin.com.seven_wying.bean;

import java.io.Serializable;

/**
 * data:2017/12/15
 * auther:admin
 */

public class Video implements Serializable {
    private int airTime;
    private String angleIcon;
    private String dataId;
    private String description;
    private String duration;
    private String loadType;
    private String loadURL;
    private String pic;
    private String roomId;
    private int score;
    private String shareURL;
    private String title;

    public Video(int airTime, String angleIcon, String dataId, String description, String duration, String loadType, String loadURL, String pic, String roomId, int score, String shareURL, String title) {
        this.airTime = airTime;
        this.angleIcon = angleIcon;
        this.dataId = dataId;
        this.description = description;
        this.duration = duration;
        this.loadType = loadType;
        this.loadURL = loadURL;
        this.pic = pic;
        this.roomId = roomId;
        this.score = score;
        this.shareURL = shareURL;
        this.title = title;
    }

    public int getAirTime() {
        return airTime;
    }

    public void setAirTime(int airTime) {
        this.airTime = airTime;
    }

    public String getAngleIcon() {
        return angleIcon;
    }

    public void setAngleIcon(String angleIcon) {
        this.angleIcon = angleIcon;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getLoadURL() {
        return loadURL;
    }

    public void setLoadURL(String loadURL) {
        this.loadURL = loadURL;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getShareURL() {
        return shareURL;
    }

    public void setShareURL(String shareURL) {
        this.shareURL = shareURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
