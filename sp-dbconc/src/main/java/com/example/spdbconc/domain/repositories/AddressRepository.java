
package com.example.spdbconc.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spdbconc.domain.entities.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
