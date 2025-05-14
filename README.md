# Task Manager - система управления задачами
## Описание проекта
Task Manager - это веб-приложение для организации/
и отслеживания задач с функционалом аутентификации
пользователей. Проект разработан на Java с использованием
Hibernate ORM и PostgreSQL в качестве базы данных.

## Основные возможности
✅ Регистрация и аутентификация пользователей(а также их дальнейшая авторизация)\
✅ Создание, редактирование и удаление задач\
✅ Установка сроков выполнения (дедлайнов)\
✅ Отслеживание статусов задач (Новая, В работе, Завершена, Архив)\
✅ Фильтрация и сортировка задач

## Технологический стек
### Backend
- Java 17
- Hibernate (ORM)
- PostgreSQL (реляционная БД)
- Servlet API(веб-слой)
- BCrypt (хеширование паролей)
- Querydsl (фреймворк, который упрощает процесс написания типобезопасных запросов )

### Frontend
- JSP (шаблонизация)
- HTML/CSS/JS (базовый интерфейс)

### Инструменты
- Maven (сборка)
- Git (контроль версий)
- Tomcat (контейнер сервлетов)

## Структура базы данных
<img src="mdPages/DBDiagrams.png">

```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    role VARCHAR(50) NOT NULL CHECK ( role IN ('USER','ADMIN'))
);
```

```sql
CREATE TABLE tasks (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL CHECK (status IN ('NEW', 'IN_PROGRESS', 'COMPLETED', 'ARCHIVED')),
    priority VARCHAR(20) NOT NULL CHECK (priority IN ('LOW', 'MEDIUM', 'HIGH', 'CRITICAL')),
    due_date TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE
);
```

## Сборка проекта
```
mvn clean packge
```

## Использование
1. Открыть браузер по ссылке http://localhost:8080/TaskManager/login
2. Зарегистрируйте нового пользователя или войдите под существующим
3. Создавайте задачи, устанавливайте приоритеты и сроки выполнения
4. Отслеживайте прогресс выполнения задач