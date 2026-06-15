# NinzaHRM Hybrid E2E Integration & Automation Testing Suite

An advanced, production-grade hybrid automation testing framework architected from scratch to validate multi-tier enterprise workflows within the NinzaHRM platform. This repository demonstrates a highly scalable testing model that seamlessly bridges **Backend REST API Validation** with **Frontend Web UI Data Persistence Checks** inside a single unified execution pipeline.

---

## 🛠️ Core Technology Stack
*   **Backend API Engine:** RestAssured 5.x (REST API Lifecycle Verification)
*   **Frontend UI Engine:** Selenium WebDriver 4.x (Dynamic UI Regression Tracking)
*   **Programming Language:** Java SE (Advanced OOP, Serialization, POJO Models)
*   **Test Management Matrix:** TestNG Engine (Upstream Multi-Class Dependencies, Structural Assertions)
*   **JSON Serialization Layer:** Jackson / Gson Parsing Frameworks
*   **Reporting & Telemetry:** Allure Reporting Engine / TestNG HTML Logging
*   **Continuous Integration:** Jenkins CI/CD Automation Webhooks

---

## 📂 Framework Architecture Layout
```text
NinzaHrm_Backend_Testing/
├── src/
│   ├── main/java/
│   │   ├── com.Ninza.Hrm.api.POMclass/       # Frontend UI Page Object Factories (Page Factory Model)
│   │   ├── com.Ninza.Hrm.api.pojoClass/      # Enterprise Object Models (POJOs for API Serialization)
│   │   └── com.Ninza.Hrm.constants.endpoints/# Centralized Network Controller Endpoints
│   └── test/java/
│       ├── com.Ninza.Hrm.api.BaseTest/       # Global Base Configurations (Driver hooks, Request/Response Specs)
│       ├── com.Ninza.Hrm.api.projectTest/    # Upstream Dependency Modules (Project Generation Controllers)
│       └── com.Ninza.Hrm.api.employeeTest/   # Hybrid E2E Integration Test Cases (`EmployeeTest.java`)
├── pom.xml                                   # Core Maven Dependency Matrix and Build Lifecycle Engine
└── Project.xml / Batch.xml                   # TestNG Multi-Suite Parallel Run Profiles
```

---

## 💻 Advanced Technical Implementations

### 1. Hybrid End-to-End Execution Flow (`EmployeeTest.java`)
*   **Cross-Module Dependency Tracking:** Utilizes TestNG pipeline structures (`dependsOnMethods`) to ingest upstream transactional data parameters (`projectId`, `projectName`) generated across isolated backend modules.
*   **POJO Payload Serialization:** Encapsulates transaction requests using clean Java Plain Old Java Objects (POJOs) injected with dynamic alphanumeric randomizers, bypassing backend data caching constraints.
*   **Immediate Service Level Agreement (SLA) Assertions:** Leverages **Hamcrest Matchers** to immediately enforce performance speed thresholds, verifying that microservice roundtrips complete strictly within designated performance metrics (< 3000ms).

### 2. Multi-Tier Data Persistence Verification (GUI Validation)
*   **API-to-UI Integrity Checks:** Dynamically parses runtime response entities (`employeeId`) using JSONPath parsers, routing those backend identifiers straight into frontend Selenium locator factories.
*   **Asynchronous DOM Synchronization:** Implements custom, non-blocking Explicit Waits to securely intercept target UI table structures without relying on brittle hardcoded delays, eliminating execution pipeline flakiness.
*   **Data Integrity Enforcement:** Executes robust TestNG hard assertions comparing live database readouts on the graphic user interface directly against transactional API outputs, ensuring zero data loss across platform layers.
