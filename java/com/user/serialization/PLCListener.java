package com.user.serialization;

/**
 * Created by Administrator on 2019-02-10.
 */

public interface PLCListener {
    abstract public void PLCBitChanged(int address, int pos, boolean val, String plcName);
}