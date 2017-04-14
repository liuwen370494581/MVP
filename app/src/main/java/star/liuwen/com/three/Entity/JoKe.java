package star.liuwen.com.three.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by liuwen on 2017/4/14.
 */
public class JoKe {

    @SerializedName("msg") //这种注解方式是为了和返回的结果的gson字段相匹配
    private String msg;

    @SerializedName("status")
    private String status;

    @SerializedName("result")
    private Result mResult;


    public class Result {

        /**
         * "total": "35328", "pagenum": "1", "pagesize": "6", "list": []
         */
        @SerializedName("total")
        private int total;
        @SerializedName("pagenum")
        private int pageNum;
        @SerializedName("pagesize")
        private int pageSize;

        @SerializedName("list")
        private ArrayList<JokeInfo>  mJokeInfoArrayList=new ArrayList<>();

        public ArrayList<JokeInfo> getJokeInfoArrayList() {
            return mJokeInfoArrayList;
        }

        public void setJokeInfoArrayList(ArrayList<JokeInfo> jokeInfoArrayList) {
            mJokeInfoArrayList = jokeInfoArrayList;
        }
    }


}
