package com.graphql.example.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.example.model.Department;
import com.graphql.example.model.DepartmentInput;
import com.graphql.example.repository.DepartmentRepository;

import graphql.GraphQLException;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository deptRepo;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Department> deptList() {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deptIdsFilter");
        Long[] ids = new Long[]{1L, 2L};
        filter.setParameterList("deptIds", ids);
        List<Department> list = deptRepo.findAll();
        session.disableFilter("deptIdsFilter");
        session.close();
        return list;
    }

    public Optional<Department> getDepartmentById(long id) {
        Optional<Department> department = deptRepo.findById(id);
        if (null != department)
            return department;
        else
            throw new GraphQLException("Dept not found");
    }

    public Department createDepartment(DepartmentInput departmentInput) {
        Department exiDept = deptRepo.getDeptByName(departmentInput.getName());
        System.out.println("exiDept: " + exiDept);
        if (null != exiDept) {
            return null;
        } else {
            Department dept = Department.builder().name(departmentInput.getName()).build();
            return deptRepo.save(dept);
        }
    }

    public String deleteDept(long deptId) {
        String s = null;
        try {
//			Department exiDept = deptRepo.findById(deptId).get();
            deptRepo.deleteById(deptId);
            s = "Department deleted successfully";
        } catch (Exception e) {
            s = "Department not found";
        }
        return s;
    }

    public Department updateDept(DepartmentInput departmentInput) {
        Department exiDept = deptRepo.findById(departmentInput.getId()).get();
        if (null != exiDept) {
            if (null != departmentInput)
                exiDept.setName(departmentInput.getName());
            deptRepo.save(exiDept);
            Department dept = deptRepo.getDepartmentByPrevVersionId(exiDept.getId());
            return dept;
        } else {
            exiDept = null;
            return exiDept;
        }
    }

    public Department getDeptByName(String name) {
        return deptRepo.getDeptByName(name);
    }

    public Map<Long, Department> getDepartmentsByIds(Set<Long> deptIds) {
        Map<Long, Department> map = deptRepo.findAllById(deptIds).stream()
                .collect(Collectors.toMap(Department::getId, item -> item));
        return map;
    }
}
