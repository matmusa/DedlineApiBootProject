package peaksoft.dedlineapibootproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.scanner.ScannerImpl;
import peaksoft.dedlineapibootproject.dto.CompanyGetAllInformationResponse;
import peaksoft.dedlineapibootproject.dto.CompanyRequest;
import peaksoft.dedlineapibootproject.dto.CompanyResponse;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService service;

    @GetMapping
    public List<CompanyResponse> getAllCompanies() {
        return service.getAllCompanies();

    }

    @PostMapping("/save")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return service.saveCompany(companyRequest);
    }

    @GetMapping("/{id}")
    public CompanyResponse getCompanyById(@PathVariable Long id) {
        return service.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest company) {
        return service.updateCompany(id, company);

    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteCompanyById(@PathVariable Long id) {
        service.deleteCompanyById(id);
        return new SimpleResponse("DELETED", "Company with " + id + "  deleted");
    }

    @GetMapping("/{companyId}")
    public CompanyResponse getAllCompaniesById(@PathVariable Long companyId) {
        return service.getAllCompanyById(companyId);
    }

    @GetMapping("/all/{companyId}")
    public CompanyGetAllInformationResponse getAllInformationFromCompanyById(@PathVariable Long companyId){
      return service.getAllInformationCompanyById(companyId);
    }
}
