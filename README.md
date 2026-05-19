# skyCast 🌦️

A lightweight, efficient Spring Boot backend application designed to fetch, process, and deliver real-time weather information using modern reactive programming patterns.

---

## 🚀 Current Status: Phase 2 Complete
The core backend processing layers are now fully established. The application seamlessly interfaces with external weather microservices to fetch both immediate conditions and multi-day metrics, mapping raw JSON matrices into clean data transfer objects (DTOs).

### Key Features Implemented:
* **Spring Boot Framework:** Foundation backend architecture set up.
* **WebClient Integration:** Initialized Spring WebFlux's `WebClient` for non-blocking, reactive HTTP requests.
* **Current Weather Endpoint:** Built the internal API architecture to capture and handle real-time weather datasets.
* **3-Day Weather Forecast:** Added a multi-day forecast endpoint featuring custom nested JSON parsing utilities to map temperatures, environmental conditions, and precipitation probabilities.

---

## 🛠️ Tech Stack
* **Backend Framework:** Spring Boot 3.x
* **Language:** Java (JDK 17+)
* **Networking:** Spring WebFlux (`WebClient`)
* **Data Processing:** Stream API & Jackson Object Mapping
* **IDE:** Eclipse IDE (with EGit)

---

## 📅 Roadmap / Next Steps
- [x] Phase 1: Initialize project architecture & implement Current Weather endpoint.
- [x] Phase 2: Design and implement the **3-Day Weather Forecast** endpoint.
- [ ] Phase 3: Add global error-handling, reactive fallback structures, and API key security wrappers.
- [ ] Phase 4: Build out and connect front-end architecture.

---
*Developed as a side-project to explore reactive Spring microservices.*