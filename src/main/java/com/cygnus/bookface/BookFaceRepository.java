package com.cygnus.bookface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookFaceRepository extends JpaRepository<BookFaceClass, Long>{
    // List<BookFaceClass> findByNameShelf(String userdisplayname, String shelf);
    List<BookFaceClass> findByUserdisplayname(String userdisplayname);
    List<BookFaceClass> findByShelf(String shelf);
}

