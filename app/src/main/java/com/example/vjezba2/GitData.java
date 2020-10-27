package com.example.vjezba2;

import android.media.Image;

public class GitData {
    private Image avatar;
    public String nameOfOwner;
    public String nameOfRepository;
    public String starsOfRepository;

    public GitData(String name, String repository, String stars, Image avatar)
    {
        this.nameOfOwner = name;
        this.nameOfRepository = repository;
        this.starsOfRepository = stars;
        this.avatar = avatar;
    }

    // GET AND SET

    public String getNameOfRepository()
    {
        return nameOfRepository;
    }

    public void setNameOfRepository(String nameOfRepository)
    {
        this.nameOfRepository = nameOfRepository;
    }

    public String getStarsOfRepository()
    {
        return starsOfRepository;
    }

    public void setStarsOfRepository(String starsOfRepository)
    {
        this.starsOfRepository = starsOfRepository;
    }

    public String getNameOfOwner()
    {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner)
    {
        this.nameOfOwner = nameOfOwner;
    }
}
