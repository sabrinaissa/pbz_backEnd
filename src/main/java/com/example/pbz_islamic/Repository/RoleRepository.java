package com.example.pbz_islamic.Repository;

import com.example.pbz_islamic.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,String> {
}
