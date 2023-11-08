package zyq.opcmilo.client.pojo.enums;

public enum PLCCommandConstant {

    GX_NORMAL("GX_NORMAL", (short)1),
    GX_EXC("GX_EXC",(short)2),
    GX_CHANGE("GX_CHANGE",(short)3);

    private String commandStr;

    private short commandCode;

    public String getCommandStr(){
        return this.commandStr;
    }

    public short getCommandCode(){
        return this.commandCode;
    }

    PLCCommandConstant(String commandStr, short commandCode) {
        this.commandStr = commandStr;
        this.commandCode = commandCode;
    }
}
