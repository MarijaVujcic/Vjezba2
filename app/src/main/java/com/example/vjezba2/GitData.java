package com.example.vjezba2;

public class GitData {
    public Integer avatar;
    public String nameOfOwner;
    public String nameOfRepository;
    public Integer starsOfRepository;

    public GitData(String name, String repository, Integer stars, Integer avatar)
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

    public Integer getStarsOfRepository()
    {
        return starsOfRepository;
    }

    public void setStarsOfRepository(Integer starsOfRepository)
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
