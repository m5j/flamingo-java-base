package common;

/**
 * Created by MIN.WU.JUN on 2019/12/27
 */
public enum CityEnum {
    CHONGQING("重庆"),
    SHENZHEN("深圳");

    private String desc;

    CityEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
