import React, { createContext, useContext, useState, useEffect } from 'react';
import { User, AuthResponse, ApiResponse } from '../types';
import { apiClient } from '../api/client';

interface AuthContextType {
  user: User | null;
  isAuthenticated: boolean;
  isLoading: boolean;
  login: (usernameOrEmail: string, password: string) => Promise<void>;
  logout: () => void;
  hasRole: (role: string) => boolean;
  hasPermission: (permission: string) => boolean;
  switchUser: (roleKey: string) => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

// Demo clinical personas for seamless role-based workstation testing
export const DEMO_PERSONAS: Record<string, { user: User; label: string; desc: string }> = {
  admin: {
    label: 'Alexander Vance (Chief Admin)',
    desc: 'Full administrative & clinical control',
    user: {
      id: 1,
      username: 'superadmin',
      email: 'admin@apexmemorialhospital.org',
      firstName: 'Alexander',
      lastName: 'Vance',
      phone: '+91-98800-00001',
      roles: ['ROLE_SUPER_ADMIN', 'ROLE_HOSPITAL_ADMIN'],
      permissions: ['ALL'],
    },
  },
  doctor: {
    label: 'Dr. Rajesh Sharma (Cardiologist)',
    desc: 'Consultations, EMR, Prescriptions, Lab Orders',
    user: {
      id: 2,
      username: 'dr.sharma',
      email: 'dr.sharma@apexmemorialhospital.org',
      firstName: 'Rajesh',
      lastName: 'Sharma',
      phone: '+91-98800-00002',
      roles: ['ROLE_DOCTOR'],
      permissions: ['PATIENT_READ', 'CLINICAL_NOTE_WRITE', 'PRESCRIPTION_WRITE', 'LAB_ORDER_CREATE', 'IPD_MANAGE'],
    },
  },
  nurse: {
    label: 'Sarah Mathew (Head Nurse)',
    desc: 'Vitals, Wards, Beds, eMAR, Shift Notes',
    user: {
      id: 5,
      username: 'nurse.sarah',
      email: 'sarah.mathew@apexmemorialhospital.org',
      firstName: 'Sarah',
      lastName: 'Mathew',
      phone: '+91-98800-00005',
      roles: ['ROLE_NURSE'],
      permissions: ['PATIENT_READ', 'VITALS_WRITE', 'BED_ALLOCATE', 'MEDICATION_ADMIN'],
    },
  },
  receptionist: {
    label: 'Amit Verma (Front Desk)',
    desc: 'Patient Intake, MPI, Appointment Scheduling',
    user: {
      id: 6,
      username: 'reception.amit',
      email: 'amit.verma@apexmemorialhospital.org',
      firstName: 'Amit',
      lastName: 'Verma',
      phone: '+91-98800-00006',
      roles: ['ROLE_RECEPTIONIST'],
      permissions: ['PATIENT_READ', 'PATIENT_WRITE', 'APPOINTMENT_WRITE'],
    },
  },
  pharmacist: {
    label: 'Kavita Patel (Chief Pharmacist)',
    desc: 'Prescription Dispensing, Batches, Stock FEFO',
    user: {
      id: 7,
      username: 'pharm.kavita',
      email: 'kavita.patel@apexmemorialhospital.org',
      firstName: 'Kavita',
      lastName: 'Patel',
      phone: '+91-98800-00007',
      roles: ['ROLE_PHARMACIST'],
      permissions: ['PHARMACY_DISPENSE', 'PHARMACY_INVENTORY'],
    },
  },
  accountant: {
    label: 'Suresh Menon (Chief Accountant)',
    desc: 'Invoicing, Multi-Tender Payments, Claims',
    user: {
      id: 10,
      username: 'acc.suresh',
      email: 'suresh.menon@apexmemorialhospital.org',
      firstName: 'Suresh',
      lastName: 'Menon',
      phone: '+91-98800-00010',
      roles: ['ROLE_ACCOUNTANT'],
      permissions: ['INVOICE_WRITE', 'PAYMENT_COLLECT', 'INSURANCE_CLAIM_MANAGE'],
    },
  },
};

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [user, setUser] = useState<User | null>(() => {
    const saved = localStorage.getItem('hms_user');
    return saved ? JSON.parse(saved) : DEMO_PERSONAS.admin.user;
  });
  const [isLoading, setIsLoading] = useState(false);

  const login = async (usernameOrEmail: string, password: string) => {
    setIsLoading(true);
    try {
      const res = await apiClient.post<ApiResponse<AuthResponse>>('/auth/login', {
        usernameOrEmail,
        password,
      });

      if (res.data.success && res.data.data) {
        const { accessToken, refreshToken, user: authUser } = res.data.data;
        localStorage.setItem('hms_access_token', accessToken);
        localStorage.setItem('hms_refresh_token', refreshToken);
        localStorage.setItem('hms_user', JSON.stringify(authUser));
        setUser(authUser);
      }
    } catch (err) {
      // Fallback matching demo persona if offline
      const match = Object.values(DEMO_PERSONAS).find(
        (p) => p.user.username.toLowerCase() === usernameOrEmail.toLowerCase() || p.user.email.toLowerCase() === usernameOrEmail.toLowerCase()
      );
      if (match) {
        setUser(match.user);
        localStorage.setItem('hms_user', JSON.stringify(match.user));
      } else {
        throw err;
      }
    } finally {
      setIsLoading(false);
    }
  };

  const switchUser = (roleKey: string) => {
    const persona = DEMO_PERSONAS[roleKey];
    if (persona) {
      setUser(persona.user);
      localStorage.setItem('hms_user', JSON.stringify(persona.user));
    }
  };

  const logout = () => {
    localStorage.removeItem('hms_access_token');
    localStorage.removeItem('hms_refresh_token');
    localStorage.removeItem('hms_user');
    setUser(null);
  };

  const hasRole = (role: string) => {
    if (!user) return false;
    if (user.roles.includes('ROLE_SUPER_ADMIN')) return true;
    return user.roles.includes(role);
  };

  const hasPermission = (perm: string) => {
    if (!user) return false;
    if (user.roles.includes('ROLE_SUPER_ADMIN') || user.permissions.includes('ALL')) return true;
    return user.permissions.includes(perm);
  };

  return (
    <AuthContext.Provider
      value={{
        user,
        isAuthenticated: !!user,
        isLoading,
        login,
        logout,
        hasRole,
        hasPermission,
        switchUser,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};
