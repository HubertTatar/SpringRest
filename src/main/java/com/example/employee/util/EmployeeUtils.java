package com.example.employee.util;

import com.example.employee.model.Employee;

import java.util.function.BiFunction;

/**
 * Created by huta on 27.05.16.
 */
public class EmployeeUtils {

    public static BiFunction<Employee, Employee, Employee> copyFields = (ori, upd) -> {
        ori.setComm(upd.getComm());
        ori.setDepartmentNo(upd.getDepartmentNo());
        ori.setHireDate(upd.getHireDate());
        ori.setJob(upd.getJob());
        ori.setMgr(upd.getMgr());
        ori.setWorkCity(upd.getWorkCity());
        ori.setWorkCountry(upd.getWorkCountry());
        ori.setName(upd.getName());
        return ori;
    };

}
