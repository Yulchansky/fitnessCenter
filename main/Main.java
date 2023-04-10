package com.fitness.controller.main;

import com.fitness.model.Users;
import com.fitness.repo.StaticsRepo;
import com.fitness.repo.SubsRepo;
import com.fitness.repo.TrainersRepo;
import com.fitness.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.SimpleDateFormat;

public class Main {
    @Autowired
    protected StaticsRepo staticsRepo;
    @Autowired
    protected SubsRepo subsRepo;
    @Autowired
    protected TrainersRepo trainersRepo;
    @Autowired
    protected UsersRepo usersRepo;
    @Value("${upload.img}")
    protected String uploadImg;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    protected String defaultAvatar = "def.jpeg";

    protected Users getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return usersRepo.findByUsername(userDetail.getUsername());
        }
        return null;
    }

    protected String getRole() {
        Users users = getUser();
        if (users == null) return "NOT";
        return users.getRole().toString();
    }
}