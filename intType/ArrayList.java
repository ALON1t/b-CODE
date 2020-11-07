package intType;

import java.lang.reflect.Array;
import java.util.Arrays;

//仿写真实的ArrayList
public class ArrayList implements List{
    private  int[] arr;
    private int size;

    public ArrayList() {
        arr = new int[10];
        size = 0;
    }

    public ArrayList(List other) {

    }

    public void ensureCap(int cap) {
        if(this.arr.length >= cap) {//判断是否需要扩容
            return;
        }
        int[] newArr = new int[cap];//转移到新数组
        for(int i = 0;i < size; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }

    @Override
    public boolean add(Integer e) {
        if(this.arr.length ==size) {
            ensureCap(arr.length*2);
        }
        arr[size++] = e; //时间复杂度O(1)
        return true;
    }

    @Override
    public void add(int index, Integer e) {
        //[0;size]

        if(index < 0 || index > size) {
            throw  new IndexOutOfBoundsException("下标不合法");
        }
        //index位置后的向后搬移
        for(int i = size; i > index;i--) {
            arr[i] = arr[i-1];
        }
       /* for(int i = size-1; i > index;i--) {//一样
            arr[i + 1]  =arr[i];
        }*/
        arr[index] = e;
        size++;
    }

    @Override
    public Integer remove(int index) {
        if(size < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        int e = arr[index];
        //从前往后删
        for(int i = index+1; i <= size-1; i++) {
        arr[i-1] = arr[i];
        }
        size--;
        return e;
    }

    @Override
    public boolean remove(Integer e) {
        int index = indexOf(e);
        if(index != -1) {
            remove(e);
            return true;
        } else {
            return false;
        }
/*        for(int i = 0; i < size; i++) {
            if(arr[i] == e) {
                remove(i);
                return  true;
            }
        }
        return false;*/
    }

    @Override
    public Integer get(int index) {
        return arr[index];
    }

    @Override
    public Integer set(int index, Integer e) {
        Integer old = arr[index];
        arr[index] = e;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(arr,-1);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Integer e) {
        return indexOf(e) !=-1;
    }

    @Override
    public int indexOf(Integer e) {
        for(int i = 0; i < size; i++) {
            if(arr[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        for(int i = size-1; i >= 0; i--) {
            if(arr[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
