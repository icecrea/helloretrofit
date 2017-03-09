package com.example.helloretrofit.Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */
public class NewsGson {
    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-03-03 11:07","title":"台湾通缉犯遭警方盘查谎报身份 母亲：你别演了","description":"搜狐社会","picUrl":"","url":"http://news.sohu.com/20170303/n482240919.shtml"},{"ctime":"2017-03-03 11:16","title":"环卫工怕82岁老人孤单 带着患脑梗婆婆扫大街","description":"搜狐社会","picUrl":"","url":"http://news.sohu.com/20170303/n482247355.shtml"},{"ctime":"2017-03-03 11:16","title":"女子为美容一年花80多万 借完亲友又借高利贷","description":"搜狐社会","picUrl":"","url":"http://news.sohu.com/20170303/n482247354.shtml"},{"ctime":"2017-03-03 11:17","title":"市民拎大桶直饮水点排队取水 记者拍照被骂","description":"搜狐社会","picUrl":"","url":"http://news.sohu.com/20170303/n482247357.shtml"},{"ctime":"2017-03-03 11:19","title":"天坛公园回应厕纸被\u201c打包\u201d：不会取消免费厕纸","description":"搜狐社会","picUrl":"","url":"http://news.sohu.com/20170303/n482242422.shtml"},{"ctime":"2017-03-03 11:22","title":"陕西一路段10公里设3个收费站 管理方：可以撤俩","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170303/Img482247363_ss.jpg","url":"http://news.sohu.com/20170303/n482243280.shtml"},{"ctime":"2017-03-03 11:28","title":"广西土豪村探秘：身家亿元以上2人 千万级14人","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170303/Img482240921_ss.jpg","url":"http://news.sohu.com/20170303/n482245153.shtml"},{"ctime":"2017-03-03 11:29","title":"楼盘烂尾10年：业主等房结婚 未婚妻等成别人妻","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170303/Img482243281_ss.jpeg","url":"http://news.sohu.com/20170303/n482245324.shtml"},{"ctime":"2017-03-03 11:32","title":"49岁古装女神张敏宣布复出 往日剧照现盛世美颜","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170303/Img482245154_ss.jpeg","url":"http://news.sohu.com/20170303/n482247499.shtml"},{"ctime":"2017-03-03 11:33","title":"90后相亲大会：2个小时里大家都在玩手机","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170303/Img482245325_ss.jpeg","url":"http://news.sohu.com/20170303/n482247179.shtml"}]
     */

    private int code;
    private String msg;
    private List<News> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<News> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<News> newslist) {
        this.newslist = newslist;
    }


}
