package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dedlineapibootproject.dto.CompanyRequest;
import peaksoft.dedlineapibootproject.dto.CompanyResponse;
import peaksoft.dedlineapibootproject.dto.StudentResponse;
import peaksoft.dedlineapibootproject.entity.Company;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query("select new peaksoft.dedlineapibootproject.dto.CompanyResponse " +
            "(c.id,c.name,c.country,c.address,c.phoneNumber) from Company c")
      List<CompanyResponse>getAllCompanies();

    Optional<CompanyResponse>getCompanyById(Long id);

    Optional<CompanyResponse>updateCompanyById(Long id, CompanyRequest companyRequest);
}
