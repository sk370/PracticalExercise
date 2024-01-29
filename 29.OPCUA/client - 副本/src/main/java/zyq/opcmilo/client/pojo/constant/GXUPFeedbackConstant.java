package zyq.opcmilo.client.pojo.constant;

public enum GXUPFeedbackConstant {

    GX_UPLOAD_SUCCESS("GX_UPLOAD_SUCCESS", (short)1),
    GX_HAD_UPLOAD_SUCC("GX_HAD_UPLOAD_SUCC", (short)2),
    GX_UPLOAD_EQUIP_ERROE("GX_UPLOAD_EQUIP_ERROE", (short)3),
    GX_UPLOAD_USER_ERROE("GX_UPLOAD_USER_ERROE", (short)4),
    GX_UPLOAD_WIRE_ERROE("GX_UPLOAD_WIRE_ERROE", (short)5),
    GX_NOT_JUDGE("GX_NOT_JUDGE", (short)6),
    GX_DIAMETER_NOT_STANDARD("GX_DIAMETER_NOT_STANDARD", (short)7),
    GX_ALREADY_EMPTY("GX_ALREADY_EMPTY", (short)8),
    GX_OTHER_EQUIP_NOT_DOWN("GX_OTHER_EQUIP_NOT_DOWN", (short)9),
    GX_STATUS_EXCEPTION("GX_STATUS_EXCEPTION", (short)10),
    GX_UPLOAD_NOT_DOWN("GX_UPLOAD_NOT_DOWN", (short)11),
    GX_NOT_OUT_WS("GX_NOT_OUT_WS", (short)12),
    GX_UPLOAD_BY_PC("GX_UPLOAD_BY_PC", (short)13),
    GX_HAS_AUTODOWN("GX_HAS_AUTODOWN", (short)14),
    GX_UPLOAD_SAVE_AGAIN("GX_UPLOAD_SAVE_AGAIN", (short)15),
    GX_UPLOAD_MES_OPEN("GX_UPLOAD_MES_OPEN", (short)16),
    GX_SLOT_N5T_MATCH_DIAMETER("GX_SLOT_N5T_MATCH_DIAMETER", (short)17);

    private String feedbackStr;

    private short feedbackCode;

    public String getFeedbackStr(){
        return this.feedbackStr;
    }

    public short getFeedbackCode(){
        return this.feedbackCode;
    }

    GXUPFeedbackConstant(String feedbackStr, short feedbackCode) {
        this.feedbackStr = feedbackStr;
        this.feedbackCode = feedbackCode;
    }
}
