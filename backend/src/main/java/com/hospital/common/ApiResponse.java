package com.hospital.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    @Builder.Default
    private boolean success = true;

    @Builder.Default
    private Instant timestamp = Instant.now();

    @Builder.Default
    private String requestId = UUID.randomUUID().toString();

    private String message;

    private T data;

    private PagedResponse.PaginationMeta pagination;

    public static <T> ApiResponse<T> ok(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> ok(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> ApiResponse<T> paged(T data, PagedResponse.PaginationMeta meta) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .pagination(meta)
                .build();
    }
}
