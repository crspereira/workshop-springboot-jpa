package com.claytonpereira.springproject01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claytonpereira.springproject01.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
