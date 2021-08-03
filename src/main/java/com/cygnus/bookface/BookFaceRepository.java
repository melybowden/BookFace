package com.cygnus.bookface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFaceRepository extends JpaRepository<BookFaceClass, Long>{}