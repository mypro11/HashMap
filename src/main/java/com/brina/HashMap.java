package com.brina;

public class HashMap {
    private Pair[] pairs;
    private final float loadFactor;
    private int size;

    public HashMap() {
        this(16);
    }

    public HashMap(int capacity) {
        this(capacity, 0.75f);
    }

    public HashMap(int capacity, float loadFactor) {
        size = 0;
        pairs = new Pair[capacity];
        this.loadFactor = loadFactor;
    }

    public boolean put(int key, long value) {
        int index = hash(key);
        Pair newPair = new Pair(key, value);
        overwriteIfCloseToFull();
        for(int k = 0; k < pairs.length; k++) {
            index = getNextIndex(index, k);
            if (pairs[index] == null) {
                pairs[index] = newPair;
                increaseSize();
                return true;
            } else if(pairs[index].equals(newPair)) {
                return false;
            } else if(pairs[index].getKey() == key) {
                pairs[index].setValue(value);
                return true;
            }
        }
        return false;
    }

    public long get(int key) throws Exception {
        int index = hash(key);
        for(int k = 0; k < pairs.length; k++) {
            index = getNextIndex(index, k);
            if(pairs[index] == null) {
                throw new Exception("The value of this key does not exist");
            } else if (pairs[index].getKey() == key) {
                return pairs[index].getValue();
            }
        }
        throw new Exception("The value of this key does not exist");
    }

    public int size(){
        return size;
    }

    private int getNextIndex(int index, int coefficient) {
        return (index + (int) Math.pow(coefficient, 2)) % pairs.length;
    }

    private int hash(int key) {
        return key % pairs.length;
    }

    private void increaseSize(){
        size++;
    }

    private void overwriteMap() {
        size = 0;
        Pair[] newPairs = pairs;
        pairs = new Pair[pairs.length * 2];
        for(int i = 0; i < newPairs.length; i++) {
            if(newPairs[i] != null) {
                put(newPairs[i].getKey(), newPairs[i].getValue());
            }
        }
    }

    private void overwriteIfCloseToFull() {
        if(size >= loadFactor * pairs.length) {
            overwriteMap();
        }
    }
}
