package text.bwie.mrc.jdcom.Bean.ShouyeBean;

import java.util.List;

/**
 * Created by Mr.c on 2017/12/16.
 */

public class shouyeFenlei {


    /**
     * id : 14
     * opt_id : 14
     * opt_name : 服饰
     * image_url : http://omsproductionimg.yangkeduo.com/goods/5635bbe762/730/100/6bce5c6db8e6bf1a41b2544d453a255c.jpg
     * home_priority : 1
     * home_man_priority : 5
     * children : [{"id":45,"opt_id":45,"opt_name":"女装","image_url":"http://omsproductionimg.yangkeduo.com/images/2017-10-13/f2e65e5865152ca4b6b0e3dd727faf94.png","home_priority":1,"home_man_priority":1},{"id":999,"opt_id":999,"opt_name":"冬上新","image_url":"http://omsproductionimg.yangkeduo.com/images/2017-11-27/4cd1a0fd95ba56ae19f09d1880a67c7e.jpeg","home_priority":2,"home_man_priority":2},{"id":52,"opt_id":52,"opt_name":"女裤","image_url":"http://omsproductionimg.yangkeduo.com/images/2017-08-25/95e9f63138325ade3ed893d535c34c68.png","home_priority":3,"home_man_priority":3},{"id":610,"opt_id":610,"opt_name":"内衣裤袜","image_url":"http://omsproductionimg.yangkeduo.com/images/2017-09-13/93025dd21801ebee5614678172369750.png","home_priority":4,"home_man_priority":4},{"id":1875,"opt_id":1875,"opt_name":"羽绒服","image_url":"http://omsproductionimg.yangkeduo.com/images/2017-11-23/e783eec8d2d9c147a1efa7d9d6c8fcd9.png","home_priority":5,"home_man_priority":5},{"id":1874,"opt_id":1874,"opt_name":"棉服","image_url":"http://omsproductionimg.yangkeduo.com/images/2017-11-23/c799c9d02f13b29ab6cbe7f364a0eaf7.png","home_priority":6,"home_man_priority":6},{"id":997,"opt_id":997,"opt_name":"针织毛衣","image_url":"http://omsproductionimg.yangkeduo.com/images/2017-10-13/68421c9d6718d83d145d0b1cf74fecae.png","home_priority":7,"home_man_priority":7}]
     */

    private int id;
    private int opt_id;
    private String opt_name;
    private String image_url;
    private int home_priority;
    private int home_man_priority;
    private List<ChildrenBean> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(int opt_id) {
        this.opt_id = opt_id;
    }

    public String getOpt_name() {
        return opt_name;
    }

    public void setOpt_name(String opt_name) {
        this.opt_name = opt_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getHome_priority() {
        return home_priority;
    }

    public void setHome_priority(int home_priority) {
        this.home_priority = home_priority;
    }

    public int getHome_man_priority() {
        return home_man_priority;
    }

    public void setHome_man_priority(int home_man_priority) {
        this.home_man_priority = home_man_priority;
    }

    public List<ChildrenBean> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBean> children) {
        this.children = children;
    }

    public static class ChildrenBean {
        /**
         * id : 45
         * opt_id : 45
         * opt_name : 女装
         * image_url : http://omsproductionimg.yangkeduo.com/images/2017-10-13/f2e65e5865152ca4b6b0e3dd727faf94.png
         * home_priority : 1
         * home_man_priority : 1
         */

        private int id;
        private int opt_id;
        private String opt_name;
        private String image_url;
        private int home_priority;
        private int home_man_priority;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOpt_id() {
            return opt_id;
        }

        public void setOpt_id(int opt_id) {
            this.opt_id = opt_id;
        }

        public String getOpt_name() {
            return opt_name;
        }

        public void setOpt_name(String opt_name) {
            this.opt_name = opt_name;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public int getHome_priority() {
            return home_priority;
        }

        public void setHome_priority(int home_priority) {
            this.home_priority = home_priority;
        }

        public int getHome_man_priority() {
            return home_man_priority;
        }

        public void setHome_man_priority(int home_man_priority) {
            this.home_man_priority = home_man_priority;
        }
    }
}
