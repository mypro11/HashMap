package com.brina;

public class Pair {
    private final int key;
    private  long value;

    public Pair(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        if (key == ((Pair) o).key) if (value == ((Pair) o).value) {
            return true;
        }
        return false;
    }
}
