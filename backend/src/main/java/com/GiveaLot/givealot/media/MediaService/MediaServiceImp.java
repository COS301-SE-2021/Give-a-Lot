package com.GiveaLot.givealot.media.MediaService;

import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaServiceImp implements MediaService{
    @Autowired
    OrganisationRepository organisationRepository;

    @Override
    public boolean orgIdExists(Long orgId)
    {
        if(orgId == null)
            return false;
        else
        {
            try{
                return organisationRepository.existsById(orgId);
            }
            catch (Exception e)
            {
                return false;
            }
        }
    }
}
