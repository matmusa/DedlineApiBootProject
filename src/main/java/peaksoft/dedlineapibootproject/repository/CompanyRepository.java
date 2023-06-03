package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.dedlineapibootproject.dto.CompanyResponse;
import peaksoft.dedlineapibootproject.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select new peaksoft.dedlineapibootproject.dto.CompanyResponse " +
            "(c.id,c.name,c.country,c.address,c.phoneNumber) from Company c")
    List<CompanyResponse> getAllCompanies();

    Optional<CompanyResponse> getCompanyById(Long id);
    @Query("select g.groupName from Company c join c.courses cc join cc.groups g where c.id=:companyId")
    List<String> groupName(@Param("companyId")Long companyId);
    @Query("select cc.courseName from Company c join c.courses cc where c.id=:companyId")
    List<String> courseName(@Param("companyId")Long companyId);
    @Query("select i.firstName from Company c join c.instructors i where c.id=:companyId")
    List<String> instructorName(@Param("companyId")Long companyId);
    @Query("select count(s.id) from Company c join c.courses cc join cc.groups g join g.students s where c.id=:companyId")
    int studentCount(@Param("companyId") Long companyId);

}
