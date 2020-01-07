package component.fastjson;

/**
 * Author: Guo.Mao.Lin
 * Time: 2019-09-11 10:56
 * Description:
 */
public enum MessageOperateType {
    ADD("新增"),
    UPDATE("修改"),
    DEL("删除"),
    BATCH_ADD("批量新增"),
    BATCH_UPDATE("批量修改"),
    BATCH_DELETE("批量删除"),
    DRAG_BUILDING("拖拽楼栋"),
    POPULARIZE("推广房号"),
    COPY_ROOM("复制房号"),;

    private String desc;

    MessageOperateType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
