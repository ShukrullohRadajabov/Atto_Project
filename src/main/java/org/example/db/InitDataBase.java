package org.example.db;

import org.example.container.ComponentContainer;
import org.example.dto.Card;
import org.example.dto.Profile;
import org.example.enums.GeneralStatus;
import org.example.enums.ProfileRole;
import org.example.repository.CardRepository;
import org.example.repository.ProfileRepository;
import org.example.util.MD5Util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InitDataBase {

    public static void adminInit() {

        Profile profile = new Profile();
        profile.setName("Admin");
        profile.setSurname("Adminjon");
        profile.setPhone("123");
        profile.setPassword(MD5Util.encode("123"));
        profile.setCreatedDate(LocalDateTime.now());
        profile.setStatus(GeneralStatus.ACTIVE);
        profile.setRole(ProfileRole.ADMIN);


        ProfileRepository profileRepository = ComponentContainer.profileRepository;

        Profile profile1 = profileRepository.getProfileByPhone(profile.getPhone());
        if (profile1 != null) {
            return;
        }
        profileRepository.saveProfile(profile);
    }

    public static void addCompanyCard() {
        Card card = new Card();
        card.setCardNumber("5555");
        card.setExpDate(LocalDate.of(2025, 12, 01));

        card.setPhone("123");
        card.setBalance(0d);
        card.setCreatedDate(LocalDateTime.now());
        card.setStatus(GeneralStatus.ACTIVE);

        CardRepository cardRepository = ComponentContainer.cardRepository;
        Card exists = cardRepository.getCardByNumber(card.getCardNumber());

        if (exists != null) {
            return;
        }
        cardRepository.save(card);
    }
}
