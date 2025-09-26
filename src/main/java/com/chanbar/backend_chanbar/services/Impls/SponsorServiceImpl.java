package com.chanbar.backend_chanbar.services.Impls;

import com.chanbar.backend_chanbar.DTOs.SponsorDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.models.Sponsor;
import com.chanbar.backend_chanbar.models.Vacancy;
import com.chanbar.backend_chanbar.repositories.SponsorRepository;
import com.chanbar.backend_chanbar.services.ISponsorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SponsorServiceImpl implements ISponsorService {
    private final SponsorRepository sponsorRepository;

    @Override
    public SponsorDTO createSponsor(SponsorDTO sponsorDTO) {
        Sponsor sponsor = new Sponsor();
        sponsor.setSponsorName(sponsorDTO.getSponsorName());
        sponsor.setImgSponsor(sponsorDTO.getImgSponsor());

        sponsorRepository.save(sponsor);

        SponsorDTO sponsorDTO1 = new SponsorDTO();
        sponsorDTO1.setSponsorName(sponsor.getSponsorName()); // ✅ sponsor-dan oxu
        sponsorDTO1.setImgSponsor(sponsor.getImgSponsor());   // ✅ sponsor-dan oxu
        return sponsorDTO1;
    }

    @Override
    public List<SponsorDTO> getAllSponsor() {
        List<Sponsor> sponsorList = sponsorRepository.findAll();
        List<SponsorDTO> sponsorDTOList = new ArrayList<>();

        for (Sponsor sponsor : sponsorList){
            SponsorDTO sponsorDTO = new SponsorDTO();
            sponsorDTO.setSponsorName(sponsor.getSponsorName());
            sponsorDTO.setImgSponsor(sponsor.getImgSponsor());
            sponsorDTOList.add(sponsorDTO);
        }
        return sponsorDTOList;
    }

    @Override
    public void deleteSponsor(Long id) {
        Optional<Sponsor> sponsor = sponsorRepository.findById(id);
        if (sponsor.isPresent()) {
            sponsorRepository.deleteById(id);
        }
    }
}
