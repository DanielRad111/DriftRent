package com.example.DriftRent.repository;

import com.example.DriftRent.model.User;

public interface UserRepository extends CRUDRepository<User, String> {

    User findUserByRating(Double rating);

}