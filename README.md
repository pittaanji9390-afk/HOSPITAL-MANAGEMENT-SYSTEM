# Enterprise Hospital Management System (HMS)

A production-grade, full-stack enterprise healthcare platform built with **Spring Boot 3.3 (Java 21)**, **PostgreSQL 16**, **Redis 7**, and **React 19 + TypeScript + Vite + Tailwind CSS**.

---

## 📋 Dependencies

The following runtime and developer dependencies are required to run the platform locally or in containerized mode:

- **Node.js**: `v18.0.0+` or `v20.x` (LTS recommended) and `npm v9.0.0+`
- **Java Development Kit (JDK)**: `JDK 21` (Eclipse Temurin, OpenJDK, or Amazon Corretto)
- **Maven**: `v3.9.0+` (or use bundled Maven wrapper)
- **Database Engine**: `PostgreSQL 16+` (or via Docker Compose)
- **In-Memory Cache**: `Redis 7+` (or via Docker Compose)
- **Container Engine**: `Docker v24+` and `Docker Compose v2.20+`
- **Python**: `Python 3.10+` (Optional for local CLI runner)

---

## ⚙️ Installation

### 1. Clone the Repository
```bash
git clone https://github.com/pittaanji9390-afk/HOSPITAL-MANAGEMENT-SYSTEM.git
cd "HOSPITAL MANAGEMENT SYSTEM"
```

### 2. Install Frontend Dependencies
```bash
cd frontend
npm install
cd ..
```

### 3. Install Mobile App Dependencies
```bash
cd mobile
npm install
cd ..
```

### 4. Install & Verify Backend Dependencies
```bash
cd backend
mvn dependency:resolve
cd ..
```

---

## 🔨 Build

### Build Frontend Web Portal
```bash
cd frontend
npm run build
cd ..
```

### Build Mobile Handheld Application
```bash
cd mobile
npm run build
cd ..
```

### Build Spring Boot Backend Service
```bash
cd backend
mvn clean package -DskipTests
cd ..
```

### Build Docker Multi-Stage Image
```bash
docker build -t hospital-management-system:latest .
```

---

## 🚀 Run

### Option A: Run Full Stack via Docker Compose (Recommended)
```bash
docker compose up --build -d
```
- **Enterprise Web Portal**: [http://localhost:5173](http://localhost:5173) (or `http://localhost`)
- **Backend Spring Boot API**: [http://localhost:8080](http://localhost:8080)
- **Swagger / OpenAPI Interactive Docs**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Option B: Run Local Development Servers
In separate terminal tabs:
```bash
# Terminal 1: Backend
cd backend && mvn spring-boot:run

# Terminal 2: Web Portal
cd frontend && npm run dev

# Terminal 3: Mobile Handheld App
cd mobile && npm run dev
```

### Option C: Run via Python Orchestrator
```bash
python app.py
```

---

## 🧪 Testing

Execute automated unit, integration, and clinical workflow test suites:

```bash
# Run Backend JUnit 5 & Mockito Test Suites
cd backend && mvn test

# Run Frontend End-to-End Workflow Tests
cd frontend && npm test
```

---

## 📖 Usage & Domain Capabilities

- **Master Patient Index (MPI)**: Unique MRN sequence generation, demographic management, allergy flags, and duplicate record merge.
- **Appointments & Scheduling**: Doctor shift templates, collision-free slot reservations, check-in, and status transitions.
- **Outpatient Department (OPD)**: Outpatient encounter triage queue, doctor consultation workbench, and orders.
- **Inpatient Department (IPD) & Wards**: Real-time bed occupancy matrix, room classifications, and transactional admission/discharge.
- **Emergency Room (ER) & Resuscitation**: Emergency Severity Index (ESI 1-5) rapid intake, real-time color-coded severity dashboard.
- **Electronic Medical Records (EMR)**: Immutable clinical notes, ICD-10 diagnoses, and longitudinal vitals tracking.
- **E-Prescriptions & eMAR**: Formulation routes, dosages, durations, and inpatient nurse medication administration logs.
- **Pharmacy & Dispensary**: Medicine catalog, batch & lot FEFO stock tracking, expiration alerts, and dispensing depletion.
- **Laboratory Diagnostics**: Test catalog, specimen collection barcodes, normal reference ranges, and abnormal flag detection.
- **Radiology & Imaging**: Modality scheduling (X-Ray, CT, MRI, Ultrasound), PACS image linkage, and diagnostic reporting.
- **Billing & Financial Ledger**: Service price lists, automated invoice generation, double-entry ledger, and multi-tender payments with idempotency guards.
- **Insurance & TPA Claims**: Payer directory, policy coverage percentage, pre-authorization, and claims adjudication.
- **Central Hospital Inventory**: Medical consumable stock ledger, reorder levels, and transactional adjustments.
- **Blood Bank & Transfusion**: Donor management, component separation, refrigeration storage, and cross-matching.
- **Security & Audit Trail**: Argon2/BCrypt hashing, short-lived rotating JWT pairs, fine-grained RBAC/ABAC permissions, and tamper-evident audit logs.

---

## 🔐 Default Seed Credentials

All seed accounts are initialized with password: `Hospital@123`

| Role | Username | Purpose |
|:---|:---|:---|
| **Super Admin** | `superadmin` | Unrestricted system & configuration access |
| **Senior Cardiologist** | `dr.sharma` | Consultations, EMR, Prescriptions, Lab Orders |
| **Lead Orthopedic Surgeon** | `dr.priya` | Surgical records, Ward rounds, EMR |
| **Head Nurse** | `nurse.sarah` | Vitals recording, Ward beds, eMAR administration |
| **Front Desk Officer** | `reception.amit` | Patient intake, MPI registration, Appointment booking |
| **Chief Pharmacist** | `pharm.kavita` | Stock batch inspection, FEFO dispensing |
| **Lead Lab Tech** | `lab.rahul` | Specimen collection, Diagnostic test result entry |
| **Lead Radiographer** | `rad.deepak` | Imaging orders, PACS links, Radiologist reports |
| **Chief Accountant** | `acc.suresh` | Invoicing, Multi-tender payments, Ledger |
