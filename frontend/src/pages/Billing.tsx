import React, { useState, useEffect } from 'react';
import {
  Receipt,
  Search,
  Plus,
  CreditCard,
  CheckCircle2,
  AlertCircle,
  FileText,
  DollarSign,
  X,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { Invoice, Payment, PagedResponse, ApiResponse } from '../types';

export const Billing: React.FC = () => {
  const [invoices, setInvoices] = useState<Invoice[]>([
    {
      id: 1,
      invoiceNo: 'INV-10001',
      patientId: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      subtotal: 1200.0,
      discountAmount: 0.0,
      taxAmount: 0.0,
      totalAmount: 1200.0,
      paidAmount: 1200.0,
      balanceAmount: 0.0,
      status: 'PAID',
      dueDate: '2026-09-05',
      createdAt: '2026-08-28T10:30:00Z',
      items: [
        {
          id: 1,
          itemType: 'SERVICE',
          description: 'Consultation - Senior Cardiologist (Dr. Rajesh Sharma)',
          quantity: 1,
          unitPrice: 1200.0,
          discountAmount: 0.0,
          taxAmount: 0.0,
          totalPrice: 1200.0,
        },
      ],
    },
    {
      id: 2,
      invoiceNo: 'INV-10002',
      patientId: 2,
      patientName: 'Deepa Rao',
      patientMrn: 'MRN-10002',
      subtotal: 2500.0,
      discountAmount: 0.0,
      taxAmount: 125.0,
      totalAmount: 2625.0,
      paidAmount: 0.0,
      balanceAmount: 2625.0,
      status: 'ISSUED',
      dueDate: '2026-09-05',
      createdAt: '2026-08-29T09:00:00Z',
      items: [
        {
          id: 2,
          itemType: 'SERVICE',
          description: 'Consultation - Lead Orthopedic Surgeon (Dr. Priya Nair)',
          quantity: 1,
          unitPrice: 1000.0,
          discountAmount: 0.0,
          taxAmount: 0.0,
          totalPrice: 1000.0,
        },
        {
          id: 3,
          itemType: 'LAB',
          description: 'Pre-operative Diagnostic Panel (CBC, KFT, LFT)',
          quantity: 1,
          unitPrice: 1500.0,
          discountAmount: 0.0,
          taxAmount: 125.0,
          totalPrice: 1625.0,
        },
      ],
    },
  ]);

  const [isPaymentModalOpen, setIsPaymentModalOpen] = useState(false);
  const [selectedInvoice, setSelectedInvoice] = useState<Invoice | null>(null);
  const [paymentAmount, setPaymentAmount] = useState<string>('');
  const [paymentMethod, setPaymentMethod] = useState<Payment['paymentMethod']>('CREDIT_CARD');
  const [transactionRef, setTransactionRef] = useState<string>('');

  useEffect(() => {
    apiClient
      .get<ApiResponse<PagedResponse<Invoice>>>('/billing/invoices')
      .then((res) => {
        if (res.data?.success && res.data?.data?.content) {
          setInvoices(res.data.data.content);
        }
      })
      .catch(() => {});
  }, []);

  const openPayment = (inv: Invoice) => {
    setSelectedInvoice(inv);
    setPaymentAmount(inv.balanceAmount.toString());
    setIsPaymentModalOpen(true);
  };

  const handleCollectPayment = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!selectedInvoice) return;

    const idempotencyKey = `pay-${selectedInvoice.id}-${Date.now()}`;
    const payload = {
      invoiceId: selectedInvoice.id,
      amount: parseFloat(paymentAmount),
      paymentMethod,
      transactionRef: transactionRef || `TXN-${Math.floor(Math.random() * 1000000)}`,
      idempotencyKey,
    };

    try {
      await apiClient.post('/payments', payload);
    } catch (err) {}

    // Update local balance state
    const amt = parseFloat(paymentAmount);
    setInvoices(
      invoices.map((inv) => {
        if (inv.id === selectedInvoice.id) {
          const newPaid = inv.paidAmount + amt;
          const newBalance = inv.totalAmount - newPaid;
          return {
            ...inv,
            paidAmount: newPaid,
            balanceAmount: newBalance,
            status: newBalance === 0 ? 'PAID' : 'PARTIALLY_PAID',
          };
        }
        return inv;
      })
    );
    setIsPaymentModalOpen(false);
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Receipt className="h-6 w-6 text-sky-600" />
            Billing, Invoices & Financial Ledger
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Service charge master, price lists, double-entry ledger, and multi-tender payments
          </p>
        </div>
      </div>

      {/* Invoices List */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Invoice No</th>
                <th className="py-3.5 px-4">Patient (MRN)</th>
                <th className="py-3.5 px-4">Total Amount</th>
                <th className="py-3.5 px-4">Paid Amount</th>
                <th className="py-3.5 px-4">Remaining Balance</th>
                <th className="py-3.5 px-4">Due Date</th>
                <th className="py-3.5 px-4">Status</th>
                <th className="py-3.5 px-4 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {invoices.map((inv) => {
                const statusBadge =
                  inv.status === 'PAID'
                    ? 'bg-emerald-100 text-emerald-800'
                    : inv.status === 'PARTIALLY_PAID'
                    ? 'bg-amber-100 text-amber-800'
                    : 'bg-sky-100 text-sky-800';

                return (
                  <tr key={inv.id} className="hover:bg-slate-50/80 transition-colors">
                    <td className="py-3.5 px-4 font-mono font-bold text-sky-700">{inv.invoiceNo}</td>
                    <td className="py-3.5 px-4">
                      <p className="font-semibold text-slate-900">{inv.patientName}</p>
                      <span className="text-[10px] text-slate-400 font-mono">{inv.patientMrn}</span>
                    </td>
                    <td className="py-3.5 px-4 font-bold text-slate-900">₹{inv.totalAmount.toLocaleString()}</td>
                    <td className="py-3.5 px-4 font-medium text-emerald-600">₹{inv.paidAmount.toLocaleString()}</td>
                    <td className="py-3.5 px-4 font-bold text-rose-600">
                      ₹{inv.balanceAmount.toLocaleString()}
                    </td>
                    <td className="py-3.5 px-4 text-slate-600">{inv.dueDate}</td>
                    <td className="py-3.5 px-4">
                      <span className={`px-2.5 py-1 rounded-full text-[10px] font-bold ${statusBadge}`}>
                        {inv.status}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-right">
                      {inv.balanceAmount > 0 && (
                        <button
                          onClick={() => openPayment(inv)}
                          className="px-3 py-1.5 bg-emerald-600 hover:bg-emerald-500 text-white rounded-xl text-xs font-semibold shadow-sm transition-colors inline-flex items-center gap-1"
                        >
                          <CreditCard className="h-3.5 w-3.5" />
                          Collect Payment
                        </button>
                      )}
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>

      {/* Collect Payment Modal */}
      {isPaymentModalOpen && selectedInvoice && (
        <div className="fixed inset-0 bg-slate-950/60 z-50 flex items-center justify-center p-4">
          <div className="bg-white w-full max-w-md rounded-3xl shadow-2xl border border-slate-200 overflow-hidden">
            <div className="px-6 py-4 bg-slate-900 text-white flex items-center justify-between">
              <div>
                <h3 className="text-base font-bold">Collect Payment</h3>
                <p className="text-xs text-sky-400">Invoice: {selectedInvoice.invoiceNo}</p>
              </div>
              <button onClick={() => setIsPaymentModalOpen(false)} className="text-slate-400 hover:text-white">
                <X className="h-5 w-5" />
              </button>
            </div>

            <form onSubmit={handleCollectPayment} className="p-6 space-y-4 text-xs">
              <div className="p-3 bg-slate-50 rounded-2xl border border-slate-100 flex justify-between">
                <span className="text-slate-500 font-semibold">Remaining Balance:</span>
                <span className="font-bold text-rose-600 text-sm">
                  ₹{selectedInvoice.balanceAmount.toLocaleString()}
                </span>
              </div>

              <div>
                <label className="font-semibold text-slate-700 block mb-1">Payment Amount (₹) *</label>
                <input
                  type="number"
                  step="0.01"
                  required
                  value={paymentAmount}
                  onChange={(e) => setPaymentAmount(e.target.value)}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none font-bold text-slate-900"
                />
              </div>

              <div>
                <label className="font-semibold text-slate-700 block mb-1">Tender / Payment Method *</label>
                <select
                  value={paymentMethod}
                  onChange={(e) => setPaymentMethod(e.target.value as any)}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                >
                  <option value="CREDIT_CARD">Credit Card (POS)</option>
                  <option value="DEBIT_CARD">Debit Card</option>
                  <option value="UPI">UPI / QR Code</option>
                  <option value="CASH">Cash</option>
                  <option value="INSURANCE">Insurance Cashless TPA</option>
                  <option value="BANK_TRANSFER">Bank Wire Transfer</option>
                </select>
              </div>

              <div>
                <label className="font-semibold text-slate-700 block mb-1">Transaction / POS Reference ID</label>
                <input
                  type="text"
                  value={transactionRef}
                  onChange={(e) => setTransactionRef(e.target.value)}
                  placeholder="e.g. POS-AUTH-94819"
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>

              <div className="pt-4 flex items-center justify-end gap-3 border-t border-slate-100">
                <button
                  type="button"
                  onClick={() => setIsPaymentModalOpen(false)}
                  className="px-4 py-2 bg-slate-100 hover:bg-slate-200 text-slate-700 rounded-xl font-semibold"
                >
                  Cancel
                </button>
                <button
                  type="submit"
                  className="px-5 py-2 bg-emerald-600 hover:bg-emerald-500 text-white rounded-xl font-bold shadow-md shadow-emerald-500/20"
                >
                  Record & Issue Receipt
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};
