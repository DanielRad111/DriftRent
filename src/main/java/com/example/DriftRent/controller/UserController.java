package com.example.DriftRent.controller;

import com.example.DriftRent.dto.AdDTO;
import com.example.DriftRent.dto.LoginRequestDTO;
import com.example.DriftRent.dto.UserDTO;
import com.example.DriftRent.model.User;
import com.example.DriftRent.service.UserService;
import com.example.DriftRent.single_point_access.ServiceSinglePointAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService = ServiceSinglePointAccess.getUserService();

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        User user = userService.findUserByEmail(email);
        if (user != null) {
            UserDTO userDTO = convertToDTO(user);
            return ResponseEntity.status(HttpStatus.OK).body(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        User savedUser = userService.save(user);
        UserDTO userDTO = convertToDTO(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }



    private UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setRating(user.getRating());
        List<AdDTO> adDTOS = user.getAds().stream()
                .map(ad -> {
                    AdDTO adDTO = new AdDTO();
                    adDTO.setTitle(ad.getTitle());
                    adDTO.setDescription(ad.getDescription());
                    adDTO.setPrice(ad.getPrice());
                    return adDTO;
                })
                .toList();
        userDTO.setAds(adDTOS);
        return userDTO;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (user != null) {
            UserDTO userDTO = convertToDTO(user);
            return ResponseEntity.status(HttpStatus.OK).body(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
