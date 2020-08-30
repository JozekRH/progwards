package ru.progwards.java2.lessons.basetypes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleHashTable<K extends HashValue, V> implements Iterable<TableItem<K,V>> {

    private Object[] table;
    private int size;
    private final int STEP_CONST_VALUE = 10;

    DoubleHashTable() {
        table = new Object[101];
        size = 0;
    }

    private int getHash(int key) {
        return key % table.length;
    }

    private int getHashForStep(int key) {
        double A = (Math.pow(5, 0.5) - 1) / 2;
        double d = key * A;
        int N = 509;
        return (int)(N * (d - Math.floor(d)));
    }

    public void add(K key, V item) throws Exception {
        internalAdd(new TableItem<K, V>(key, item));
    }

    private void internalAdd(TableItem<K, V> item) throws Exception {
        K key = item.getKey();
        int index = getHash(key.getHash());
        int step = getHashForStep(key.getHash());
        step = step==0 ? STEP_CONST_VALUE : step;
        int collisionCounter = 0;
        while (true){
            if (index >= table.length) {
                index = index % table.length;
            }
            if(table[index] != null && key.equals(((TableItem<K, V>)table[index]).getKey()) && !((TableItem<K, V>) table[index]).isRemoved) {
                throw new Exception("Key already exists");
            }
            if(table[index] == null || ((TableItem<K, V>) table[index]).isRemoved)
                break;
            collisionCounter++;
            if(collisionCounter * 100 / table.length >= 10 || size >= table.length) {
                expandTable();
                index = getHash(key.getHash());
            } else {
                index += step;
            }
        }
        table[index] = item;
        size++;
    }

    private void expandTable() throws Exception{
        Object[] oldTable = table;
        table = new Object[PrimeNumber.getNearestPrime(table.length * 2)];
        size = 0;
        for(Object o : oldTable) {
            if(o != null && !((TableItem<K, V>) o).isRemoved) {
                TableItem<K, V> item = (TableItem<K, V>) o;
                internalAdd(item);
            }
        }
    }

    public V get(K key) {
        int index = getHash(key.getHash());
        int step = getHashForStep(key.getHash());
        int startIndex = index;
        do {
            if (index >= table.length)
                index = index % table.length;
            if(table[index] == null) {
                return null;
            } else {
                if (key.equals(((TableItem<K, V>)table[index]).getKey())) {
                    if(((TableItem<K, V>)table[index]).isRemoved) {
                        return null;
                    } else {
                        return ((TableItem<K, V>)table[index]).getItem();
                    }
                }
            }
            index += step;
        } while (index != startIndex);
        return null;
    }

    public void remove(K key) {
        int index = getHash(key.getHash());
        int step = getHashForStep(key.getHash());
        int startIndex = index;
        do {
            if (index >= table.length)
                index = index % table.length;
            if(table[index] == null) {
                return;
            } else {
                if(key.equals(((TableItem<K, V>)table[index]).getKey())) {
                    if(((TableItem<K, V>)table[index]).isRemoved) {
                        return;
                    } else {
                        ((TableItem<K, V>) table[index]).isRemoved = true;
                        size--;
                        return;
                    }
                }
            }
            index += step;
        } while (index != startIndex);
    }

    public void change(K key1, K key2) throws Exception { // изменить значение ключа у элемента с key1 на key2
        V itemValue = get(key1);
        add(key2, itemValue);
        remove(key1);
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<TableItem<K, V>> iterator() {
        return getIterator();
    }

    class HashTableIterator implements Iterator<TableItem<K,V>> {

        private int currentTableIndex;
        private int number;

        HashTableIterator() {
            currentTableIndex = 0;
            while(currentTableIndex < table.length && (table[currentTableIndex] == null || ((TableItem<K, V>)table[currentTableIndex]).isRemoved)) {
                currentTableIndex++;
            }
            number = 0;
        }

        @Override
        public boolean hasNext() {
            return number < size();
        }

        @Override
        public TableItem<K, V> next() {
            if (!hasNext()) throw new NoSuchElementException();
            TableItem<K, V> tableItemToReturn = (TableItem<K, V>) table[currentTableIndex];
            currentTableIndex++;
            while(currentTableIndex < table.length && (table[currentTableIndex] == null || ((TableItem<K, V>)table[currentTableIndex]).isRemoved)) {
                currentTableIndex++;
            }
            number++;
            return tableItemToReturn;
        }
    }

    public Iterator<TableItem<K,V>> getIterator(){
        return new HashTableIterator();
    }

    public static void main(String[] args) throws Exception {
//        DoubleHashTable<KeyInteger, Integer> intHashTable = new DoubleHashTable<>();
//        for(int i = 0; i < 101; i++) {
//            intHashTable.add(new KeyInteger(i), i);
//        }
//        intHashTable.add(new KeyInteger(101), 101);
//        intHashTable.remove(new KeyInteger(50));
//        intHashTable.change(new KeyInteger(45), new KeyInteger(55));
//
//        for(int i = 0; i < 199; i++) {
//            System.out.println(intHashTable.get(new KeyInteger(i)));
//        }
//
//        for(int i = 0; i < 199; i++) {
//            if((intHashTable.table[i]) != null)
//                System.out.println(i + " " + ((DoubleHashTable.TableItem)intHashTable.table[i]).getItem());
//        }
//
//        Iterator iterator = intHashTable.getIterator();
//        while (iterator.hasNext()) {
//            DoubleHashTable.TableItem item = (DoubleHashTable.TableItem)iterator.next();
//            System.out.println(item.getItem());
//        }

        DoubleHashTable<KeyInteger, String> table = new DoubleHashTable<>();
        for(int i=0; i<10; i++) {
            table.add(new KeyInteger(i), "i="+i);
        }
        for(int i=0; i<10; i++) {
            System.out.println(table.get(new KeyInteger(i)));
        }
        System.out.println();

        for (TableItem item : table) {
            System.out.println(item);
        }
        System.out.println();

        Iterator<TableItem<KeyInteger, String>> iterator = table.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        for(int i=0; i<10; i++) {
            table.remove(new KeyInteger(i));
            System.out.println(table.size());
        }
    }
}