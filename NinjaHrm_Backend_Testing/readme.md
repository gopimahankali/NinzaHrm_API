# NinzaHRM Modular Hybrid E2E Integration Testing Framework

An enterprise-grade, modular hybrid automation framework architected from scratch to validate multi-tier business workflows within the NinzaHRM platform. This repository demonstrates a highly scalable testing model that bridges **Backend REST API Validation** with **Frontend Web UI Data Persistence Checks** inside a single, unified continuous integration execution pipeline.

---

## 🛠️ Core Technology Stack
*   **Backend API Engine:** RestAssured 5.x (REST API Lifecycle Verification)
*   **Frontend UI Engine:** Selenium WebDriver 4.x (Dynamic UI Regression Tracking)
*   **Programming Language:** Java SE (Advanced Object-Oriented Programming, POJO Serialization)
*   **Test Management Matrix:** TestNG Engine (Upstream Multi-Class Dependencies & Assertions)
*   **Reporting & Telemetry:** Allure Reporting Engine / TestNG HTML Logging
*   **Build Automation Tool:** Apache Maven (`pom.xml`)

---

## 📂 Framework Modular Utility Architecture
The core architecture is built around highly decoupled, reusable utility layers located under `src/main/java/com/Ninza/Hrm/api/`:

*   **`BaseTest`**: Orchestrates global configuration hooks, target browser setup/teardown cycles, and centralized Request/Response specifications.
*   **`DataBase_Utility`**: Manages structural JDBC connections to interact with back-end database schemas, enabling direct data verification queries.
*   **`File_Utility`**: Parses localized external system files and dynamic property matrices (`.properties`) to store environment configurations securely.
*   **`Java_Utility`**: Enforces algorithmic helper mechanisms, handling dynamic random data generation to prevent transactional data caching.
*   **`Json_Utility`**: Packages payload parsers to read, manipulate, and execute strict schema validations across dynamic JSON payloads.
*   **`POMclass`**: Implements the **Page Object Model (POM)** design pattern, encapsulating UI web elements away from underlying script logic to slash maintenance timelines.
*   **`WebDriver_Utility`**: Houses customized Selenium action abstractions, explicit synchronization loops, and browser command overrides to eliminate application flakiness.
*   **`pojoClass`**: Encapsulates enterprise entity templates as Plain Old Java Objects (POJOs) supporting seamless JSON payload serialization.

---

## 💻 Advanced Technical Implementations

### 1. Hybrid End-to-End Execution Flow (`EmployeeTest.java`)
*   **Cross-Module Dependency Tracking:** Utilizes TestNG pipeline structures (`dependsOnMethods`) to ingest upstream transactional data parameters (`projectId`, `projectName`) generated across isolated backend modules.
*   **POJO Payload Serialization:** Encapsulates transaction requests using clean Java POJO classes injected with dynamic alphanumeric randomizers, bypassing backend database caching constraints.
*   **Immediate Service Level Agreement (SLA) Assertions:** Leveraged **Hamcrest Matchers** to immediately enforce performance speed thresholds, verifying that microservice roundtrips complete strictly within designated performance metrics (< 3000ms).

### 2. Multi-Tier Data Persistence Verification (GUI Validation)
*   **API-to-UI Integrity Checks:** Dynamically parses runtime response entities (`employeeId`) using JSONPath parsers, routing those backend identifiers straight into frontend Selenium locator factories.
*   **Asynchronous DOM Synchronization:** Implements custom, non-blocking Explicit Waits inside the `WebDriver_Utility` to securely intercept target UI table structures without relying on brittle hardcoded delays.
*   **Data Integrity Enforcement:** Executes robust TestNG hard assertions comparing live database readouts on the graphic user interface directly against transactional API outputs, ensuring zero data loss across platform layers.
