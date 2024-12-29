package com.example.DriftRent.service;

import com.example.DriftRent.dto.AdDTO;
import com.example.DriftRent.dto.UserDTO;
import com.example.DriftRent.model.User;
import com.example.DriftRent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CarService carService;

    public User findUserById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public User update(User user) {
        return this.userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    public void delete(User user) {
         this.userRepository.delete(user);
    }

    public User findUserByRating(Double rating){return this.userRepository.findUserByRating(rating);}

    public User login(String email, String password) {
        // Find the user by email
        User user = this.userRepository.findUserByEmail(email);

        // If user doesn't exist, return null
        if (user == null) {
            return null;
        }

        // Check if the provided password matches the stored password
        if (user.getPassword().equals(password)) {
            return user;
        }

        // If password doesn't match, return null
        return null;
    }

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        if(user.getRating() != null){
            userDTO.setRating(user.getRating());
        }
        if(user.getAds() != null){
            List<AdDTO> adDTOS = user.getAds().stream()
                    .map(ad -> {
                        AdDTO adDTO = new AdDTO();
                        adDTO.setId(ad.getId());
                        adDTO.setTitle(ad.getTitle());
                        adDTO.setDescription(ad.getDescription());
                        adDTO.setPrice(ad.getPrice());
                        adDTO.setCarDTO(this.carService.convertToDTO(ad.getCar()));
                        return adDTO;
                    })
                    .toList();
            userDTO.setAds(adDTOS);
        }
        return userDTO;
    }
}