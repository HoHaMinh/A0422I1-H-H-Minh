package com.example.Service;

import com.example.Model.Temporary;

import java.util.List;

public interface ITemporaryService {
    List<Temporary> showAll ();

    List<Temporary> search (String searchName, String searchService);
}
