package com.greenleaf.ntsp.service.module;

import java.util.List;

public class CibaBean {

    /**
     * sid : 3084
     * tts : http://news.iciba.com/admin/tts/2018-08-051-day.mp3
     * content : When I was young, I wanted to be anybody but myself. I would have to accept myself, my warts and all.
     * note : 当我年轻的时候，我想成为除我之外的任何人。但我必须接受我自己，我的缺点，我的一切。
     * love : 1597
     * translation : 小编的话：这句话出自《玛丽和马克思》，该部澳大利亚粘土动画是圣丹斯电影节开幕大作。每个人都会有缺陷，就像被上帝咬过的苹果，有的人缺陷比较大，正是因为上帝特别喜欢他的芬芳。我们没有办法选择自己的缺点，它是我们的一部分，我们要试着接受它。
     * picture : http://cdn.iciba.com/news/word/20180805.jpg
     * picture2 : http://cdn.iciba.com/news/word/big_20180805b.jpg
     * caption : 词霸每日一句
     * dateline : 2018-08-05
     * s_pv : 0
     * sp_pv : 0
     * tags : [{"id":null,"name":null}]
     * fenxiang_img : http://cdn.iciba.com/web/news/longweibo/imag/2018-08-05.jpg
     */

    private String sid;
    private String tts;
    private String content;
    private String note;
    private String love;
    private String translation;
    private String picture;
    private String picture2;
    private String caption;
    private String dateline;
    private String s_pv;
    private String sp_pv;
    private String fenxiang_img;
    private List<TagsBean> tags;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTts() {
        return tts;
    }

    public void setTts(String tts) {
        this.tts = tts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    public String getS_pv() {
        return s_pv;
    }

    public void setS_pv(String s_pv) {
        this.s_pv = s_pv;
    }

    public String getSp_pv() {
        return sp_pv;
    }

    public void setSp_pv(String sp_pv) {
        this.sp_pv = sp_pv;
    }

    public String getFenxiang_img() {
        return fenxiang_img;
    }

    public void setFenxiang_img(String fenxiang_img) {
        this.fenxiang_img = fenxiang_img;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {
        /**
         * id : null
         * name : null
         */

        private Object id;
        private Object name;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }
    }
}
