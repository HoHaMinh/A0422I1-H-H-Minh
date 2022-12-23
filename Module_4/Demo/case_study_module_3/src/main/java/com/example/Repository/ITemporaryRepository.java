package com.example.Repository;

import com.example.Model.Temporary;

import java.util.List;

public interface ITemporaryRepository {
    List<Temporary> showAll ();

    List<Temporary> search (String searchName, String searchService);
}
