import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import { AppLayout } from './layouts/AppLayout';
import { Login } from './pages/Login';
import { Dashboard } from './pages/Dashboard';
import { Patients } from './pages/Patients';
import { PatientDetail } from './pages/PatientDetail';
import { Appointments } from './pages/Appointments';
import { OpdQueue } from './pages/OpdQueue';
import { IpdWards } from './pages/IpdWards';
import { Emergency } from './pages/Emergency';
import { Pharmacy } from './pages/Pharmacy';
import { Laboratory } from './pages/Laboratory';
import { Radiology } from './pages/Radiology';
import { Billing } from './pages/Billing';
import { Inventory } from './pages/Inventory';
import { BloodBank } from './pages/BloodBank';
import { AuditLogs } from './pages/AuditLogs';
import { Settings } from './pages/Settings';

import { OperatingTheater } from './pages/OperatingTheater';
import { MedicationAdminRecord } from './pages/MedicationAdminRecord';
import { ClinicalCalculators } from './pages/ClinicalCalculators';
import { Hl7FhirHub } from './pages/Hl7FhirHub';
import { ClinicalPathways } from './pages/ClinicalPathways';
import { MedicalTerminology } from './pages/MedicalTerminology';
import { OncologyDaycare } from './pages/OncologyDaycare';
import { LaborDelivery } from './pages/LaborDelivery';
import { DialysisUnit } from './pages/DialysisUnit';
import { DischargeSummaryBuilder } from './pages/DischargeSummaryBuilder';
import { InfectionControl } from './pages/InfectionControl';
import { TelemedicineStation } from './pages/TelemedicineStation';
import { AntibiogramAnalytics } from './pages/AntibiogramAnalytics';

const ProtectedRoute: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const { isAuthenticated } = useAuth();
  if (!isAuthenticated) {
    return <Navigate to="/login" replace />;
  }
  return <>{children}</>;
};

export const App: React.FC = () => {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route
            path="/"
            element={
              <ProtectedRoute>
                <AppLayout />
              </ProtectedRoute>
            }
          >
            <Route index element={<Dashboard />} />
            <Route path="patients" element={<Patients />} />
            <Route path="patients/:id" element={<PatientDetail />} />
            <Route path="appointments" element={<Appointments />} />
            <Route path="opd" element={<OpdQueue />} />
            <Route path="ipd" element={<IpdWards />} />
            <Route path="emergency" element={<Emergency />} />
            <Route path="operating-theater" element={<OperatingTheater />} />
            <Route path="emar" element={<MedicationAdminRecord />} />
            <Route path="oncology" element={<OncologyDaycare />} />
            <Route path="labor-delivery" element={<LaborDelivery />} />
            <Route path="dialysis" element={<DialysisUnit />} />
            <Route path="telemedicine" element={<TelemedicineStation />} />
            <Route path="discharge-summary" element={<DischargeSummaryBuilder />} />
            <Route path="infection-control" element={<InfectionControl />} />
            <Route path="antibiogram" element={<AntibiogramAnalytics />} />
            <Route path="calculators" element={<ClinicalCalculators />} />
            <Route path="clinical-pathways" element={<ClinicalPathways />} />
            <Route path="hl7-fhir" element={<Hl7FhirHub />} />
            <Route path="terminology" element={<MedicalTerminology />} />
            <Route path="prescriptions" element={<Pharmacy />} />
            <Route path="pharmacy" element={<Pharmacy />} />
            <Route path="laboratory" element={<Laboratory />} />
            <Route path="radiology" element={<Radiology />} />
            <Route path="billing" element={<Billing />} />
            <Route path="payments" element={<Billing />} />
            <Route path="insurance" element={<Billing />} />
            <Route path="inventory" element={<Inventory />} />
            <Route path="blood-bank" element={<BloodBank />} />
            <Route path="audit-logs" element={<AuditLogs />} />
            <Route path="settings" element={<Settings />} />
          </Route>
          <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
};
