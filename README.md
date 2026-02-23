Home Rental Service
====================

This is a full-stack **Home Rental Service** web application with:

- **Frontend**: HTML, CSS, and JavaScript (no framework)  
- **Backend**: Java **Spring Boot** REST API  
- **Database**: **MySQL** using **Spring Data JPA**

The app provides:

- Modern, responsive landing page
- Property search (location, price range, bedrooms)
- Property listing cards with images and details
- Listing detail modal with contact form (frontend only)
- Backend APIs for managing properties

---

Project Structure
-----------------

- `frontend/`
  - `index.html` – main single-page UI
  - `styles.css` – global styles, layout, responsive design
  - `app.js` – frontend logic and API calls
- `backend/`
  - `pom.xml` – Maven configuration for Spring Boot app
  - `src/main/java/com/houserentalservice/`
    - `HomeRentalServiceApplication.java` – Spring Boot entry point
    - `model/Property.java` – JPA entity
    - `repository/PropertyRepository.java` – Spring Data JPA repository
    - `controller/PropertyController.java` – REST endpoints
  - `src/main/resources/application.properties` – MySQL + JPA config

---

Prerequisites
-------------

- Java 17 or later
- Maven 3.8+  
- MySQL Server
- A browser (Chrome/Edge/Firefox)

---

Backend Setup (Spring Boot + MySQL)
-----------------------------------

1. **Create a MySQL database**:

   ```sql
   CREATE DATABASE home_rental_service CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

2. **Update database credentials** in `backend/src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/home_rental_service?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
   spring.datasource.username=YOUR_DB_USERNAME
   spring.datasource.password=YOUR_DB_PASSWORD
   ```

3. **Run the backend**:

   ```bash
   cd backend
   mvn spring-boot:run
   ```

   The API will be available at `http://localhost:8080`.

---

Frontend Setup
--------------

1. Open the `frontend/index.html` file in your browser **OR** use a simple static server:

   ```bash
   cd frontend
   # Example using npx (optional, if you have Node)
   npx serve .
   ```

2. Make sure the backend is running on `http://localhost:8080` so that the search and listing features can load data.

---

Key REST Endpoints
------------------

- `GET /api/properties` – list/search properties with optional filters:
  - `city` – partial match
  - `minPrice`
  - `maxPrice`
  - `bedrooms`
- `GET /api/properties/{id}` – get single property
- `POST /api/properties` – create a property (JSON body)

These endpoints are consumed by the frontend `app.js`.

---

Next Steps / Customization
--------------------------

- Add user authentication (owners vs renters)
- Add booking requests and availability calendar
- Add image upload storage (e.g., AWS S3, local storage, etc.)
- Add admin dashboard for approving/rejecting listings

