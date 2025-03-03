package com.example.EmployeePayrollApp.exception;

import com.example.EmployeePayrollApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(EmployeeNotFoundException e){
        ResponseDTO responseDTO = new ResponseDTO("not valid exception" , e.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMesg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).toList();
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST request" , errMesg);
        return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.BAD_REQUEST);
    }
}