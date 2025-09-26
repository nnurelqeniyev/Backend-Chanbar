package com.chanbar.backend_chanbar.services;

import com.chanbar.backend_chanbar.DTOs.SponsorDTO;

import java.util.List;

public interface ISponsorService {
    SponsorDTO createSponsor(SponsorDTO sponsorDTO);

    List<SponsorDTO> getAllSponsor();

    void deleteSponsor(Long id);
}
