package com.jwjjgs.robotcenter.nettyServer.ser;

public interface SerializeI {
    public <T> byte[] serialize(T obj);

    public <T> T deserialize(byte[] data, Class<T> cls);
}
