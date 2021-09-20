package com.GiveaLot.givealot.media.MediaService;

import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

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


    @Override
    public String getOrganisationStatus(Long orgId) throws Exception
    {
        if(this.orgIdExists(orgId))
        {
           return organisationRepository.selectOrganisationById(orgId).getStatus().toLowerCase().trim();
        }
        return null;
    }
}
