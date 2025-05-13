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

### Frontend
- JSP (шаблонизация)
- HTML/CSS/JS (базовый интерфейс)
- Bootstrap (опционально для стилизации)

### Инструменты
- Maven (сборка)
- Git (контроль версий)
- Tomcat (контейнер сервлетов)

## Структура базы данных
<img src="mdPages/DBDiagrams.png">

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    role VARCHAR(50) NOT NULL CHECK ( role IN ('USER','ADMIN'))
);
```