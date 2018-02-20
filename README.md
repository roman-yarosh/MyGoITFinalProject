﻿# GoIT Final Project.

[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/0k6r/GoITFinalProject/master/LICENSE)

## Table of contents

- [About](#about)
- [Demo](#demo)
- [Technical task](#technical-task)
- [Development](#development)
- [License](#license)

## About

Some text about us.
#### Project start date 19.02.2018

## Demo

[My github home url](https://github.com/0k6r)

## Technical task

### Необходимо разработать REST сервер, который имеет следующий функционал:

* Приложение хранит информацию о сотрудниках компании и позволяет вести учет рабочего времени.
* В базе данных должны храниться данные о:
1. Сотрудниках,
2. Должностях сотрудников,
3. Отделе в котором работает сотрудник,
4. Событие (рабочий день, техническая учеба),
5. Статусе сотрудника (больничный, работает, отпуск)
6. Должны быть реализованы 3 уровня доступа к системе:
    * Администратор -  доступ ко всему функционалу (управление ролями, назначение модераторов и т.д.)
    * Модератор - управление данными о сотрудниках (создание, редактирование и т.д.) и рабочих часах
    * Сотрудник - только чтение данных о себе и своем рабочем времени.

- [ ] У каждого сотрудника должна быть часовая ставка. Первого числа каждого месяца, система должна авооматичкски подсчитывать зарплату сотрудника и сохранять ее.Расчетный лист должен автоматически отправляться сотруднику.
- [ ] Необходимо реализовать возможность получения данных о зп сотрудника за любой период.
- [ ] Событие - модератор создает событие
- [ ] Указывает тип события
- [ ] Указывает список сотрудников, которые принимают участие и количество часов для каждого из сотрудников.
- [ ] Данные об отработанных часах суммируются в месячные отработанные часы.

**Технологически стек:**Java, SQL, Spring (MVC, DATA, SECURITY),spring boot, Maven, MySQL, Git, Swagger, Liquidbase.Приложение должно быть развернуто на удаленном сервере (Heroku, AWS, etc.).Результатом выполнения задачи должен быть отдельный репозиторий с описание задачи, документацией по проекту, UML диаграммой проекта и ссылкой на сервер.

По желанию, разрешается реализовать клиентскую часть приложения - front end с использованием любой frontend технологии.

На выполнение проекта - 3 недели!

## Development

* Database creation:
1. Open your console.
2. Run script:
 ```bash
 mysql -u userName -p databaseName < path/to/GoITFinalProject/src/main/resources/initDatabase.sql
```
3. Enter your mysql password.

## License

MIT
