package text.bwie.mrc.jdcom.Bean.LoginBean;

/**
 * Created by Mr.c on 2017/12/13.
 */

public class LoginBean {

    /**
     * code : 0
     * data : {"appkey":"dfc84641a2a8c4d3","appsecret":"7E9E1E70309E3072BEB317589F56D88D","createtime":"2017-12-18T16:17:35","mobile":"15313545601","password":"8F669074CAF5513351A2DE5CC22AC04C","token":"C0B057C40217BCF1E08C373C7D093705","uid":4910,"username":"15313545601"}
     * msg : 登录成功
     */

    private String code;
    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * appkey : dfc84641a2a8c4d3
         * appsecret : 7E9E1E70309E3072BEB317589F56D88D
         * createtime : 2017-12-18T16:17:35
         * mobile : 15313545601
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * token : C0B057C40217BCF1E08C373C7D093705
         * uid : 4910
         * username : 15313545601
         */

        private String appkey;
        private String appsecret;
        private String createtime;
        private String mobile;
        private String password;
        private String token;
        private int uid;
        private String username;

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
