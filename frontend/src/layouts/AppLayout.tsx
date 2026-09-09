import React, { useState } from 'react';
import { Outlet, NavLink, useNavigate, useLocation } from 'react-router-dom';
import {
  Activity,
  Users,
  Calendar,
  UserCheck,
  BedDouble,
  Flame,
  FileText,
  Pill,
  TestTube2,
  ScanLine,
  Receipt,
  CreditCard,
  ShieldCheck,
  Boxes,
  HeartPulse,
  History,
  Settings,
  LogOut,
  ChevronDown,
  Bell,
  Search,
  Menu,
  X,
  Stethoscope,
  Building2,
  GitFork,
  Share2,
  BookOpen,
  Droplets,
  ShieldAlert,
  Video,
  Bug,
} from 'lucide-react';
import { useAuth, DEMO_PERSONAS } from '../context/AuthContext';

export const AppLayout: React.FC = () => {
  const { user, logout, switchUser } = useAuth();
  const [sidebarOpen, setSidebarOpen] = useState(false);
  const [userMenuOpen, setUserMenuOpen] = useState(false);
  const navigate = useNavigate();
  const location = useLocation();

  const navGroups = [
    {
      title: 'CLINICAL & PATIENTS',
      items: [
        { label: 'Overview Dashboard', path: '/', icon: Activity },
        { label: 'Master Patient Index', path: '/patients', icon: Users },
        { label: 'Appointments & Slots', path: '/appointments', icon: Calendar },
        { label: 'OPD Consultation Queue', path: '/opd', icon: UserCheck },
        { label: 'IPD Admissions & Wards', path: '/ipd', icon: BedDouble },
        { label: 'Emergency Trauma Triage', path: '/emergency', icon: Flame, badge: 'ER' },
        { label: 'Operating Theaters (OR)', path: '/operating-theater', icon: Building2 },
        { label: 'Nurse eMAR Workstation', path: '/emar', icon: Pill },
        { label: 'Oncology Chemotherapy Daycare', path: '/oncology', icon: Activity },
        { label: 'Labor & Delivery (L&D)', path: '/labor-delivery', icon: HeartPulse },
        { label: 'Nephrology & Dialysis Unit', path: '/dialysis', icon: Droplets },
        { label: 'Clinical Calculators & CDSS', path: '/calculators', icon: Stethoscope },
        { label: 'Telemedicine Consultation', path: '/telemedicine', icon: Video },
        { label: 'Inpatient Care Pathways', path: '/clinical-pathways', icon: GitFork },
        { label: 'Discharge Summary Builder', path: '/discharge-summary', icon: FileText },
        { label: 'Infection Control & AMS', path: '/infection-control', icon: ShieldAlert },
        { label: 'Antibiogram Analytics', path: '/antibiogram', icon: Bug },
        { label: 'HL7 & FHIR Data Hub', path: '/hl7-fhir', icon: Share2 },
        { label: 'Medical Terminology Master', path: '/terminology', icon: BookOpen },
      ],
    },
    {
      title: 'DIAGNOSTICS & PHARMACY',
      items: [
        { label: 'E-Prescriptions', path: '/prescriptions', icon: FileText },
        { label: 'Pharmacy & Batches', path: '/pharmacy', icon: Pill },
        { label: 'Laboratory Diagnostic', path: '/laboratory', icon: TestTube2 },
        { label: 'Radiology & Imaging', path: '/radiology', icon: ScanLine },
      ],
    },
    {
      title: 'FINANCIALS & SUPPLIES',
      items: [
        { label: 'Billing & Invoicing', path: '/billing', icon: Receipt },
        { label: 'Payment Ledger', path: '/payments', icon: CreditCard },
        { label: 'Insurance & Claims', path: '/insurance', icon: ShieldCheck },
        { label: 'Central Inventory', path: '/inventory', icon: Boxes },
        { label: 'Blood Bank Hub', path: '/blood-bank', icon: HeartPulse },
      ],
    },
    {
      title: 'ADMIN & COMPLIANCE',
      items: [
        { label: 'Audit Trail & Logs', path: '/audit-logs', icon: History },
        { label: 'System Configuration', path: '/settings', icon: Settings },
      ],
    },
  ];

  return (
    <div className="min-h-screen flex bg-slate-50">
      {/* Mobile backdrop */}
      {sidebarOpen && (
        <div
          className="fixed inset-0 bg-slate-900/50 z-40 lg:hidden"
          onClick={() => setSidebarOpen(false)}
        />
      )}

      {/* Sidebar */}
      <aside
        className={`fixed lg:static inset-y-0 left-0 z-50 w-72 bg-slate-900 text-slate-300 flex flex-col transition-transform duration-300 ease-in-out ${
          sidebarOpen ? 'translate-x-0' : '-translate-x-full lg:translate-x-0'
        }`}
      >
        {/* Brand Header */}
        <div className="h-16 px-6 bg-slate-950 flex items-center justify-between border-b border-slate-800">
          <div className="flex items-center gap-3">
            <div className="h-10 w-10 rounded-xl bg-gradient-to-tr from-sky-600 to-teal-400 flex items-center justify-center text-white shadow-lg shadow-sky-500/20">
              <Stethoscope className="h-6 w-6" />
            </div>
            <div>
              <h1 className="font-bold text-white tracking-wide text-base leading-tight">Apex Memorial</h1>
              <p className="text-[11px] text-sky-400 font-medium tracking-wider">HOSPITAL SYSTEM</p>
            </div>
          </div>
          <button
            className="lg:hidden text-slate-400 hover:text-white"
            onClick={() => setSidebarOpen(false)}
          >
            <X className="h-5 w-5" />
          </button>
        </div>

        {/* Quick Role Switcher Banner */}
        <div className="px-4 py-3 bg-slate-950/60 border-b border-slate-800/80">
          <label className="text-[10px] font-semibold tracking-wider text-slate-400 uppercase block mb-1.5">
            Active Role Persona:
          </label>
          <select
            className="w-full bg-slate-800 text-xs text-white border border-slate-700 rounded-lg px-2.5 py-1.5 focus:outline-none focus:ring-1 focus:ring-sky-500 font-medium"
            value={
              Object.keys(DEMO_PERSONAS).find(
                (k) => DEMO_PERSONAS[k].user.username === user?.username
              ) || 'admin'
            }
            onChange={(e) => switchUser(e.target.value)}
          >
            {Object.entries(DEMO_PERSONAS).map(([key, item]) => (
              <option key={key} value={key}>
                {item.label}
              </option>
            ))}
          </select>
        </div>

        {/* Navigation Links */}
        <nav className="flex-1 overflow-y-auto px-4 py-4 space-y-6">
          {navGroups.map((group, idx) => (
            <div key={idx}>
              <p className="px-3 text-[10px] font-bold tracking-widest text-slate-500 uppercase mb-2">
                {group.title}
              </p>
              <div className="space-y-1">
                {group.items.map((item) => {
                  const Icon = item.icon;
                  const isActive = location.pathname === item.path;
                  return (
                    <NavLink
                      key={item.path}
                      to={item.path}
                      onClick={() => setSidebarOpen(false)}
                      className={`flex items-center justify-between px-3 py-2 rounded-xl text-xs font-medium transition-all ${
                        isActive
                          ? 'bg-sky-600 text-white font-semibold shadow-md shadow-sky-600/30'
                          : 'text-slate-400 hover:text-slate-100 hover:bg-slate-800/60'
                      }`}
                    >
                      <div className="flex items-center gap-3">
                        <Icon className={`h-4 w-4 ${isActive ? 'text-white' : 'text-slate-400'}`} />
                        <span>{item.label}</span>
                      </div>
                      {item.badge && (
                        <span className="px-1.5 py-0.5 text-[9px] font-bold uppercase rounded bg-rose-500/20 text-rose-300 border border-rose-500/30">
                          {item.badge}
                        </span>
                      )}
                    </NavLink>
                  );
                })}
              </div>
            </div>
          ))}
        </nav>

        {/* Sidebar Footer User Info */}
        <div className="p-4 bg-slate-950 border-t border-slate-800 flex items-center justify-between">
          <div className="flex items-center gap-3">
            <div className="h-8 w-8 rounded-full bg-sky-800 text-sky-200 font-semibold text-xs flex items-center justify-center border border-sky-600">
              {user?.firstName?.[0]}
              {user?.lastName?.[0]}
            </div>
            <div className="overflow-hidden">
              <p className="text-xs font-semibold text-white truncate">
                {user?.firstName} {user?.lastName}
              </p>
              <p className="text-[10px] text-slate-400 truncate">
                {user?.roles?.[0]?.replace('ROLE_', '')}
              </p>
            </div>
          </div>
          <button
            onClick={() => {
              logout();
              navigate('/login');
            }}
            title="Sign Out"
            className="p-1.5 text-slate-400 hover:text-rose-400 rounded-lg hover:bg-slate-800 transition-colors"
          >
            <LogOut className="h-4 w-4" />
          </button>
        </div>
      </aside>

      {/* Main Content Area */}
      <div className="flex-1 flex flex-col min-w-0">
        {/* Top Navbar */}
        <header className="h-16 bg-white border-b border-slate-200 sticky top-0 z-30 px-4 lg:px-8 flex items-center justify-between">
          <div className="flex items-center gap-4">
            <button
              className="lg:hidden p-2 rounded-lg text-slate-600 hover:bg-slate-100"
              onClick={() => setSidebarOpen(true)}
            >
              <Menu className="h-5 w-5" />
            </button>

            {/* Quick Search */}
            <div className="relative hidden sm:block w-72 md:w-96">
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-slate-400" />
              <input
                type="text"
                placeholder="Search patient MRN, doctor, test, invoice..."
                className="w-full pl-9 pr-4 py-2 bg-slate-100 border border-slate-200 rounded-xl text-xs focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500"
              />
            </div>
          </div>

          <div className="flex items-center gap-3">
            {/* Live System Status Pill */}
            <div className="hidden md:flex items-center gap-2 px-3 py-1 bg-emerald-50 text-emerald-700 border border-emerald-200 rounded-full text-[11px] font-semibold">
              <span className="h-2 w-2 rounded-full bg-emerald-500 animate-pulse"></span>
              <span>All Systems Operational</span>
            </div>

            {/* Notifications */}
            <button className="relative p-2 text-slate-600 hover:bg-slate-100 rounded-xl transition-colors">
              <Bell className="h-5 w-5" />
              <span className="absolute top-1.5 right-1.5 h-2 w-2 rounded-full bg-rose-500"></span>
            </button>

            {/* User Avatar Menu */}
            <div className="relative">
              <button
                onClick={() => setUserMenuOpen(!userMenuOpen)}
                className="flex items-center gap-2 pl-2 pr-3 py-1.5 rounded-xl hover:bg-slate-100 transition-colors"
              >
                <div className="h-8 w-8 rounded-full bg-gradient-to-tr from-sky-600 to-indigo-600 text-white text-xs font-semibold flex items-center justify-center shadow-sm">
                  {user?.firstName?.[0]}
                </div>
                <div className="text-left hidden md:block">
                  <p className="text-xs font-semibold text-slate-800 leading-tight">
                    {user?.firstName} {user?.lastName}
                  </p>
                  <p className="text-[10px] text-slate-500">{user?.username}</p>
                </div>
                <ChevronDown className="h-3.5 w-3.5 text-slate-400" />
              </button>

              {userMenuOpen && (
                <div className="absolute right-0 mt-2 w-56 bg-white border border-slate-200 rounded-2xl shadow-xl py-2 z-50">
                  <div className="px-4 py-2 border-b border-slate-100">
                    <p className="text-xs font-bold text-slate-800">
                      {user?.firstName} {user?.lastName}
                    </p>
                    <p className="text-[11px] text-slate-500 truncate">{user?.email}</p>
                  </div>
                  <NavLink
                    to="/settings"
                    onClick={() => setUserMenuOpen(false)}
                    className="flex items-center gap-2 px-4 py-2 text-xs text-slate-700 hover:bg-slate-50"
                  >
                    <Settings className="h-4 w-4 text-slate-400" />
                    System Settings
                  </NavLink>
                  <button
                    onClick={() => {
                      setUserMenuOpen(false);
                      logout();
                      navigate('/login');
                    }}
                    className="w-full flex items-center gap-2 px-4 py-2 text-xs text-rose-600 hover:bg-rose-50 text-left"
                  >
                    <LogOut className="h-4 w-4 text-rose-500" />
                    Sign Out
                  </button>
                </div>
              )}
            </div>
          </div>
        </header>

        {/* Dynamic Page Router Body */}
        <main className="flex-1 p-4 lg:p-8 overflow-y-auto">
          <Outlet />
        </main>
      </div>
    </div>
  );
};
