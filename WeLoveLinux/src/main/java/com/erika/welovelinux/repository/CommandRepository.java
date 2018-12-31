package com.erika.welovelinux.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erika.welovelinux.model.Command;

public interface CommandRepository extends JpaRepository<Command, Long>{

}
