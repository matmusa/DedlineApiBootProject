package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.dedlineapibootproject.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {


}
