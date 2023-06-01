package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.CompanyRequest;
import peaksoft.dedlineapibootproject.dto.CompanyResponse;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.entity.Company;
import peaksoft.dedlineapibootproject.repository.CompanyRepository;
import peaksoft.dedlineapibootproject.service.CompanyService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setAddress(companyRequest.getAddress());
        company.setPhoneNumber(companyRequest.getPhoneNumber());
        company.setCountry(companyRequest.getCountry());
        companyRepository.save(company);
        return new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getCountry(),
                company.getAddress(),
                company.getPhoneNumber());
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        Company company = new Company();
        companyRepository.getCompanyById(id).orElseThrow(()
                -> new NullPointerException("Company with id " + id + "  is not found "));
        return new CompanyResponse(company.getId(),
                company.getName(),
                company.getCountry(),
                company.getAddress(),
                company.getPhoneNumber());

    }

    @Override
    public List<CompanyResponse> getAllCompanies() {

        return companyRepository.getAllCompanies();
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new NullPointerException("User with id " + id + "  is not found "));
        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        company.setPhoneNumber(companyRequest.getPhoneNumber());
        companyRepository.save(company);
        return new CompanyResponse(company.getId(),
                company.getName(),
                company.getCountry(),
                company.getAddress(),
                company.getPhoneNumber());
    }

    @Override
    public SimpleResponse deleteCompanyById(Long id) {
        boolean exist = companyRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Student with id: " + id + " is not found");
        }
        companyRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Company with id deleted");

    }
}
