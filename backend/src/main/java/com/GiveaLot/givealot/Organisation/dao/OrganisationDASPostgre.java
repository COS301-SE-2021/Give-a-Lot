/*
package com.GiveaLot.givealot.Organisation.dao;

import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository("OrganisationDAOInterface")
public class OrganisationDASPostgre implements OrganisationDAOInterface {
    @Override
    public Organisation selectOrganisation(String orgId) {
        return null;
    }

    @Override
    public OrganisationInfo selectOrganisationInfo(String orgId) {
        return null;
    }

    @Override
    public OrganisationPoints selectOrganisationPoints(String orgId) {
        return null;
    }

    @Override
    public boolean organisationExists(Organisation organisation) {
        return false;
    }

    @Override
    public boolean addOrganisation(Organisation organisation) {
        return false;
    }

    @Override
    public boolean reactivateOrganisation(String orgId) {
        return false;
    }

    @Override
    public boolean investigateOrganisation(String orgId) {
        return false;
    }

    @Override
    public boolean suspendOrganisation(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgWebsite(String orgId, String website) {
        return false;
    }

    @Override
    public boolean removeOrgWebsite(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgAddress(String orgId, String address) {
        return false;
    }

    @Override
    public boolean removeOrgAddress(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgImage(String orgId, File image) {
        return false;
    }

    @Override
    public boolean removeOrgImage(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgAuditDoc(String orgId, File audit) {
        return false;
    }

    @Override
    public boolean removeOrgAuditDoc(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgTaxRef(String orgId, String reference) {
        return false;
    }

    @Override
    public boolean removeOrgTaxRef(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgAuditor(String orgId, String auditor) {
        return false;
    }

    @Override
    public boolean removeOrgAuditor(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgCommittee(String orgId, String committee) {
        return false;
    }

    @Override
    public boolean removeOrgCommittee(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgDonationInfo(String orgId, String info) {
        return false;
    }

    @Override
    public boolean removeOrgDonationInfo(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgSocials(String orgId, String type, String url) {
        return false;
    }

    @Override
    public boolean removeOrgSocials(String orgId, String type) {
        return false;
    }

    @Override
    public boolean addOrgNGO(String orgId, String ngoNumber, Date ngoDate) {
        return false;
    }

    @Override
    public boolean removeOrgNGO(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgEstDate(String orgId, Date date) {
        return false;
    }

    @Override
    public boolean removeOrgEstDate(String orgId) {
        return false;
    }

    @Override
    public boolean adminValidateOrgEstDate(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidateOrgNGO(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidatOrgSocials(String orgid, String type) {
        return false;
    }

    @Override
    public boolean adminValidateOrgDonationInfo(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidateOrgCommittee(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidateAuditor(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidateOrgTaxRef(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidateAuditDoc(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidateNoOfImages(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidateAdress(String orgid) {
        return false;
    }

    @Override
    public boolean adminValidateWebsite(String orgid) {
        return false;
    }

    @Override
    public List<Organisation> findAll() {
        return null;
    }

    @Override
    public List<Organisation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Organisation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Organisation> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Organisation organisation) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Organisation> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Organisation> S save(S s) {

        return null;
    }

    @Override
    public <S extends Organisation> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Organisation> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Organisation> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Organisation> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Organisation> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Organisation getOne(Long aLong) {
        return null;
    }

    @Override
    public Organisation getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Organisation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Organisation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Organisation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Organisation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Organisation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Organisation> boolean exists(Example<S> example) {
        return false;
    }
}
*/
