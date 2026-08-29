import axios, { AxiosError, InternalAxiosRequestConfig } from 'axios';
import { ApiResponse, AuthResponse } from '../types';

const API_BASE_URL = import.meta.env.VITE_API_URL || '/api/v1';

export const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
  timeout: 15000,
});

// Request Interceptor: Attach JWT Access Token
apiClient.interceptors.request.use(
  (config: InternalAxiosRequestConfig) => {
    const token = localStorage.getItem('hms_access_token');
    if (token && config.headers) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// Response Interceptor: Handle 401 Unauthorized with Refresh Token rotation
apiClient.interceptors.response.use(
  (response) => response,
  async (error: AxiosError) => {
    const originalRequest = error.config as InternalAxiosRequestConfig & { _retry?: boolean };

    if (error.response?.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;
      const refreshToken = localStorage.getItem('hms_refresh_token');

      if (refreshToken) {
        try {
          const res = await axios.post<ApiResponse<AuthResponse>>(`${API_BASE_URL}/auth/refresh`, {
            refreshToken,
          });

          if (res.data.success && res.data.data) {
            localStorage.setItem('hms_access_token', res.data.data.accessToken);
            localStorage.setItem('hms_refresh_token', res.data.data.refreshToken);

            if (originalRequest.headers) {
              originalRequest.headers.Authorization = `Bearer ${res.data.data.accessToken}`;
            }
            return apiClient(originalRequest);
          }
        } catch (refreshErr) {
          // Token refresh failed -> Log out
          localStorage.removeItem('hms_access_token');
          localStorage.removeItem('hms_refresh_token');
          localStorage.removeItem('hms_user');
          window.location.href = '/login';
        }
      } else {
        localStorage.removeItem('hms_access_token');
        localStorage.removeItem('hms_refresh_token');
        localStorage.removeItem('hms_user');
        window.location.href = '/login';
      }
    }

    return Promise.reject(error);
  }
);
