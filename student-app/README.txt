Практическая работа №3 — приложение для учёта студентов

Что реализовано:
- Spring Boot + Maven, зависимости Web, Thymeleaf, Spring Data JPA и H2.
- Сущности Student и User.
- StudentRepository и UserRepository с поиском пользователя по логину.
- StudentService и UserService.
- Регистрация, вход и выход через сессию.
- Защита страниц /students и /students/add: без входа происходит переход на /login.
- Добавление студентов и вывод списка.

Как запустить:
1. Распакуйте архив.
2. Откройте папку student-app в OpenIDE как Maven-проект.
3. Убедитесь, что используется JDK 17 или новее.
4. Запустите StudentAppApplication.java.
5. Откройте http://localhost:8080/register и создайте пользователя.
6. Войдите через http://localhost:8080/login, затем добавьте студентов.

Консоль H2: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: оставить пустым

Учебное упрощение: пароли сохраняются в базе в обычном виде, как в минимальном варианте задания. Для реального приложения необходимо хранить хеши паролей.
