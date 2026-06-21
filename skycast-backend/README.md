# skyCast 🌦️

A real-time, responsive weather dashboard application built with a modern decoupled architecture: a high-performance Spring Boot backend paired with a reactive Angular single-page frontend.

---

## 🚀 Current Status: Core Full-Stack Pipeline Complete
The core end-to-end architecture is fully established. The application dynamically captures client-side browser coordinates, translates them into local location markers, and queries a custom Spring Boot API to fetch real-time weather analytics and 3-day forecasts—rendering everything dynamically.

### Key Features Implemented:
* **Reactive Spring Boot Backend:** Built structured endpoints for current metrics and forecasts using non-blocking programming patterns and clean DTO mapping structures.
* **Angular Frontend Architecture:** Created a Standalone Component single-page interface featuring dark-mode dashboard metrics.
* **Shared State Search Stream:** Implemented an RxJS-driven state stream allowing the top navbar to instantly broadcast manual searches and "Home" navigation actions straight to the data viewport.
* **Geocoding & Dynamic Assets:** Connected client-side reverse-geocoding workflows and integrated external weather CDN graphics to display precise dynamic forecast summaries.

---

## 🛠️ Tech Stack

### Backend Architecture
* **Framework:** Spring Boot 3.x
* **Language:** Java (JDK 17+)
* **Networking:** Spring WebFlux (`WebClient`)
* **Data Processing:** Stream API & Jackson Object Mapping

### Frontend Architecture
* **Framework:** Angular 18+ (Standalone Components)
* **Language:** TypeScript, HTML5, CSS3
* **State Management:** RxJS (BehaviorSubjects & Subscriptions)

---

## 📅 Roadmap / Current Status
- [x] Phase 1: Initialize project architecture & implement Current Weather endpoint.
- [x] Phase 2: Design and implement the **3-Day Weather Forecast** endpoint.
- [x] Phase 3: Build out standalone Angular frontend and design responsive dashboard UI layout.
- [x] Phase 4: Wire end-to-end reactive communication (Navbar search tracking & Dashboard bindings).
- [ ] Phase 5: Add global backend error-handling, API security wrappers, and user settings panel.

---

## 👤 Author
Created with 💻 by **Adithyalal P**