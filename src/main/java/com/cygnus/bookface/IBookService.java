package com.cygnus.bookface;

import java.util.List;

public interface IBookService {
    List<BookFaceClass> findByNameShelf(String userdisplayname, String shelf);
    
}
