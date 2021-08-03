package com.cygnus.bookface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BookService implements IBookService{
    @Autowired
    private BookFaceRepository bfr;
    @Override
    public List<BookFaceClass> findByNameShelf(String userdisplayname, String shelf) {
        // TODO Auto-generated method stub
        List<BookFaceClass> books= bfr.findByUserdisplayname(userdisplayname);
        List<BookFaceClass> books2= bfr.findByShelf(shelf);
        List<BookFaceClass> result= new ArrayList<BookFaceClass>();
        for(BookFaceClass b:books){
            for(BookFaceClass a:books2){
                if(b.equals(a)){
                    if(!result.contains(b)){
                        result.add(b);
                    }
                }
            }
        }
        return result;
    }
}
