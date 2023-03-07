package org.example.service;

import org.example.container.ComponentContainer;
import org.example.dto.Terminal;
import org.example.enums.GeneralStatus;
import org.example.repository.TerminalRepository;

import java.time.LocalDateTime;
import java.util.List;

public class TerminalService {


    public void addTerminal(Terminal terminal) {
        TerminalRepository terminalRepository = ComponentContainer.terminalRepository;
        Terminal exist = terminalRepository.getTerminalByCode(terminal.getCode());
        if (exist != null) {
            System.out.println("Terminal code exists");
            return;
        }
        terminal.setCreatedDate(LocalDateTime.now());
        terminal.setStatus(GeneralStatus.ACTIVE);
        terminalRepository.save(terminal);
    }

    public void terminalList() {
        TerminalRepository terminalRepository = ComponentContainer.terminalRepository;
        List<Terminal> terminalList = terminalRepository.getTerminalList();
        for (Terminal terminal : terminalList) {
            System.out.println(terminal);
        }

    }

    public void updateTerminal(Terminal terminal) {
        TerminalRepository terminalRepository = ComponentContainer.terminalRepository;
        Terminal exist = terminalRepository.getTerminalByCode(terminal.getCode());
        if (exist == null) {
            System.out.println("Terminal not found");
            return;
        }

        terminalRepository.updateTerminal(terminal);
    }

    public void changeTerminalStatus(String code) {
        TerminalRepository terminalRepository = ComponentContainer.terminalRepository;
        Terminal terminal = terminalRepository.getTerminalByCode(code);
        if (terminal == null) {
            System.out.println("Terminal not found");
            return;
        }
        if (terminal.getStatus().equals(GeneralStatus.ACTIVE)) {
            terminalRepository.changeTerminalStatus(code, GeneralStatus.BLOCK);
        } else {
            terminalRepository.changeTerminalStatus(code, GeneralStatus.BLOCK);
        }

    }

    public void deleteTerminal(String code) {
        TerminalRepository terminalRepository = ComponentContainer.terminalRepository;
        Terminal terminal = terminalRepository.getTerminalByCode(code);
        if (terminal == null) {
            System.out.println("Terminal not found");
            return;
        }

        terminalRepository.deleteTerminal(code);
    }
}
