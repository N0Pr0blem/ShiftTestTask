Версия Java 17
Система сборки Maven 4.0.0

Сторонние библиотеки:
    - lombok 1.18.36           - https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.36
    - junit-jupiter-api 5.11.4 - https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.11.4
    - commons-lang3 3.12.0     - https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.12.0
    - mockito-core 5.15.2      - https://mvnrepository.com/artifact/org.mockito/mockito-core/5.15.2

*** Особенности реализации:
На вход идут данные из файла по пути указанному в org.example.config.Config.class в константе INPUT_FILE_PATH.

*** Программа обрабатывает следующие команды:

------Сортировака--------------
--sort={name/salary} --order={asc/desc}
--s={name/salary} --order={asc/desc}

------Настройка вывода--------
--output=console
-o=console
--output=file --path={path}
-o=file --path={path}

------Остановка программы-----
--exit
-e

*** Условие "Параметр сортировки является необязательным. Если он не указан, то данные выводятся так, как указаны в исходных данных"
я реализовал как команды
--sort
-s
которые выводят данные

Программа написана гибко, поэтому добавить новую команду довольно просто
1. Написать регулярное выражение для парсинга команды в Config
2. Добавляем в CommandParser логику создания CommandContext
3. Создаем саму команду, т.е класс реализующий интерфейс Command
4. Регистрируем команду в CommandExecutor

Программа покрыта тестами
    - Class   - 85%
    - Methods - 88%
    - Line    - 82%
    - Branch  - 76%

Запуск программы через команду java -jar target/shiftTestTask-1.0-SNAPSHOT.jar также был протестирован