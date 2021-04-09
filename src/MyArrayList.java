import java.util.Arrays;
import java.util.Iterator;
import java.util.Collection;

public class MyArrayList <T> implements Iterable<T> { //<T> - Generic
    //Изначальный ArrayList имеет размер 10 по умолчанию
    //[0]->[1]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]
    //Когда массив заполняется, создается новый, увеличенный в (size*3)/2+1 раза, а старый будет удален
    // сборщиком мусора
    //[0]->[1]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10]->[11]->[12]->[13]->[14]
        private T[] list; //массив для хранения
        private int size; //размер списка
        private static final int DEF_CAPACITY = 10; //размера массива по умолчанию

        public MyArrayList() {
            this.list = (T[]) new Object[DEF_CAPACITY];
        }

        //Добавление элемента в коллекции
        public boolean add(T t) {
            if(size == list.length) {
                list = increaseCapacity();
            }
            list[size] = t;
            size++;
            return true;
        }

        //приватный метод для увеличения емкости массива
        private T[] increaseCapacity() {//взято из исходников ArrayList в Интернете
            T[] temp = (T[]) new Object[(list.length*3)/2+1]; //создаем новый массив большего размера
            System.arraycopy(list, 0, temp, 0, list.length); //копируем в новый массив элементыиз старого
            return temp;
        }

        @Override
        public String toString() {
            T[] result = (T[]) new Object[size];
            System.arraycopy(list, 0, result, 0, size);
            return Arrays.toString(result);
        }

        //Получение размера коллекции
        public int getSize() {
            return size;
        }

        //Получение элемента по индексу
        public T get(int index) {
            T result = list[index];
            return result;
        }

        //Установление элемента по индексу
        public void set(int index, T t) {
            list[index] = t;
        }

        //Удаление элемента по индексу
        public T remove(int index) {
            T[] result = list;
            list = (T[]) new Object[list.length-1];
            T value = result[index]; //значeние удаляемого элемента
            System.arraycopy(result, 0, list, 0, index); //копируем левую часть массива до указанного элемента
            System.arraycopy(result, index+1, list, index, result.length-index-1); //копируем правую часть массива после указанного индекса
            size--;
            return value;
        }

        //Преобразование коллекции в массив
        public T[] toArray() {
            return Arrays.copyOf(list, size);
        }

        //Проход по списку iterator
        @Override
        public Iterator<T> iterator() {
            Iterator<T> iterator = new Iterator<T>() {
                private int currentIndex = 0; //текущий индекс
                @Override
                public boolean hasNext() {
                    return currentIndex < size && list[currentIndex] != null;
                }
                @Override
                public T next() {
                    return list[currentIndex++];
                }
            };
            return iterator;
        }
//    //Сортировка
//        public <T extends Comparable<? super T» void sort(MyArrayList<T> list) { //Т - тип, который можно сравнить с самим собой
//            T swap;
//            T x;
//            T y;
//            for(int i = 0; i < list.getSize(); i++) {
//                for(int j = i; j < list.getSize()-1; j++) {
//                    if(list.get(j).compareTo(list.get(j+1)) < 0) {
//                        x = list.get(j);
//                        y = list.get(j+1);
//                        swap = x;
//                        x = y;
//                        y = swap;
//                    }
//                }
//            }
//            System.out.println(list);
//        }
}
