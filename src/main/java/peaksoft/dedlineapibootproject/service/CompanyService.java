package peaksoft.dedlineapibootproject.service;

import jdk.dynalink.linker.support.SimpleLinkRequest;
import peaksoft.dedlineapibootproject.dto.CompanyRequest;
import peaksoft.dedlineapibootproject.dto.CompanyResponse;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;

import java.util.List;

public interface CompanyService {
    CompanyResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse getCompanyById(Long id);
    List<CompanyResponse> getAllCompanies();
    CompanyResponse updateCompany(Long id,CompanyRequest companyRequest);

    SimpleResponse deleteCompanyById(Long id);

}
