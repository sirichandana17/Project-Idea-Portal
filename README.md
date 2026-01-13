# 🚀 Project Idea Portal

A **Full-Stack Web Application** that allows students to submit project ideas and enables reviewers/admins to review, comment, and manage project submissions efficiently.

---

## 📌 Features

### 👩‍🎓 Student
- Register & Login
- Submit project ideas
- View project status
- Receive reviewer feedback

### 🧑‍🏫 Reviewer / Admin
- View submitted project ideas
- Add comments and reviews
- Approve / Reject ideas
- Manage users and projects

---

## 🛠️ Tech Stack

### Frontend
- React (TypeScript)
- Vite
- Tailwind CSS

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- REST APIs

### Database
- MySQL

### Tools
- VS Code
- Spring Tool Suite (STS)
- Git & GitHub

---

## 📂 Project Structure

```text
Project-Idea-Portal/
│
├── frontend/
│   ├── src/
│   ├── public/
│   ├── index.html
│   ├── package.json
│   ├── tsconfig.json
│   └── vite.config.ts
│
├── backend/
│   ├── src/main/java/
│   ├── src/main/resources/
│   ├── src/test/java/
│   ├── pom.xml
│   └── mvnw
│
├── .gitignore
└── README.md
```

---

## ⚙️ Prerequisites

Ensure the following tools are installed before running the project:

- Node.js (v18 or above)
- npm
- Java JDK 17
- Maven
- MySQL
- Git

---

## ▶️ How to Run the Project Locally

### 🔹 1. Clone the Repository

```bash
git clone https://github.com/sirichandana17/Project-Idea-Portal.git
cd Project-Idea-Portal
```
### 🔹 2. Run Backend (Spring Boot)

```bash
cd backend
mvn spring-boot:run
```
- Backend will start at: 
```bash 
http://localhost:8080
```


### 🔹 3. Run Frontend (React)

```bash
cd frontend
npm install
npm run dev
```
- Frontend will start at: 
```bash 
http://localhost:3000
```
---
## 🔗 API Communication

- Frontend communicates with backend using REST APIs
- Backend runs on port 8080
- Frontend runs on port 3000

---
## 🧪 Testing

- Backend APIs tested using Browser and Postman
- Hibernate SQL logs confirm database connectivity
- Frontend tested using local browser

---
## 👩‍💻 Author

- Siri Chandana
- B.Tech CSE (AI & ML)
- GitHub: https://github.com/sirichandana17
---





