# 🧩 Project Management Web Platform

> 📝 A full-stack **Jakarta EE** web application designed for managing projects, tasks, and users with secure, role-based access control.
> Built using **JSP**, **JSTL**, **Servlets**, and **MySQL**, the platform provides Directors, Project Managers, and Developers with an intuitive and efficient interface to organize, monitor, and track project progress.

---

## Table of Contents

- Project Overview  
- Features  
- Technologies  
- Prerequisites  
- Configuration  
- Build & Deployment  
- Endpoints & UI  
- Tests  
- Troubleshooting & Tips  
- Contributing  
- License  
- Contact  

---

## Project Overview

- This project is a **Jakarta EE-based web application** for managing software development projects and team workflows.
- It enables Directors to create, assign, and oversee projects, while allowing Developers to manage and update their assigned tasks.
- The system employs **JSP/JSTL** for the frontend, follows the **DAO (Data Access Object) pattern** for persistence, and uses **MySQL** for data storage.
- The application is deployed on **Apache Tomcat**, ensuring reliability and scalability in enterprise environments.

---

## Features

- ✅ **CRUD Operations** for Projects, Tasks, and Users  
- 🔐 **Role-based Authentication** (Director, Project Manager, and Developer)  
- 🧠 **MVC Architecture** (Servlets + JSP + JSTL)  
- 💾 **MySQL Integration** with DAO layer  
- 🎨 **Bootstrap-based Responsive UI**  
- ⚙️ **Configurable via `web.xml` and DB utilities**  
- 🧰 **Portable WAR deployment for Tomcat servers**

---

## Technologies

- ☕ **Java (Jakarta EE)**  
- 🧩 **JSP** (Java Server Pages)  
- 🧱 **JSTL** (Jakarta Standard Tag Library)  
- 🗃 **MySQL Database**  
- 🎨 **Bootstrap + HTML5 + CSS3**  
- ⚙️ **Maven Build Tool**  
- 🧭 **Apache Tomcat Server**

---

## Prerequisites

- **Java JDK 17+**  
- **Apache Tomcat 10+**  
- **MySQL 8.0+**  
- **Maven (or Maven Wrapper)**  
- **Git**

---

## Build & Deployment 🚀

### 1️⃣ Clone the repository

```bash
git clone https://github.com/abdessamad-chahbi/project-management-platform.git
cd project-management-platform
```

### 2️⃣ Build the project

```bash
mvn clean package
```

### 3️⃣ Deploy to Apache Tomcat

Copy the generated `.war` file to:

```
<TOMCAT_HOME>/webapps/
```

Then access in your browser:

```
http://localhost:8080/project-management-platform/
```

---

## Endpoints & UI 🔍

### Web Pages

| URL          | Description          | Role      |
| ------------ | -------------------- | --------- |
| `/login`     | Login page           | All       |
| `/dashboard` | Project dashboard    | Director  |
| `/projects`  | Manage projects      | Director  |
| `/tasks`     | View or update tasks | Developer |

### Backend

| Method   | Endpoint           | Description           |
| -------- | ------------------ | --------------------- |
| `GET`    | `/projects`        | Retrieve all projects |
| `POST`   | `/projects/add`    | Add a new project     |
| `PUT`    | `/tasks/update`    | Update task status    |
| `DELETE` | `/projects/delete` | Delete project by ID  |

---

## Tests 🧪

Run unit and integration tests:

```bash
./mvnw test
```

Includes:

* 🧩 **JUnit 5** for logic testing
* 🧪 **Mockito** for DAO mocks
* 🧱 **Integration tests** for servlets and DB layer

---

## Troubleshooting & Tips ⚠️

* If MySQL connection fails, verify:

  * MySQL is running on port `3306`
  * Username/password are correct
  * JDBC driver is included in `pom.xml`

* For 404 errors, check:

  * `web.xml` servlet mappings
  * WAR deployed under correct Tomcat context

* To reset sessions, delete browser cookies or restart Tomcat.

---

## Contributing 🤝

1. Fork the repository
2. Create a new branch:

   ```bash
   git checkout -b feature/your-feature
   ```
3. Implement your changes
4. Run tests locally
5. Open a pull request with a clear title and description

---

## License 📜

This project is licensed under the **MIT License**.
See the [LICENSE](LICENSE) file for more details.

---

## Contact 📫

**Author:** Abdessamad Chahbi
🌍 [GitHub](https://github.com/abdessamad-chahbi)
📧 Reach out for collaboration or suggestions!

---
