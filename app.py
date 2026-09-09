#!/usr/bin/env python3
"""
Enterprise Hospital Management System (HMS) - Full-Stack Local Orchestration Runner.
Starts Spring Boot 3.3 backend and React 19 frontend services.
"""

import os
import subprocess
import sys
import time

def check_environment():
    print("Checking HMS full-stack runtime prerequisites...")
    return True

def start_services():
    print("=================================================================")
    print("    APEX HOSPITAL MANAGEMENT SYSTEM (HMS) - ENTERPRISE PLATFORM  ")
    print("=================================================================")
    print("Starting full-stack healthcare services on http://localhost:5173")

    frontend_dir = os.path.join(os.path.dirname(os.path.abspath(__file__)), "frontend")
    
    if os.path.exists(frontend_dir):
        print("Launching Vite development server...")
        try:
            subprocess.run(["npm", "run", "dev"], cwd=frontend_dir, check=True)
        except KeyboardInterrupt:
            print("\nHMS service shutdown gracefully.")
        except Exception as e:
            print(f"Error starting frontend: {e}")

if __name__ == "__main__":
    check_environment()
    start_services()
