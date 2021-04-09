public class Test {
    public static void main(String[] args) {
        MyArrayList<String> people = new MyArrayList<>();

        //добавляем в список людей
        people.add("Tom");
        people.add("Jack");
        people.add("James");
        people.add("Sabrina");
        people.add("Nicholas");

        //Выводим список на экран
        System.out.println(people);
        //Выводим размер списка
        System.out.println(people.getSize());
        //Получим, например, 2 элемент списка
        System.out.println(people.get(2));
        //Изменим, например, 3 элемент
        people.set(3, "Natasha");
        System.out.println(people);
        //Удалим элемент и покажем, какой именно, а потом выведем измененный список
        System.out.println(people.remove(1));
        System.out.println(people);
        //Преобразуем список в массив
        System.out.println(people.toArray());
        //Проитерируем список с помощью цикла for-each
        for(String human : people) {
            System.out.println(human);
        }

//        //Oтсортируем список
//        people.sort(people);
    }
}
