package com.xiaojun.yb.comm;

public class Ref<T> {
    T value;

    public Ref(T value) {
        this.value = value;
    }

    public T get() {
        return this.value;
    }

    public void set(T value) {
        this.value = value;
    }
}
