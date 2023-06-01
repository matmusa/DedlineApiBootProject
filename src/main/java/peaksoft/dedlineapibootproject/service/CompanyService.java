package peaksoft.dedlineapibootproject.service;

import jdk.dynalink.linker.support.SimpleLinkRequest;
import peaksoft.dedlineapibootproject.dto.CompanyRequest;
import peaksoft.dedlineapibootproject.dto.CompanyResponse;

import java.util.List;

public interface CompanyService {
    CompanyResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse getCompanyById(Long id);
    List<CompanyResponse> getAllCompanies();
    CompanyResponse updateCompany(Long id,CompanyRequest companyRequest);

    void deleteCompany(Long id);
    List<CompanyResponse> getAllCompaniesByBlockerOrNotBlocked(boolean isBlocked);
    SimpleLinkRequest blockOrUnBlock(Long id, Boolean isBlocked);
}
