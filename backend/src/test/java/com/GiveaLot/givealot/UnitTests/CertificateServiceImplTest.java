package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.service.BlockchainService;
import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Certificate.service.CertificateServiceImpl;
import com.GiveaLot.givealot.Notification.service.SendMailService;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Server.ServerAccess;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CertificateServiceImpl.class, ServerAccess.class})
@ExtendWith(SpringExtension.class)
public class CertificateServiceImplTest {
    @MockBean
    private BlockChainRepository blockChainRepository;

    @MockBean
    private BlockchainService blockchainService;

    @MockBean
    private CertificateRepository certificateRepository;

    @Autowired
    private CertificateServiceImpl certificateServiceImpl;

    @MockBean
    private OrganisationInfoRepository organisationInfoRepository;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private SendMailService sendMailService;

    @Test
    public void testCheckRenewal() throws Exception {
        when(this.certificateRepository.findAll()).thenReturn(new ArrayList<Certificate>());
        assertTrue(this.certificateServiceImpl.checkRenewal());
        verify(this.certificateRepository).findAll();
    }

    @Test
    public void testCheckRenewalComplete() throws Exception {
        Certificate certificate = new Certificate();
        certificate.setDateCreated("2020-03-01");
        certificate.setAdminRenewal(true);
        certificate.setPoints(0);
        certificate.setOrgId(0L);
        certificate.setDateExpiry("2020-03-01");
        certificate.setOrgRenewal(true);

        ArrayList<Certificate> certificateList = new ArrayList<Certificate>();
        certificateList.add(certificate);
        when(this.certificateRepository.updateAdminRenewal((Long) any(), anyBoolean())).thenReturn(1);
        when(this.certificateRepository.updateOrgRenewal((Long) any(), anyBoolean())).thenReturn(1);
        when(this.certificateRepository.findAll()).thenReturn(certificateList);
        assertTrue(this.certificateServiceImpl.checkRenewal());
        verify(this.certificateRepository).findAll();
        verify(this.certificateRepository).updateAdminRenewal((Long) any(), anyBoolean());
        verify(this.certificateRepository).updateOrgRenewal((Long) any(), anyBoolean());
    }

    @Test
    public void testCertificateExpiredEmail() throws Exception {
        doNothing().when(this.sendMailService).sendMail((com.GiveaLot.givealot.Notification.dataclass.Mail) any());
        assertTrue(this.certificateServiceImpl.CertificateExpiredEmail("Org Name", "jane.doe@example.org"));
        verify(this.sendMailService).sendMail((com.GiveaLot.givealot.Notification.dataclass.Mail) any());
    }

    @Test
    public void testOrganisationRenewal() throws Exception {
        when(this.certificateRepository.updateOrgRenewal((Long) any(), anyBoolean())).thenReturn(1);
        assertTrue(this.certificateServiceImpl.organisationRenewal(123L));
        verify(this.certificateRepository).updateOrgRenewal((Long) any(), anyBoolean());
    }

    @Test
    public void testAdminRenewal() throws Exception {
        when(this.certificateRepository.updateAdminRenewal((Long) any(), anyBoolean())).thenReturn(1);
        assertTrue(this.certificateServiceImpl.adminRenewal(123L));
        verify(this.certificateRepository).updateAdminRenewal((Long) any(), anyBoolean());
    }
}

