package com.masterpiece.rentService.controller;

import com.masterpiece.rentService.controller.rent.RentRestController;
import com.masterpiece.rentService.model.RentData;
import com.masterpiece.rentService.repository.LotRepository;
import com.masterpiece.rentService.repository.RentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class RentRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RentRestController controller;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private LotRepository lotRepository;

    @Test
    public void createRent() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime start = LocalDateTime.parse("2022-09-02T07:00:00.000Z", formatter);
        LocalDateTime end = LocalDateTime.parse("2022-09-04T07:00:00.000Z", formatter);
        RentData data = new RentData(start, end, 100003);

        ErrorsSpringExtendingClass errorsSpringExtendingClass = new ErrorsSpringExtendingClass();
        ResponseEntity<?> rentResponse = controller.rentLot(data, errorsSpringExtendingClass);
        assertThat(rentResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    public static class ErrorsSpringExtendingClass implements Errors {

        private final List<?> EMPTY_LIST = Collections.EMPTY_LIST;

        @Override
        public String getObjectName() {
            return null;
        }

        @Override
        public void setNestedPath(String nestedPath) {

        }

        @Override
        public String getNestedPath() {
            return null;
        }

        @Override
        public void pushNestedPath(String subPath) {

        }

        @Override
        public void popNestedPath() throws IllegalStateException {

        }

        @Override
        public void reject(String errorCode) {

        }

        @Override
        public void reject(String errorCode, String defaultMessage) {

        }

        @Override
        public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {

        }

        @Override
        public void rejectValue(String field, String errorCode) {

        }

        @Override
        public void rejectValue(String field, String errorCode, String defaultMessage) {

        }

        @Override
        public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {

        }

        @Override
        public void addAllErrors(Errors errors) {

        }

        @Override
        public boolean hasErrors() {
            return false;
        }

        @Override
        public int getErrorCount() {
            return 0;
        }

        @Override
        public List<ObjectError> getAllErrors() {
            return null;
        }

        @Override
        public boolean hasGlobalErrors() {
            return false;
        }

        @Override
        public int getGlobalErrorCount() {
            return 0;
        }

        @Override
        public List<ObjectError> getGlobalErrors() {
            return null;
        }

        @Override
        public ObjectError getGlobalError() {
            return null;
        }

        @Override
        public boolean hasFieldErrors() {
            return false;
        }

        @Override
        public int getFieldErrorCount() {
            return 0;
        }

        @Override
        public List<FieldError> getFieldErrors() {
            return null;
        }

        @Override
        public FieldError getFieldError() {
            return null;
        }

        @Override
        public boolean hasFieldErrors(String field) {
            return false;
        }

        @Override
        public int getFieldErrorCount(String field) {
            return 0;
        }

        @Override
        public List<FieldError> getFieldErrors(String field) {
            return null;
        }

        @Override
        public FieldError getFieldError(String field) {
            return null;
        }

        @Override
        public Object getFieldValue(String field) {
            return null;
        }

        @Override
        public Class<?> getFieldType(String field) {
            return null;
        }
    }

}
