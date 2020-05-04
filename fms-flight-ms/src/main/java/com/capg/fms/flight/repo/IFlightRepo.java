
/***************************************************************
 -Author                : Geetha and Meghana
 -Created/Modified Date : 28/04/2020
 -Description           : Repository Interface implements JPARepo
 						  for all crud methods
*******************************************************************/
  package com.capg.fms.flight.repo;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.capg.fms.flight.model.Flight;
  
  public interface IFlightRepo extends JpaRepository<Flight, Long>{

 }