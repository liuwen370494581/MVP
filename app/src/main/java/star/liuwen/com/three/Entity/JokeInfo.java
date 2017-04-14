package star.liuwen.com.three.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liuwen on 2017/4/14.
 */
public class JokeInfo {

    @SerializedName("content")
    private String mContent;

    @SerializedName("addtime")
    private String mAddtime;

    public JokeInfo() {
    }

    public JokeInfo(String content, String addtime) {
        mContent = content;
        mAddtime = addtime;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getAddtime() {
        return mAddtime;
    }

    public void setAddtime(String addtime) {
        mAddtime = addtime;
    }
}
