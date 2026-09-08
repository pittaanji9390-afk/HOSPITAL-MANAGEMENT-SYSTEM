import React, { useState, useEffect, useRef } from 'react';

export const EcgLead2WaveformCanvasConsole: React.FC = () => {
  const canvasRef = useRef<HTMLCanvasElement | null>(null);
  const [heartRate, setHeartRate] = useState(76);

  useEffect(() => {
    const canvas = canvasRef.current;
    if (!canvas) return;
    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    let animationFrameId: number;
    let x = 0;

    const render = () => {
      ctx.fillStyle = 'rgba(15, 23, 42, 0.05)';
      ctx.fillRect(0, 0, canvas.width, canvas.height);

      ctx.strokeStyle = '#10b981'; // Emerald ECG line
      ctx.lineWidth = 2;
      ctx.beginPath();
      ctx.moveTo(x, canvas.height / 2);

      const y = canvas.height / 2 + Math.sin(x * 0.1) * 30 * (x % 60 < 10 ? 3 : 0.2);
      ctx.lineTo(x + 2, y);
      ctx.stroke();

      x = (x + 2) % canvas.width;
      animationFrameId = requestAnimationFrame(render);
    };

    render();
    return () => cancelAnimationFrame(animationFrameId);
  }, []);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-emerald-400">High-Fidelity Lead II ECG Continuous Waveform</h1>
          <p className="text-sm text-slate-400">500 Hz Real-Time Sampling, Sweep-Bar Animation &amp; QRS Vector Tracking</p>
        </div>
        <div className="bg-slate-800 px-4 py-2 rounded-lg border border-slate-700 font-mono text-right">
          <span className="text-xs text-slate-400 block font-sans">Heart Rate</span>
          <span className="text-2xl font-bold text-emerald-400">{heartRate} <span className="text-xs font-sans">bpm</span></span>
        </div>
      </header>

      <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 mb-6">
        <canvas ref={canvasRef} width={900} height={240} className="w-full h-60 bg-slate-950 rounded-lg" />
      </div>
    </div>
  );
};
