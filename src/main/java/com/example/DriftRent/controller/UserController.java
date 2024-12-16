package com.example.DriftRent.controller;

import com.example.DriftRent.dto.AdDTO;
import com.example.DriftRent.dto.LoginRequestDTO;
import com.example.DriftRent.dto.UserDTO;
import com.example.DriftRent.model.User;
import com.example.DriftRent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing users.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    /**
     * Retrieves a user by their email.
     *
     * @param email the email of the user to retrieve
     * @return the ResponseEntity containing the UserDTO if found, or a NOT_FOUND status
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        User user = this.userService.findUserByEmail(email);
        if (user != null) {
            UserDTO userDTO = convertToDTO(user);
            return ResponseEntity.status(HttpStatus.OK).body(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Creates a new user.
     *
     * @param user the User entity to create
     * @return the ResponseEntity containing the created UserDTO, or a BAD_REQUEST status if the email is invalid
     */
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        User savedUser = userService.save(user);
        UserDTO userDTO = convertToDTO(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user the User entity to convert
     * @return the converted UserDTO
     */
    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
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

    /**
     * Deletes a user.
     *
     * @param email the UserDTO of the user to delete
     * @return a ResponseEntity indicating the result of the operation
     */
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        if (email == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        User user = userService.findUserByEmail(email);
        userService.delete(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Logs in a user.
     *
     * @param loginRequest the LoginRequestDTO containing the user's email and password
     * @return the ResponseEntity containing the UserDTO if login is successful, or an UNAUTHORIZED status
     */
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

    /**
     * Updates an existing user.
     *
     * @param user the User entity with updated information
     * @return the ResponseEntity containing the updated UserDTO
     */
    @PutMapping("/update")
    public ResponseEntity<UserDTO> update(@RequestBody User user) {
        User userFromDB = userService.findUserById(user.getId());
        userFromDB.setEmail(user.getEmail());
        userFromDB.setPassword(user.getPassword());
        userFromDB.setRating(user.getRating());
        User userUpdated = userService.update(userFromDB);
        UserDTO userDTO = convertToDTO(userUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }
}