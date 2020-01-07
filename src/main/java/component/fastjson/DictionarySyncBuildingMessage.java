package component.fastjson;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by MIN.WU.JUN on 2019/9/26
 */
@Setter
@Getter
public class DictionarySyncBuildingMessage extends BaseMessage {
    private static final long serialVersionUID = 1L;

    private List<String> buildingIdList;

    /**
     * 需要执行更新操作的单元id
     */
    private String updateBuildingId;

    /**
     * 楼盘id
     */
    private String gardenId;

    /**
     * 保存类型，SAVE_BUILDING表示保存楼栋，SAVE_UNIT表示保存单元或者独栋
     * 在单个新增/编辑的时候才有用
     */
    private BuildingSaveType saveType;

    /**
     * 是否为新增
     * 在单个新增/编辑的时候才有用
     */
    private Boolean create = Boolean.FALSE;


    /*复制房号 start*/
    private List<String> floorIdList;

    private List<String> roomIdList;
    /*复制房号 end*/


    public DictionarySyncBuildingMessage() {
    }

    public DictionarySyncBuildingMessage(MessageOperateType operateType) {
        super(operateType);
    }

    @Override
    public String toString() {
        return "DictionarySyncBuildingMessage{" +
                "buildingIdList=" + buildingIdList +
                ", updateBuildingId='" + updateBuildingId + '\'' +
                ", gardenId='" + gardenId + '\'' +
                ", saveType=" + saveType +
                ", create=" + create +
                ", floorIdList=" + floorIdList +
                ", roomIdList=" + roomIdList +
                '}';
    }
}
