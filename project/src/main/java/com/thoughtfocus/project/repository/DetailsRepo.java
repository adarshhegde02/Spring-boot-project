package com.thoughtfocus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thoughtfocus.project.entity.DetailsEntity;
@Repository
public interface DetailsRepo extends JpaRepository<DetailsEntity, Integer> {
public DetailsEntity getByEmail(String email);

public DetailsEntity getByName(String name);

public DetailsEntity getByContact(long contact);

public DetailsEntity getByEmailAndPassword(String email, String password);

}
