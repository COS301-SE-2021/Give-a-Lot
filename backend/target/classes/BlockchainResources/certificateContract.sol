// SPDX-License-Identifier: MIT
pragma solidity ^0.8.7;

contract CertificateContract {

    address admin;


    uint256 private certificateCount = 0;
    mapping(uint => Certificate) public certificates;

    modifier onlyAdmin(){
        require(msg.sender == admin);
        _;
    }

    struct Certificate {
        uint256 organisationId;
        string certificateHash;
        uint256 level;
    }

    constructor(){
        admin = msg.sender;
    }

    function addCertificate(
        string memory _certificateHash,
        uint256 _organisationId,
        uint256 _level
    )
    public onlyAdmin
    {
        incrementCount();
        certificates[certificateCount] = Certificate(_organisationId,_certificateHash,_level);
    }

    function upgradeCertificate(
        uint256 index,
        string memory _certificateHash,
        uint256 _organisationId,
        uint256 _level
    )
    public onlyAdmin
    {
        if(certificates[index].organisationId == _organisationId){
            certificates[index] = Certificate(_organisationId,_certificateHash,_level);
        }

    }

    function findCertificateIndex(
        uint256 _organisationId
    )
    public onlyAdmin view
    returns(uint256)
    {

        uint256 i = 0;
        for (i; i<=certificateCount; i++){
            if(certificates[i].organisationId == _organisationId){
                return i;
            }
        }
        return 9999;
    }

    function retrieveCertificate(
        uint256 _index,
        uint256 _organisationId
    )
    public onlyAdmin view
    returns(uint256,string memory,uint256)
    {


        if(certificates[_index].organisationId == _organisationId){
            return (certificates[_index].organisationId,certificates[_index].certificateHash,certificates[_index].level);
        }
        return (0,"notFound",0);
    }

    function incrementCount() internal{
        certificateCount += 1;
    }
}