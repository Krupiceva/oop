/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.collections;

/**
 * This class represents simple Hash table
 *
 * @author Dora Mlinarić 0036480184
 * @version 1.1
 */
public class SimpleHashtable {

    /**
     * One slot of table
     */
    private TableEntry[] table;
    /**
     * How many pairs is saved in table
     */
    private int size = 0;

    /**
     * Default constructor for table. It create table with 16 slots
     */
    public SimpleHashtable() {
        this(16);
    }

    /**
     * Constructor for table. If capacity is not potency of number two, then
     * make new capacity. New capacity is potency of number two which is first
     * grater value of accepted capacity
     *
     * @param capacity is number of slots in table
     * @throws IllegalArgumentException if capacity is less than 1
     */
    public SimpleHashtable(int capacity) {

        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be grater or equal to 1");
        }

        for (int i = 1; i <= capacity; i++) {
            int tempPot = (int) Math.pow(2, i);
            int tempPotPrev = (int) Math.pow(2, i - 1);

            if (capacity == tempPot) {
                break;
            } else if (capacity > tempPotPrev & capacity < tempPot) {
                capacity = tempPot;
                break;
            }
        }
        table = new TableEntry[capacity];
    }

    /**
     * This method add new pair in table. With method hashCode() determines in
     * which slot will pair be saved. Overflow is not processed, but it puts
     * elements in sequence list. If received key that already exists, replace
     * old value with new one
     *
     * @param key is a key by which is sort in table
     * @param value is a value which needs to be put in table
     * @throws NullPointerException if key is null
     */
    public void put(Object key, Object value) {
        int flag = 0;

        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        TableEntry newData = new TableEntry(key, value, null);
        int slotIndex = Math.abs(key.hashCode()) % table.length;

        //adding first pair
        if (table[slotIndex] == null) {
            table[slotIndex] = newData;
            size++;
        } else {

            //If already exist
            if (table[slotIndex].getKey() == key) {
                table[slotIndex].setValue(value);
            } else {

                //Put pair on end of a list
                TableEntry tempNext;
                tempNext = table[slotIndex];
                while (tempNext.next != null) {
                    flag=0;
                    if (tempNext.getKey() == key) {
                        tempNext.setValue(value);
                        flag = 1;
                        break;
                    }

                    tempNext = tempNext.next;
                }
                if (flag == 0) {
                    tempNext.next = newData;
                    size++;
                }
            }
        }
    }

    /**
     * This method return value of key
     *
     * @param key is key which value is requested
     * @return requested value If list is empty or pair with this key don't
     * exist, return null
     * @throws NullPointerException if key is null
     */
    public Object get(Object key) {

        if (key == null) {
            throw new NullPointerException("Key cannot be null.");
        }

        int slotIndex = Math.abs(key.hashCode()) % table.length;

        //If list is empty
        if (table[slotIndex] == null) {
            return null;
        }

        //Go through all elements
        TableEntry tempNext;
        tempNext = table[slotIndex];
        while (tempNext != null) {
            if (tempNext.getKey() == key) {
                return tempNext.getValue();
            } else {
                tempNext = tempNext.next;
            }
        }

        return null;

    }

    /**
     * This method return number of pairs saved in table
     *
     * @return number of saved pairs
     */
    public int size() {
        return size;
    }

    /**
     * This method return how many slots table have
     *
     * @return table size
     */
    public int sizeOfTable() {
        return table.length;
    }

    /**
     * This method checks if element with received key exists
     *
     * @param key is a element key
     * @return true if exist, false if not
     * @throws NullPointerException if key is null
     */
    public boolean containsKey(Object key) {

        if (key == null) {
            throw new NullPointerException("Key cannot be null.");
        }

        int slotIndex = Math.abs(key.hashCode()) % table.length;

        //If matching slot is empty, return false
        if (table[slotIndex] == null) {
            return false;
        }

        //Go through all elements
        TableEntry tempNext;
        tempNext = table[slotIndex];
        while (tempNext != null) {
            if (tempNext.getKey() == key) {
                return true;
            } else {
                tempNext = tempNext.next;
            }
        }
        //If it is not found return false
        return false;

    }

    /**
     * This method checks if received value is saved in table
     *
     * @param value which is requested to find
     * @return true if it is found, false if not
     */
    public boolean containsValue(Object value) {
        for (int i = 0; i < table.length; i++) {
            //If some slot is empty, check other slots
            if (table[i] == null) {
                continue;
            }

            TableEntry tempNext;
            tempNext = table[i];
            while (tempNext != null) {
                if (tempNext.getValue() == value) {
                    return true;
                } else {
                    tempNext = tempNext.next;
                }
            }
        }
        return false;
    }

    /**
     * This method remove pair with received key. If that pair is only one,
     * element is null and subtract number of pairs. If that pair is first in
     * list, but not the last one, make second pair first
     *
     * @param key is a key of element which is need to be removed
     * @throws NullPointerException if key is null
     */
    public void remove(Object key) {

        if (key == null) {
            throw new NullPointerException("Key cannot be null.");
        }

        int slotIndex = Math.abs(key.hashCode()) % table.length;
        //If this is first element, it could be the only one or could be more elements
        if (table[slotIndex].getKey() == key) {
            //If this is only one
            if (table[slotIndex].next == null) {
                table[slotIndex] = null;
                size--;
            } else {
                //If is not the only one, make second element to be first
                table[slotIndex] = table[slotIndex].next;
                size--;
            }
        } else {
            TableEntry tempNext;
            tempNext = table[slotIndex];
            while (tempNext.next != null) {
                if (tempNext.next.getKey() == key) {
                    tempNext.next = tempNext.next.next;
                    size--;
                    break;
                } else {
                    tempNext = tempNext.next;
                }
            }
        }
    }

    /**
     * This method checks if table is empty
     *
     * @return true if it is, false if not
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void toStringPrint() {
        String outPut = "";
        for (int i = 0; i < table.length; i++) {
            TableEntry tempNext;
            tempNext = table[i];
            while (tempNext != null) {
                outPut = tempNext.toString();
                System.out.println("Slot = " + i + " " + outPut);
                tempNext = tempNext.next;
            }

        }

    }

    /**
     * This class represents one slot of table
     */
    private class TableEntry {

        /**
         * key value of element
         */
        private Object key;
        /**
         * value of element
         */
        private Object value;
        /**
         * reference on next element in list
         */
        private TableEntry next;

        /**
         * Constructor for slot of table It initializes values of one pair
         *
         * @param key is a key of element by which is sort in table
         * @param value is a value that is need to be saved in table
         * @param next reference on next element
         * @throws NullPointerException if key is null
         */
        public TableEntry(Object key, Object value, TableEntry next) {

            if (key == null) {
                throw new NullPointerException("Key cannot be null.");
            }

            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * Getter for TableEntry
         *
         * @return key of element
         */
        public Object getKey() {
            return key;
        }

        /**
         * Getter for TableEntry
         *
         * @return value of element
         */
        public Object getValue() {
            return value;
        }

        /**
         * Setter for TableEntry
         *
         * @param value is new value
         */
        public void setValue(Object value) {
            this.value = value;
        }

        /**
         * This method create string display of one slot
         *
         * @return this string value
         */
        @Override
        public String toString() {
            String outPut = "Key = " + String.valueOf(key) + " Value = " + String.valueOf(value);
            return outPut;
        }
    }

}
