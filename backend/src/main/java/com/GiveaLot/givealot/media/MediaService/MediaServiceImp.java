package com.GiveaLot.givealot.media.MediaService;

import com.GiveaLot.givealot.Organisation.model.OrganisationData;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class MediaServiceImp implements MediaService{
    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    organisationPointsRepository organisationPointsRepository;

    @Autowired
    OrganisationDataRepository organisationDataRepository;

    @Autowired
    OrganisationGalleryRepository organisationGalleryRepository;

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

    @Override
    public byte[] getOrganisationQrCode(Long orgId) throws Exception
    {
        if(orgId == null)
        {
            throw new Exception("provided ID is null");
        }
        else if(!this.orgIdExists(orgId))
        {
            throw new Exception("Organisation is does not exist");
        }
        else if(!organisationPointsRepository.existsById(orgId))
        {
            throw new Exception("Fatal: info does not exist");
        }
        else if(!organisationPointsRepository.selectOrganisationPoints(orgId).isQrCodeIsValid())
        {
            throw new Exception("QR code not validated");
        }
        return organisationDataRepository.selectOrganisationDataById(orgId).getQrCode();
    }


    @Override
    public byte[] getOrganisationQrCodeAdmin(Long orgId) throws Exception
    {
        if(orgId == null)
        {
            throw new Exception("provided ID is null");
        }
        else if(!this.orgIdExists(orgId))
        {
            throw new Exception("Organisation is does not exist");
        }
        else if(!organisationPointsRepository.existsById(orgId))
        {
            throw new Exception("Fatal: info does not exist");
        }
        return organisationDataRepository.selectOrganisationDataById(orgId).getQrCode();
    }

    @Override
    public byte[] getOrganisationCertificateAsPDF(Long orgId) throws Exception {

        if(orgId == null)
        {
            throw new Exception("provided ID is null");
        }
        else if(!this.orgIdExists(orgId))
        {
            throw new Exception("Organisation is does not exist");
        }

        return organisationDataRepository.selectOrganisationDataById(orgId).getCertificateImage();
    }

    @Override
    public byte[] getGalleryImages(Long orgId, Long imageId) throws Exception {
        if(orgId == null)
        {
            throw new Exception("provided ID is null");
        }
        else if(!this.orgIdExists(orgId))
        {
            throw new Exception("Organisation is does not exist");
        }
        else if(imageId == null)
        {
            throw new Exception("Image name not provided");
        }

        byte[] image = organisationGalleryRepository.getOrganisationGalleryImages(orgId,"image"+imageId);

        if(image == null)
            throw new Exception("image not found");

        return image;
    }

    @Override
    public byte[] getOrganisationCertificateAsPNG(Long orgId) throws Exception {
        if(orgId == null)
        {
            throw new Exception("provided ID is null");
        }
        else if(!this.orgIdExists(orgId))
        {
            throw new Exception("Organisation is does not exist");
        }

        byte [] image = organisationDataRepository.selectOrganisationDataById(orgId).getCertificateImage();
        return image;
    }
}
