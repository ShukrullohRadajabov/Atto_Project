package org.example.container;

import org.example.dto.Profile;
import org.example.repository.CardRepository;
import org.example.repository.ProfileRepository;
import org.example.repository.TerminalRepository;
import org.example.repository.TransactionRepository;
import org.example.service.*;

import java.util.ServiceConfigurationError;

public class ComponentContainer {
    public static Profile currentProfile = null;
    public static CardRepository cardRepository = new CardRepository();
    public static ProfileRepository profileRepository = new ProfileRepository();
    public static TerminalRepository terminalRepository = new TerminalRepository();
    public static TransactionRepository transactionRepository = new TransactionRepository();

    public static CardService cardService = new CardService();

    public static ProfileService profileService = new ProfileService();

    public static AuthService authService = new AuthService();


    public static TerminalService terminalService = new TerminalService();
    public static TransactionService transactionService = new TransactionService();
}
