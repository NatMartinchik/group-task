# group-task

Привет, коллеги! 

Небольшая подсказка для сборки в Jenkins.

Пример параметров (всего их 3):
BROWSERSIZE,
URLSELENOID,
BASEURL (для корректной работы один из вариантов должен быть https://test.qa.studio)

Tasks:
clean
test
-DpropertyBrowserSize=${BROWSERSIZE}
-DselenoidUrl=${URLSELENOID}
-DstartUrl=${BASEURL}


Путь к файлу с кредами: src/test/resources/config/credentials.properties (там login, password)

