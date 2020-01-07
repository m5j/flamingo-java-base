package component.fastjson;

import java.io.Serializable;
import java.util.UUID;

/**
 * Author: Guo.Mao.Lin
 * Time: 2019-09-11 10:52
 * Description:
 */
public class BaseMessage implements Serializable {
    private static final long serialVersionUID = 7270640043055608618L;
    /*消息唯一Id*/
    private String msgId;
    /*业务操作类型*/
    private MessageOperateType operateType;

    public BaseMessage() {
    }

    protected BaseMessage(MessageOperateType operateType) {
        msgId = UUID.randomUUID().toString();
        this.operateType = operateType;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public MessageOperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(MessageOperateType operateType) {
        this.operateType = operateType;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                "id='" + msgId + '\'' +
                ", operateType=" + operateType +
                '}';
    }
}
