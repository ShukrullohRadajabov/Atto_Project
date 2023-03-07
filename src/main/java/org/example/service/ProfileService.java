package org.example.service;

import org.example.container.ComponentContainer;
import org.example.dto.Profile;
import org.example.enums.GeneralStatus;
import org.example.repository.ProfileRepository;

import java.util.List;

public class ProfileService {

    private ProfileRepository profileRepository = new ProfileRepository();
    private CardService cardService = ComponentContainer.cardService;

    public void profileList() {
        List<Profile> profileList = profileRepository.getProfileList();

        for (Profile profile : profileList) {
            System.out.println(profile);
        }
    }

    public void changeProfileStatus(String phone) {
        Profile profile = profileRepository.getProfileByPhone(phone);
        if (profile == null) {
            System.out.println("Profile not found");
            return;
        }

        if (profile.getStatus().equals(GeneralStatus.ACTIVE)) {
            profileRepository.changeProfileStatus(phone, GeneralStatus.BLOCK);
        } else {
            profileRepository.changeProfileStatus(phone, GeneralStatus.ACTIVE);
        }
    }

}
