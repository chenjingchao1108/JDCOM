package text.bwie.mrc.jdcom.Api;

/**
 * Created by Mr.c on 2017/12/8.
 */

public class Api {
    public static boolean isOnline = false;
    public static final String DEV = "http://120.27.23.105/";
    public static final String WROK = "";
    public static final String HOST = isOnline ? WROK : DEV;

    //登录
    public static final String LOGIN="https://www.zhaoapi.cn/user/login";
    //注册
    public static final String RIGST="https://www.zhaoapi.cn/user/reg";
    //个人中心
    public static final String GEREN="https://www.zhaoapi.cn/user/getUserInfo";
    //上传头像
    public static final String UPHEAD="https://www.zhaoapi.cn/file/upload";
    //发现分类
    public static final String SYFL="http://apiv4.yangkeduo.com/";
    //首页
    public static final String Kind = "http://120.27.23.105/product/getCatagory";
    //首页轮播
    public static final String BannerInfo = "http://120.27.23.105/ad/getAd";
    //分类界面三个
    public static final String GOODSINFO = "http://120.27.23.105/product/getProducts";
    public static final String GOODSDETAILS = "http://120.27.23.105/product/getProductDetail";
    //添加购物车
    public static final String ADDCAR = "http://120.27.23.105/product/addCart";
    //获取购物车数据信息
    public static final String GETCART = "http://120.27.23.105/product/getCarts";

    public static final String SEARCH = "http://120.27.23.105/product/searchProducts";

    public static final String CHANGECART = "http://120.27.23.105/product/updateCarts";

    public static final String CREATEPRICE = "http://120.27.23.105/product/createOrder";

    public static final String CLASS = HOST + "product/getCatagory";//分类
    public static final String PRODUCT_CATAGORY = HOST + "product/getProductCatagory";//商品子分类接口
}
