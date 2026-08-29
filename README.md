# Enterprise Hospital Management System (HMS)

A production-grade, full-stack enterprise healthcare platform built with **Spring Boot 3.3 (Java 21)**, **PostgreSQL 16**, **Redis 7**, and **React 19 + TypeScript + Vite + Tailwind CSS**.

---

## 🏥 Platform Capabilities & Domain Coverage

- **Master Patient Index (MPI)**: Unique MRN sequence generation, demographic management, allergy flags, and duplicate record merge.
- **Appointments & Scheduling**: Doctor shift templates, collision-free slot reservations, check-in, and status transitions.
- **Outpatient Department (OPD)**: Outpatient encounter triage queue, doctor consultation workbench, and orders.
- **Inpatient Department (IPD) & Wards**: Real-time bed occupancy matrix, room classifications, and transactional admission/discharge.
- **Emergency Room (ER) & Resuscitation**: Emergency Severity Index (ESI 1-5) rapid intake, real-time color-coded severity dashboard.
- **Electronic Medical Records (EMR)**: Immutable clinical notes (Draft -> Finalized -> Amended), ICD-10 diagnoses, and longitudinal vitals tracking.
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

## 🛠 Technology Stack

- **Backend**: Java 21, Spring Boot 3.3, Spring Security 6, Spring Data JPA, Hibernate, Flyway Migrations, JJWT.
- **Database**: PostgreSQL 16 (Relational integrity, check constraints, indexed search, transactional isolation).
- **Cache & Concurrency**: Redis 7 (Session storage, rate limiting, and concurrency locks).
- **Frontend**: React 18/19, TypeScript, Vite, Tailwind CSS, Lucide Icons, TanStack Query, React Hook Form, Recharts.
- **Infrastructure**: Docker, Docker Compose, Nginx Reverse Proxy, Kubernetes manifests.

---

## 🚀 Quick Start with Docker

```bash
# Clone the repository
git clone https://github.com/pittaanji9390-afk/HOSPITAL-MANAGEMENT-SYSTEM.git
cd "HOSPITAL MANAGEMENT SYSTEM"

# Start the complete platform (Database, Redis, Backend, Frontend)
docker compose up --build -d
```

- **Frontend Portal**: `http://localhost` (or `http://localhost:5173` in local dev)
- **Backend API**: `http://localhost:8080`
- **Swagger / OpenAPI Documentation**: `http://localhost:8080/swagger-ui.html`

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
