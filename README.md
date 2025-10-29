# 🍽️ Food Finder Admin – Selenium Test Automation with Allure Reports

This repository contains the **Selenium + TestNG + Allure** automated test framework for the **Full-Stack Food Finder Admin Management System**, which handles recipe management, authentication, Gemini AI integration, and profile management — all verified through end-to-end UI tests.

---

## 🌟 Overview

The **Food Finder Admin Portal** allows admins to:
- Manage users and recipes  
- Interact with the **Gemini AI assistant**  
- Perform authentication and password operations  
- View dashboards and profiles  
- Search, add, and manage recipes through a dynamic interface  

This automation suite ensures **smooth UI performance**, **functional correctness**, and **integration testing** for both Admin and User modules.

---

## 🚀 Tech Stack

| Layer | Technology |
|--------|-------------|
| **Frontend Tested** | HTML, CSS, JavaScript |
| **Backend** | Spring Boot, MySQL, Gemini AI |
| **Automation** | Selenium WebDriver |
| **Framework** | TestNG |
| **Reporting** | Allure Reports |
| **Build Tool** | Maven |
| **Language** | Java |

---

## 🧩 Features Covered

| Category | Description |
|-----------|-------------|
| 🔐 **Authentication** | Register, Login, Logout, Forgot Username, Reset Password |
| 👤 **Profile** | Update Password, View Profile |
| 🧠 **Gemini AI** | AI-driven search and recipe generation |
| 🧾 **Recipe Management** | Add, Search, and Delete recipes |
| 🧮 **Dashboard** | Admin statistics and analytics |
| 💬 **Chatbot Page** | Ask Gemini for recipe or AI responses dynamically |

---

## 🎯 Test Scenarios Automated

| No | Test Name | Description | Severity |
|----|------------|-------------|-----------|
| 1️⃣ | Register User | Validates user registration | 🔴 CRITICAL |
| 2️⃣ | Forgot Username | Recovers username by email | 🟠 NORMAL |
| 3️⃣ | Reset Password | Verifies password reset feature | 🟢 NORMAL |
| 4️⃣ | Login User | Checks successful login | 🔴 BLOCKER |
| 5️⃣ | Update Password | Updates password from profile | 🟢 NORMAL |
| 6️⃣ | Add Recipe | Admin adds a new recipe | 🟣 CRITICAL |
| 7️⃣ | Search Recipe | Validates search bar functionality | 🟢 NORMAL |
| 8️⃣ | Gemini AI Queries | Sends prompts to Gemini and verifies AI response | 🔴 CRITICAL |

---

## 🧱 Project Structure

