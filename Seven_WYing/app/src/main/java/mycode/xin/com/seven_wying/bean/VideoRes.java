package mycode.xin.com.seven_wying.bean;

import java.util.List;

/**
 * date:2017/12/15  20:48
 * author:Mr.XIn💕
 */


public class VideoRes {

    /**
     * msg : 成功
     * ret : {"pnum":1,"totalRecords":5,"records":20,"list":[{"msg":"几年前看过，重温","phoneNumber":"151****8102","dataId":"ff8080815ceda003015ceeb25ae40f1d","userPic":"","time":"2017-06-28 20:34:45","likeNum":6},{"msg":"超喜欢男神的这部片子，就是喜欢。","phoneNumber":"忧别人之忧","dataId":"ff8080815c9b961b015ca9b62d06649a","userPic":"","time":"2017-06-09 06:05:07","likeNum":6},{"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"自欺欺人","dataId":"ff8080815c9b961b015ca9b62d046499","userPic":"","time":"2017-06-03 11:05:07","likeNum":9},{"msg":"电影一般般吧，唯一的亮点是女主。","phoneNumber":"微笑掩饰悲伤","dataId":"ff8080815c9b961b015ca9b62d006497","userPic":"","time":"2017-05-28 15:05:07","likeNum":9},{"msg":"手机电影APP的片子还挺多，不错不错！","phoneNumber":"伪装坚强","dataId":"ff8080815c9b961b015ca9b62d026498","userPic":"","time":"2017-05-22 23:50:07","likeNum":2}],"totalPnum":1}
     * code : 200
     */

    private String msg;
    private RetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class RetBean {
        /**
         * pnum : 1
         * totalRecords : 5
         * records : 20
         * list : [{"msg":"几年前看过，重温","phoneNumber":"151****8102","dataId":"ff8080815ceda003015ceeb25ae40f1d","userPic":"","time":"2017-06-28 20:34:45","likeNum":6},{"msg":"超喜欢男神的这部片子，就是喜欢。","phoneNumber":"忧别人之忧","dataId":"ff8080815c9b961b015ca9b62d06649a","userPic":"","time":"2017-06-09 06:05:07","likeNum":6},{"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"自欺欺人","dataId":"ff8080815c9b961b015ca9b62d046499","userPic":"","time":"2017-06-03 11:05:07","likeNum":9},{"msg":"电影一般般吧，唯一的亮点是女主。","phoneNumber":"微笑掩饰悲伤","dataId":"ff8080815c9b961b015ca9b62d006497","userPic":"","time":"2017-05-28 15:05:07","likeNum":9},{"msg":"手机电影APP的片子还挺多，不错不错！","phoneNumber":"伪装坚强","dataId":"ff8080815c9b961b015ca9b62d026498","userPic":"","time":"2017-05-22 23:50:07","likeNum":2}]
         * totalPnum : 1
         */

        private int pnum;
        private int totalRecords;
        private int records;
        private int totalPnum;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * msg : 几年前看过，重温
             * phoneNumber : 151****8102
             * dataId : ff8080815ceda003015ceeb25ae40f1d
             * userPic :
             * time : 2017-06-28 20:34:45
             * likeNum : 6
             */

            private String msg;
            private String phoneNumber;
            private String dataId;
            private String userPic;
            private String time;
            private int likeNum;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
