

public class JvmComprehension {				//класс загруажется загрузчиком класса по схеме Bootstrap -> Platform -> Application.
											//Загрузчик классов сначала проверяет, не загружал ли он данный класс ранее.
											//Если это так, то возвращается тот же класс, который возвращался в прошлый раз (класс, хранящийся в кэше)
											//Создается представление класса в памяти Metaspace

    public static void main(String[] args) {
        int i = 1;                      // 1 в Stack [фрэйм main] сохранется переменная i;
        Object o = new Object();        // 2 объект Object создается в Heap, ссылка на объект (o) передается в Stack [фрэйм main]
        Integer ii = 2;                 // 3 объект Integer создается в Heap, ссылка на объект (ii) передается в Stack [фрэйм main]
        printAll(o, i, ii);             // 4 создается фрейм printAll. Посе вызова метода фрейм printAll очищается
        System.out.println("finished"); // 7 Удаляются объекты, которые больше не используются (нет ссылок) - uselessVar
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 ссылка на объект (uselessVar) передается в Stack [фрэйм printAll]
        System.out.println(o.toString() + i + ii);  // 6 Создается фрейм в Stack, туда передаются ссылки на o, i, ii
    }
}

